
-- Table: Weather
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | id            | int     |
-- | recordDate    | date    |
-- | temperature   | int     |
-- +---------------+---------+
-- id is the column with unique values for this table.
-- This table contains information about the temperature on a certain day.


select distinct w2.id from Weather w1
                               join Weather w2 on w1.recordDate = DATE_SUB(w2.recordDate, interval 1 day)
where w1.temperature < w2.temperature