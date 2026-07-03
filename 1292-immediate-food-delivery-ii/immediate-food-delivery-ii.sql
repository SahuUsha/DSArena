# Write your MySQL query statement belo
SELECT 
    Round(
        100.0 * COUNT(
            case
            when d.order_date = d.customer_pref_delivery_date then 1
            end
        )/Count(*),
        2
    ) as immediate_percentage
FROM Delivery d
join(
    select customer_id, min(order_date) as first_order
    from Delivery
    group by customer_id
) f
on d.customer_id = f.customer_id
and d.order_date = f.first_order;