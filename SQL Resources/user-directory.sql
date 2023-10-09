CREATE DATABASE  IF NOT EXISTS `user_directory`;
USE `user_directory`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_number` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `user`
--

INSERT INTO `user` VALUES 
	(1,'Leslie','Andrews','leslie@bezahive.work','3144756885'),
	(2,'Emma','Baumgarten','emma@bezahive.work','3144756886'),
	(3,'Avani','Gupta','avani@bezahive.work','3144756887'),
	(4,'Yuri','Petrov','yuri@bezahive.work','3144756888'),
	(5,'Juan','Vega','juan@bezahive.work','3144756889');

