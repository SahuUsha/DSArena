# Write your MySQL query statement below
select s.student_id, s.student_name, sub.subject_name,
Count(e.subject_name) AS attended_exams
from Students s
CROSS JOIN Subjects sub
LEFT JOIN Examinations e 
on e.student_id = s.student_id
and e.subject_name = sub.subject_name
Group by 
s.student_id,
s.student_name,
sub.subject_name
order by 
s.student_id,
sub.subject_name;