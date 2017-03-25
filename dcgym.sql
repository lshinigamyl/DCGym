CREATE DATABASE  IF NOT EXISTS `dcgym` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dcgym`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dcgym
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` int(11) unsigned NOT NULL,
  `coment` varchar(100) DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  `people_id` int(11) unsigned NOT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customers_people_people_id` (`people_id`),
  CONSTRAINT `customers_people_people_id` FOREIGN KEY (`people_id`) REFERENCES `people` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (6000,'Constante con su entrenamiento','H',2016),(6001,'Llega siempre tarde','H',2017),(6002,'Cliente puntual','H',2018),(6003,'Dejo de asistir','H',2019),(6004,'Impuntal al pagar','H',2020),(6005,'Cliente constante','H',2021),(6006,'Inconstante en asistencias','H',2022),(6007,'Cliente a punto de ser dado de baja','H',2023),(6008,'Le falta pagar la reactivacion de su membresia.','H',2024),(6009,'Cliente predilecto','H',2025)(6010,'Falta cancelar el 50% de su membresia.','H',2027,10016),(6011,'Cliente predilecto.','H',2028,10017),(6012,'Aun debe el 30% de su membresia.','H',2029,10020),(6013,'Falta poco para renovacion de membresia.','H',2030,10021),(6014,'Puntual en los pagos.','H',2031,10022);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers_memberships`
--

DROP TABLE IF EXISTS `customers_memberships`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers_memberships` (
  `id` int(11) unsigned NOT NULL,
  `state` char(1) DEFAULT NULL,
  `customers_id` int(11) unsigned NOT NULL,
  `membership_types_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clientMemberships_customers_customers_id` (`customers_id`),
  KEY `clientMemberships_typesMemberships_typesMemberships_id` (`membership_types_id`),
  CONSTRAINT `clientMemberships_customers_customers_id` FOREIGN KEY (`customers_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `clientMemberships_typesMemberships_typesMemberships_id` FOREIGN KEY (`membership_types_id`) REFERENCES `membership_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers_memberships`
--

LOCK TABLES `customers_memberships` WRITE;
/*!40000 ALTER TABLE `customers_memberships` DISABLE KEYS */;
INSERT INTO `customers_memberships` VALUES (8000,'H',6000,7000),(8001,'H',6001,7001),(8002,'H',6002,7002),(8003,'H',6003,7001),(8004,'H',6004,7002),(8005,'H',6005,7000),(8006,'H',6006,7005),(8007,'H',6007,7003),(8008,'H',6008,7008),(8009,'H',6009,7007),(8010,'2017-03-27','H',6010,13010),(8011,'2017-03-31','H',6011,13011),(8012,'2017-04-18','H',6012,13012),(8013,'2017-03-18','H',6013,13013),(8014,'2017-05-01','H',6014,13014);
/*!40000 ALTER TABLE `customers_memberships` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers_routines`
--

DROP TABLE IF EXISTS `customers_routines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers_routines` (
  `id` int(11) unsigned NOT NULL,
  `state` char(1) DEFAULT NULL,
  `customers_id` int(11) unsigned NOT NULL,
  `routines_id` int(11) unsigned NOT NULL,
  `employees_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customersroutines_customers_customers_id` (`customers_id`),
  KEY `customersroutines_Iroutines_routines_id` (`routines_id`),
  KEY `customersroutines_employees_employees_id` (`employees_id`),
  CONSTRAINT `customersroutines_Iroutines_routines_id` FOREIGN KEY (`routines_id`) REFERENCES `routines` (`id`),
  CONSTRAINT `customersroutines_customers_customers_id` FOREIGN KEY (`customers_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `customersroutines_employees_employees_id` FOREIGN KEY (`employees_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers_routines`
--

LOCK TABLES `customers_routines` WRITE;
/*!40000 ALTER TABLE `customers_routines` DISABLE KEYS */;
INSERT INTO `customers_routines` VALUES (11000,'H',6000,4004,10000),(11001,'H',6001,4001,10000),(11002,'H',6002,4002,10019),(11003,'H',6003,4003,10020),(11004,'H',6004,4005,10004),(11005,'H',6005,4000,10003),(11006,'H',6006,4005,10009),(11007,'H',6007,4002,10008),(11008,'H',6008,4004,10013),(11009,'H',6009,4005,10014),(11010,6010,4000),(11011,6011,4003),(11012,6012,4005),(11013,6013,4000),(11014,6014,4002);
/*!40000 ALTER TABLE `customers_routines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_types`
--

DROP TABLE IF EXISTS `employee_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_types` (
  `id` int(11) unsigned NOT NULL,
  `nane` varchar(100) NOT NULL,
  `state` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_types`
--

LOCK TABLES `employee_types` WRITE;
/*!40000 ALTER TABLE `employee_types` DISABLE KEYS */;
INSERT INTO `employee_types` VALUES (9000,'Entrenador','H'),(9001,'Administrador','H'),(9002,'Gerente','H'),(9003,'Secretaria(o)','H');
/*!40000 ALTER TABLE `employee_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `id` int(11) unsigned NOT NULL,
  `state` char(1) DEFAULT NULL,
  `training_centers_id` int(11) unsigned NOT NULL,
  `people_id` int(11) unsigned NOT NULL,
  `employee_types_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employees_trainingcenters_trainingcenters_id` (`training_centers_id`),
  KEY `employees_people_people_id` (`people_id`),
  KEY `employees_typeemployees_typeemployees_id` (`employee_types_id`),
  CONSTRAINT `employees_people_people_id` FOREIGN KEY (`people_id`) REFERENCES `people` (`id`),
  CONSTRAINT `employees_trainingcenters_trainingcenters_id` FOREIGN KEY (`training_centers_id`) REFERENCES `training_centers` (`id`),
  CONSTRAINT `employees_typeemployees_typeemployees_id` FOREIGN KEY (`employee_types_id`) REFERENCES `employee_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (10000,'H',1000,2000,9000),(10001,'H',1000,2001,9001),(10002,'H',1000,2002,9002),(10003,'H',1002,2000,9000),(10004,'H',1002,2003,9000),(10005,'H',1002,2004,9001),(10006,'H',1002,2005,9003),(10007,'H',1002,2006,9002),(10008,'H',1003,2007,9000),(10009,'H',1003,2008,9000),(10010,'H',1003,2000,9000),(10011,'H',1003,2009,9002),(10012,'H',1003,2010,9001),(10013,'H',1004,2007,9000),(10014,'H',1004,2003,9000),(10015,'H',1004,2011,9001),(10016,'H',1004,2012,9002),(10018,'H',1004,2013,9003),(10019,'H',1001,2000,9000),(10020,'H',1001,2003,9000),(10021,'H',1001,2014,9002),(10022,'H',1001,2015,9001),(10023,'H',1004,2014,9001),(10024,'H',1004,2015,9002);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercises`
--

DROP TABLE IF EXISTS `exercises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercises` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3019 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercises`
--

LOCK TABLES `exercises` WRITE;
/*!40000 ALTER TABLE `exercises` DISABLE KEYS */;
INSERT INTO `exercises` VALUES (3000,'Abdominales','Estos son los clasicos abdominales','H'),(3001,'Planchas (ambos brasos, palmas)','Estas son las planchas que todo el mundo sabe hacer','H'),(3002,'Sentadillas','Flexionando rodillas y cadera para hacer bajar el cuerpo hacia el suelo sin perder la verticalidad.','H'),(3003,'Puente con pierna cruzada','Boca arriba con las rodillas flexionadas y luego cruza una pierna.','H'),(3004,'Curl de bíceps','Tomamos dos mancuernas y las elevamos como si estuviéramos martillando y bajamos lentamente el peso','H'),(3005,'Zancadas ','Un paso hacia adelante doblando las dos piernas hasta que la rodilla de atrás casi toque el suelo','H'),(3006,'Bicicleta ','Simula un movimiento de pedaleo constante con las piernas.','H'),(3007,'La tabla','Contraer isométricamente el abdomen para mantener el cuerpo en línea recta.','H'),(3008,'Saltar a la comba','Saltar al ritmo que quieras y con el salto que desees.','H'),(3009,'Pectorales','Las flexiones de pecho o lagartijas constituyen.','H'),(3010,'Estiramiento del cuello','Baja la cabeza hacia un lado y sujétala ligeramente con la mano contraria.','H'),(3011,'Estiramiento del flexor de la cadera\r\n','Tumbado de lado, agarra un pie con la mano y empuja la cadera hacia adelante.','H'),(3012,'Estiramiento del pectoral','De pie, con los hombros hacia abajo y el abdominal contraído, agarra las dos manos en la espalda. ','H'),(3013,'Estiramiento de isquiotibiales','Sentado en el suelo, extiende una pierna hacia adelante y mantén la otra flexionada.','H'),(3014,'Estiramiento de gemelos','De pie en un escalón, deja caer un talón hacia abajo','H'),(3015,'Estiramiento de tríceps','De pie o sentado, pon la mano derecha encima del hombro derecho con la palma mirando hacia delante.','H'),(3016,'Estiramiento de la parte exterior de la cadera','Tumbado boca arriba, flexiona la pierna derecha y pon la izquierda encima.','H'),(3017,'Remo horizontal','Con peso en ambas manos, y torso hacia adelante, elevamos ambas manos simultáneamente.','H'),(3018,'Elevaciones laterales de brazos','Con peso en ambas mano fleccionar los brazos hacia arriba.','H');
/*!40000 ALTER TABLE `exercises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercises_routines`
--

DROP TABLE IF EXISTS `exercises_routines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exercises_routines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sequence` varchar(100) DEFAULT NULL,
  `range` varchar(100) DEFAULT NULL,
  `repeat` varchar(100) DEFAULT NULL,
  `value_percent` varchar(100) DEFAULT NULL,
  `routines_id` int(11) unsigned NOT NULL,
  `exercises_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `exercisesroutines_exercises_exercises_id` (`exercises_id`),
  KEY `exercisesroutines_routines_routines_id` (`routines_id`),
  CONSTRAINT `exercisesroutines_exercises_exercises_id` FOREIGN KEY (`exercises_id`) REFERENCES `exercises` (`id`),
  CONSTRAINT `exercisesroutines_routines_routines_id` FOREIGN KEY (`routines_id`) REFERENCES `routines` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5017 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercises_routines`
--

LOCK TABLES `exercises_routines` WRITE;
/*!40000 ALTER TABLE `exercises_routines` DISABLE KEYS */;
INSERT INTO `exercises_routines` VALUES (5,'18','56','7','20',4005,3011),(5000,'30','60','5','3',4000,3001),(5001,'20','10','3','56',4000,3000),(5002,'15','30','2','9',4000,3005),(5003,'10','15','4','5',4001,3016),(5004,'30','20','4','4',4001,3013),(5005,'20','10','3','6',4001,3014),(5006,'12','30','2','12',4002,3004),(5007,'9','60','3','15',4002,3017),(5008,'8','60','2','10',4002,3018),(5009,'10','15','5','8',4003,3006),(5010,'13','15','3','9',4003,3007),(5011,'15','32','6','16',4003,3009),(5012,'5','25','5','7',4004,3003),(5013,'5','10','5','9',4004,3002),(5014,'5','20','5','12',4004,3008),(5015,'15','40','6','16',4005,3016),(5016,'22','50','3','18',4005,3012);
/*!40000 ALTER TABLE `exercises_routines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membership_types`
--

DROP TABLE IF EXISTS `membership_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membership_types` (
  `id` int(11) unsigned NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `cost` decimal(8,2) unsigned DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membership_types`
--

LOCK TABLES `membership_types` WRITE;
/*!40000 ALTER TABLE `membership_types` DISABLE KEYS */;
INSERT INTO `membership_types` VALUES (7000,'Oro',400.00,'Se permite el uso completo de maquinas, piscina y spa','tipo','H'),(7001,'Plata',360.00,'Se permite el uso de todas las maquinas, talleres y spa.','tipo','H'),(7002,'Bronce',250.00,'Se permite el uso completo de maquinas y ingreso a talleres.','tipo','H'),(7003,'SuperHero',315.00,'Uso completo de maquinas, talleres y  spa','tipo','H'),(7004,'Hero',275.00,'Uso completo de maquinas y spa','tipo','H'),(7005,'Survivor',168.00,'Uso de maquinas o  talleres ','tipo','H'),(7006,'SuperForce',520.00,'Se permite el uso completo de maquinas, talleres, spa y piscina','tipo','H'),(7007,'MetalForce',450.00,'Se permite el uso completo de maquinas , talleres y piscina.','tipo','H'),(7008,'Force',320.00,'Se permite el ingreso a talleres o maquinas','tipo','H');
/*!40000 ALTER TABLE `membership_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `people` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) DEFAULT NULL,
  `document_number` varchar(50) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `date_birth` date NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `cellphone` varchar(15) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `user` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2026 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (2000,'Pilato','Olmos Calderón','538106  ','PilatoOlmosCalderon@superrito.com ','1991-03-07','37478 Alba de Yeltes','788 630 030','788 630 030','olmos','olmos','H'),(2001,'Ursulina','Pizarro Reyna','775710','UrsulinaPizarroReyna@gustr.com ','1984-05-23','09110 Castrojeriz','664 859 133','664 859 133','ursila','ursila','H'),(2002,'Facunda','Padilla Cervantes','903685','FacundaPadillaCervantes@superrito.com ','1964-06-06','18438 Almegíjar','797 048 751','797 048 751','facunda','facunda','H'),(2003,'Athina','Alonso Villaseñor','384801','AthinaAlonsoVillasenor@superrito.com ','1954-12-13','03728 Alcalalí','798 368 058','798 368 058','athina','athina','H'),(2004,'Lolly','Haro Muro','669158','LollyHaroMuro@gustr.com 16, 1943','1943-07-16','Ventanilla de Beas, 63','624 417 553','624 417 553','lolly','lolly','H'),(2005,'Roxana','Felicidad Medina','153269','rox_medina@gmail.com','1986-06-19','Av. Los Higos 143','996 693 398','456 359 698','roxy','roxyme','H'),(2006,'Alberto','Paredes Guevara','459729','PardGue_Alb@hotmail.com','1975-08-27','Jr. Los cientificos 56','855 452 382','342 956 483','albert','albert','H'),(2007,'Felipe','Martinez Veracruz','526967','Vera_Felipe@gmail.com','1982-11-05','Call.Vasco de Gama','789 632 354','456 257 357','felipe','felipe23','H'),(2008,'Maria','Pomachagua De la Cruz','721586','Maria721@yahoo.com','1995-01-03','Jr. Unión 895','993 689 589','512 263 897','mariacruz','maria993','H'),(2009,'Julio','Melendez Ramirez','693269','julioRa@gmail.com','1991-10-26','Call. Los Girasoles 35','896 698 753','352 254 114','julio','juliora12','H'),(2010,'Fresia','Quiñones Mejia','655168','Fresi@yahoo.com','1988-03-24','Urb. Arboleda','953 356 457','485 236 157','fresia','fresia123','H'),(2011,'Marina','Vallejo Alvarez','865263','vallejo_mari@gmail.com','1979-10-19','Jr. Santa Clara','965 248 369','253 578 123','mari','mariaValle','H'),(2012,'Victor','Gonzales Manrique','533963','vict_56@hotmail.com','1992-06-05','Av. Marina','924 635 775','345 964 475','victor','vict15','H'),(2013,'Pamela','Vila Silva','453396','pame_vila@yahoo.com','1980-03-19','Call. Melgarejo 153','954 538 963','257 632 984','pame','pamevila','H'),(2014,'Francis','Villavicencio Martinez','325469','francis_325@hotmail.com','1991-12-28','Jr. Los Manzanales 85','964 757 369 ','458 423 125','francis','francis91','H'),(2015,'Carmindy','Melgarejo Sanchez','943366','carmin_66@gmail.com','1988-08-10','Av. Constructores','865 365 487','315 547 569','carmin','carmin66','H'),(2016,'Pablo','Quiñones Mejilla','254696','pablo_q@gmail.com','1989-06-21','Call. Los quimicos','963 425 962','243 693 968','pablo','pablo243','H'),(2017,'Joaquin','Remigio Ninatay','345869','remigio_nin@gmail.com','1985-09-30','Av. Vasco de Gama','694 365 657','232 356 395','joaquin','joaquin','H'),(2018,'Naomy','Fernandez Saravia','568773','naomy56@hotmail.com','1989-11-22','Call. Los Cariocos','965 366 985','452 369 754','naomy','naomy23','H'),(2019,'Will','Paredes Vallejo','452154','will452@yahoo.com','1984-01-18','Av. Flora Tristan 45','989 245 357','356 241 854','will456','will456','H'),(2020,'Darcy','Melendez Dionisio','697236','darcy_mele@gmail.com','1982-06-23','Jr. Fernandez 863','921 254 223','335 255 452','darcymele','darcy452','H'),(2021,'Enrique','Abad Acedo','758423','enrique159@yahoo.com','1992-06-19','Av. San Ignacio 96','968 754 365 ','256 785 455','enrique159 ','enrique159','H'),(2022,'Grecia','Quispe Alfonso','698739','greciaQ@yahoo.com','1985-02-28','Jr. Eduardo Marquez','899 556 741 ','221 963 996','greciaquispe','grecia123','H'),(2023,'Daniel','Ruiz Calleja','751423','daniel@hotmail.com','1990-08-23','Av. Oscar Benavides','965 365 885','336 445 221','daniel48','danielruiz','H'),(2024,'Karina','Fuentes Gilbert','365994','karina48@gmail.com','1985-01-28','Call. Jose Parodi 25','885 255 484','458 265 693','karina58','karina96','H'),(2025,'Rolando','Huertas Iriarte','693456','rolando456@yahoo.com','1984-11-26','Jr. Juan Pablo II 69','963 397 112','366 596 452','rolando','rolano485','H');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `records`
--

DROP TABLE IF EXISTS `records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `records` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `duration` varchar(255) DEFAULT NULL,
  `advance` varchar(255) DEFAULT NULL,
  `commentary` varchar(255) DEFAULT NULL,
  `customer_routines_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customerreoutes` (`customer_routines_id`),
  CONSTRAINT `customerreoutes` FOREIGN KEY (`customer_routines_id`) REFERENCES `customers_routines` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `records`
--

LOCK TABLES `records` WRITE;
/*!40000 ALTER TABLE `records` DISABLE KEYS */;
INSERT INTO `records` VALUES (12000,'2017-03-09',60,60,'Ligera lesión en el tobillo por el cual no completo el entrenamiento.',11000),(12001,'2017-03-09',60,80,'Se retiro antes de completar su entrenamiento.',11001),(12002,'2017-03-09',90,100,'Entrenamiento sin dificultades.',11002),(12003,'2017-03-09',30,50,'Se sintio mal de salud y se retiro temprano.',11003),(12004,'2017-03-09',40,100,'Completo sin dificultad el entrenamiento.',11004),(12005,'2017-03-09',50,70,'Al ser principiante su cuerpo no pudo resistir el entrenamiento en su totalidad.',11005),(12006,'2017-03-09',90,100,'Dificultad al hacer los ejercicios, pero logro la meta de completarlos.',11006),(12007,'2017-03-09',45,100,'Debe tener cuidado en no realizar los ejercicios de manera acelerada, pues sus musculos podrían dañarse.',11007),(12008,'2017-03-10',60,80,'No completo entrenamiento por la lesión al tobillo.',11000),(12009,'2017-03-10',90,100,'Poca resistencia fisica en las piernas. Se debe trabajar esa zona.',11001),(12010,'2017-03-10',45,90,'Agotamiento le impidio seguir adelante con la rutina.',11002),(12011,'2017-03-10',80,80,'Debilidad al no sentirce del todo bien de salud. No realizo como debia la rutina.',11003),(12012,'2017-03-10',60,100,'Sin complicación alguna en la rutina.',11004),(12013,'2017-03-10',60,90,'Aún tiene complicaciones pero esta mejorando. ',11005),(12014,'2017-03-10',70,100,'Mejor resistencia a los ejercicios.',11006),(12015,'2017-03-10',50,80,'\'No pudo seguir la rutina por un imprevisto.',11007),(12016,'2017-04-11',60,70,'Solo realiza los ejercicios que no comprometen su tobillo.',11000),(12017,'2017-03-11',55,100,'Sin complicaciones.',11001),(12018,'2017-03-11',75,90,'Tuvo que retirarse temprano y no completo la rutina.',11002),(12019,'2017-03-11',30,100,'Completo sin dificultad la rutina del día.',11003),(12020,'2017-03-11',96,90,'Se sentia cansado así que dejo de realizar un ejercicio.',11004),(12021,'2017-03-11',120,100,'Termino satisfactoriamente la rutina.',11005),(12022,'2017-03-11',83,80,'Se esforzo pero no pudo culminar con los dos ultimos ejercicios.',11006),(12023,'2017-03-11',45,100,'Se recomienda más paciencia al realizar los ejercicios.',11007),(12024,'2017-03-12',73,95,'Le falto realizar la mitad del segundo ejercicio.',11000),(12025,'2017-03-12',48,100,'Termino sin complicaciones.',11001),(12026,'2017-03-12',85,93,'No quiso realizar levantamiento de pesas.',11002),(12027,'2017-03-12',59,70,'Se nego a hacer un ejercicio por una dolencia que tenia.',11003),(12028,'2017-03-12',120,100,'Sin complicaciones en la rutina.',11004),(12029,'2017-03-12',30,50,'Se retiro antes de completar su entrenamiento.',11005),(12030,'2017-03-12',90,100,'Completo sin problemas.',11006),(12031,'2017-03-12',56,100,'Completo la rutina sin problemas.',11007);
/*!40000 ALTER TABLE `records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routines`
--

DROP TABLE IF EXISTS `routines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `routines` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4006 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routines`
--

LOCK TABLES `routines` WRITE;
/*!40000 ALTER TABLE `routines` DISABLE KEYS */;
INSERT INTO `routines` VALUES (4000,'full-body','De poco esfuerzo físico dirigido a principiantes','H'),(4001,'Charles Poliquin','Rutina que es especifica para relajar los musculos.','H'),(4002,'Starting Strength','Este es un programa muy simple pero efectivo en cuanto a ganancias de masa muscular y fuerza.','H'),(4003,'Torso – Piernas','Rutina para preparar tus músculos para entrenamientos más intensos.','H'),(4004,'5×5','Progresión sistemática para inducir ganancias y aumentar en los ejercicios principales.','H'),(4005,'Stephan Korte','Entrenamiento orientado hacia powerlifters o personas que quieren mejorar sus marcas personales.','H');
/*!40000 ALTER TABLE `routines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_center_memberships`
--

DROP TABLE IF EXISTS `training_center_memberships`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_center_memberships` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `state` varchar(255) DEFAULT NULL,
  `training_centers_id` int(10) unsigned NOT NULL,
  `types_memberships_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `traininccenter` (`training_centers_id`),
  KEY `typesmembershp` (`types_memberships_id`),
  CONSTRAINT `traininccenter` FOREIGN KEY (`training_centers_id`) REFERENCES `training_centers` (`id`),
  CONSTRAINT `typesmembershp` FOREIGN KEY (`types_memberships_id`) REFERENCES `membership_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_center_memberships`
--

LOCK TABLES `training_center_memberships` WRITE;
/*!40000 ALTER TABLE `training_center_memberships` DISABLE KEYS */;
/*!40000 ALTER TABLE `training_center_memberships` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_centers`
--

DROP TABLE IF EXISTS `training_centers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_centers` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `ruc` char(11) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `description` text,
  `website` varchar(100) DEFAULT NULL,
  `credit_card` varchar(15) NOT NULL,
  `user` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `state` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`,`credit_card`,`user`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_centers`
--

LOCK TABLES `training_centers` WRITE;
/*!40000 ALTER TABLE `training_centers` DISABLE KEYS */;
INSERT INTO `training_centers` VALUES (1000,'Gold\'s Gym Camacho','67171275648','Centro Comercial Plaza Camacho Av. Javier Prado Este 5193 La Molina','437-3539','Camacho@goldsgymperu.com','El 5 de Enero de 1998 Gold\'s Gym Camacho, nuestro primer local, abrió sus puertas; iniciándose un nuevo concepto en el Perú en lo que se refiere a gimnasios. Le ofrecemos un ambiente relajante y placentero para ayudar a alcanzar sus objetivos y encontrar su fuerza interior. n/ n/ Gold\'s Gym Camacho, ahora totalmente remodelado le ofrece modernos programas de entrenamiento, equipos de última tecnología, amplios ambientes cuidadosamente estructurados y un equipo altamente calificado que estará con Ud. los 365 días del año.','www.goldsgymperu.com','671712756483607','t_goldencamacho','goldencamacho','H'),(1001,'Gold\'s Gym Basadre','27564836071','Av. Jorge Basadre 548 San Isidro','221-9000','Basadre@goldsgymperu.com','El 5 de Noviembre del 2001 Gold\'s Gym Basadre, nuestro tercer local, abrió sus puertas, un moderno local de tres niveles, usted encontrará un ambiente energético y de apoyo total que se han comprometido a alcanzar sus metas.','www.goldsgymperu.com','275648360715792','t_goldenbasadre','goldenbasadre','H'),(1002,'Gold\'s Gym Lima Norte','83607157929','Centro Comercial Megaplaza Av. Alfredo Mendiola 3698 Independencia','485-1515','LimaNorte@goldsgymperu.com','El 15 de Febrero del 2003, Gold\'s Gym Lima Norte nuestro cuarto local, abrió sus puertas; de su espectacular local en Lima Norte con los más modernos equipos, y programas diseñados para todas las edades y niveles. n/n/ Gold\'s Gym Lima Norte, te ofrece amplios ambientes cuidadosamente estructurados, modernos programas de entrenamiento, nuevos equipos de última tecnología y personal altamente calificado que estará con Ud. los 365 días del año.','www.goldsgymperu.com','836071579291199','t_goldenlimanorte','goldenlimanorte','H'),(1003,'Sport life Perú Chacarrilla','52802384154','Av. Caminos del Inca 331 Chacarrilla','372-7738','chacariila@gmail.com','Somos un gymnasio sin descripcion, es por esto que estamos en blanco','http://sportlifeperu.com','528023841542209','t_lifechacarrilla','lifechacarrilla','H'),(1004,'Sport life Perú San Isidro','42209240103','Av. Jorge Basadre 801 - 805 San Isidro','421-8665','isidro@gmail.com','Somos un gymnasio sin descripcion, es por esto que estamos en blanco','http://sportlifeperu.com','422092401033054','t_lifeisidro','lifeisidro','H');
/*!40000 ALTER TABLE `training_centers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-20 23:30:46
