/*
REPEATABLE_READ is the default isolation level in InnoDB - the default and most commonly used database engine in
MySQL. Since its a default value, we don't need to set it here explicitly. However, it's a good idea to leave it here
during the course to make it easier to understand.

In this example we set the isolation level only for the next transaction. Refer to the official documentation to see
all available scopes https://dev.mysql.com/doc/refman/8.0/en/set-transaction.html.
*/
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;

-- 1. Start transaction
START TRANSACTION;

-- 2. Run statements inside the transaction
CREATE DATABASE IF NOT EXISTS twitter;
USE twitter;

CREATE TABLE author (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(100) NOT NULL
);
CREATE TABLE tweet (
  id           INT PRIMARY KEY AUTO_INCREMENT,
  message      VARCHAR(140) NOT NULL,
  author_id    INT,
  creationDate DATETIME(6)  NOT NULL,
  INDEX (message, creationDate),
  FOREIGN KEY (author_id) REFERENCES author (id)
    ON DELETE CASCADE
);
CREATE TABLE tag (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL UNIQUE
);
CREATE TABLE tag_tweet (
  tag_id   INT NOT NULL,
  tweet_id INT NOT NULL,
  PRIMARY KEY (tag_id, tweet_id),
  FOREIGN KEY (tag_id) REFERENCES tag (id),
  FOREIGN KEY (tweet_id) REFERENCES tweet (id)
);

-- create procedure to execute complex query - find number of used tags for each author
CREATE PROCEDURE find_number_of_tags_used_by_each_author()
  BEGIN
    SELECT
      author.username                  as author,
      COUNT(DISTINCT tag_tweet.tag_id) as used_tags
    FROM author, tweet, tag_tweet
    WHERE author.id = tweet.author_id AND tag_tweet.tweet_id = tweet.id
    GROUP BY author.username;
  END;

-- create a trigger to automatically set tweet default creation date
CREATE TRIGGER before_tweet_insert
  BEFORE INSERT
  ON tweet
  FOR EACH ROW
  BEGIN
    if (NEW.creationDate IS NULL)
    THEN
      SET NEW.creationDate = NOW();
    END IF;
  END;

-- add goobar and his tweets
INSERT INTO author (id, username) VALUES (1, "goobar");
INSERT INTO tweet (id, message, author_id, creationDate)
VALUES (1, "goobar's tweet 0", 1, "2018-09-19 10:15:35.00001");
INSERT INTO tweet (id, message, author_id, creationDate)
VALUES (2, "goobar's tweet 1", 1, "2018-09-19 15:00:35.99999");
INSERT INTO tweet (id, message, author_id, creationDate) VALUES (3, "goobar's tweet 2", 1, "2018-09-25 05:00:00");

-- add foobar and his tweets
INSERT INTO author (id, username) VALUES (2, "foobar");
INSERT INTO tweet (id, message, author_id, creationDate) VALUES (4, "foobar's tweet 0", 2, "2018-10-01 10:00:00");
INSERT INTO tweet (id, message, author_id, creationDate) VALUES (5, "foobar's tweet 1", 2, "2018-10-02 10:00:00");
INSERT INTO tweet (id, message, author_id, creationDate) VALUES (6, "foobar's tweet 2", 2, "2018-10-03 10:00:00");
INSERT INTO tweet (id, message, author_id, creationDate) VALUES (7, "foobar's tweet about sql", 2, "2018-10-04
10:00:00");
INSERT INTO tweet (id, message, author_id, creationDate) VALUES (8, "foobar's tweet about spring", 2, "2018-10-05
10:00:00");

-- add tags
INSERT INTO tag (id, name) VALUES (1, "#goobar");
INSERT INTO tag (id, name) VALUES (2, "#foobar");
INSERT INTO tag (id, name) VALUES (3, "#java");
INSERT INTO tag (id, name) VALUES (4, "#sql");
INSERT INTO tag (id, name) VALUES (5, "#spring");

-- #goobar tag
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (1, 1);
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (1, 2);
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (1, 3);
-- #java tag
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (3, 1);
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (3, 2);
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (3, 3);
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (3, 4);
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (3, 5);
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (3, 6);
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (3, 8);
-- #foobar tag
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (2, 4);
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (2, 5);
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (2, 6);
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (2, 7);
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (2, 8);
-- #sql tag
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (4, 7);
-- #spring tag
INSERT INTO tag_tweet (tag_id, tweet_id) VALUES (5, 8);

-- 3. Commit the transaction - should have the same effect as in previous versions
COMMIT;