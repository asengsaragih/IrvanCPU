-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05 Des 2018 pada 17.49
-- Versi Server: 10.1.28-MariaDB
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cr`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_peminjam` int(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `no_telepon` int(20) NOT NULL,
  `no_identitas` int(20) NOT NULL,
  `tipe_mobil` varchar(20) NOT NULL,
  `merk_mobil` varchar(20) NOT NULL,
  `harga` int(30) NOT NULL,
  `tgl_pinjam` varchar(20) NOT NULL,
  `tgl_kembali` varchar(20) NOT NULL,
  `durasi` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id_peminjam`, `nama`, `alamat`, `no_telepon`, `no_identitas`, `tipe_mobil`, `merk_mobil`, `harga`, `tgl_pinjam`, `tgl_kembali`, `durasi`) VALUES
(19, 'rani', 'pga', 82183467, 132567788, 'Manual', 'XENIA', 400000, '2018-12-05', '2018-12-06 08:24:25', 1),
(20, 'yolinn', 'sdf', 822829836, 12436889, 'Matic', 'KIJANG', 200000, '2018-12-05', '2018-12-06 08:26:58', 1),
(21, 'boy', 'bojongsoang', 2020202, 7777777, 'Manual', 'PAJERO XE8', 500000, '2018-12-05', '2018-12-07 09:25:37', 2),
(22, 'esa', 'pga', 221675378, 126487917, 'Manual', 'mobil esa', 1000000, '2018-12-05', '2018-12-07 09:41:39', 2),
(23, 'esa ', 'bla bla ', 987887, 165379, 'Matic', 'esa ganteng', 90000, '2018-12-05', '2018-12-07 09:50:32', 2),
(24, 'esa', 'bla bla ', 263521403, 9092828, 'Matic', 'dummy', 1000000, '2018-12-05', '2018-12-07 09:55:18', 2),
(25, 'JAMMY', 'BUAH BATU', 8919191, 1717171, 'Manual', 'FORTUNER AXL', 900000, '2018-12-05', '2018-12-07 10:04:20', 2),
(26, 'ANDRI', 'BANDUNG', 2156478, 15243789, 'Manual', 'YARIS XS5', 200000, '2018-12-05', '2018-12-07 10:09:22', 2),
(27, 'AMIN', 'PGA', 22, 1233, 'Matic', 'XENIA S21', 500000, '2018-12-05', '2018-12-07 10:23:06', 2),
(28, 'YFUY', 'EWFW', 3523, 3534, 'Manual', 'AVANZA SS1', 400000, '2018-12-05', '2018-12-07 10:24:16', 2),
(29, 'bayu', 'sukapura', 85743563, 123, 'Manual', 'AVANZA  VV2', 400000, '2018-12-05', '2018-12-06 10:40:07', 1),
(30, 'jafar', 'sukabirus', 634435, 675765, 'Manual', 'Xenia', 100000, '2018-12-05', '2018-12-07 10:44:16', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_mobil`
--

CREATE TABLE `tbl_mobil` (
  `id_mobil` int(10) NOT NULL,
  `merk` varchar(20) NOT NULL,
  `tipe` varchar(20) NOT NULL,
  `tahun` varchar(20) NOT NULL,
  `no_polisi` varchar(20) NOT NULL,
  `harga` int(30) NOT NULL,
  `status` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_mobil`
--

INSERT INTO `tbl_mobil` (`id_mobil`, `merk`, `tipe`, `tahun`, `no_polisi`, `harga`, `status`) VALUES
(18, 'AVANZA SS1', 'Manual', '2017', 'B 44 D', 400000, 0),
(19, 'XENIA S21', 'Matic', '2018', 'D 21 GZ', 500000, 0),
(20, 'PAJERO X05', 'Matic', '2017', 'D 111 YU', 400000, 1),
(21, 'PAJERO XE8', 'Manual', '2018', 'D 301', 500000, 1),
(22, 'JAZZ XXI', 'Matic', '2017', 'B 400 YU', 600000, 1),
(23, 'YARIS YY11', 'Manual', '2016', 'D 2 Z', 400000, 0),
(28, 'AVANZA  VV2', 'Manual', '2016', 'D 552 PQ', 400000, 0),
(29, 'BRIO H6S', 'Matic', '2016', ' BE 301 Y', 400000, 1),
(30, 'FORTUNER AXL', 'Manual', '2017', 'B 00 BY', 900000, 0),
(31, 'YARIS XS5', 'Manual', '2015', 'D 20 BC', 200000, 0),
(32, 'Xenia', 'Manual', '2016', 'd56437t', 100000, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_transaksi`
--

CREATE TABLE `tbl_transaksi` (
  `id_transaksi` int(10) NOT NULL,
  `id_peminjam` int(10) NOT NULL,
  `tipe_mobil` varchar(30) NOT NULL,
  `merk_mobil` varchar(20) NOT NULL,
  `tgl_pinjam` varchar(20) NOT NULL,
  `tgl_kembali` varchar(20) NOT NULL,
  `harga` int(30) NOT NULL,
  `lama` int(10) NOT NULL,
  `total` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_transaksi`
--

INSERT INTO `tbl_transaksi` (`id_transaksi`, `id_peminjam`, `tipe_mobil`, `merk_mobil`, `tgl_pinjam`, `tgl_kembali`, `harga`, `lama`, `total`) VALUES
(1, 12, 'Matic', 'bmw', '04-12-2018', '06-12-2018', 200000, 11, 11),
(2, 13, 'Manual', 'kijang', '1', '1', 250000, 1, 250000),
(3, 14, 'Matic', 'mobilio', '2018-12-05', '2018-12-06 02:18:56', 450000, 1, 450000),
(4, 16, 'Matic', 'xenia', '2018-12-05', '2018-12-06 07:25:49', 10000, 1, 10000),
(5, 14, 'Matic', 'mobilio', '2018-12-05', '2018-12-06 02:18:56', 450000, 1, 450000),
(6, 20, 'Matic', 'KIJANG', '2018-12-05', '2018-12-06 08:26:58', 200000, 1, 200000),
(7, 20, 'Matic', 'KIJANG', '2018-12-05', '2018-12-06 08:26:58', 200000, 1, 200000),
(8, 20, 'Matic', 'KIJANG', '2018-12-05', '2018-12-06 08:26:58', 200000, 1, 200000),
(9, 24, 'Matic', 'dummy', '2018-12-05', '2018-12-07 09:55:18', 1000000, 2, 2000000),
(10, 25, 'Manual', 'FORTUNER AXL', '2018-12-05', '2018-12-07 10:04:20', 900000, 2, 1800000),
(11, 26, 'Manual', 'YARIS XS5', '2018-12-05', '2018-12-07 10:09:22', 200000, 2, 400000),
(12, 27, 'Matic', 'XENIA S21', '2018-12-05', '2018-12-07 10:23:06', 500000, 2, 1000000),
(13, 29, 'Manual', 'AVANZA  VV2', '2018-12-05', '2018-12-06 10:40:07', 400000, 1, 400000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_peminjam`),
  ADD KEY `no_telepon` (`no_telepon`);

--
-- Indexes for table `tbl_mobil`
--
ALTER TABLE `tbl_mobil`
  ADD PRIMARY KEY (`id_mobil`);

--
-- Indexes for table `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_peminjam` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `tbl_mobil`
--
ALTER TABLE `tbl_mobil`
  MODIFY `id_mobil` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  MODIFY `id_transaksi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
