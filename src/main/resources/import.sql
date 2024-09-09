-- Crear tabla City
CREATE TABLE city (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      nombre VARCHAR(255),
                      departamento VARCHAR(255)
);

-- Crear tabla Product
CREATE TABLE product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         categoria VARCHAR(255),
                         sostenibilidad DOUBLE,
                         descripcion VARCHAR(255),
                         disponible BOOLEAN,
                         precio_base DOUBLE
);

-- Crear tabla Offer
CREATE TABLE offer (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       producto_id INT,
                       fecha_inicio TIMESTAMP,
                       fecha_fin TIMESTAMP,
                       detalles VARCHAR(255),
                       CONSTRAINT fk_offer_producto FOREIGN KEY (producto_id) REFERENCES product(id)
);

-- Crear tabla Store
CREATE TABLE store (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(255),
                       direccion VARCHAR(255),
                       ubicacion_id INT,
                       CONSTRAINT fk_store_ubicacion FOREIGN KEY (ubicacion_id) REFERENCES city(id)
);

-- Tabla intermedia para ManyToMany entre Store y Product
CREATE TABLE store_product (
                               store_id INT,
                               producto_id INT,
                               PRIMARY KEY (store_id, producto_id),
                               CONSTRAINT fk_store_product_store FOREIGN KEY (store_id) REFERENCES store(id),
                               CONSTRAINT fk_store_product_product FOREIGN KEY (producto_id) REFERENCES product(id)
);

-- Crear tabla User
CREATE TABLE user (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      usuario VARCHAR(255),
                      nombre VARCHAR(255),
                      ubicacion_id INT,
                      CONSTRAINT fk_user_ubicacion FOREIGN KEY (ubicacion_id) REFERENCES city(id)
);

-- Tabla intermedia para ManyToMany entre User y Offer
CREATE TABLE user_offer (
                            user_id INT,
                            oferta_id INT,
                            PRIMARY KEY (user_id, oferta_id),
                            CONSTRAINT fk_user_offer_user FOREIGN KEY (user_id) REFERENCES user(id),
                            CONSTRAINT fk_user_offer_offer FOREIGN KEY (oferta_id) REFERENCES offer(id)
);

-- Crear tabla Review
CREATE TABLE review (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        producto_id INT,
                        calificacion INT,
                        publicacion TIMESTAMP,
                        usuario_id INT,
                        CONSTRAINT fk_review_producto FOREIGN KEY (producto_id) REFERENCES product(id),
                        CONSTRAINT fk_review_usuario FOREIGN KEY (usuario_id) REFERENCES user(id)
);
