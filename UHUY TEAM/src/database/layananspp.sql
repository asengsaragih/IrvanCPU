-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 03 Des 2018 pada 19.25
-- Versi Server: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `layananspp`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id` int(15) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id`, `nama`, `password`) VALUES
(123, 'Admin', '123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kelas`
--

CREATE TABLE `kelas` (
  `idKelas` int(10) NOT NULL,
  `namaKelas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kelas`
--

INSERT INTO `kelas` (`idKelas`, `namaKelas`) VALUES
(1, 'Kelas 10'),
(2, 'Kelas 11'),
(3, 'Kelas 12');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesanadmin`
--

CREATE TABLE `pesanadmin` (
  `id` int(10) NOT NULL,
  `nis_siswa` int(10) NOT NULL,
  `pesan` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pesanadmin`
--

INSERT INTO `pesanadmin` (`id`, `nis_siswa`, `pesan`) VALUES
(19, 2, 'data masuk');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesanuser`
--

CREATE TABLE `pesanuser` (
  `idPesan` int(11) NOT NULL,
  `pesan` varchar(1000) NOT NULL,
  `nis` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pesanuser`
--

INSERT INTO `pesanuser` (`idPesan`, `pesan`, `nis`) VALUES
(1, 'cobaaaaaaaa', 2),
(2, 'cwk pesan', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE `siswa` (
  `nis` int(15) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `kelas` varchar(15) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `namaWali` varchar(20) NOT NULL,
  `noTelp` int(15) NOT NULL,
  `Tanggungan` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `siswa`
--

INSERT INTO `siswa` (`nis`, `nama`, `kelas`, `gender`, `alamat`, `namaWali`, `noTelp`, `Tanggungan`) VALUES
(1, 'ris', '13', 'Perempuan', 'utd', 'aww', 98, 150300),
(2, 'is', 'Kelas 12', 'Perempuan', 'aa', 'ss', 32, 150300),
(3, 'udin', 'Kelas 11', 'Laki-laki', 'eee', 'wwww', 321, 0),
(4, 'ayu', 'Kelas 12', 'Perempuan', 'rrr', 'ddd', 432, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tanggungan`
--

CREATE TABLE `tanggungan` (
  `idTanggungan` int(15) NOT NULL,
  `bulan` varchar(5) NOT NULL,
  `keteranganTanggungan` varchar(100) NOT NULL,
  `nominal` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tanggungan`
--

INSERT INTO `tanggungan` (`idTanggungan`, `bulan`, `keteranganTanggungan`, `nominal`) VALUES
(1, '1', 'pertama', 110000),
(2, '2', 'Kedua', 22000),
(3, '3', 'ketiga', 3000),
(4, '4', '4', 4000),
(6, '6', '6', 100000),
(8, '8', '8', 12000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`idKelas`);

--
-- Indexes for table `pesanadmin`
--
ALTER TABLE `pesanadmin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pesanuser`
--
ALTER TABLE `pesanuser`
  ADD PRIMARY KEY (`idPesan`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`nis`);

--
-- Indexes for table `tanggungan`
--
ALTER TABLE `tanggungan`
  ADD PRIMARY KEY (`idTanggungan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pesanadmin`
--
ALTER TABLE `pesanadmin`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `pesanuser`
--
ALTER TABLE `pesanuser`
  MODIFY `idPesan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
