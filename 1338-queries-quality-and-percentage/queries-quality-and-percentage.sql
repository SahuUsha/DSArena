# Write your MySQL query statement below
select r.query_name , Round(
    Avg(r.rating/r.position),2
) as quality, Round(
        (select count(rating) from Queries where rating<3 and  query_name =r.query_name)*100 / (select count(rating) from Queries where query_name =r.query_name ),2
) as poor_query_percentage
from Queries r
group by query_name