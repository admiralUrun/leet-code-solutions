-- Table: Employees
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | employee_id | int     |
-- | name        | varchar |
-- +-------------+---------+
-- employee_id is the primary key for this table.
-- Each row of this table indicates the name of the employee whose ID is employee_id.
--
--
-- Table: Salaries
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | employee_id | int     |
-- | salary      | int     |
-- +-------------+---------+
-- employee_id is the primary key for this table.
-- Each row of this table indicates the salary of the employee whose ID is employee_id.
(select Employees.employee_id
 from Employees
          left join Salaries on Employees.employee_id = Salaries.employee_id
 where Salaries.salary is null
 union
 select Salaries.employee_id
 from Salaries
          left join Employees on Employees.employee_id = Salaries.employee_id
 where Employees.name is null)
    order by employee_id