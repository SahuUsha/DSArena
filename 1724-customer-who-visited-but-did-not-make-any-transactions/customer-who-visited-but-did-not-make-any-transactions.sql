select customer_id, Count(*) as count_no_trans
from visits
where visit_id not in (
    select visit_id from  Transactions
    )
Group by customer_id;

