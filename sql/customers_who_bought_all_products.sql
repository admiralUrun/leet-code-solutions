Create table If Not Exists Customer (customer_id int, product_key int)
Create table Product (product_key int)
    Truncate table Customer
insert into Customer (customer_id, product_key) values ('1', '5')
insert into Customer (customer_id, product_key) values ('2', '6')
insert into Customer (customer_id, product_key) values ('3', '5')
insert into Customer (customer_id, product_key) values ('3', '6')
insert into Customer (customer_id, product_key) values ('1', '6');
Truncate table Product
    insert into Product (product_key) values ('5')
insert into Product (product_key) values ('6')

select customer_id
from Customer
         left join Product P on Customer.product_key = P.product_key
group by customer_id
having COUNT(distinct Customer.product_key) = (select COUNT(*) from Product)