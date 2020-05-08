-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05 Des 2018 pada 15.36
-- Versi Server: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tugas_sisiran`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `invoice`
--

CREATE TABLE `invoice` (
  `id_invoice` varchar(10) NOT NULL,
  `tgl_invoice` datetime NOT NULL,
  `id_voucher` varchar(10) DEFAULT NULL,
  `total` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `invoice`
--

INSERT INTO `invoice` (`id_invoice`, `tgl_invoice`, `id_voucher`, `total`) VALUES
('IVC0000001', '2018-12-03 21:40:58', 'VCR0000002', 27000),
('IVC0000002', '2018-12-03 22:00:14', 'VCR0000001', 16000),
('IVC0000003', '2018-12-03 22:38:52', '', 10000),
('IVC0000004', '2018-12-03 23:48:46', '', 10000),
('IVC0000005', '2018-12-03 23:50:39', '', 10000),
('IVC0000006', '2018-12-03 23:51:21', '', 10000),
('IVC0000007', '2018-12-03 23:58:18', '', 10000),
('IVC0000008', '2018-12-03 23:59:22', '', 10000),
('IVC0000009', '2018-12-04 00:12:39', '', 10000),
('IVC0000010', '2018-12-04 00:13:34', '', 10000),
('IVC0000011', '2018-12-04 00:15:06', '', 10000),
('IVC0000012', '2018-12-04 08:26:06', 'VCR0000002', 9000),
('IVC0000013', '2018-12-04 18:53:52', '', 50000),
('IVC0000014', '2018-12-05 10:26:06', '', 10000),
('IVC0000015', '2018-12-05 10:32:27', 'VCR0000004', 5220);

-- --------------------------------------------------------

--
-- Struktur dari tabel `menu`
--

CREATE TABLE `menu` (
  `id_menu` varchar(10) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `harga` int(20) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `stok` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `menu`
--

INSERT INTO `menu` (`id_menu`, `nama`, `harga`, `jenis`, `stok`) VALUES
('MNU0000001', 'mie goreng', 5000, 'Makanan', 97),
('MNU0000002', 'mie kocok', 10000, 'Makanan', 10),
('MNU0000003', 'Bubur', 10000, 'Makanan', 10),
('MNU0000004', 'es teh', 3000, 'Minuman', 18);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(10) NOT NULL,
  `tgl_transaksi` datetime NOT NULL,
  `id_user` varchar(10) NOT NULL,
  `id_menu` varchar(10) NOT NULL,
  `id_invoice` varchar(10) DEFAULT NULL,
  `quantity` int(5) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `tgl_transaksi`, `id_user`, `id_menu`, `id_invoice`, `quantity`, `status`) VALUES
('TRX0000001', '2018-12-03 21:39:58', 'USR0000002', 'MNU0000003', 'IVC0000001', 2, 2),
('TRX0000002', '2018-12-03 21:40:29', 'USR0000002', 'MNU0000001', 'IVC0000001', 2, 2),
('TRX0000003', '2018-12-03 21:52:08', 'USR0000002', 'MNU0000003', 'IVC0000002', 2, 2),
('TRX0000004', '2018-12-03 22:38:45', 'USR0000002', 'MNU0000001', 'IVC0000003', 2, 2),
('TRX0000005', '2018-12-03 23:48:33', 'USR0000002', 'MNU0000001', 'IVC0000004', 2, 2),
('TRX0000006', '2018-12-03 23:50:34', 'USR0000002', 'MNU0000001', 'IVC0000005', 2, 2),
('TRX0000007', '2018-12-03 23:51:10', 'USR0000002', 'MNU0000001', 'IVC0000006', 2, 2),
('TRX0000008', '2018-12-03 23:58:12', 'USR0000002', 'MNU0000001', 'IVC0000007', 2, 2),
('TRX0000009', '2018-12-03 23:59:18', 'USR0000002', 'MNU0000001', 'IVC0000008', 2, 2),
('TRX0000010', '2018-12-04 00:12:34', 'USR0000002', 'MNU0000001', 'IVC0000009', 2, 2),
('TRX0000011', '2018-12-04 00:13:29', 'USR0000002', 'MNU0000001', 'IVC0000010', 2, 2),
('TRX0000012', '2018-12-04 00:15:02', 'USR0000002', 'MNU0000001', 'IVC0000011', 2, 2),
('TRX0000013', '2018-12-04 08:25:33', 'USR0000002', 'MNU0000001', 'IVC0000012', 2, 2),
('TRX0000014', '2018-12-04 11:11:45', 'USR0000002', 'MNU0000001', 'IVC0000013', 5, 2),
('TRX0000015', '2018-12-04 11:12:04', 'USR0000002', 'MNU0000001', 'IVC0000013', 5, 2),
('TRX0000016', '2018-12-05 10:25:47', 'USR0000004', 'MNU0000001', 'IVC0000014', 2, 2),
('TRX0000017', '2018-12-05 10:32:00', 'USR0000002', 'MNU0000004', 'IVC0000015', 2, 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `role` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `role`) VALUES
('USR0000001', 'admin', 'admin', 1),
('USR0000002', 'daffa', '123', 2),
('USR0000003', 'aldi', '123', 3),
('USR0000004', 'yusril', '123', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `voucher`
--

CREATE TABLE `voucher` (
  `id_voucher` varchar(10) NOT NULL,
  `stok_voucher` int(10) NOT NULL,
  `potongan` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `voucher`
--

INSERT INTO `voucher` (`id_voucher`, `stok_voucher`, `potongan`) VALUES
('VCR0000001', 2, 20),
('VCR0000002', 49, 10),
('VCR0000003', 20, 50),
('VCR0000004', 19, 13);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id_invoice`),
  ADD KEY `id_voucher` (`id_voucher`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id_menu`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_menu` (`id_menu`),
  ADD KEY `id_invoice` (`id_invoice`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`id_voucher`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
