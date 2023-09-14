Create table If Not Exists Delivery (delivery_id int, customer_id int, order_date date, customer_pref_delivery_date date)
    Truncate table Delivery
    insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('1', '1', '2019-08-01', '2019-08-02')
    insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('2', '2', '2019-08-02', '2019-08-02')
    insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('3', '1', '2019-08-11', '2019-08-12')
    insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('4', '3', '2019-08-24', '2019-08-24')
    insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('5', '3', '2019-08-21', '2019-08-22')
    insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('6', '2', '2019-08-11', '2019-08-13')
    insert into Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date) values ('7', '4', '2019-08-09', '2019-08-09')


select ROUND((COUNT(IMD.customer_id) / COUNT(*)) * 100, 2) as immediate_percentage from Delivery D1
                                                                                            left join (select customer_id, MIN(order_date) as date from Delivery where order_date = customer_pref_delivery_date group by customer_id) as IMD on D1.customer_id = IMD.customer_id and D1.order_date = IMD.date
                                                                                            left join (select customer_id, MIN(order_date) as date from Delivery group by customer_id) as F on D1.customer_id = F.customer_id and D1.order_date = F.date
where F.customer_id is not null

select ROUND(COUNT(case when order_date = customer_pref_delivery_date then 1 end) * 100 / COUNT(customer_id),
             2) as immediate_percentage
from Delivery
where (customer_id, order_date) in (select customer_id, MIN(order_date)
                                    from Delivery
                                    group by customer_id)
