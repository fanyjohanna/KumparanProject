/*
SQLyog - Free MySQL GUI v5.0
Host - 5.5.5-10.1.31-MariaDB : Database - kumparan_database
*********************************************************************
Server version : 5.5.5-10.1.31-MariaDB
*/


create database if not exists `kumparan_database`;

USE `kumparan_database`;

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `editor` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `news` */

insert into `news` values 
(1,'pemilu 2018 akan dilaksanakan tanggal 2018','Fany','pemilu','johanna','Draft');

/*Table structure for table `news_topic` */

DROP TABLE IF EXISTS `news_topic`;

CREATE TABLE `news_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `news_id` int(11) NOT NULL,
  `topic_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `news_topic` */

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `topic` */

insert into `topic` values 
(1,'pemilu'),
(2,'mobil');
