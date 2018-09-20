USE twitter;

-- 1. Start transaction
START TRANSACTION;

-- 2. Delete (doesn't affect the real database yet)
DELETE FROM tag_tweet;

-- 3. And finally decide to commit the transaction - all changes inside the transaction are persisted.
COMMIT;