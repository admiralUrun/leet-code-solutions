-- Table: Customers
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | name        | varchar |
-- +-------------+---------+
-- In SQL, id is the primary key column for this table.
-- Each row of this table indicates the ID and name of a customer.
--
--
-- Table: Orders
--
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | id          | int  |
-- | customerId  | int  |
-- +-------------+------+
-- In SQL, id is the primary key column for this table.
-- customerId is a foreign key (join key in Pandas) of the ID from the Customers table.
-- Each row of this table indicates the ID of an order and the ID of the customer who ordered it.

select name as Customers
from Customers
where id not in (
    select distinct customerId
    from Orders
)
