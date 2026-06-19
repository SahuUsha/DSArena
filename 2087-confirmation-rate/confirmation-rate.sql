# Write your MySQL query statement below
select e.user_id, 
Round (
    AVG( CASE
        when c.action = "confirmed" then 1
        else 0
     END
    ),
    2
) AS confirmation_rate
from Signups e
left Join Confirmations c on e.user_id = c.user_id
Group by e.user_id ;
