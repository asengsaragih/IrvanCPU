-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2018 at 03:47 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mekdun`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `idAdmin` int(5) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`idAdmin`, `username`, `password`) VALUES
(2, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `idDriver` int(10) NOT NULL,
  `namaDriver` varchar(20) NOT NULL,
  `notelp` varchar(15) NOT NULL,
  `umur` int(5) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `nosim` varchar(20) NOT NULL,
  `Pengalaman` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`idDriver`, `namaDriver`, `notelp`, `umur`, `username`, `password`, `nosim`, `Pengalaman`) VALUES
(2, 'panji', '156461', 12, 'ada', 'qwe', '123456', 'dadada');

-- --------------------------------------------------------

--
-- Table structure for table `inputmenu`
--

CREATE TABLE `inputmenu` (
  `idMenu` int(5) NOT NULL,
  `kategori` varchar(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `harga` int(11) NOT NULL,
  `deskripsi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inputmenu`
--

INSERT INTO `inputmenu` (`idMenu`, `kategori`, `nama`, `harga`, `deskripsi`) VALUES
(1, 'Makanan', 'Nasi Goreng', 20000, 'khas makassar'),
(2, 'Minuman', 'Es Teh', 3000, 'pake gula'),
(3, 'Minuman', 'Es Teh', 3000, 'pake gula'),
(4, 'Cemilan', 'Kentang Goreng', 7000, 'asin'),
(5, 'Es Krim', 'Es Krim Combo', 2000, 'Rasa Vanilai'),
(6, 'Cemilan', 'Kentang Goreng', 7000, 'kentang asin'),
(7, 'Es Krim', 'Es krim vanila', 10000, 'rasa vanila susu'),
(8, 'Minuman', 'free', 123, '123');

-- --------------------------------------------------------

--
-- Table structure for table `kodepromo`
--

CREATE TABLE `kodepromo` (
  `id` int(5) NOT NULL,
  `kodepromo` varchar(10) NOT NULL,
  `potongan` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kodepromo`
--

INSERT INTO `kodepromo` (`id`, `kodepromo`, `potongan`) VALUES
(1, 'QWERTY', 5000),
(2, 'MEKDUN', 7000);

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `idPesanan` int(5) NOT NULL,
  `tgl` date NOT NULL,
  `totalMakanan` int(10) NOT NULL,
  `hargaDelivery` int(10) NOT NULL,
  `pajak` int(10) NOT NULL,
  `total` int(20) NOT NULL,
  `metode` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pesanan`
--

INSERT INTO `pesanan` (`idPesanan`, `tgl`, `totalMakanan`, `hargaDelivery`, `pajak`, `total`, `metode`) VALUES
(13, '2018-12-05', 43000, 8600, 4300, 55900, 'Cash');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idtrx` int(5) NOT NULL,
  `idMenu` int(5) NOT NULL,
  `idUser` int(5) NOT NULL,
  `idPesanan` int(5) DEFAULT NULL,
  `status` int(5) NOT NULL,
  `banyak` int(10) NOT NULL,
  `subtotal` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idtrx`, `idMenu`, `idUser`, `idPesanan`, `status`, `banyak`, `subtotal`) VALUES
(35, 1, 6, 13, 2, 2, 40000),
(36, 2, 6, 13, 2, 1, 3000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` int(5) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `notelp` varchar(15) NOT NULL,
  `tgl` date NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `nama`, `notelp`, `tgl`, `alamat`, `email`, `username`, `password`) VALUES
(1, 'panji', '423432', '2018-10-12', '', 'adas', 'panjie', '123'),
(2, 'Muhammad Panji Reza', '081243361743', '2018-10-11', 'dasdsadasdsa', 'rezapanji1@gmaiil.com', 'panjireza', '123'),
(3, 'awe', '42342', '2018-10-02', 'sukabirus', 'dsasd', 'aw', 'iya'),
(4, 'Hisyam', '08546931544', '2018-04-05', 'Jalan Ciganitri', 'hisyamfadhil@gmail.com', 'hisyam', 'qwe'),
(5, 'amien japar', '085456465', '2018-04-05', 'sukapura', 'amien@gmail.com', 'amien', 'qwe'),
(6, 'andri', '08156776777', '2018-12-10', 'jl.sukabirus', 'andri@gmail.com', 'andrisilalahi', '222222');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`idDriver`);

--
-- Indexes for table `inputmenu`
--
ALTER TABLE `inputmenu`
  ADD PRIMARY KEY (`idMenu`);

--
-- Indexes for table `kodepromo`
--
ALTER TABLE `kodepromo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`idPesanan`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idtrx`),
  ADD KEY `idMenu` (`idMenu`),
  ADD KEY `idUser` (`idUser`),
  ADD KEY `idPesanan` (`idPesanan`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `idAdmin` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `driver`
--
ALTER TABLE `driver`
  MODIFY `idDriver` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `inputmenu`
--
ALTER TABLE `inputmenu`
  MODIFY `idMenu` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `kodepromo`
--
ALTER TABLE `kodepromo`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pesanan`
--
ALTER TABLE `pesanan`
  MODIFY `idPesanan` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `idtrx` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
