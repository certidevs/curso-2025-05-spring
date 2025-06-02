-- Insertar categorías
INSERT INTO categorias (nombre, descripcion) VALUES ('Frutas', 'Productos frescos');
INSERT INTO categorias (nombre, descripcion) VALUES ('Lácteos', 'Productos derivados de la leche');
INSERT INTO categorias (nombre, descripcion) VALUES ('Cereales', 'Alimentos a base de granos y cereales');
INSERT INTO categorias (nombre, descripcion) VALUES ('Carne', 'Productos cárnicos de origen animal');
INSERT INTO categorias (nombre, descripcion) VALUES ('Pescado', 'Productos del mar');
INSERT INTO categorias (nombre, descripcion) VALUES ('Juegos de mesa', 'Juegos de mesa para toda la familia');
INSERT INTO categorias (nombre, descripcion) VALUES ('Bebidas energéticas', 'Bebidas con cafeína');
INSERT INTO categorias (nombre, descripcion) VALUES ('Ropa', 'Productos textiles');
INSERT INTO categorias (nombre, descripcion) VALUES ('Marisco', 'Productos del mar artrópodos');
INSERT INTO categorias (nombre, descripcion) VALUES ('Utensilios', 'Herramientas para la casa');
INSERT INTO categorias (nombre, descripcion) VALUES ('Limpieza y hogar', 'Productos para limpiar el hogar');
INSERT INTO categorias (nombre, descripcion) VALUES ('Sillas', 'Sillas para sentarte');
INSERT INTO categorias (nombre, descripcion) VALUES ('Libros', 'Publicaciones escritas');
INSERT INTO categorias (nombre, descripcion) VALUES ('Postres', 'Dulces y frutas');
INSERT INTO categorias (nombre, descripcion) VALUES ('Fontanería', 'Productos de bricolaje');
INSERT INTO categorias (nombre, descripcion) VALUES ('Platos precocinados', 'Productos preparados para comer');
INSERT INTO categorias (nombre, descripcion) VALUES ('Automoción', 'Productos para coche y motor');

-- Insertar productos
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Manzana', 1.50, 100, true, 1);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Yogur', 2.00, 50, true, 2);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Avena', 3.50, 30, true, 3);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Queso', 7.50, 1, true, 2);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Aguacate', 5.00, 0, false, 1);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Plátano', 2.00, 5, false, 1);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Solomillo de cerdo', 8.00, 10, true, 4);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES('Pantalón', 7.99, 20, true, 8);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Mosquetón', 2.00, 5, false, 10);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES('Uno', 4.99, 20, true, 6);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Sartén', 10.00, 3, true, 10);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Codo 90º 1/4 1/2', 3.50, 100, true, 15);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Tortilla de patatas', 7.00, 25, true, 16);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Bacalao', 10.00, 30, true, 5);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Limpia cristales', 3.00, 40, true, 11);
INSERT INTO productos (nombre, precio, stock, disponible, categoria_id) VALUES ('Aceite 40/50', 75.99, 175, true, 17);

-- Insertar proveedores
INSERT INTO proveedores (nombre, email, telefono, activo) VALUES ('Proveedor 1', 'proveedor1@mail.com', '111111111', true);
INSERT INTO proveedores (nombre, email, telefono, activo) VALUES ('Proveedor 2', 'proveedor2@mail.com', '222222222', true);
INSERT INTO proveedores (nombre, email, telefono, activo) VALUES ('Proveedor 3', 'proveedor3@mail.com', '333333333', false);
INSERT INTO proveedores (nombre, email, telefono, activo) VALUES ('Proveedor 4', 'proveedor4@mail.com', '444444444', true);

-- Insertar relaciones proveedor-producto (tabla intermedia)
-- Proveedor 1
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (1, 1);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (1, 2);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (1, 4);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (1, 5);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (1, 11);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (1, 14);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (1, 16);

-- Proveedor 2
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (2, 3);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (2, 4);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (2, 5);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (2, 6);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (2, 8);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (2, 9);

-- Proveedor 3
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (3, 4);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (3, 10);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (3, 11);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (3, 2);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (3, 8);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (3, 9);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (3, 16);

-- Proveedor 4
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (4, 9);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (4, 5);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (4, 6);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (4, 7);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (4, 2);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (4, 15);
INSERT INTO proveedor_producto (proveedor_id, productos_id) VALUES (4, 16);