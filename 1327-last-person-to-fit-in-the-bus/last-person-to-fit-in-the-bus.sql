# Write your MySQL query statement below
-- select q1.person_name
-- from Queue q1
-- where(
--     Select SUM(weight)
--     From Queue q2
--     where q2.turn<=q1.turn
-- )<= 1000
-- order by q1.turn DESC
-- limit 1;


select person_name
from (
    select person_name, SUM(weight) OVER (Order by turn) as total_weight
    From Queue
 ) as q
WHERE total_weight<=1000
ORDER by total_weight DESC
LIMIT 1;

