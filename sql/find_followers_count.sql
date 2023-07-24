-- Table: Followers
--
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | user_id     | int  |
-- | follower_id | int  |
-- +-------------+------+
-- (user_id, follower_id) is the primary key for this table.
-- This table contains the IDs of a user and a follower in a social media app where the follower follows the user.

select user_id, COUNT(follower_id) as followers_count
from Followers
group by user_id
order by user_id