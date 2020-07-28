-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 25, 2019 at 02:43 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `baza`
--

-- --------------------------------------------------------

--
-- Table structure for table `studentilicni`
--

CREATE TABLE `studentilicni` (
  `ime` text NOT NULL,
  `prezime` text NOT NULL,
  `indeks` int(11) NOT NULL,
  `ulica` varchar(30) NOT NULL,
  `grad` text NOT NULL,
  `jmbg` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentilicni`
--

INSERT INTO `studentilicni` (`ime`, `prezime`, `indeks`, `ulica`, `grad`, `jmbg`) VALUES
('Milos', 'Stolica', 2342, 'Mojsijeva', 'Beograd', '23467823423'),
('Lazar', 'Radicevic', 2343, 'Radinovacka', 'Beograd', '23423423423'),
('Stefan', 'Mitrovic', 3714, 'Vladetina', 'Beograd', '0407994710063'),
('Marko', 'Markovic', 4455, 'cvijiceva', 'Beograd', '24357823423'),
('Darko', 'Darkic', 4561, 'Milankova', 'Gornji milanovac', '2342342343245'),
('Nemanja', 'Stepic', 7832, 'Njegoseva', 'Beograd', '2435435345345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `studentilicni`
--
ALTER TABLE `studentilicni`
  ADD PRIMARY KEY (`indeks`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
