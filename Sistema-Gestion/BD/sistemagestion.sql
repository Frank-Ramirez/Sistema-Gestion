-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-08-2021 a las 23:21:07
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemagestion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(40) NOT NULL,
  `nombre` varchar(40) COLLATE utf8mb4_bin NOT NULL,
  `apellido` varchar(40) COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `telefono` varchar(40) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `email`, `telefono`, `password`) VALUES
(2, 'Franklin', 'Ramirez', 'theking.liri3@gmail.com', '3126548978', '123456'),
(4, 'Luis Franklin', 'Valencia', '17302173@utfv.edu.mx', '456987135', '123'),
(5, 'Luis', 'Valencia', 'frank_rv.07@outlook.com', NULL, '345'),
(6, 'qwe', 'qwe', 'wicho305.lv@gmail.com', NULL, '$argon2id$v=19$m=1024,t=1,p=1$IECJMXIFppn1Ynsv1dkJOQ$IqzaskkEKseENedKW5QgzdWOzomIPJl8gnn9bJ3/kTA'),
(8, 'lu', 'lu', 'lu@gmail.com', NULL, '$argon2id$v=19$m=1024,t=1,p=1$rmuI+ETy5yZp8q1dRFE+lw$wb3RY2BX7+dnKj+GTkXfdsAC8q8oxkGChzkUWhfJIsY');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
