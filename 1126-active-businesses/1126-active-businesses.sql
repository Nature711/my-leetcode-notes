# Write your MySQL query statement below

with avg_activity as (
    select event_type as type, avg(occurences) as avg_occurence
    from Events
    group by event_type
)

select e.business_id 
from Events e, avg_activity aa
where e.event_type = aa.type
    and e.occurences > aa.avg_occurence
group by business_id
having count(*) >= 2
;