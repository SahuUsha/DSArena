# Write your MySQL query statement below
Select employee_id, department_id
from Employee
where 
-- department_id in (
--    select department_id from Employee
--    where 
   primary_flag='Y'
-- )
 or 
employee_id in (
    select employee_id from Employee
    group by employee_id
    having count(employee_id) = 1
)
group by employee_id;