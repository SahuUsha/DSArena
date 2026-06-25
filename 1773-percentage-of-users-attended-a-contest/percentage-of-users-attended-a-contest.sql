# Write your MySQL query statement below
select r.contest_id , Round(
     count(r.contest_id)*100/ (select count(*) from users),2
) as percentage
from Register r 
group by r.contest_id
order by percentage DESC , contest_id ASC;