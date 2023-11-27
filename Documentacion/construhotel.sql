-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-11-2023 a las 18:48:09
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `construhotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservacionhotel`
--

CREATE TABLE `reservacionhotel` (
  `roomId` varchar(2) NOT NULL,
  `pricePerDay` float NOT NULL DEFAULT 550.5,
  `petAvailable` tinyint(1) NOT NULL,
  `impairedAvailable` tinyint(4) NOT NULL,
  `commodities` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reservacionhotel`
--

INSERT INTO `reservacionhotel` (`roomId`, `pricePerDay`, `petAvailable`, `impairedAvailable`, `commodities`) VALUES
('11', 750.5, 1, 0, 'Tina, Spa, Balcón'),
('12', 750.5, 1, 1, 'Balcón, regadera amplia'),
('13', 650.5, 0, 1, 'Regadera amplia, vista al mar'),
('14', 550.5, 1, 1, 'Regadera amplia'),
('15', 550.5, 0, 0, 'Vista al mar, tina'),
('16', 850.5, 1, 1, 'Balcón, vista al mar, regadera amplia, spa'),
('21', 600, 1, 0, 'tina,spa'),
('22', 620, 0, 1, 'regadera'),
('23', 650, 1, 0, 'spa'),
('24', 700, 0, 1, 'tina,regadera'),
('25', 670, 1, 1, 'tina,spa,regadera'),
('31', 650, 0, 1, 'spa'),
('32', 630, 1, 0, 'tina,regadera'),
('33', 690, 0, 1, 'spa,regadera'),
('34', 600, 1, 0, 'tina'),
('35', 620, 0, 1, 'regadera'),
('36', 670, 1, 1, 'tina,spa,regadera'),
('41', 620, 0, 1, 'regadera'),
('42', 650, 1, 0, 'spa'),
('43', 700, 0, 1, 'tina,regadera'),
('44', 670, 1, 1, 'tina,spa,regadera'),
('45', 600, 1, 0, 'tina'),
('46', 630, 0, 1, 'tina,regadera'),
('51', 650, 1, 0, 'spa'),
('52', 690, 0, 1, 'spa,regadera'),
('53', 620, 0, 1, 'regadera'),
('54', 700, 0, 1, 'tina,regadera'),
('55', 670, 1, 1, 'tina,spa,regadera'),
('56', 600, 1, 0, 'tina'),
('D1', 550.5, 1, 1, 'Acceso a buffet, piscina en techo, spa con masaje'),
('D2', 550.5, 1, 1, 'Acceso a buffet, piscina en techo, spa con masaje');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usershotel`
--

CREATE TABLE `usershotel` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Family Names` varchar(50) NOT NULL,
  `Pets` tinyint(1) NOT NULL,
  `Impaired movement` tinyint(1) NOT NULL,
  `Admin` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usershotel`
--

INSERT INTO `usershotel` (`Username`, `Password`, `Name`, `Family Names`, `Pets`, `Impaired movement`, `Admin`) VALUES
('Daroz', 'admin', 'Armando', 'Áviles López ', 0, 0, 1),
('ZeroPatatoso', 'Isaac123', 'Hernán Rodrigo', 'Muñoz Marrufo', 1, 0, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `reservacionhotel`
--
ALTER TABLE `reservacionhotel`
  ADD PRIMARY KEY (`roomId`);

--
-- Indices de la tabla `usershotel`
--
ALTER TABLE `usershotel`
  ADD PRIMARY KEY (`Username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
