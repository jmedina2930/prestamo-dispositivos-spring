-- Base de datos: `prestamo_dispositivos`

-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `Usuario` varchar(50) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Apellidos` varchar(40) NOT NULL,
  `Cedula` varchar(10) NOT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `Telefono` varchar(15) NOT NULL,
  `Contrasena` varchar(15) NOT NULL,
  `Rol` varchar(15) NOT NULL, 
  PRIMARY KEY (`Usuario`)
) ENGINE=InnoDB;

INSERT INTO `usuario` (`Usuario`, `Nombre`, `Apellidos`, `Cedula`, `Direccion`, `Telefono`, `Contrasena`, `Rol`) VALUES
('jjonathan.medina', 'Jonathan', 'Medina', '1020', 'av', '5986039', 'contraseña', 'Administrador');

-- Estructura de tabla para la tabla `dispositivo`
--

CREATE TABLE IF NOT EXISTS `dispositivo` (
  `Estado` varchar(10) NOT NULL,
  `id_dispositivo` int(5) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(60) NOT NULL,     
  PRIMARY KEY (`id_dispositivo`)
) ENGINE=InnoDB;


INSERT INTO `dispositivo` (`Estado`, `Descripcion`) VALUES
('Disponible', 'portatil');

-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE IF NOT EXISTS `prestamo` (
  `Codigo` int(5) NOT NULL AUTO_INCREMENT,  
  `Fecha_inicial` date NOT NULL,
  `Fecha_final` date NOT NULL,  
  `Nusuario` varchar(50) NOT NULL,
  `id` int(5) NOT NULL,
  `Estado_prestamo` varchar(15) NOT NULL,
  PRIMARY KEY (`Codigo`),
  
  FOREIGN KEY (`Nusuario`) REFERENCES `usuario` (`Usuario`),
  FOREIGN KEY (`id`) REFERENCES `dispositivo` (`id_dispositivo`)
) ENGINE=InnoDB;


