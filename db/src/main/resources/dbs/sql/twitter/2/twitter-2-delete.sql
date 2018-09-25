-- Delete tweet with id = 1 - why db doesn't allow to execute this? (note many-to-many relationship between tags and
-- tweets)
DELETE FROM tweet WHERE id = 1;