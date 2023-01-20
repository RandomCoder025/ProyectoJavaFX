-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-04-2022 a las 12:11:15
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hoja9`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clases`
--

CREATE TABLE `clases` (
  `id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `descripcion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clases`
--

INSERT INTO `clases` (`id`, `nombre`, `descripcion`) VALUES
(1, 'Explorador', 'Los exploradores se centran en el combate a distancia con arcos o 2 espadas curvas. Su especialidad es la de saber moverse y orientarse por un mapa grande. Pueden rastrear muy bien y tener compañeros animales'),
(2, 'Paladín', 'Los paladines se centran en las armas a dos manos o escudos grandes y un arma secundaria. Su especialidad es de proporcionar mucho daño y aguantar los ataques mas poderosos de los enemigos. Pueden aniquilar a los no muertos y son devotos a un dios. '),
(3, 'Artificiero', 'Los artificieros se centran en combinar la magia con la tecnología para crear versátiles bombas o torretas. Su especialidad es hacer daño y crear soluciones creativas a los problemas del grupo. Pueden tirar pocos hechizos y patatin'),
(4, 'Pícaro', 'Los pícaros se centran en dagas a ambas manos o ballestas cortas. Su especialidad es el sigilo y la capacidad de robar. Pueden asestar poderosos ataques por la espalda y esconderse en las sombras'),
(5, 'Clérigo', 'Los clérigos se centran en mazas a una mano y escudos medianos. Su especialidad es la de curar ampliamente a su grupo y crear escudos mágicos. Pueden aguantar daño y curar enfermedades '),
(6, 'Mago', 'Los magos se centran en lanzar hechizos mediante grimorios o bastones. Su especialidad es la de tener muchos hechizos y a niveles altos muy poderosos. Pueden tener la mayor cantidad de hechizos y los más poderosos'),
(7, 'Brujo', 'Los brujos se centran en pocos hechizos pero con gran impacto. Su especialidad son unos rituales útiles y hechizos siempre a máximo poder. Pueden recuperar los hechizos en un descanso corto y hacen un pacto con un dios maligno'),
(8, 'Druida', 'Los druidas se centran en hechizos de naturaleza y compañeros animales. Su especialidad es la versatilidad de hechizos y transformaciones animales.\r\nPueden recuperar sus hechizos tras un descanso corto y orientarse en los bosques'),
(9, 'Bardo', 'Los bardos se centran en las artes y la seducción. Su especialidad es la de mejorar sus ataques y a su equipo.\r\nPueden conjurar hechizos y poseer mucho conocimiento'),
(10, 'Bárbaro', 'Los bárbaros se centran en su fuerza y en ser un bruto. Su especialidad es la de aguantar mucho daño y pegar aún más fuerte. No saben leer y suelen ser bastante tontos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id` int(11) NOT NULL,
  `texto` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE `respuestas` (
  `id` int(11) NOT NULL,
  `texto` text NOT NULL,
  `id_preg` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clases`
--
ALTER TABLE `clases`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_preg` (`id_preg`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clases`
--
ALTER TABLE `clases`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD CONSTRAINT `respuestas_ibfk_1` FOREIGN KEY (`id_preg`) REFERENCES `preguntas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
