# Write your MySQL query statement below
SELECT Distinct p.product_id ,  COALESCE(t.new_price,10) as price
  from (
    Select Distinct product_id
    from Products
  ) p
Left join (
    select product_id , new_price 
    from Products 
    where (product_id,change_date)  IN (
        select product_id , max(change_date) 
        from Products
        where change_date <='2019-08-16'
        group by product_id
    ) ) t
    on p.product_id = t.product_id;

