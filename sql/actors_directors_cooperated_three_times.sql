-- Table: ActorDirector
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | actor_id    | int     |
-- | director_id | int     |
-- | timestamp   | int     |
-- +-------------+---------+
-- In SQL, timestamp is the primary key column for this table.

select actor_id, director_id
from ActorDirector
group by actor_id, director_id
having count(*) >= 3
