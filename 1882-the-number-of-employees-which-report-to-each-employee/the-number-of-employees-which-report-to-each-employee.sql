# Write your MySQL query statement below
select e.employee_id , e.name , 
      count(m.employee_id ) as reports_count,
      Round(AVG(m.age))as average_age 
from Employees e
join Employees m on e.employee_id = m.reports_to
Group by e.employee_id, e.name
order by e.employee_id;
