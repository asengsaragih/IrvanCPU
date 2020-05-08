-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 04 Des 2018 pada 15.38
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
-- Database: `rumah_sakit`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `pasien`
--

CREATE TABLE `pasien` (
  `id_customer` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `nik` varchar(20) NOT NULL,
  `alamat` varchar(1000) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `agama` varchar(10) NOT NULL,
  `status` varchar(20) NOT NULL,
  `warga_negara` varchar(3) NOT NULL,
  `Checkin` varchar(20) NOT NULL,
  `nomor_kamar` varchar(3) NOT NULL,
  `Checkout` varchar(20) NOT NULL,
  `status_checkin` int(1) NOT NULL,
  `price` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pasien`
--

INSERT INTO `pasien` (`id_customer`, `nama`, `nik`, `alamat`, `jenis_kelamin`, `agama`, `status`, `warga_negara`, `Checkin`, `nomor_kamar`, `Checkout`, `status_checkin`, `price`) VALUES
(38, 'Deviana Rahmadhani', '3211131001970005', 'PGA', 'perempuan', 'islam', 'belum kawin', 'wni', '2-12-2018', '201', '4-12-2018', 0, 500000),
(39, 'Ikhwan', '3211131001978884', 'Jl. Radio	', 'pria', 'islam', 'belum kawin', 'wni', '01-12-2018', '301', '03-12-2018', 1, 0),
(40, 'Andreas', '3211131001970005', 'Suka Birus', 'pria', 'kristen', 'belum kawin', 'wni', '01-12-2018', '102', '03-12-2018', 0, 300000),
(42, 'pakpahan', '3211131001978880', 'Suka pura', 'pria', 'Kristen', 'kawin', 'wni', '04-12-2018', '102', '05-12-2018', 0, 300000),
(44, 'ojan', '1111111111111111', 'suka birus', 'pria', 'Islam', 'belum kawin', 'wna', '04-12-2018', '201', '05-12-2018', 0, 500000),
(45, 'yoga', '2222222222222222', 'pga', 'pria', 'Islam', 'belum kawin', 'wni', '04-12-2018', '102', '05-12-2018', 0, 300000);

--
-- Trigger `pasien`
--
DELIMITER $$
CREATE TRIGGER `after_checkin` AFTER INSERT ON `pasien` FOR EACH ROW BEGIN
 UPDATE room
 SET status = 'isi'
 WHERE nomor_kamar = NEW.nomor_kamar;
 end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `room`
--

CREATE TABLE `room` (
  `nomor_kamar` varchar(3) NOT NULL,
  `jenis_kamar` varchar(15) NOT NULL,
  `status` varchar(8) NOT NULL,
  `harga` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `room`
--

INSERT INTO `room` (`nomor_kamar`, `jenis_kamar`, `status`, `harga`) VALUES
('101', 'standar', 'isi', 300000),
('102', 'standar', 'kosong', 300000),
('103', 'standar', 'kosong', 300000),
('104', 'standar', 'kosong', 300000),
('105', 'standar', 'kosong', 300000),
('106', 'standar', 'kosong', 300000),
('201', 'doubel', 'kosong', 500000),
('202', 'doubel', 'kosong', 500000),
('203', 'doubel', 'kosong', 500000),
('204', 'doubel', 'kosong', 500000),
('206', 'superrior', 'kosong', 700000),
('223', 'doubel', 'kosong', 500000),
('301', 'superrior', 'isi', 700000),
('302', 'superrior', 'kosong', 700000),
('303', 'superrior', 'kosong', 700000),
('304', 'superrior', 'kosong', 700000),
('305', 'superrior', 'kosong', 700000),
('307', 'superrior', 'kosong', 700000),
('309', 'superrior', 'kosong', 700000),
('323', 'superrior', 'kosong', 700000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id_customer`),
  ADD KEY `nomor_kamar` (`nomor_kamar`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`nomor_kamar`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pasien`
--
ALTER TABLE `pasien`
  MODIFY `id_customer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `pasien`
--
ALTER TABLE `pasien`
  ADD CONSTRAINT `pasien_ibfk_1` FOREIGN KEY (`nomor_kamar`) REFERENCES `room` (`nomor_kamar`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
