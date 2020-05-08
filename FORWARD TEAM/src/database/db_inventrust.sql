-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2018 at 06:47 AM
-- Server version: 10.1.30-MariaDB
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
-- Database: `db_inventrust`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `id_admin` varchar(20) NOT NULL,
  `nm_admin` varchar(100) NOT NULL,
  `jk_admin` varchar(10) NOT NULL,
  `almt_admin` varchar(200) NOT NULL,
  `no_telp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_barang`
--

CREATE TABLE `tbl_barang` (
  `id_barang` varchar(20) NOT NULL,
  `nm_barang` varchar(100) NOT NULL,
  `jenis_barang` varchar(100) NOT NULL,
  `stok_barang` varchar(100) NOT NULL,
  `id_distributor` varchar(20) NOT NULL,
  `id_gudang` varchar(20) NOT NULL,
  `harga` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_barang`
--

INSERT INTO `tbl_barang` (`id_barang`, `nm_barang`, `jenis_barang`, `stok_barang`, `id_distributor`, `id_gudang`, `harga`) VALUES
('BRG001', 'Nabati', 'Makanan', '50', 'DSB001', 'G0001', '1500');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_beli`
--

CREATE TABLE `tbl_beli` (
  `id_beli` varchar(20) NOT NULL,
  `tgl` datetime NOT NULL,
  `total` decimal(10,0) NOT NULL,
  `id_admin` varchar(20) NOT NULL,
  `id_distributor` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_detailbeli`
--

CREATE TABLE `tbl_detailbeli` (
  `id_beli` varchar(20) NOT NULL,
  `id_barang` varchar(20) NOT NULL,
  `qty` int(11) NOT NULL,
  `harga` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_detailtransaksi`
--

CREATE TABLE `tbl_detailtransaksi` (
  `id_transaksi` varchar(50) NOT NULL,
  `id_barang` varchar(20) NOT NULL,
  `qty` varchar(100) NOT NULL,
  `harga_satuan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_distributor`
--

CREATE TABLE `tbl_distributor` (
  `id_distributor` varchar(20) NOT NULL,
  `nm_distributor` varchar(100) NOT NULL,
  `almt_distributor` varchar(200) NOT NULL,
  `no_telp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_distributor`
--

INSERT INTO `tbl_distributor` (`id_distributor`, `nm_distributor`, `almt_distributor`, `no_telp`) VALUES
('DS0001', 'testing', 'testing', 'testing'),
('DS0002', 'te', 'te', 'te');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_gudang`
--

CREATE TABLE `tbl_gudang` (
  `id_gudang` varchar(20) NOT NULL,
  `nm_gudang` varchar(100) NOT NULL,
  `jenis_gudang` varchar(100) NOT NULL,
  `kapasitas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_konsumen`
--

CREATE TABLE `tbl_konsumen` (
  `id_konsumen` varchar(20) NOT NULL,
  `nm_konsumen` varchar(100) NOT NULL,
  `almt_konsumen` varchar(200) NOT NULL,
  `no_telp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_konsumen`
--

INSERT INTO `tbl_konsumen` (`id_konsumen`, `nm_konsumen`, `almt_konsumen`, `no_telp`) VALUES
('KN0001', 'Muhammad Hisyam Fadhil', 'Cianjur', '0848365343'),
('KN0002', 'Haris Wedira', 'Padang', '0892753753'),
('KN0003', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaksi`
--

CREATE TABLE `tbl_transaksi` (
  `id_transaksi` varchar(50) NOT NULL,
  `id_konsumen` varchar(20) NOT NULL,
  `id_admin` varchar(20) NOT NULL,
  `tgl_transaksi` datetime NOT NULL,
  `total` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `tbl_barang`
--
ALTER TABLE `tbl_barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `tbl_beli`
--
ALTER TABLE `tbl_beli`
  ADD PRIMARY KEY (`id_beli`);

--
-- Indexes for table `tbl_detailbeli`
--
ALTER TABLE `tbl_detailbeli`
  ADD KEY `id_beli` (`id_beli`),
  ADD KEY `id_barang` (`id_barang`);

--
-- Indexes for table `tbl_detailtransaksi`
--
ALTER TABLE `tbl_detailtransaksi`
  ADD KEY `id_transaksi` (`id_transaksi`);

--
-- Indexes for table `tbl_distributor`
--
ALTER TABLE `tbl_distributor`
  ADD PRIMARY KEY (`id_distributor`);

--
-- Indexes for table `tbl_gudang`
--
ALTER TABLE `tbl_gudang`
  ADD PRIMARY KEY (`id_gudang`);

--
-- Indexes for table `tbl_konsumen`
--
ALTER TABLE `tbl_konsumen`
  ADD PRIMARY KEY (`id_konsumen`);

--
-- Indexes for table `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  ADD PRIMARY KEY (`id_transaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
