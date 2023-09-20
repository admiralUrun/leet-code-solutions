Create table If Not Exists Employee (employee_id int, department_id int, primary_flag ENUM('Y','N'))
    Truncate table Employee
    insert into Employee (employee_id, department_id, primary_flag) values ('1', '1', 'N')
    insert into Employee (employee_id, department_id, primary_flag) values ('2', '1', 'Y')
    insert into Employee (employee_id, department_id, primary_flag) values ('2', '2', 'N')
    insert into Employee (employee_id, department_id, primary_flag) values ('3', '3', 'N')
    insert into Employee (employee_id, department_id, primary_flag) values ('4', '2', 'N')
    insert into Employee (employee_id, department_id, primary_flag) values ('4', '3', 'Y')
    insert into Employee (employee_id, department_id, primary_flag) values ('4', '4', 'N')

select E1.employee_id, department_id from Employee E1
                                              join (select employee_id, COUNT(department_id) as count from Employee
                                                    group by employee_id) as E2 on E1.employee_id = E2.employee_id
where E2.count = 1 or E1.primary_flag = 'Y'