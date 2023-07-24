-- Table: Salary
--
-- +-------------+----------+
-- | Column Name | Type     |
-- +-------------+----------+
-- | id          | int      |
-- | name        | varchar  |
-- | sex         | ENUM     |
-- | salary      | int      |
-- +-------------+----------+
-- id is the primary key for this table.
-- The sex column is ENUM value of type ('m', 'f').
-- The table contains information about an employee.

update Salary set sex = IF(sex = "m", "f", "m")