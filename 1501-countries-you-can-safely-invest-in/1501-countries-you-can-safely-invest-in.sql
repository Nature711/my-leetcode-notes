# Write your MySQL query statement below
# for each country, find the average call duration
with person_country as (
    select id, SUBSTRING(phone_number, 1, 3) as phone_code
    from Person
),
country_duration as (
    select ct.name as country, AVG(c.duration) as country_avg_duration
    from person_country pc, Country ct, Calls c
    where (pc.id = c.caller_id or pc.id = c.callee_id) and pc.phone_code = ct.country_code
    group by country_code
    having AVG(c.duration) > (select avg(duration) as global_avg_duration from Calls)
)
select country from country_duration;

# select country
# from country_duration 
# where country_avg_duration > (select avg(duration) as global_avg_duration from Calls);

