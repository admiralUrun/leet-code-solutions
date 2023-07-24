-- Table: Employees
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | employee_id | int     |
-- | name        | varchar |
-- | salary      | int     |
-- +-------------+---------+
-- In SQL, employee_id is the primary key for this table.
-- Each row of this table indicates the employee ID, employee name, and salary.

select employee_id, IF(employee_id % 2 != 0 && SUBSTRING(name, 1, 1) != "M", salary, 0) as bonus from Employees order by employee_id
