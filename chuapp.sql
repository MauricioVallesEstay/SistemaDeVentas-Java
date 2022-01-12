-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-12-2021 a las 01:49:32
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `chuapp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `rutCliente` varchar(10) NOT NULL,
  `nomCliente` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `Telefono` int(9) NOT NULL,
  `correo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `rutCliente`, `nomCliente`, `direccion`, `Telefono`, `correo`) VALUES
(34, '222-2', 'rodrigo', 'asdasd', 121, 'asdas'),
(36, 'mauricio', '333-3', 'asdas', 1, 'adas'),
(37, '444-4', 'gabriel', 'asdasd', 123, 'asdsa'),
(38, '555-5', 'victor', 'asdasd', 1111, 'asdas'),
(39, '666-6', 'damari', 'adasd', 1231, 'asdas'),
(43, '111', '222', '344', 3333, '444'),
(44, '111', 'mauri', 'adas', 5555, 'asdsa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cotizacion`
--

CREATE TABLE `cotizacion` (
  `idCotizacion` int(11) NOT NULL,
  `nomTienda` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` int(9) NOT NULL,
  `urlPagTienda` varchar(50) NOT NULL,
  `distribucion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cotizacion`
--

INSERT INTO `cotizacion` (`idCotizacion`, `nomTienda`, `direccion`, `telefono`, `urlPagTienda`, `distribucion`) VALUES
(7, 'detergentes Aromax', 'san pablo', 90909, 'www.aromax.com', 'detergentes lavalozas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `despacho`
--

CREATE TABLE `despacho` (
  `idDespacho` int(11) NOT NULL,
  `cliente` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `repartidor` varchar(100) NOT NULL,
  `fecha` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `despacho`
--

INSERT INTO `despacho` (`idDespacho`, `cliente`, `direccion`, `repartidor`, `fecha`) VALUES
(3, 'cliente2', 'direccion2', 'nomRepartidor', '04/12/2021'),
(4, 'adasd', 'asdsa', 'adas', '04/12/2021'),
(5, 'cristobal', 'Peñalolen', 'xd', '04/12/2021'),
(6, 'cristobal', 'Peñalolen', 'antonio', '04/12/2021'),
(7, 'mauricio', 'asdas', 'antonio', '04/12/2021');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `idDetalleVenta` int(11) NOT NULL,
  `cod_pro` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `id_ventaCabecera` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`idDetalleVenta`, `cod_pro`, `cantidad`, `precio`, `id_ventaCabecera`) VALUES
(38, '2', 1, '3500.00', 58),
(39, '1', 1, '2500.00', 58),
(40, '3', 1, '3500.00', 58),
(41, '1', 1, '2500.00', 59),
(42, '2', 1, '3500.00', 59),
(43, '1', 1, '2500.00', 60),
(44, '2', 1, '3500.00', 60),
(45, '3', 1, '3500.00', 60),
(46, '1', 1, '2500.00', 61),
(47, '2', 1, '3500.00', 61),
(48, '1', 1, '2500.00', 62);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devocabecera`
--

CREATE TABLE `devocabecera` (
  `idDevoCabecera` int(11) NOT NULL,
  `Cliente` varchar(50) NOT NULL,
  `IdVenta` int(11) NOT NULL,
  `situacion` varchar(50) NOT NULL,
  `observacion` varchar(100) NOT NULL,
  `OpDevolucion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `devocabecera`
--

INSERT INTO `devocabecera` (`idDevoCabecera`, `Cliente`, `IdVenta`, `situacion`, `observacion`, `OpDevolucion`) VALUES
(9, 'cristobal', 11, 'Estado Producto', 'asd', 'Cambio de producto'),
(10, 'victor', 111, 'Estado Producto', 'asdas', 'Cambio de producto'),
(11, 'cristobal', 111, 'Estado Producto', 'asdasd', 'Devolucion dinero'),
(12, 'rodrigo', 111, 'Estado Producto', 'asdas', 'Cambio de producto'),
(13, 'gabriel', 333, 'Recibo del Despacho', 'asdasda', 'Devolucion dinero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devodetalle`
--

CREATE TABLE `devodetalle` (
  `idDevoDetalle` int(11) NOT NULL,
  `cod_producto` varchar(50) NOT NULL,
  `descProducto` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `devodetalle`
--

INSERT INTO `devodetalle` (`idDevoDetalle`, `cod_producto`, `descProducto`, `cantidad`) VALUES
(3, '1', 'Detergente Ro', 2),
(4, '2', 'lavaloza', 1),
(5, '1', 'Detergente Ro', 2),
(6, '1', 'Detergente Ro', 2),
(7, '2', 'lavaloza', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL,
  `rutEmpresa` varchar(11) NOT NULL,
  `nomEmpresa` varchar(100) NOT NULL,
  `telefono` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `mensaje` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `codigo` varchar(25) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `stock` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `proveedor` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `codigo`, `descripcion`, `stock`, `precio`, `proveedor`) VALUES
(10, '1', 'Detergente Ro', 48, '2500.00', 'Ro'),
(11, '2', 'lavaloza', 20, '3500.00', 'Ro'),
(12, '3', 'Limpia Piso', 37, '3500.00', 'aromax');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `rutProveedor` varchar(10) NOT NULL,
  `nomProveedor` varchar(25) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `Telefono` int(9) NOT NULL,
  `correo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `rutProveedor`, `nomProveedor`, `direccion`, `Telefono`, `correo`) VALUES
(225, '209133', 'proveedor', 'asdas', 111, 'asdas'),
(226, '110', 'Ro', 'direccion', 972882758, 'correo@gmail.com'),
(227, '10202', 'aromax', 'asda', 123134, 'asda');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reclamo`
--

CREATE TABLE `reclamo` (
  `idReclamo` int(11) NOT NULL,
  `rutCliente` varchar(15) NOT NULL,
  `nomCliente` varchar(50) NOT NULL,
  `comentario` varchar(100) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `idVenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reclamo`
--

INSERT INTO `reclamo` (`idReclamo`, `rutCliente`, `nomCliente`, `comentario`, `fecha`, `idVenta`) VALUES
(1, '11', 'asdas', 'asdasdasdasdasd', '04/12/2021', 111);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `repartidor`
--

CREATE TABLE `repartidor` (
  `idRepartidor` int(11) NOT NULL,
  `nomRepartidor` varchar(50) NOT NULL,
  `rutRepartidor` varchar(10) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `repartidor`
--

INSERT INTO `repartidor` (`idRepartidor`, `nomRepartidor`, `rutRepartidor`, `direccion`, `telefono`) VALUES
(4, 'antonio', '111-1', 'macul', 2324);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `rutUsuario` varchar(10) NOT NULL,
  `nomUsuario` varchar(50) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `rol` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `rutUsuario`, `nomUsuario`, `correo`, `pass`, `rol`) VALUES
(236, '222-2', 'Administrador', 'admin@gmail.com', 'admin', 'Administrador'),
(237, '111-1', 'Vendedor', 'vendedor@gmail.com', '1234', 'Vendedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventacabecera`
--

CREATE TABLE `ventacabecera` (
  `idVentaCabecera` int(11) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `vendedor` varchar(60) NOT NULL,
  `cliente` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ventacabecera`
--

INSERT INTO `ventacabecera` (`idVentaCabecera`, `fecha`, `total`, `vendedor`, `cliente`) VALUES
(58, '03/12/2021', '9500.00', 'Administrador', 'cristobal'),
(59, '03/12/2021', '6000.00', 'Administrador', 'rodrigo'),
(60, '03/12/2021', '9500.00', 'Administrador', 'victor'),
(61, '03/12/2021', '6000.00', 'Administrador', 'gabriel'),
(62, '03/12/2021', '2500.00', 'Administrador', 'damari');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  ADD PRIMARY KEY (`idCotizacion`);

--
-- Indices de la tabla `despacho`
--
ALTER TABLE `despacho`
  ADD PRIMARY KEY (`idDespacho`);

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`idDetalleVenta`);

--
-- Indices de la tabla `devocabecera`
--
ALTER TABLE `devocabecera`
  ADD PRIMARY KEY (`idDevoCabecera`);

--
-- Indices de la tabla `devodetalle`
--
ALTER TABLE `devodetalle`
  ADD PRIMARY KEY (`idDevoDetalle`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`idEmpresa`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indices de la tabla `reclamo`
--
ALTER TABLE `reclamo`
  ADD PRIMARY KEY (`idReclamo`);

--
-- Indices de la tabla `repartidor`
--
ALTER TABLE `repartidor`
  ADD PRIMARY KEY (`idRepartidor`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `ventacabecera`
--
ALTER TABLE `ventacabecera`
  ADD PRIMARY KEY (`idVentaCabecera`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  MODIFY `idCotizacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `despacho`
--
ALTER TABLE `despacho`
  MODIFY `idDespacho` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `idDetalleVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT de la tabla `devocabecera`
--
ALTER TABLE `devocabecera`
  MODIFY `idDevoCabecera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `devodetalle`
--
ALTER TABLE `devodetalle`
  MODIFY `idDevoDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `idEmpresa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=228;

--
-- AUTO_INCREMENT de la tabla `reclamo`
--
ALTER TABLE `reclamo`
  MODIFY `idReclamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `repartidor`
--
ALTER TABLE `repartidor`
  MODIFY `idRepartidor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=239;

--
-- AUTO_INCREMENT de la tabla `ventacabecera`
--
ALTER TABLE `ventacabecera`
  MODIFY `idVentaCabecera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
