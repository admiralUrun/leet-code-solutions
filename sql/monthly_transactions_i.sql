Create table If Not Exists Transactions (id int, country varchar(4), state enum('approved', 'declined'), amount int, trans_date date)
    Truncate table Transactions
    insert into Transactions (id, country, state, amount, trans_date) values ('121', 'US', 'approved', '1000', '2018-12-18')
    insert into Transactions (id, country, state, amount, trans_date) values ('122', 'US', 'declined', '2000', '2018-12-19')
    insert into Transactions (id, country, state, amount, trans_date) values ('123', 'US', 'approved', '2000', '2019-01-01')
    insert into Transactions (id, country, state, amount, trans_date) values ('124', 'DE', 'approved', '2000', '2019-01-07')

select CONCAT(YEAR(T1.trans_date), '-', LPAD(MONTH(T1.trans_date), 2, '0')) as month,
       T1.country,
       COUNT(T1.amount)                                                     as trans_count,
       COUNT(approved.amount)                                               as approved_count,
       SUM(T1.amount)                                                       as trans_total_amount,
       SUM(IFNULL(approved.amount, 0))                                                 as approved_total_amount
from Transactions T1
    left join (select id, amount from Transactions where state = 'approved') as approved
on T1.id = approved.id
group by month, T1.country