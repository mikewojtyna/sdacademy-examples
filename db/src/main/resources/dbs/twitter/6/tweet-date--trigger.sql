-- create a new tweet without date - this would be impossible previously without BEFORE INSERT trigger, because
-- creationDate has NOT NULL constraint
INSERT INTO tweet (message, author_id) VALUES ("new message with default creation date", 1);