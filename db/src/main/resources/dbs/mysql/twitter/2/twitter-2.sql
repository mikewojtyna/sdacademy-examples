CREATE DATABASE IF NOT EXISTS twitter;
USE twitter;

CREATE TABLE author (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(100) NOT NULL
);
CREATE TABLE tweet (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  message   VARCHAR(140) NOT NULL,
  author_id INT,
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

-- add goobar and his tweets
INSERT INTO author (id, username) VALUES (1, "goobar");
INSERT INTO tweet (id, message, author_id) VALUES (1, "goobar's tweet 0", 1);
INSERT INTO tweet (id, message, author_id) VALUES (2, "goobar's tweet 1", 1);
INSERT INTO tweet (id, message, author_id) VALUES (3, "goobar's tweet 2", 1);

-- add foobar and his tweets
INSERT INTO author (id, username) VALUES (2, "foobar");
INSERT INTO tweet (id, message, author_id) VALUES (4, "foobar's tweet 0", 2);
INSERT INTO tweet (id, message, author_id) VALUES (5, "foobar's tweet 1", 2);
INSERT INTO tweet (id, message, author_id) VALUES (6, "foobar's tweet 2", 2);
INSERT INTO tweet (id, message, author_id) VALUES (7, "foobar's tweet about sql", 2);
INSERT INTO tweet (id, message, author_id) VALUES (8, "foobar's tweet about spring", 2);

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