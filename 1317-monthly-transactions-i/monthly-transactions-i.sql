# Write your MySQL query statement below
Select DATE_FORMAT(trans_date, '%Y-%m') As month,
    country,
    COUNT(*) as trans_count ,
    COUNT(CASE WHEN state = 'approved' THEN 1 END) AS approved_count,
    SUM(amount) as trans_total_amount,
    SUM(
    Case
      when state="approved" then amount
      else 0
    end
   ) as approved_total_amount 
   from Transactions
   Group by month,country;



