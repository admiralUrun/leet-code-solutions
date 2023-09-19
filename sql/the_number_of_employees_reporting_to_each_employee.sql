Create table If Not Exists Employees(employee_id int, name varchar(20), reports_to int, age int)
    Truncate table Employees;
insert into Employees (employee_id, name, reports_to, age) values ('9', 'Hercy', null, '43')
    insert into Employees (employee_id, name, reports_to, age) values ('6', 'Alice', '9', '41')
insert into Employees (employee_id, name, reports_to, age) values ('4', 'Bob', '9', '36')
insert into Employees (employee_id, name, reports_to, age) values ('2', 'Winston', null, '37')


select E1.employee_id, E1.name, COUNT(E2.reports_to) as reports_count, ROUND(AVG(E2.age)) as average_age from Employees E1
                                                                                                                  left join Employees E2 on E1.employee_id = E2.reports_to
group by E1.employee_id, E1.name
HAVING reports_count > 0
order by employee_id