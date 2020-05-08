-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2018 at 01:39 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tebak-aku`
--

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE `quiz` (
  `id_quiz` int(11) NOT NULL,
  `soal_quiz` varchar(255) NOT NULL,
  `jawaban_quiz` varchar(100) NOT NULL,
  `gambar_quiz` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiz`
--

INSERT INTO `quiz` (`id_quiz`, `soal_quiz`, `jawaban_quiz`, `gambar_quiz`) VALUES
(34, '', '', 'C:\\\\Users\\\\Layat\\\\Pictures\\\\100MEDIA\\\\YDXJ4748.jpg\\\\'),
(35, '', '', 'C:\\\\Users\\\\Layat\\\\Pictures\\\\100MEDIA\\\\YDXJ4865.jpg\\\\'),
(36, '', '', 'C:\\\\Users\\\\Layat\\\\Pictures\\\\100MEDIA\\\\YDXJ4749.jpg\\\\');

-- --------------------------------------------------------

--
-- Table structure for table `quiz_tebak_aku`
--

CREATE TABLE `quiz_tebak_aku` (
  `id_quiz` int(11) NOT NULL,
  `soal_quiz` varchar(255) NOT NULL,
  `jawaban_quiz` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiz_tebak_aku`
--

INSERT INTO `quiz_tebak_aku` (`id_quiz`, `soal_quiz`, `jawaban_quiz`) VALUES
(1, 'segitiga yang mempunyai 2 sisi yang sama panjang', 'Segitiga Sama Sisi'),
(7, 'Bangun datar seperti handphone', 'Persegi Panjang'),
(10, 'Yang menyerupai topi ulang tahun', 'Kerucut'),
(11, 'Bangun ruang yang tidak memiliki sudut', 'Lingkaran'),
(12, 'Bangun datar yang memiliki sisi sama panjang', 'Persegi'),
(13, 'Bangun ruang yang memiliki alas dan tutup berbentuk lingkaran', 'tabung'),
(14, 'bangun data yang memiliki sisi sama panjang', 'segitiga sama sisi');

-- --------------------------------------------------------

--
-- Table structure for table `quiz_tebak_angka`
--

CREATE TABLE `quiz_tebak_angka` (
  `id_quiz` int(11) NOT NULL,
  `soal_quiz` varchar(255) NOT NULL,
  `jawaban_quiz` varchar(255) NOT NULL,
  `pilihan_quiz` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiz_tebak_angka`
--

INSERT INTO `quiz_tebak_angka` (`id_quiz`, `soal_quiz`, `jawaban_quiz`, `pilihan_quiz`) VALUES
(1, '1 + 3', '4', '3,5,4,2'),
(6, '1 - 1', '0', '1,2,0,4'),
(7, '2 + 0', '2', '5,2,1,4'),
(10, '2 + 4', '6', '1,4,2,6'),
(11, '4 - 2', '2', '1,4,2,6'),
(12, '5-0', '5', '1,3,5,7');

-- --------------------------------------------------------

--
-- Table structure for table `quiz_tebak_gambar`
--

CREATE TABLE `quiz_tebak_gambar` (
  `id_quiz` int(11) NOT NULL,
  `soal_quiz` varchar(255) NOT NULL,
  `jawaban_quiz` varchar(100) NOT NULL,
  `pilihan_quiz` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiz_tebak_gambar`
--

INSERT INTO `quiz_tebak_gambar` (`id_quiz`, `soal_quiz`, `jawaban_quiz`, `pilihan_quiz`) VALUES
(1, 'E:\\\\Yusri Yusron\\\\Tugas\\\\Telkom University\\\\Semester 3\\\\Pemrograman Berbasis Objek\\\\Tugas Besar\\\\TebakAku\\\\Gambar Soal\\\\kerbau.jpg\\\\', 'Kerbau', 'Gajah,Kerbau,Sapi,Rusa'),
(2, 'E:\\\\Yusri Yusron\\\\Tugas\\\\Telkom University\\\\Semester 3\\\\Pemrograman Berbasis Objek\\\\Tugas Besar\\\\TebakAku\\\\Gambar Soal\\\\semut.jpg\\\\', 'Semut', 'Kutu,Laron,Semut,Lebah'),
(7, 'C:\\\\Users\\\\Layat\\\\Pictures\\\\2017-03-28 Sawah Baru 1\\\\Sawah Baru 1 001.png\\\\', 'Mawar', 'Mawar,Melati,Anggrek,Tulip'),
(8, 'E:\\\\Yusri Yusron\\\\Tugas\\\\Telkom University\\\\Semester 3\\\\Pemrograman Berbasis Objek\\\\Tugas Besar\\\\TebakAku\\\\Gambar Soal\\\\melati.jpg\\\\', 'Melati', 'Dahlia,Melati,Mawar,Kamboja'),
(9, 'E:\\\\Yusri Yusron\\\\Tugas\\\\Telkom University\\\\Semester 3\\\\Pemrograman Berbasis Objek\\\\Tugas Besar\\\\TebakAku\\\\Gambar Soal\\\\zebra.jpg\\\\', 'zebra', 'kuda,sapi,zebra,kambing'),
(10, 'E:\\\\Yusri Yusron\\\\Tugas\\\\Telkom University\\\\Semester 3\\\\Pemrograman Berbasis Objek\\\\Tugas Besar\\\\TebakAku\\\\Gambar Soal\\\\raflesia.jpg\\\\', 'raflesia', 'mawar,melati,raflesia,kamboja'),
(11, 'E:\\\\Yusri Yusron\\\\Tugas\\\\Telkom University\\\\Semester 3\\\\Pemrograman Berbasis Objek\\\\Tugas Besar\\\\TebakAku\\\\Gambar Soal\\\\semut.jpg\\\\', 'semut', 'kecoa,semut,lalat,nyamuk');

-- --------------------------------------------------------

--
-- Table structure for table `temp_name`
--

CREATE TABLE `temp_name` (
  `idName` int(11) NOT NULL,
  `nameUser` varchar(100) NOT NULL,
  `skor_tebak_aku` int(11) DEFAULT NULL,
  `skor_tebak_gambar` int(11) DEFAULT NULL,
  `skor_tebak_angka` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `temp_name`
--

INSERT INTO `temp_name` (`idName`, `nameUser`, `skor_tebak_aku`, `skor_tebak_gambar`, `skor_tebak_angka`) VALUES
(1, 'Ateng', 10, 30, 20),
(2, 'Yusron', 1, NULL, NULL),
(5, 'Yus', 2, NULL, NULL),
(6, 'Ateng', 10, 30, 20),
(7, 'Atengs', NULL, NULL, NULL),
(8, 'Uhuy', 10, 30, NULL),
(11, 'yusri', 10, NULL, 20),
(12, 'Panji', 10, NULL, NULL),
(13, 'yulio', 10, NULL, NULL),
(15, 'feb', 20, NULL, NULL),
(16, 'YusriYusron', 40, 50, 20),
(17, 'feby', NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`id_quiz`);

--
-- Indexes for table `quiz_tebak_aku`
--
ALTER TABLE `quiz_tebak_aku`
  ADD PRIMARY KEY (`id_quiz`);

--
-- Indexes for table `quiz_tebak_angka`
--
ALTER TABLE `quiz_tebak_angka`
  ADD PRIMARY KEY (`id_quiz`);

--
-- Indexes for table `quiz_tebak_gambar`
--
ALTER TABLE `quiz_tebak_gambar`
  ADD PRIMARY KEY (`id_quiz`);

--
-- Indexes for table `temp_name`
--
ALTER TABLE `temp_name`
  ADD PRIMARY KEY (`idName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `id_quiz` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `quiz_tebak_aku`
--
ALTER TABLE `quiz_tebak_aku`
  MODIFY `id_quiz` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `quiz_tebak_angka`
--
ALTER TABLE `quiz_tebak_angka`
  MODIFY `id_quiz` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `quiz_tebak_gambar`
--
ALTER TABLE `quiz_tebak_gambar`
  MODIFY `id_quiz` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `temp_name`
--
ALTER TABLE `temp_name`
  MODIFY `idName` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
