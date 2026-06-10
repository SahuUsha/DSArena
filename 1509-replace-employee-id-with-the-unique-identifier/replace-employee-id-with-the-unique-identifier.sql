# Write your MySQL query statement below
Select e.unique_id,ei.name 
from EmployeeUNI e
RIGHT JOIN Employees ei 
on e.id=ei.id;