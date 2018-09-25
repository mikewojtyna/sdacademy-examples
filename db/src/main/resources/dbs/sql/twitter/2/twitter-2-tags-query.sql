SELECT
  author.username,
  COUNT(DISTINCT tag_tweet.tag_id)
FROM author, tweet, tag_tweet
WHERE author.id = tweet.author_id AND tag_tweet.tweet_id = tweet.id
GROUP BY author.username;