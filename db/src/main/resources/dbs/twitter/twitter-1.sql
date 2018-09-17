CREATE DATABASE IF NOT EXISTS twitter;
USE twitter;

CREATE TABLE author (
  id       INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(100)
);
CREATE TABLE tweet (
  id        INT PRIMARY KEY AUTO_INCREMENT,
  message   VARCHAR(140),
  author_id INT,
  FOREIGN KEY (author_id) REFERENCES author (id)
    ON DELETE CASCADE
);

INSERT INTO author (id, username) VALUES (1, "goobar");
INSERT INTO tweet (message, author_id) VALUES ("goobar's tweet 0", 1);
INSERT INTO tweet (message, author_id) VALUES ("goobar's tweet 1", 1);
INSERT INTO tweet (message, author_id) VALUES ("goobar's tweet 2", 1);