-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 07 Des 2018 pada 07.00
-- Versi Server: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parkirdatabase`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenis_kendaraan`
--

CREATE TABLE `jenis_kendaraan` (
  `id_jenis` int(10) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `biaya` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jenis_kendaraan`
--

INSERT INTO `jenis_kendaraan` (`id_jenis`, `jenis`, `biaya`) VALUES
(1, 'Roda 2', 2000),
(2, 'Roda 4', 3000),
(4, 'Bus', 4000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `parkir_data`
--

CREATE TABLE `parkir_data` (
  `id_parkir` int(10) NOT NULL,
  `nomor_polisi` varchar(16) NOT NULL,
  `id_jenis` int(10) NOT NULL,
  `masuk` datetime NOT NULL,
  `keluar` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `parkir_data`
--

INSERT INTO `parkir_data` (`id_parkir`, `nomor_polisi`, `id_jenis`, `masuk`, `keluar`) VALUES
(1, 'B 1111 WWW', 1, '2018-12-05 09:13:15', NULL),
(2, 'D 2222 EEE', 2, '2018-12-05 09:13:28', NULL),
(3, 'L 3333 FFF', 1, '2018-12-05 09:13:44', NULL),
(4, 'Z 4444 CCC', 1, '2018-12-05 09:25:07', '2018-12-05 09:25:21'),
(5, 'A 5555 MMM', 2, '2018-12-05 09:39:26', NULL),
(6, 'Z 7777 DDD', 1, '2018-12-05 09:44:51', '2018-12-05 09:45:35'),
(7, 'D 8888 SSS', 2, '2018-12-05 09:45:55', '2018-12-05 09:46:25'),
(8, 'L 9999 EEE', 2, '2018-12-05 09:50:06', '2018-12-05 12:51:22'),
(9, 'K 8888 WWW', 1, '2018-12-05 12:51:41', '2018-12-06 12:53:09');

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas`
--

CREATE TABLE `petugas` (
  `username` int(15) NOT NULL,
  `password` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `petugas`
--

INSERT INTO `petugas` (`username`, `password`) VALUES
(0, 123);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jenis_kendaraan`
--
ALTER TABLE `jenis_kendaraan`
  ADD PRIMARY KEY (`id_jenis`);

--
-- Indexes for table `parkir_data`
--
ALTER TABLE `parkir_data`
  ADD PRIMARY KEY (`id_parkir`),
  ADD KEY `id_jenis` (`id_jenis`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jenis_kendaraan`
--
ALTER TABLE `jenis_kendaraan`
  MODIFY `id_jenis` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `parkir_data`
--
ALTER TABLE `parkir_data`
  MODIFY `id_parkir` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `parkir_data`
--
ALTER TABLE `parkir_data`
  ADD CONSTRAINT `parkir_data_ibfk_1` FOREIGN KEY (`id_jenis`) REFERENCES `jenis_kendaraan` (`id_jenis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
