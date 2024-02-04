-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2021 at 10:30 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `final`
--

-- --------------------------------------------------------

--
-- Table structure for table `administration`
--

CREATE TABLE `administration` (
  `id` int(11) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `administration`
--

INSERT INTO `administration` (`id`, `username`, `password`) VALUES
(1, 'admin', 1234);

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `number` varchar(3) NOT NULL,
  `title` varchar(60) NOT NULL,
  `unitsCount` int(11) NOT NULL,
  `master1` varchar(60) DEFAULT NULL,
  `master2` varchar(60) DEFAULT NULL,
  `master3` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `number`, `title`, `unitsCount`, `master1`, `master2`, `master3`) VALUES
(1, 'C1', 'design of algorithms', 3, 'firstMaster', 'secondMaster', 'nill'),
(2, 'C2', 'data structures', 3, 'firstMaster', 'secondMaster', 'thirdMaster'),
(3, 'C3', 'linear algebra', 3, 'firstMaster', 'secondMaster', 'nill'),
(4, 'C4', 'math', 2, 'thirdMaster', 'fourthMaster', 'nill'),
(5, 'C5', 'computer architecure', 3, 'fourthMaster', 'nill', 'nill'),
(6, 'C6', 'micro', 2, 'firstMaster', 'thirdMaster', 'nill'),
(7, 'C7', 'electrical circuits', 2, 'secondMaster', 'fourthMaster', 'nill');

-- --------------------------------------------------------

--
-- Table structure for table `masterslessons`
--

CREATE TABLE `masterslessons` (
  `id` int(11) NOT NULL,
  `mastersName` varchar(60) NOT NULL,
  `mNum` varchar(60) NOT NULL,
  `lesson1` varchar(60) DEFAULT NULL,
  `lesson2` varchar(60) DEFAULT NULL,
  `lesson3` varchar(60) DEFAULT NULL,
  `lesson4` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `masterslessons`
--

INSERT INTO `masterslessons` (`id`, `mastersName`, `mNum`, `lesson1`, `lesson2`, `lesson3`, `lesson4`) VALUES
(1, 'firstMaster', 'm1', 'design of algorithms', 'data structures', 'linear algebra', 'micro'),
(2, 'secondMaster', 'm2', 'design of algorithms', 'data structures', 'linear algebra', 'electrical circuits'),
(3, 'thirdMaster', 'm3', 'data structures', 'math', 'micro', NULL),
(4, 'fourthMaster', 'm4', 'math', 'computer architecure', 'electrical circuits', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `id` int(11) NOT NULL,
  `roomName` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`id`, `roomName`) VALUES
(1, 'r1'),
(2, 'r2'),
(3, 'r3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `masterslessons`
--
ALTER TABLE `masterslessons`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
