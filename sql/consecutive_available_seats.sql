-- Table: Cinema
--
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | seat_id     | int  |
-- | free        | bool |
-- +-------------+------+
-- In SQL, seat_id is an auto-increment primary key column for this table.
-- Each row of this table indicates whether the ith seat is free or not. 1 means free while 0 means occupied.
select distinct c1.seat_id from Cinema c1
                                    join Cinema c2 on abs(c1.seat_id - c2.seat_id) = 1 and c2.free = true and c1.free = true
order by seat_id