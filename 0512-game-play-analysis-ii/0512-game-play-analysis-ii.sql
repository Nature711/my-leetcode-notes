# Write your MySQL query statement below

with player_login as (
    select player_id, min(event_date) as first_login
    from Activity
    group by player_id
)
select a.player_id, a.device_id 
from Activity a, player_login p
where a.player_id = p.player_id
    and a.event_date = p.first_login
;


