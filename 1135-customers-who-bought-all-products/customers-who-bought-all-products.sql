
select  customer_id from Customer
group by customer_id
having count(DiSTINCT product_key) = (select count(*) from Product);