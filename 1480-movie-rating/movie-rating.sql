# Write your MySQL query statement below
(select u.name as results 
from Users u 
join (
    select user_id, count(user_id)  as rateCount
    from MovieRating 
    group by user_id
) m on u.user_id = m.user_id
order by m.rateCount DESC , u.name
limit 1
)
union all
(
select m.title as results
from Movies m
join (
    select movie_id, avg(rating) as avgRating
    from MovieRating
    where created_at >='2020-02-01' and 
   created_at <= '2020-02-29'
    group by movie_id

) mr on m.movie_id = mr.movie_id
order by mr.avgRating DESC, m.title
limit 1
);