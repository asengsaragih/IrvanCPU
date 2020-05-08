-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 06 Des 2018 pada 03.21
-- Versi Server: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quiz`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `question`
--

CREATE TABLE `question` (
  `id_question` int(10) NOT NULL,
  `soal` varchar(500) NOT NULL,
  `jawaban` varchar(50) NOT NULL,
  `level` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `question`
--

INSERT INTO `question` (`id_question`, `soal`, `jawaban`, `level`) VALUES
(19, '12 + 6 ?', '18', 1),
(20, 'Binatang yang bisa hidup di air dan di darat disebut', 'amfibi', 1),
(23, 'Tanggal 29 Februari terjadi setiap 4 tahun sekali. Tahun yang ada tanggal tersebut disebut?', 'kabisat', 2),
(24, 'Patung Sphinx kebanyakan terdapat di negara?', 'Mesir', 1),
(25, 'Monumen terkenal di kota Paris adalah menara?', 'eiffel', 1),
(26, 'Ilmu Pengetahuan Alam disebut juga ilmu?', 'sains', 2),
(27, 'Pusat peredaran tata surya adalah ?', 'matahari', 2),
(28, 'Flute adalah alat musik yang dimainkan dengan cara?', 'ditiup', 3),
(29, 'Sebuah papan catur memiliki kotak-kotak tempat bidak sebanyak?', '64', 2),
(30, 'Pohon yang melambangkan hari natal adalah pohon?', 'cemara', 2),
(31, 'Alat pembayaran resmi untuk biaya pengiriman melalui pos adalah?', 'prangko', 3),
(32, 'Vitamin yang banyak terkandung dalam buah-buahan adalah?', 'c', 1),
(33, 'Arah jam 9 itu sama dengan arah', 'barat', 3),
(34, 'Mata uang negara Jepang yaitu?', 'yen', 2),
(35, 'Layar komputer disebut juga?', 'monitor', 2),
(36, 'Bahan yang digunakan lebah untuk membuat madu adalah ?', 'nektar', 2),
(37, 'Udara yang bergerak disebut juga?', 'angin', 2),
(38, 'Ibukota negara Rusia yaitu ?', 'moscow', 2),
(39, 'Paus pembunuh adalah nama lain dari paus?', 'orca', 3),
(40, 'Indra manusia yang digunakan untuk mengecap adalah?', 'lidah', 1),
(41, 'Suara dengan frekuensi 20 - 20.000 Hz termasuk bunyi?', 'audiosonik', 3),
(42, 'Nama resmi negara Belanda adalah?', 'netherland', 2),
(43, 'Patung Liberty berada di pulau?', 'liberty', 3),
(44, 'Anjing Pitbull berasal dari negara?', 'inggris', 2),
(45, 'Penemu radio berasal dari negara ?', 'italia', 3),
(46, 'Satpol PP adalah singkatan dari ', 'satuan polisi pamong praja', 2),
(47, 'Sudut terkecil yang dibentuk jam pada pukul 04.00 adalah?', '120', 3),
(48, 'Pencipta karakter Naruto adalah?', 'masashi kishimoto', 2),
(49, 'Spongebob Squarepants tinggal di daerah?', 'bikini bottom', 1),
(50, 'Produk makanan yang memiliki moto \"Berapa lapis? Ratusan\" adalah?', 'tango', 2),
(51, 'Casablanka adalah contoh merek produk?', 'snack', 1),
(52, 'Pakaian tradisional khas Indonesia yang bernilai seni tinggi adalah?', 'batik', 2),
(53, 'Besaran bunyi adalah?', 'desibel', 3),
(54, 'siapa temen doraemon?', 'shizuka', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `score`
--

CREATE TABLE `score` (
  `id_score` int(10) NOT NULL,
  `id_user` int(10) NOT NULL,
  `score` int(10) NOT NULL,
  `level` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `score`
--

INSERT INTO `score` (`id_score`, `id_user`, `score`, `level`) VALUES
(1, 5, 200, 1),
(2, 6, 400, 2),
(3, 7, 400, 2),
(4, 8, 300, 2),
(5, 9, 200, 3),
(6, 10, 0, 1),
(7, 11, 0, 2),
(8, 12, 0, 2),
(9, 13, 100, 1),
(10, 14, 100, 1),
(11, 15, 0, 2),
(12, 16, 100, 1),
(13, 17, 400, 2),
(14, 18, 300, 1),
(15, 19, 300, 1),
(16, 20, 400, 1),
(17, 21, 700, 1),
(18, 22, 200, 1),
(19, 23, 200, 1),
(20, 24, 100, 1),
(21, 25, 900, 2),
(22, 26, 600, 2),
(23, 27, 0, 2),
(24, 28, 600, 2),
(25, 29, 300, 3),
(26, 30, 600, 2),
(27, 31, 0, 2),
(28, 32, 100, 1),
(29, 33, 400, 1),
(30, 34, 0, 3),
(31, 35, 200, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(10) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `name`) VALUES
(12, 'abdi'),
(16, 'abdi'),
(17, 'adi'),
(18, 'mo'),
(20, 'd'),
(22, 'ss'),
(23, 'fr'),
(24, 'de'),
(25, 'abdi'),
(26, 'bagian'),
(27, 'kkj'),
(28, 'rizky'),
(29, 'fauzi'),
(30, 'nabila'),
(31, 'sd'),
(32, ''),
(34, ''),
(35, 'asd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id_question`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`id_score`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id_question` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
--
-- AUTO_INCREMENT for table `score`
--
ALTER TABLE `score`
  MODIFY `id_score` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
