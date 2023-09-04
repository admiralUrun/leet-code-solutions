
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | id          | int  |
-- | salary      | int  |
-- +-------------+------+
-- id is the primary key (column with unique values) for this table.
-- Each row of this table contains information about the salary of an employee.


select IFNULL((select distinct salary from Employee order by salary desc limit 1 offset 1), NULL) as SecondHighestSalary;