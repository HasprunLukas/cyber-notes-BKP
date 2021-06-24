insert into USER select * from (
                                            select 0, 'admin' as xUsername,'admin' as xPassword
                                       ) x where not exists(select * from USER);