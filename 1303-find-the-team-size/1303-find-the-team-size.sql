# Write your MySQL query statement below
with Team as (
    select team_id, count(*) as size
    from Employee
    group by team_id
)

select employee_id, t.size as team_size
from Employee e, Team t
where e.team_id = t.team_id
;