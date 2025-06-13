insert into supermarket (id, name, init_year, category)
values (1, 'Carrefour', 1973, 0),
       (2, 'Mercadona', 2000, 1),
       (3, 'Alimerka', 2005, 2);


insert into foods (available, category, color, description, expire_date, name, price, quantity, supermarket_id)
values (0, 'verdura', 'Naranja', 'ejemplo description', '2023-01-12', 'zanahoria', 4.99, 2, 1),
       (0, 'fruta', 'Amarillo', 'ejemplo description', '2023-01-12', 'plátano', 4.99, 2, 1),
       (0, 'fruta', 'Naranja', 'ejemplo description', '2023-01-12', 'Mandarina', 4.99, 2, 2),
       (0, 'fruta', 'Naranja', 'ejemplo description', '2023-01-12', 'Melón', 4.99, 2, 2),
       (0, 'fruta', 'Naranja', 'ejemplo description', '2023-01-12', 'Sandía', 4.99, 2, 3),
       (0, 'fruta', 'Naranja', 'ejemplo description', '2023-01-12', 'Uvas', 4.99, 2, 3);
