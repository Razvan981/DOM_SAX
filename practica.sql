-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2019 at 09:29 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- -----------------------------------------------------------


--
-- Database: `practica_facultate`
--

create database practica_facultate;
use practica_facultate;


-- -----------------------------------------------------------

--
-- Table structure for table `produs`
--

CREATE TABLE `produs` (
  `id` int(6) UNSIGNED NOT NULL,
  `numele_produsului` varchar(30) NOT NULL,
  `greutate_in_Kg` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produs`
--

INSERT INTO `produs` (`id`, `numele_produsului`, `greutate_in_Kg`) VALUES
(1, 'cafea', '0.2'),
(2, 'zahar', '1'),
(3, 'faina', '2'),
(4, 'biscuiti', '15'),
(5, 'napolitane', '7');

-- -----------------------------------------------------------

--
-- Table structure for table `stoc_disponibil`
--

CREATE TABLE `stoc_disponibil` (
  `id` int(6) UNSIGNED NOT NULL,
  `nume_produs` varchar(30) NOT NULL,
  `cantitate` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stoc_disponibil`
--

INSERT INTO `stoc_disponibil` (`id`, `nume_produs`, `cantitate`) VALUES
(1, 'punga_cipsuri', '100'),
(2, 'caiet', '150'),
(3, 'paine', '75'),
(4, 'pix', '210'),
(5, 'creion', '50');


-- ---------------------------------------------------------

--
-- Table structure for table `stoc_epuizat`
--

CREATE TABLE `stoc_epuizat` (
  `id` int(6) UNSIGNED NOT NULL,
  `nume_produs` varchar(30) NOT NULL,
  `cantitate_necesara` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stoc_epuizat`
--

INSERT INTO `stoc_epuizat` (`id`, `nume_produs`, `cantitate_necesara`) VALUES
(1, 'otet', '300'),
(2, 'iaurt', '150'),
(3, 'branza_topita', '50'),
(4, 'malai', '120'),
(5, 'cozonac', '50');

-- ---------------------------------------------------------

--
-- Table structure for table `user_baza_de_date`
--

CREATE TABLE `user_baza_de_date` (
  `ID` int(25) NOT NULL,
  `nume` varchar(11) NOT NULL,
  `rol` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_baza_de_date`
--

INSERT INTO `user_baza_de_date` (`ID`, `nume`, `rol`) VALUES
(1, 'Razvan', 'admin'),
(2, 'Cosmin', 'user1'),
(3, 'Mihaita', 'user2'),
(4, 'Andreea', 'user3'),
(5, 'Ioana', 'user4');

-- --------------------------------------------------------

--
-- Table structure for table `angajati_magazin`
--

CREATE TABLE `angajati_magazin` (
  `ID` int(25) NOT NULL,
  `nume` varchar(11) NOT NULL,
  `prenume` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `angajati_magazin`
--

INSERT INTO `angajati_magazin` (`ID`, `nume`, `prenume`) VALUES
(1, 'Brinzan', 'Razvan'),
(2, 'Costache', 'Marius'),
(3, 'Croitoru', 'Mihaitza'),
(4, 'Ivan', 'Andrei'),
(5, 'Puscas', 'George');

-- --------------------------------------------------------


--
-- Indexes for table `produs`
--
ALTER TABLE `produs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stoc_disponibil`
--
ALTER TABLE `stoc_disponibil`
  ADD PRIMARY KEY (`id`);
  
--
-- Indexes for table `stoc_epuizat`
--
ALTER TABLE `stoc_epuizat`
  ADD PRIMARY KEY (`id`);
  
  
--
-- Indexes for table `user_baza_de_date`
--
ALTER TABLE `user_baza_de_date`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `angajati_magazin`
--
ALTER TABLE `angajati_magazin`
  ADD PRIMARY KEY (`ID`);
  
--
-- AUTO_INCREMENT for table `produs`
--
ALTER TABLE `produs`
  MODIFY `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
  
--
-- AUTO_INCREMENT for table `stoc_disponibil`
--
ALTER TABLE `stoc_disponibil`
  MODIFY `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `stoc_epuizat`
--
ALTER TABLE `stoc_epuizat`
  MODIFY `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
  
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
