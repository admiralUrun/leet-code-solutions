-- Table: Orders
--
-- +-----------------+----------+
-- | Column Name     | Type     |
-- +-----------------+----------+
-- | order_number    | int      |
-- | customer_number | int      |
-- +-----------------+----------+
-- In SQL, order_number is the primary key for this table.
-- This table contains information about the order ID and the customer ID.

select customer_number
from Orders
group by customer_number
having COUNT(*) = (
    select MAX(order_count)
    from (
             select COUNT(*) as order_count
             from Orders
             group by customer_number
         ) as counts
)
