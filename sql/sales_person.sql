-- Table: SalesPerson
--
-- +-----------------+---------+
-- | Column Name     | Type    |
-- +-----------------+---------+
-- | sales_id        | int     |
-- | name            | varchar |
-- | salary          | int     |
-- | commission_rate | int     |
-- | hire_date       | date    |
-- +-----------------+---------+
-- In SQL, sales_id is the primary key column for this table.
-- Each row of this table indicates the name and the ID of a salesperson alongside their salary, commission rate, and hire date.
--
--
-- Table: Company
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | com_id      | int     |
-- | name        | varchar |
-- | city        | varchar |
-- +-------------+---------+
-- In SQL, com_id is the primary key column for this table.
-- Each row of this table indicates the name and the ID of a company and the city in which the company is located.
--
--
-- Table: Orders
--
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | order_id    | int  |
-- | order_date  | date |
-- | com_id      | int  |
-- | sales_id    | int  |
-- | amount      | int  |
-- +-------------+------+
-- In SQL, order_id is the primary key column for this table.
-- com_id is a foreign key (join key in Pandas) to com_id from the Company table.
-- sales_id is a foreign key (join key in Pandas) to sales_id from the SalesPerson table.
-- Each row of this table contains information about one order. This includes the ID of the company, the ID of the salesperson, the date of the order, and the amount paid.

select name
from SalesPerson
where sales_id not in (
    select distinct Orders.sales_id
    from Orders
             join Company on Orders.com_id = Company.com_id
    where Company.name = "RED"
)
