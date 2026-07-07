# Write your MySQL query statement below
select q1.person_name
from Queue q1
where(
    Select SUM(weight)
    From Queue q2
    where q2.turn<=q1.turn
)<= 1000
order by q1.turn DESC
limit 1;