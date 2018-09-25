--  select all tweet messages having #java tag
select tweet.message
from tag_tweet, tweet
where tag_tweet.tweet_id = tweet.id AND tag_tweet.tag_id = (select id
                                                            from tag
                                                            where name = '#java');