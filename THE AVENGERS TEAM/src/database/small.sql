-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2018 at 12:29 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `small`
--

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` int(10) NOT NULL,
  `nama_pegawai` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama_pegawai`, `username`, `password`) VALUES
(1, 'admin', 'admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `registrasi`
--

CREATE TABLE `registrasi` (
  `id_pemilik` int(10) NOT NULL,
  `nama_pemilik` varchar(50) NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tgl_lahir` varchar(50) NOT NULL,
  `bln_lahir` varchar(50) NOT NULL,
  `thn_lahir` varchar(50) NOT NULL,
  `nohp` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jenis_kelamin` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nama_toko` varchar(50) NOT NULL,
  `jenis_barang` varchar(50) NOT NULL,
  `jangka_waktu` int(50) NOT NULL,
  `total` varchar(50) NOT NULL,
  `tahap1` int(50) DEFAULT NULL,
  `tahap2` int(50) DEFAULT NULL,
  `tahap3` int(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `kode_toko` int(50) NOT NULL,
  `tgl_masuk` varchar(50) NOT NULL,
  `sisa_bayar` varchar(50) DEFAULT NULL,
  `tgl_keluar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registrasi`
--

INSERT INTO `registrasi` (`id_pemilik`, `nama_pemilik`, `tempat_lahir`, `tgl_lahir`, `bln_lahir`, `thn_lahir`, `nohp`, `alamat`, `jenis_kelamin`, `email`, `nama_toko`, `jenis_barang`, `jangka_waktu`, `total`, `tahap1`, `tahap2`, `tahap3`, `status`, `kode_toko`, `tgl_masuk`, `sisa_bayar`, `tgl_keluar`) VALUES
(1102, 'artika', 'subang', '1', 'Januari', '1999', '087771118', 'pga', 'perempuan', 'art@gmail.com', 'konter', 'tika cell', 1, '20000000', 10000000, 5000000, 5000000, 'Lunas', 102, '04-12-2018', '0', '04-12-2019'),
(2203, 'yulio', 'subang', '1', 'Januari', '1999', '08708899', 'bandung', 'laki - laki', 'yulio@gmail.com', 'makanan', 'mcd', 2, '20000000', NULL, NULL, NULL, NULL, 203, '4-12-2018', NULL, '4-12-2020');

-- --------------------------------------------------------

--
-- Table structure for table `toko`
--

CREATE TABLE `toko` (
  `kode_toko` int(50) NOT NULL,
  `lantai` int(50) NOT NULL,
  `status_toko` varchar(50) DEFAULT NULL,
  `ukuran` varchar(50) NOT NULL,
  `harga` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `toko`
--

INSERT INTO `toko` (`kode_toko`, `lantai`, `status_toko`, `ukuran`, `harga`) VALUES
(101, 1, '', '10x10', 16000000),
(102, 1, 'terisi', '9x11', 20000000),
(103, 1, '', '8x12', 14800000),
(104, 1, '', '11x9', 1700),
(105, 1, '', '10x10', 19000000),
(106, 2, '', '10x10', 10000000),
(107, 1, '', '10x10', 20000000),
(201, 2, '', '12x10', 18500000),
(202, 2, '', '13x9', 16800000),
(203, 2, 'terisi', '11x11', 10000000),
(204, 2, '', '10x12', 17500000),
(205, 2, '', '9x12', 15500000),
(206, 2, '', '10x10', 19000000),
(207, 2, '', '12x10', 19500000),
(208, 2, '', '12x10', 17800000),
(209, 2, '', '10x11', 290000000),
(301, 3, '', '13x10', 13000000),
(302, 3, '', '12x11', 14000000),
(303, 3, '', '11x12', 11000000),
(304, 3, '', '10x13', 13500000),
(305, 3, '', '13x10', 15000000),
(306, 3, '', '13x13', 18000000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `registrasi`
--
ALTER TABLE `registrasi`
  ADD PRIMARY KEY (`id_pemilik`);

--
-- Indexes for table `toko`
--
ALTER TABLE `toko`
  ADD PRIMARY KEY (`kode_toko`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `id_pegawai` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `registrasi`
--
ALTER TABLE `registrasi`
  MODIFY `id_pemilik` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2204;

--
-- AUTO_INCREMENT for table `toko`
--
ALTER TABLE `toko`
  MODIFY `kode_toko` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=307;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
