-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2018 at 09:22 AM
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
-- Database: `db_pbo_psb_sma1backend`
--

-- --------------------------------------------------------

--
-- Table structure for table `hasil_seleksi`
--

CREATE TABLE `hasil_seleksi` (
  `nisn` varchar(20) DEFAULT NULL,
  `id_user` varchar(200) DEFAULT NULL,
  `jurusan` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hasil_seleksi`
--

INSERT INTO `hasil_seleksi` (`nisn`, `id_user`, `jurusan`) VALUES
('9987874', 'A0001', 'ipa'),
('998238', 'A0001', 'ips'),
('987987', 'A0001', 'ipa'),
('999199', 'A0001', 'ipa'),
('999199', 'A0001', 'ipa'),
('9992838', 'A0001', 'ips'),
('999819', 'A0001', 'ipa'),
('999128', 'A0001', 'ipa'),
('9987291029', 'A0001', 'ips');

-- --------------------------------------------------------

--
-- Table structure for table `nilai_minimal_ipa`
--

CREATE TABLE `nilai_minimal_ipa` (
  `id_user` varchar(200) DEFAULT NULL,
  `tahunAjaran` varchar(20) NOT NULL,
  `jurusan` varchar(50) NOT NULL,
  `bahasa` varchar(2) NOT NULL,
  `inggris` varchar(2) NOT NULL,
  `matematika` varchar(2) NOT NULL,
  `ipa` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nilai_minimal_ipa`
--

INSERT INTO `nilai_minimal_ipa` (`id_user`, `tahunAjaran`, `jurusan`, `bahasa`, `inggris`, `matematika`, `ipa`) VALUES
('A0001', '2018 / 2019', 'ipa', '75', '75', '75', '75'),
('A0001', '2021 / 2022', 'ipa', '75', '75', '85', '85');

-- --------------------------------------------------------

--
-- Table structure for table `nilai_minimal_ips`
--

CREATE TABLE `nilai_minimal_ips` (
  `id_user` varchar(200) DEFAULT NULL,
  `tahunAjaran` varchar(20) NOT NULL,
  `jurusan` varchar(50) NOT NULL,
  `bahasa` varchar(2) NOT NULL,
  `inggris` varchar(2) NOT NULL,
  `matematika` varchar(2) NOT NULL,
  `ipa` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `siswa_baru`
--

CREATE TABLE `siswa_baru` (
  `nama_lengkap` varchar(100) NOT NULL,
  `nisn` varchar(20) NOT NULL,
  `asal_sekolah` varchar(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  `status` varchar(20) NOT NULL,
  `id_user` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswa_baru`
--

INSERT INTO `siswa_baru` (`nama_lengkap`, `nisn`, `asal_sekolah`, `email`, `status`, `id_user`) VALUES
('dummi', '909090', 'smpn 1 dummi', 'dummi@dummi.com', 'belum', 'F0013'),
('Dougan', '9876667', 'smpn 1 cipanas', 'dougan@gmail.com', 'belum', 'F0010'),
('SETH SORENSON', '98787474', 'SMPN 1 CIPANAS', 'seth@sorenson.com', 'belum', 'F0004'),
('Kendra Sorenson', '987987', 'smpn 1 ciranjang', 'kendra@sorenson.com', 'lulus', 'F0003'),
('Warren', '998238', 'SMPN 1 CIPANAS', 'warren@gmail.com', 'lulus', 'F0005'),
('dummy data', '9987291029', 'smpn 1 dummy', 'dummy@dummy.com', 'lulus', 'F0012'),
('vanessa', '998782', 'smpn 1 cipanas', 'vanessa@santoro.com', 'belum', 'F0011'),
('ESA PUTRA', '9987874', 'SMPN 1 CIPANAS ', 'esaputra@gmail.com', 'lulus', 'F0002'),
('Tere', '999128', 'smp n 1 gamping', 'tere@gmail.com', 'lulus', 'F0009'),
('Abe', '999199', 'smp m 1', 'abe@gmail.com', 'lulus', 'F0007'),
('stan sorenson', '9992838', 'smpn 1 cipanas', 'stan@sorenson.com', 'lulus', 'F0006'),
('aminah', '999819', 'smp n 1 gamping', 'aminah@gmail.com', 'lulus', 'F0008');

-- --------------------------------------------------------

--
-- Table structure for table `siswa_baru_data_diri`
--

CREATE TABLE `siswa_baru_data_diri` (
  `nisn` varchar(20) DEFAULT NULL,
  `nama_lengkap` varchar(100) DEFAULT NULL,
  `tempat_lahir` varchar(20) DEFAULT NULL,
  `tanggal_lahir` date NOT NULL,
  `jenis_kelamin` varchar(10) DEFAULT NULL,
  `No_hp` varchar(20) DEFAULT NULL,
  `image` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswa_baru_data_diri`
--

INSERT INTO `siswa_baru_data_diri` (`nisn`, `nama_lengkap`, `tempat_lahir`, `tanggal_lahir`, `jenis_kelamin`, `No_hp`, `image`) VALUES
('9987874', 'ESA PUTRA', 'CIANJUR', '2018-12-02', 'laki-laki', '08987547', 'C:\\Users\\Lynn\\Downloads\\cpy-saofb\\TUBES\\PSB\\image\\1.jpg'),
('987987', 'kendra', 'cipanas', '2018-12-02', 'perempuan', '08977787', 'C:\\Users\\Lynn\\Downloads\\cpy-saofb\\TUBES\\PSB\\image\\1.jpg'),
('98787474', 'seth', 'cianjur', '2018-12-02', 'laki-laki', '08997787', 'C:UsersLynnDownloadscpy-saofbTUBESPSBimage1.jpg'),
('998238', 'warren', 'cianjur', '2018-12-03', 'laki-laki', '08998', 'C:\\Users\\Lynn\\Downloads\\cpy-saofb\\TUBES\\PSB\\image\\1.jpg'),
('9992838', 'stan sorenson', 'cianjur', '2018-12-02', 'laki-laki', '0987547', 'C:\\Users\\Lynn\\Downloads\\cpy-saofb\\TUBES\\PSB\\image\\1.jpg'),
('999199', 'Abe', 'Sleman', '2018-11-04', 'laki-laki', '0817451564', 'E:\\seprian-foto.jpg'),
('999819', 'ami', 'Sleman', '2018-08-07', 'perempuan', '0851987456', 'E:Miera Tamara L 3x4.jpg'),
('999128', 'tere liye', 'sleman', '2018-08-06', 'laki-laki', '0825467522', 'E:seprian-foto.jpg'),
('9876667', 'dougan', 'cianjur', '2018-12-02', 'laki-laki', '087720192923', 'E:seprian-foto.jpg'),
('998782', 'vanessa', 'cianjur', '2018-12-02', 'perempuan', '087720167878', 'E:seprian-foto.jpg'),
('9987291029', 'dummy', 'dummy', '2018-12-02', 'perempuan', '089765654321', 'E:\\Miera Tamara L 3x4.jpg'),
('909090', 'dummi', 'cianjur', '2018-12-02', 'perempuan', '097872727', 'E:\\\\seprian-foto.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `siswa_baru_ket_jasmani`
--

CREATE TABLE `siswa_baru_ket_jasmani` (
  `nisn` varchar(20) DEFAULT NULL,
  `berat` varchar(11) DEFAULT NULL,
  `tinggi` varchar(11) DEFAULT NULL,
  `gol_darah` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswa_baru_ket_jasmani`
--

INSERT INTO `siswa_baru_ket_jasmani` (`nisn`, `berat`, `tinggi`, `gol_darah`) VALUES
('9987874', '69', '164', 'O'),
('987987', '69', '175', 'O'),
('98787474', '169', '64', 'O'),
('998238', '69', '175', 'O'),
('9992838', '64', '175', 'O'),
('999199', '55', '162', 'AB'),
('999819', '55', '161', 'O'),
('999128', '49', '158', 'O'),
('9876667', '64', '169', 'O'),
('9876667', '65', '169', 'O'),
('998782', '65', '169', 'O'),
('9987291029', '54', '163', 'A'),
('909090', '67', '165', 'O');

-- --------------------------------------------------------

--
-- Table structure for table `siswa_baru_ket_pend_sblmnya`
--

CREATE TABLE `siswa_baru_ket_pend_sblmnya` (
  `nisn` varchar(20) DEFAULT NULL,
  `asal_sekolah` varchar(100) DEFAULT NULL,
  `alamat_sekolah` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswa_baru_ket_pend_sblmnya`
--

INSERT INTO `siswa_baru_ket_pend_sblmnya` (`nisn`, `asal_sekolah`, `alamat_sekolah`) VALUES
('9987874', 'SMPN 1 CIPANAS ', 'BLA BLA BLA BAL '),
('987987', 'smpn 1 cipanas', 'bla bla bal bal '),
('98787474', 'smpn 1 cipanas', 'bla bla bal balb a'),
('998238', 'smpn 1 cipanas', 'bla bla bla bla '),
('9992838', 'smpn 1 cipanas', 'bla bla bla bal '),
('999199', 'smp m 1 godean', 'Pirak, Godean'),
('999819', 'smp n 1 godean', 'Sidoagung, Godean'),
('999128', 'smp n 1 gamping', 'gamping, sidoluhur'),
('9876667', 'smpn 1 cipanas', 'jln cipanas bla bla bla bla '),
('9876667', 'Smpn 1 cipanas', 'bla bla bla '),
('998782', 'smpn 1 cipanas', 'bla bla bla'),
('9987291029', 'smpn 1 dummy', 'jln dummy bla bla bla bla 92'),
('909090', 'smpn 1 dummi', 'smpn 1 cdummi bla bla ');

-- --------------------------------------------------------

--
-- Table structure for table `siswa_baru_nilai`
--

CREATE TABLE `siswa_baru_nilai` (
  `nisn` varchar(20) NOT NULL,
  `nilai_bahasa` int(11) DEFAULT NULL,
  `nilai_inggris` int(11) DEFAULT NULL,
  `nilai_matematika` int(11) DEFAULT NULL,
  `nilai_ipa` int(11) DEFAULT NULL,
  `jumlah_nilai` int(11) DEFAULT NULL,
  `rata_rata` int(11) DEFAULT NULL,
  `image_skhun` varchar(20) NOT NULL,
  `peminatan_1` varchar(10) NOT NULL,
  `peminatan_2` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `siswa_baru_nilai`
--

INSERT INTO `siswa_baru_nilai` (`nisn`, `nilai_bahasa`, `nilai_inggris`, `nilai_matematika`, `nilai_ipa`, `jumlah_nilai`, `rata_rata`, `image_skhun`, `peminatan_1`, `peminatan_2`) VALUES
('909090', 90, 90, 90, 90, 360, 90, 'E:\\skhu.png', 'IPS', 'IPA'),
('9876667', 80, 80, 80, 80, 320, 80, 'E:skhu.png', 'IPA', 'IPS'),
('98787474', 74, 74, 74, 74, 296, 74, 'D:essaimage1.jpg', 'IPA', 'IPS'),
('987987', 90, 90, 85, 85, 350, 87, 'D:\\essa\\image\\1.jpg', 'IPA', 'IPS'),
('998238', 80, 80, 80, 80, 320, 80, 'D:essaimage1.jpg', 'IPS', 'IPA'),
('9987291029', 95, 90, 90, 90, 365, 91, 'E:\\skhu.png', 'IPS', 'IPA'),
('9987874', 80, 90, 90, 90, 350, 87, 'D:essaimage1.jpg', 'IPA', 'IPS'),
('999128', 90, 75, 75, 75, 315, 78, 'E:SKHUN16.png', 'IPA', 'IPS'),
('999199', 85, 80, 86, 90, 341, 85, 'E:\\SKHUN16.png', 'IPA', 'Bahasa'),
('9992838', 85, 85, 81, 80, 331, 82, 'D:\\essa\\image\\1.jpg', 'IPS', 'IPA'),
('999819', 90, 96, 95, 99, 380, 95, 'E:\\skhu.png', 'IPA', 'IPS');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` varchar(200) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `level`) VALUES
('A0001', 'admin', 'admin', 'admin'),
('F0002', 'esa', 'esa', 'siswa Baru'),
('F0003', 'kendra', 'kendra', 'siswa Baru'),
('F0004', 'seth', 'seth', 'siswa Baru'),
('F0005', 'warren', 'warren', 'siswa Baru'),
('F0006', 'stan', 'stan', 'siswa Baru'),
('F0007', 'abe', '123', 'siswa Baru'),
('F0008', 'ami', '123', 'siswa Baru'),
('F0009', 'tere', '123', 'siswa Baru'),
('F0010', 'dougan', 'dougan', 'siswa Baru'),
('F0011', 'vanessa', 'vanessa', 'siswa Baru'),
('F0012', 'dummy', '123', 'siswa Baru'),
('F0013', 'dummi', '123', 'siswa Baru');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hasil_seleksi`
--
ALTER TABLE `hasil_seleksi`
  ADD KEY `nisn` (`nisn`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `nilai_minimal_ipa`
--
ALTER TABLE `nilai_minimal_ipa`
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `siswa_baru`
--
ALTER TABLE `siswa_baru`
  ADD PRIMARY KEY (`nisn`);

--
-- Indexes for table `siswa_baru_data_diri`
--
ALTER TABLE `siswa_baru_data_diri`
  ADD KEY `nisn` (`nisn`);

--
-- Indexes for table `siswa_baru_ket_jasmani`
--
ALTER TABLE `siswa_baru_ket_jasmani`
  ADD KEY `nisn` (`nisn`);

--
-- Indexes for table `siswa_baru_ket_pend_sblmnya`
--
ALTER TABLE `siswa_baru_ket_pend_sblmnya`
  ADD KEY `nisn` (`nisn`);

--
-- Indexes for table `siswa_baru_nilai`
--
ALTER TABLE `siswa_baru_nilai`
  ADD PRIMARY KEY (`nisn`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hasil_seleksi`
--
ALTER TABLE `hasil_seleksi`
  ADD CONSTRAINT `hasil_seleksi_ibfk_1` FOREIGN KEY (`nisn`) REFERENCES `siswa_baru` (`nisn`),
  ADD CONSTRAINT `hasil_seleksi_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `nilai_minimal_ipa`
--
ALTER TABLE `nilai_minimal_ipa`
  ADD CONSTRAINT `nilai_minimal_ipa_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `siswa_baru_data_diri`
--
ALTER TABLE `siswa_baru_data_diri`
  ADD CONSTRAINT `siswa_baru_data_diri_ibfk_1` FOREIGN KEY (`nisn`) REFERENCES `siswa_baru` (`nisn`);

--
-- Constraints for table `siswa_baru_ket_jasmani`
--
ALTER TABLE `siswa_baru_ket_jasmani`
  ADD CONSTRAINT `siswa_baru_ket_jasmani_ibfk_1` FOREIGN KEY (`nisn`) REFERENCES `siswa_baru` (`nisn`);

--
-- Constraints for table `siswa_baru_ket_pend_sblmnya`
--
ALTER TABLE `siswa_baru_ket_pend_sblmnya`
  ADD CONSTRAINT `siswa_baru_ket_pend_sblmnya_ibfk_1` FOREIGN KEY (`nisn`) REFERENCES `siswa_baru` (`nisn`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
