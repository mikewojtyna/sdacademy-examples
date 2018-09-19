-- run this on previous version and verify number of scanned rows required to find the right value
EXPLAIN SELECT *
        FROM tweet
        WHERE message = "goobar's tweet 0";