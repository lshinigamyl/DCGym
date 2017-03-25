/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : dcgym

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-03-25 18:10:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `comment` text,
  `state` char(1) DEFAULT 'H',
  `people_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uno_idx` (`people_id`),
  CONSTRAINT `uno` FOREIGN KEY (`people_id`) REFERENCES `people` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('5000', 'probando', 'H', '1001');

-- ----------------------------
-- Table structure for customers_gym_membership_types
-- ----------------------------
DROP TABLE IF EXISTS `customers_gym_membership_types`;
CREATE TABLE `customers_gym_membership_types` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `start_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `state` char(1) DEFAULT 'H',
  `customer_id` int(10) unsigned NOT NULL,
  `gyms_membership_types_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uno_idx` (`customer_id`),
  KEY `dos_idx` (`gyms_membership_types_id`),
  CONSTRAINT `sdfas44` FOREIGN KEY (`gyms_membership_types_id`) REFERENCES `gyms_membership_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tres3` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customers_gym_membership_types
-- ----------------------------

-- ----------------------------
-- Table structure for customers_routines
-- ----------------------------
DROP TABLE IF EXISTS `customers_routines`;
CREATE TABLE `customers_routines` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) unsigned NOT NULL,
  `routine_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uno_idx` (`customer_id`),
  KEY `dos_idx` (`routine_id`),
  CONSTRAINT `dos` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tres` FOREIGN KEY (`routine_id`) REFERENCES `routines` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customers_routines
-- ----------------------------

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `state` char(1) DEFAULT 'H',
  `gym_id` int(10) unsigned NOT NULL,
  `people_id` int(10) unsigned NOT NULL,
  `employee_type_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uno_idx` (`people_id`),
  KEY `dos_idx` (`gym_id`),
  KEY `tres_idx` (`employee_type_id`),
  CONSTRAINT `dgfdsgsdg` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fsdgsdf` FOREIGN KEY (`people_id`) REFERENCES `people` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tressfdgsdgsg` FOREIGN KEY (`employee_type_id`) REFERENCES `employee_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('3002', 'H', '4000', '1000', '2000');
INSERT INTO `employees` VALUES ('3003', 'H', '4001', '1008', '2001');

-- ----------------------------
-- Table structure for employee_types
-- ----------------------------
DROP TABLE IF EXISTS `employee_types`;
CREATE TABLE `employee_types` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `state` char(1) DEFAULT 'H',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_types
-- ----------------------------
INSERT INTO `employee_types` VALUES ('2000', 'uyiy', 'H');
INSERT INTO `employee_types` VALUES ('2001', 'Entrenado', 'H');
INSERT INTO `employee_types` VALUES ('2002', 'Gerente', 'H');
INSERT INTO `employee_types` VALUES ('2003', 'Administrador', 'H');

-- ----------------------------
-- Table structure for exercises
-- ----------------------------
DROP TABLE IF EXISTS `exercises`;
CREATE TABLE `exercises` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exercises
-- ----------------------------

-- ----------------------------
-- Table structure for exercises_routines
-- ----------------------------
DROP TABLE IF EXISTS `exercises_routines`;
CREATE TABLE `exercises_routines` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `comment` text,
  `state` char(1) DEFAULT 'H',
  `range` int(11) DEFAULT NULL,
  `repeat` int(11) DEFAULT NULL,
  `value_percent` int(11) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `exercise_id` int(10) unsigned NOT NULL,
  `routine_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uno_idx` (`exercise_id`),
  KEY `dos_idx` (`routine_id`),
  CONSTRAINT `sdgb` FOREIGN KEY (`routine_id`) REFERENCES `routines` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `vvfsdgsdbg` FOREIGN KEY (`exercise_id`) REFERENCES `exercises` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exercises_routines
-- ----------------------------

-- ----------------------------
-- Table structure for gyms
-- ----------------------------
DROP TABLE IF EXISTS `gyms`;
CREATE TABLE `gyms` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `description` text,
  `website` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4006 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gyms
-- ----------------------------
INSERT INTO `gyms` VALUES ('4000', 'Gold\'s Gym Camacho', ' Av. Javier Prado Este 5193 ', '437-353', '996 639 554', 'Camacho@goldsgymperu.com', 'El 5 de Enero de 1998 Gold\\\'s Gym Camacho, nuestro primer local, abrió sus puertas; iniciándose un nuevo concepto en el Perú en lo que se refiere a gimnasios. Le ofrecemos un ambiente relajante y placentero para ayudar a alcanzar sus objetivos y encontrar su fuerza interior. n/ n/ Gold\\\'s Gym Camacho, ahora totalmente remodelado le ofrece modernos programas de entrenamiento, equipos de última tecnología, amplios ambientes cuidadosamente estructurados y un equipo altamente calificado que estará con Ud. los 365 días del año', 'www.goldsgymperu.com', 'golds4', '67171275648');
INSERT INTO `gyms` VALUES ('4001', 'Gold\'s Gym Camacho', ' Av. Javier Prado Este 5193 ', '437-353', '996 639 554', 'Camacho@goldsgymperu.com', 'El 5 de Enero de 1998 Gold\\\'s Gym Camacho, nuestro primer local, abrió sus puertas; iniciándose un nuevo concepto en el Perú en lo que se refiere a gimnasios. Le ofrecemos un ambiente relajante y placentero para ayudar a alcanzar sus objetivos y encontrar su fuerza interior. n/ n/ Gold\\\'s Gym Camacho, ahora totalmente remodelado le ofrece modernos programas de entrenamiento, equipos de última tecnología, amplios ambientes cuidadosamente estructurados y un equipo altamente calificado que estará con Ud. los 365 días del año', 'www.goldsgymperu.com', 'golds1', '67171275648');
INSERT INTO `gyms` VALUES ('4002', 'Gold\'s Gym Basadre', 'Av. Jorge Basadre 548 San Isidro', '221-9000', '865 963 753', 'Basadre@goldsgymperu.com', 'El 5 de Noviembre del 2001 Gold\\\'s Gym Basadre, nuestro tercer local, abrió sus puertas, un moderno local de tres niveles, usted encontrará un ambiente energético y de apoyo total que se han comprometido a alcanzar sus metas.\r\n ', 'www.goldsgymperu.com', 'golds2', '27564836071');
INSERT INTO `gyms` VALUES ('4003', 'Gold\'s Gym Lima Norte', 'Av. Alfredo Mendiola 3698', '485-1515', '985 254 524', 'LimaNorte@goldsgymperu.com', 'Gold\\\'s Gym Lima Norte nuestro cuarto local, abrió sus puertas; de su espectacular local en Lima Norte con los más modernos equipos, y programas diseñados para todas las edades y niveles. n/n/ Gold\\\'s Gym Lima Norte, te ofrece amplios ambientes cuidadosamente estructurados, modernos programas de entrenamiento, nuevos equipos de última tecnología y personal altamente calificado que estará con Ud. los 365 días del año. ', 'www.goldsgymperu.com', 'golds3', '83607157929');
INSERT INTO `gyms` VALUES ('4004', 'Sport life Perú Chacarrilla', 'Av. Caminos del Inca 331', '372-7738', '857 452 336', 'chacariila@gmail.com', 'Este gimnasio busca siempre estar a la altura de los requerimientos del cliente y por ello brindamos los mejores servicios de entrenamiento con personal altamanete calificado.', 'www.sportlifeperu.com', 'sportlife', '52802384154');
INSERT INTO `gyms` VALUES ('4005', 'MegaGym', 'Av. Jorge Basadre 801 - 805 San Isidro', '421-8665', '865 654 223', 'isidro@gmail.com', 'Nuestro objetivo como empresa es brindarles a nuestros clientes las herramientas necesarias para que puedan lograr sus objetivos al obtener el cuerpo ideal y controlar su salud.', 'www.megagymperu.com', 'MegaGym', '42209240103');

-- ----------------------------
-- Table structure for gyms_membership_types
-- ----------------------------
DROP TABLE IF EXISTS `gyms_membership_types`;
CREATE TABLE `gyms_membership_types` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `state` char(1) DEFAULT 'H',
  `membership_type_id` int(10) unsigned NOT NULL,
  `gym_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uno_idx` (`gym_id`),
  KEY `dos_idx` (`membership_type_id`),
  CONSTRAINT `dsfgsdgggggffs` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sssssdd` FOREIGN KEY (`membership_type_id`) REFERENCES `membership_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gyms_membership_types
-- ----------------------------
INSERT INTO `gyms_membership_types` VALUES ('8000', 'H', '7000', '4001');
INSERT INTO `gyms_membership_types` VALUES ('8001', 'H', '7001', '4001');
INSERT INTO `gyms_membership_types` VALUES ('8002', 'N', '7001', '4001');
INSERT INTO `gyms_membership_types` VALUES ('8003', 'N', '7010', '4001');
INSERT INTO `gyms_membership_types` VALUES ('8004', 'N', '7011', '4001');

-- ----------------------------
-- Table structure for membership_types
-- ----------------------------
DROP TABLE IF EXISTS `membership_types`;
CREATE TABLE `membership_types` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `days_duration` int(11) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7012 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of membership_types
-- ----------------------------
INSERT INTO `membership_types` VALUES ('7000', 'Oro', '400', '30', 'Se permite el uso completo de maquinas, piscina y spa');
INSERT INTO `membership_types` VALUES ('7001', 'Plata', '360', '20', 'Se permite el uso de todas las maquinas, talleres y spa y este tbm.');
INSERT INTO `membership_types` VALUES ('7002', 'Bronce', '250', '20', 'Se permite el uso completo de maquinas y ingreso a talleres.');
INSERT INTO `membership_types` VALUES ('7003', 'SuperHero', '315', '20', 'Uso completo de maquinas, talleres y  spa');
INSERT INTO `membership_types` VALUES ('7004', 'Hero', '275', '20', 'Uso completo de maquinas y spa');
INSERT INTO `membership_types` VALUES ('7005', 'Survivor', '168', '20', 'Uso de maquinas o  talleres ');
INSERT INTO `membership_types` VALUES ('7006', 'SuperForce', '520', '20', 'Se permite el uso completo de maquinas, talleres, spa y piscina');
INSERT INTO `membership_types` VALUES ('7007', 'MetalForce', '450', '30', 'Se permite el uso completo de maquinas , talleres y piscina.');
INSERT INTO `membership_types` VALUES ('7008', 'Force', '320', '30', 'Se permite el ingreso a talleres o maquinas');
INSERT INTO `membership_types` VALUES ('7009', 'wrerfr', '50', '50', 'cxxcxcx');
INSERT INTO `membership_types` VALUES ('7010', 'fsdfsd', '435', '45', 'fdssgd');
INSERT INTO `membership_types` VALUES ('7011', 'dadf', '40', '10', 'gyjghj');

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `date_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1032 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('1000', 'Pilato', 'Olmos Calderón', '538106  ', '1991-03-07', 'PilatoOlmosCalderon@superrito.com ', '788630030', '788 630 030', 'Av. Marina', 'olmos', 'olmos');
INSERT INTO `people` VALUES ('1001', 'Ursulina', 'Pizarro Reyna', '775710', '1984-05-23', 'UrsulinaPizarroReyna@gustr.com', '664 859 133', '664 859 133', '09110 Castrojeriz', 'ursila', 'ursila');
INSERT INTO `people` VALUES ('1002', 'Facunda', 'Padilla Cervantes', '903685', '1964-06-06', 'FacundaPadillaCervantes@superrito.com', '797 048 751', '797 048 751', '18438 Almegíjar', 'facunda', 'facunda');
INSERT INTO `people` VALUES ('1003', 'Athina', 'Alonso Villaseñor', '384801', '1954-12-13', 'AthinaAlonsoVillasenor@superrito.com', '798 368 058', '798 368 058', '03728 Alcalalí', 'athina', 'athina');
INSERT INTO `people` VALUES ('1004', 'Lolly', 'Haro Muro', '669158', '1943-07-16', 'LollyHaroMuro@gustr.com', '624 417 553', '624 417 553', 'Ventanilla de Beas, 63', 'lolly', 'lolly');
INSERT INTO `people` VALUES ('1005', 'Roxana', 'Felicidad Medina', '153269', '1986-06-19', 'rox_medina@gmail.com', '996 693 398', '456 359 698', 'Av. Los Higos 143', 'roxy', 'roxy');
INSERT INTO `people` VALUES ('1006', 'Alberto', 'Paredes Guevara', '459729', '1975-08-27', 'PardGue_Alb@hotmail.com', '855 452 382', '342 956 483', 'Jr. Los cientificos 56', 'albert', 'albert');
INSERT INTO `people` VALUES ('1007', 'Felipe', 'Martinez Veracruz', '526967', '1982-11-05', 'Vera_Felipe@gmail.com', '789 632 354', '456 257 357', 'Call.Vasco de Gama', 'felipe', 'felipe');
INSERT INTO `people` VALUES ('1008', 'Maria', 'Pomachagua De la Cruz', '721586', '1995-01-03', 'Maria721@yahoo.com', '993 689 589', '993 689 589', 'Jr. Unión 895', 'mariacruz', 'mariacruz');
INSERT INTO `people` VALUES ('1009', 'Julio', 'Melendez Ramirez', '693269', '1991-10-26', 'julioRa@gmail.com', '896 698 753', '352 254 114', 'Call. Los Girasoles 35', 'julio', 'julio');
INSERT INTO `people` VALUES ('1010', 'Fresia', 'Quiñones Mejia', '655168', '1988-03-24', 'Fresi@yahoo.com', '953 356 457', '485 236 157', 'Urb. Arboleda', 'fresia', 'fresia');
INSERT INTO `people` VALUES ('1011', 'Marina', 'Vallejo Alvarez', '865263', '1979-10-19', 'vallejo_mari@gmail.com', '965 248 369', '253 578 123', 'Jr. Santa Clara', 'mari', 'mari');
INSERT INTO `people` VALUES ('1012', 'Victor', 'Gonzales Manrique', '533963', '1992-06-05', 'vict_56@hotmail.com', '924 635 775', '345 964 475', 'Av. Marina', 'victor', 'victor');
INSERT INTO `people` VALUES ('1013', 'Pamela', 'Vila Silva', '453396', '1980-03-19', 'pame_vila@yahoo.com', '954 538 963', '257 632 984', 'Call. Melgarejo 153', 'pame', 'pame');
INSERT INTO `people` VALUES ('1014', 'Francis', 'Villavicencio Martinez', '325469', '1991-12-28', 'francis_325@hotmail.com', '964 757 369', '458 423 125', 'Jr. Los Manzanales 85', 'francis', 'francis');
INSERT INTO `people` VALUES ('1015', 'Carmindy', 'Melgarejo Sanchez', '943366', '1988-08-10', 'carmin_66@gmail.com', '865 365 487', '315 547 569', 'Av. Constructores', 'carmin', 'carmin');
INSERT INTO `people` VALUES ('1016', 'Pablo', 'Quiñones Mejilla', '254696', '1989-06-21', 'pablo_q@gmail.com', '963 425 962', '243 693 968', 'Call. Los quimicos', 'pablo', 'pablo');
INSERT INTO `people` VALUES ('1017', 'Joaquin', 'Remigio Ninatay', '345869', '1985-09-30', 'remigio_nin@gmail.com', '694 365 657', '232 356 395', 'Av. Vasco de Gama', 'joaquin', 'joaquin');
INSERT INTO `people` VALUES ('1018', 'Naomy', 'Fernandez Saravia', '568773', '1989-11-22', 'naomy56@hotmail.com', '965 366 985', '452 369 754', 'Call. Los Cariocos', 'naomy', 'naomy');
INSERT INTO `people` VALUES ('1019', 'Will', 'Paredes Vallejo', '452154', '1984-01-18', 'will452@yahoo.com', '989 245 266 ', '356 241 854', 'Av. Flora Tristan 45', 'will456', 'will456');
INSERT INTO `people` VALUES ('1020', 'Darcy', 'Melendez Dionisio', '697236', '1982-06-23', 'darcy_mele@gmail.com', '921 254 223', '335 255 452', 'Jr. Fernandez 863', 'darcymele', 'darcymele');
INSERT INTO `people` VALUES ('1021', 'Enrique', 'Abad Acedo', '758423', '1992-06-19', 'enrique159@yahoo.com', '968 754 365', '256 785 455', 'Av. San Ignacio 96', 'enrique', 'enrique');
INSERT INTO `people` VALUES ('1022', 'Grecia', 'Quispe Alfonso', '698739', '1985-02-28', 'greciaQ@yahoo.com', '899 556 741', '221 963 996', 'Jr. Eduardo Marquez', 'grecia', 'grecia');
INSERT INTO `people` VALUES ('1023', 'Daniel', 'Ruiz Calleja', '751423', '1990-08-23', 'daniel@hotmail.com', '965 365 885', '336 445 221', 'Av. Oscar Benavides', 'daniel', 'daniel');
INSERT INTO `people` VALUES ('1024', 'Karina', 'Fuentes Gilber', '365994', '1985-01-28', 'karina48@gmail.com', '885 255 484', '458 265 693', 'Call. Jose Parodi 25', 'karina', 'karina');
INSERT INTO `people` VALUES ('1025', 'Rolando', 'Huertas Iriarte', '693456', '1984-11-26', 'rolando456@yahoo.com', '963 397 112', '366 596 452', 'Jr. Juan Pablo II 69', 'rolando', 'rolando');
INSERT INTO `people` VALUES ('1026', 'Ruby', 'Velarde Romani', '853228', '1988-05-18', 'ruby_velarde@gmail.com', '856 963 452', '356 935 896', 'Av. Javier Prado 156', 'ruby', 'ruby');
INSERT INTO `people` VALUES ('1027', 'Ernesto', 'Vasquez Flores', '963562', '1990-08-16', 'ernesto@yahoo.com', '965 356 452 ', '345 321 100 ', 'Jr. Flamencos 45', 'ernesto', 'ernesto');
INSERT INTO `people` VALUES ('1028', 'Miriam', 'Fernandez Ruiz', '154789', '1985-10-07', 'miriam@yahoo.com', '632 587 248', '157 253 635', 'Call. Los Higos', 'miriam', 'miriam');
INSERT INTO `people` VALUES ('1029', 'David', 'Bartolo De la Cruz', '936695', '1986-08-13', 'david@gmail.com', '987 152 478 ', '251 452 100', 'Av. España 863', 'david', 'david');
INSERT INTO `people` VALUES ('1030', 'Jose', 'Espinoza Vilchez', '254735', '1992-11-26', 'jose34@gmail.com', '945 255 000', '245 365 781 ', 'Av. La Molina 56', 'jose', 'jose');
INSERT INTO `people` VALUES ('1031', 'Sheyla', 'Ramos Castillo', '235742', '1992-04-19', 'shey@yahoo.com', '856 247 230', '254 325 500', 'Jr. Los Pinos 15', 'shey', 'shey');

-- ----------------------------
-- Table structure for records
-- ----------------------------
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `progress` int(11) DEFAULT NULL,
  `comment` text,
  `customer_routine_id` int(10) unsigned NOT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uno_idx` (`customer_routine_id`),
  KEY `dos_idx` (`employee_id`),
  CONSTRAINT `dsfgsdgfffff` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sdfgdsg` FOREIGN KEY (`customer_routine_id`) REFERENCES `customers_routines` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of records
-- ----------------------------

-- ----------------------------
-- Table structure for routines
-- ----------------------------
DROP TABLE IF EXISTS `routines`;
CREATE TABLE `routines` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` text,
  `state` char(1) DEFAULT 'H',
  `gym_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uno_idx` (`gym_id`),
  CONSTRAINT `sdfgsdggfffffffg` FOREIGN KEY (`gym_id`) REFERENCES `gyms` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of routines
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
