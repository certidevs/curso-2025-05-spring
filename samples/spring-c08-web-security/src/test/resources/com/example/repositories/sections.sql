insert into supermarket (id, name, init_year, category)
values (1, 'Carrefour', 1973, 0),
       (2, 'Mercadona', 2000, 1),
       (3, 'Alimerka', 2005, 2);

insert into supermarket_section (id, m2, name, refrigerated, supermarket_id)
values (1, 30.5, 'pescadería', 1, 1),
       (2, 30.5, 'carnicería', 1, 1),
       (3, 30.5, 'frutería', 1, 2),
       (4, 30.5, 'panadería', 1, 2);