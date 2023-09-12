Create table If Not Exists Employee (id int, name varchar(255), department varchar(255), managerId int)
    Truncate table Employee;
insert into Employee (id, name, department, managerId) values ('101', 'John', 'A', null)
    insert into Employee (id, name, department, managerId) values ('102', 'Dan', 'A', '101')
insert into Employee (id, name, department, managerId) values ('103', 'James', 'A', '101')
insert into Employee (id, name, department, managerId) values ('104', 'Amy', 'A', '101')
insert into Employee (id, name, department, managerId) values ('105', 'Anne', 'A', '101')
insert into Employee (id, name, department, managerId) values ('106', 'Ron', 'B', '101')

select E1.name from Employee E1
                        JOIN (SELECT managerId, COUNT(*) as count from Employee group by managerId) as E2 on E1.id = E2.managerId
where E2.count >= 5