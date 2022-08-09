-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 09-08-2022 a las 02:24:51
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `desarrolloweb`
--
CREATE DATABASE IF NOT EXISTS `desarrolloweb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `desarrolloweb`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gastos`
--

DROP TABLE IF EXISTS `gastos`;
CREATE TABLE IF NOT EXISTS `gastos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` varchar(255) NOT NULL,
  `fecha` varchar(255) NOT NULL,
  `valor_total_sin_iva` varchar(255) NOT NULL,
  `iva_total` varchar(255) NOT NULL,
  `valor_total_con_iva` varchar(255) NOT NULL,
  `nombre_gasto` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `lugar` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` text CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuario` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `gastos`
--

INSERT INTO `gastos` (`id`, `usuario_id`, `fecha`, `valor_total_sin_iva`, `iva_total`, `valor_total_con_iva`, `nombre_gasto`, `lugar`, `descripcion`) VALUES
(9, '73202647', '2022-07-18', '6765', '456475675', '567', 'IX', 'Rioacha', 'Ricar'),
(10, '73202647', '2022-07-18', '6765', '456475675', '567', 'X', 'Arjona', 'Pancake'),
(11, '73202647', '2022-07-18', '6765', '456475675', '567', 'XI', 'Turbaco', 'Cebolla'),
(15, '73202647', '2022-07-16', '345345', '534534', '534534543', 'Ñoqui', 'Pasto', 'Cui'),
(19, '1128050081', '2022-07-13', '45654645654', '23432', '786868', 'ARA', 'Cartagena', 'Mercado Julio'),
(20, '1128050081', '2022-07-03', '23423423', '978978798', '423423', 'Olimpica', 'Barranquilla', 'Mercado para Papa'),
(23, '1128050081', '2022-07-22', '256252', '256626552', '2656262', 'Uno+', 'Cartagena', 'Unoadd'),
(24, '73202647', '2022-07-22', '565', '566565', '5465465', 'Dos ', 'Cartagena', 'Dosmas56'),
(25, '73202647', '2022-07-05', '423432', '234234', '234234', 'P1', 'Bquilla', 'Prueba1'),
(26, '73202647', '2022-07-02', '234234', '324234', '234234', 'P2', 'Cgena', 'Prueba2'),
(27, '73202647', '2022-06-30', '3213', '4234', '23423', 'P3', 'Cartagena', 'P3'),
(34, '73202647', '2022-07-14', '34234', '234234', '234324', 'P4', 'Medellin', 'P4'),
(35, '73202647', '2022-07-07', '12312', '13123', '1231', 'P5', 'Cartagena', 'P5'),
(36, '73202647', '2022-07-07', '43242', '234234', '23423', 'P6', 'Medellin', 'P6'),
(37, '73202647', '2022-07-13', '4242', '2423', '23423', 'P7', 'Medellin', 'P7'),
(38, '0123', '2022-08-19', '4423234', '423432', '234234', 'Ajaja', 'Cartagena', 'Prueba'),
(39, '111', '2022-08-03', '42342', '24323', '2423', 'PROBANDO AGREGAR', 'Cartagena', 'AGREGANDO GASTO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `cedula` varchar(255) NOT NULL,
  `clave` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`cedula`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`cedula`, `clave`, `nombre`, `telefono`, `email`) VALUES
('0123', '123', 'Franklin Vega', '665656', 'franklin.vega@aspaen.edu.co'),
('111', '123', 'Vincent Rolong Marquez', '54687999', 'vrolongm@unicartagena.edu.co'),
('1128050081', '123', 'Carolina Acosta Jaramillo ', '3008038896', 'carolinaacostajaramillo@hotmail.com'),
('73202647', '73202647', 'Administrador', '3004755267', 'enviodecorreosprueba@gmail.com');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `gastos`
--
ALTER TABLE `gastos`
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
