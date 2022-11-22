# Write your MySQL query statement below

select id, 'Root' as type 
    from Tree 
    where p_id is null
union

select t1.id, 'Leaf' as type
    from Tree t1 left outer join Tree t2
        on t1.id = t2.p_id
    where t2.id is null and t1.p_id is not null

union

select t1.id, 'Inner' as type
    from Tree t1, Tree t2
    where t1.p_id is not null 
        and t1.id = any (select p_id from Tree)
;




