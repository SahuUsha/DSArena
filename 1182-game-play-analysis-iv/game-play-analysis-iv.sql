# Write your MySQL query statement below
select round(
     count(a.player_id) / 
     (select count(distinct player_id) from Activity),                                                                                                
    2
    ) As fraction 
from Activity a
join (
    SELECT player_id, MIN(event_date) as first_login
    from Activity
    Group by player_id
) f
on f.player_id =a.player_id
and a.event_date = DATE_ADD(f.first_login, INTERVAL 1 Day);