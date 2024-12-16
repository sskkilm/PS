select 
    c.car_id,
    case 
        when exists (
            select 1 
            from car_rental_company_rental_history AS ch
            where ch.car_id = c.car_id
              and '2022-10-16' between ch.start_date and ch.end_date
        ) then '대여중'
        else '대여 가능'
    end as availability
from (
    select distinct car_id 
    from car_rental_company_rental_history
) as c
order by car_id desc
;