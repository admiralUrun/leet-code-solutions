
-- Table: Activity
--
-- +--------------+---------+
-- | Column Name  | Type    |
-- +--------------+---------+
-- | player_id    | int     |
-- | device_id    | int     |
-- | event_date   | date    |
-- | games_played | int     |
-- +--------------+---------+
-- (player_id, event_date) is the primary key (combination of columns with unique values) of this table.
-- This table shows the activity of players of some games.
-- Each row is a record of a player who logged in and played a number of games (possibly 0) before logging out on someday using some device.

select
    A1.player_id,
    A1.device_id
from
    Activity A1
where
        (A1.player_id, A1.event_date) in (
        select A2.player_id, MIN(A2.event_date)
        from Activity A2
        group by A2.player_id
    );
