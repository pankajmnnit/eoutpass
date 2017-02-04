-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 31, 2017 at 08:25 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hostel`
--
CREATE DATABASE IF NOT EXISTS `hostel` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `hostel`;

-- --------------------------------------------------------

--
-- Table structure for table `hostel_table`
--

CREATE TABLE IF NOT EXISTS `hostel_table` (
  `COER_ID` int(20) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `F_name` varchar(30) NOT NULL,
  `Mob_No` varchar(50) NOT NULL,
  `DOB` varchar(20) NOT NULL,
  `Year` int(4) NOT NULL,
  `Branch` varchar(5) NOT NULL,
  `Father_NO` varchar(30) NOT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Room_No` int(3) NOT NULL,
  `Otp` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`COER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hostel_table`
--

INSERT INTO `hostel_table` (`COER_ID`, `Name`, `F_name`, `Mob_No`, `DOB`, `Year`, `Branch`, `Father_NO`, `Password`, `Room_No`, `Otp`) VALUES
(11056788, 'vivek', 'erw', '9897687543', '1994-11-28', 3, 'IT', '8976543256', '789', 189, NULL),
(12045788, 'raju', 'tr', '2147483647', '1995-02-01', 4, 'ME', '8123456789', '567', 122, NULL),
(12067544, 'Rajat', 'yui', '2147483647', '1994-03-30', 3, 'CE', '7865423456', '567', 413, NULL),
(14041001, 'pankaj', 'p', '8126604589', '1994-04-14', 3, 'CS', '9897686908', '67', 222, NULL),
(14041005, 'hemu', 'arv', '2147483647', '0000-00-00', 3, 'CS', '1234', NULL, 412, NULL),
(14041020, 'prateek', 'wed', '7409947582', '1995-02-14', 2, 'CS', '9853178543', '67', 333, NULL),
(14041022, 'naveen', 'tyu', '2147483647', '0000-00-00', 2, 'Me', '4538912345', NULL, 122, NULL),
(14041024, 'piyush', 'asq', '2147483647', '0000-00-00', 2, 'Me', '9812456783', NULL, 111, NULL),
(14041030, 'sanwal', 'arqwv', '8765432189', '1995-03-10', 3, 'CS', '1234', NULL, 312, NULL),
(14041031, 'sonu', 'arqwv', '8126604589', '0000-00-00', 3, 'CS', '1234', NULL, 312, NULL),
(14041043, 'neelesh', 'cb', '7409947582', '1995-11-04', 4, 'CS', '8826058557', '890', 314, '9196'),
(14041096, 'taun_sharma', 'arqwv', '8765432189', '1996-08-08', 3, 'CS', '1234', NULL, 112, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `outpass_data`
--

CREATE TABLE IF NOT EXISTS `outpass_data` (
  `COER_ID` int(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `F_NAME` varchar(20) NOT NULL,
  `Mob_No` varchar(50) NOT NULL,
  `Branch` varchar(8) NOT NULL,
  `Year` varchar(10) NOT NULL,
  `Outpass_No` varchar(10) NOT NULL,
  `Room_No` int(3) NOT NULL,
  `TIME_IN` varchar(20) NOT NULL,
  `TIME_OUT` varchar(20) NOT NULL,
  `OutpassReason` varchar(20) NOT NULL,
  `Confirmation` varchar(20) NOT NULL,
  `DATE` date NOT NULL,
  `PLACE` varchar(20) NOT NULL,
  `Changed` int(11) DEFAULT NULL,
  PRIMARY KEY (`COER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `outpass_data`
--

INSERT INTO `outpass_data` (`COER_ID`, `NAME`, `F_NAME`, `Mob_No`, `Branch`, `Year`, `Outpass_No`, `Room_No`, `TIME_IN`, `TIME_OUT`, `OutpassReason`, `Confirmation`, `DATE`, `PLACE`, `Changed`) VALUES
(12045788, 'raju', 'tr', '2147483647', 'ME', '4', 'qA20wcJ', 122, '02:01', '14:58', 'buu', 'pending', '2017-01-28', 'bbb', 0),
(14041001, 'pankaj', 'p', '8126604589', 'CS', '3', 'wb40DRC', 222, '09:00', '17:00', 'coaching', 'Granted', '2017-01-16', 'ROORKEE', 0),
(14041020, 'prateek', 'wed', '2147483647', 'CS', '2', 'QL84Rtg', 333, '13:00', '20:00', 'shopping ', 'Granted', '2017-01-16', 'ROORKEE', 0),
(14041043, 'neelesh', 'cb', '7409947582', 'CS', '4', 'vK82rhF', 314, '02:58', '14:02', 'bbb', 'Granted', '2017-02-01', 'bbb', 0);

-- --------------------------------------------------------

--
-- Table structure for table `records`
--

CREATE TABLE IF NOT EXISTS `records` (
  `COER_ID` int(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `F_NAME` varchar(20) NOT NULL,
  `Mob_No` varchar(50) NOT NULL,
  `Branch` varchar(8) NOT NULL,
  `Year` varchar(10) NOT NULL,
  `Outpass_No` varchar(10) NOT NULL,
  `Room_No` int(3) NOT NULL,
  `TIME_IN` varchar(20) NOT NULL,
  `TIME_OUT` varchar(20) NOT NULL,
  `OutpassReason` varchar(20) NOT NULL,
  `Confirmation` varchar(20) NOT NULL,
  `DATE` date NOT NULL,
  `PLACE` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `warden`
--

CREATE TABLE IF NOT EXISTS `warden` (
  `name` varchar(20) NOT NULL,
  `hostel` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `ID` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `warden`
--

INSERT INTO `warden` (`name`, `hostel`, `password`, `ID`) VALUES
('ansari', 'AHB', 'hostel', 4567);

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `backup_records` ON SCHEDULE EVERY 1 DAY STARTS '2017-01-16 20:00:00' ON COMPLETION NOT PRESERVE ENABLE DO INSERT INTO `records` SELECT * FROM `outpass_data` where  Confirmation='pending'$$

CREATE DEFINER=`root`@`localhost` EVENT `clean_outpassdata` ON SCHEDULE EVERY 1 DAY STARTS '2017-01-16 20:01:00' ON COMPLETION NOT PRESERVE ENABLE DO truncate `outpass_data`$$

DELIMITER ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
