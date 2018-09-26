USE twitter;

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

-- 2. Delete (doesn't affect the real database yet)
DELETE FROM tag_tweet;
-- 3. Now, let's make an illegal statement that will violate the constraints - primary key is duplicated, because
-- that tweet is already created by twitter-5.sql db script.
INSERT INTO tweet (id, message, author_id, creationDate) VALUES (4, "message", 2, "2018-10-01 10:00:00");

/*
4. And finally decide to rollback the transaction, because INSERT violated the constraint. Since transaction is
rollbacked, the DELETE statement is also not executed. This means that tag_tweet table should still exist. Verify this!
*/
ROLLBACK;