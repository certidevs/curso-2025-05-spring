insert into address (id, street, city, country)
values (1, 'calle1', 'Madrid', 'Spain'),
       (2, 'calle2', 'Madrid', 'Spain'),
       (3, 'calle3', 'Barcelona', 'Spain'),
       (4, 'calle4', 'Barcelona', 'Spain'),
       (5, 'calle5', 'Gijón', 'Spain'),
       (6, 'calle6', 'Gijón', 'Spain');


insert into supermarket (id, name, init_year, category)
values (1, 'Carrefour', 1973, 0),
       (2, 'Mercadona', 2000, 1),
       (3, 'Alimerka', 2005, 2);


insert into supermarket_addresses (supermarket_id, addresses_id)
values (1, 1),
       (1, 2),
       (2, 1),
       (2, 3),
       (3, 2),
       (3, 4);

