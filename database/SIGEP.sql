DROP DATABASE IF EXISTS SIGEP;
CREATE DATABASE SIGEP;
USE SIGEP;

-- ============================================================
-- TABLAS
-- ============================================================

-- 1. USUARIO
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(100) NOT NULL,
    usuario    VARCHAR(100) NOT NULL UNIQUE,
    clave      VARCHAR(255) NOT NULL
);

-- 2. CLIENTE
CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(100) NOT NULL,
    apellido   VARCHAR(100) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    telefono   VARCHAR(15),
    direccion  VARCHAR(255)
);

-- 3. EMPRESA
CREATE TABLE empresa (
    id_empresa INT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(200) NOT NULL,
    pais       VARCHAR(50)
);

-- 4. CATEGORIA
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(50) NOT NULL
);

-- 5. PRODUCTO
CREATE TABLE producto (
    id_producto  INT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(255) NOT NULL,
    precio       DECIMAL(10,2),
    stock        INT NOT NULL DEFAULT 1,
    id_empresa   INT,
    id_categoria INT,
    FOREIGN KEY (id_empresa)   REFERENCES empresa(id_empresa)     ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- 6. PEDIDO
CREATE TABLE pedido (
    id_pedido    INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente   INT NOT NULL,
    fecha_pedido DATE NOT NULL,
    fecha_pago   DATE,
    estado       VARCHAR(20) NOT NULL, -- 'EN ESPERA', 'PAGADO'
    id_producto  INT,
    cantidad     INT NOT NULL DEFAULT 1,
    FOREIGN KEY (id_cliente)  REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- 7. MOVIMIENTO_STOCK
CREATE TABLE movimiento_stock (
    id_movimiento INT AUTO_INCREMENT PRIMARY KEY,
    id_producto   INT NOT NULL,
    tipo          VARCHAR(20) NOT NULL, -- 'ENTRADA', 'SALIDA'
    cantidad      INT NOT NULL,
    fecha         DATE NOT NULL,
    observacion   VARCHAR(255),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- ============================================================
-- INSERTS
-- ============================================================

INSERT INTO usuario (nombre, usuario, clave) VALUES
('Administrador General', 'admin',     '$2a$10$GePcTtcs.dZbrWLqEvsr1e9yXXyviTUq0FTplflFyzMwxGutgIF/2'),
('Usuario Operativo',     'operativo', '$2a$10$GePcTtcs.dZbrWLqEvsr1e9yXXyviTUq0FTplflFyzMwxGutgIF/2');

INSERT INTO cliente (nombre, apellido, email, telefono, direccion) VALUES
('Carlos', 'Ramirez',   'carlos.ramirez@gmail.com', '987654321', 'Av. Peru 123'),
('Maria',  'Lopez',     'maria.lopez@gmail.com',    '912345678', 'Jr. Lima 456'),
('Luis',   'Torres',    'luis.torres@gmail.com',    '923456789', 'Calle Arequipa 789'),
('Alex',   'Velasquez', 'alex@gmail.com',           '987738810', 'Av. Gamarra');

INSERT INTO empresa (nombre, pais) VALUES
('Tech Solutions SAC',   'Peru'),
('Global Books Ltd',     'Estados Unidos'),
('Distribuidora Andina', 'Chile');

INSERT INTO categoria (nombre) VALUES
('Tecnologia'),
('Educacion'),
('Oficina');

INSERT INTO producto (nombre, precio, stock, id_empresa, id_categoria) VALUES
('Laptop ASUS TUF F15', 3500.00,  10, 1, 1),
('Libro Java Basico',     80.00,  50, 2, 2),
('Mouse Logitech',        45.50,  30, 1, 1),
('Cuaderno A4',           12.00, 100, 3, 3),
('Computador Gamer',    5000.00,  10, 1, 1),
('Sillas de Empresa',    200.00,  70, 3, 3);

INSERT INTO pedido (id_cliente, fecha_pedido, fecha_pago, estado, id_producto, cantidad) VALUES
(3, '2026-04-25', '2026-04-25', 'PAGADO',    6,  1),
(1, '2026-04-25', NULL,         'EN ESPERA', 2,  1),
(2, '2026-04-25', NULL,         'EN ESPERA', 3,  1),
(4, '2026-04-25', NULL,         'EN ESPERA', 6, 60);

INSERT INTO movimiento_stock (id_producto, tipo, cantidad, fecha, observacion) VALUES
(1, 'ENTRADA', 50, '2026-04-25', ''),
(1, 'SALIDA',  50, '2026-04-25', ''),
(6, 'ENTRADA', 20, '2026-04-25', 'Correcto');
