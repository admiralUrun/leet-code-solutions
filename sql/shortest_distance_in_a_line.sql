
-- Table: Point
--
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | x           | int  |
-- +-------------+------+
-- In SQL, x is the primary key column for this table.
-- Each row of this table indicates the position of a point on the X-axis.

select MIN(ABS(p1.x - p2.x)) as shortest from Point p1 join Point p2 on p1.x != p2.x