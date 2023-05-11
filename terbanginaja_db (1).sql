-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 09 Bulan Mei 2023 pada 05.19
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `terbanginaja_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `maskapai`
--

CREATE TABLE `maskapai` (
  `id_maskapai` varchar(10) NOT NULL,
  `nama_maskapai` text NOT NULL,
  `jam` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `maskapai`
--

INSERT INTO `maskapai` (`id_maskapai`, `nama_maskapai`, `jam`) VALUES
('Asia', 'Air Asia', '16:00:00'),
('Batik', 'Batik Air', '19:00:00'),
('Garuda', 'Garuda Airlines', '06:00:00'),
('Lion', 'Lion Air', '12:00:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_user` varchar(5) DEFAULT NULL,
  `nama` text DEFAULT NULL,
  `nik` int(16) DEFAULT NULL,
  `id_maskapai` varchar(10) DEFAULT NULL,
  `tanggal` text DEFAULT NULL,
  `tujuan` text DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `void` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_user`, `nama`, `nik`, `id_maskapai`, `tanggal`, `tujuan`, `status`, `void`) VALUES
('XXAQS', 'gWemflw', 31231, 'Lion', '3 April 2026', 'Manado - Semarang', 'TERDAFTAR', NULL),
('NTVFG', 'NDawda', 31231, 'Lion', '5 April 2027', 'Manado - Semarang', 'TERDAFTAR', NULL),
('TFMSB', 'dawd', 3312, 'Asia', '6 April 2025', 'Manado - Semarang', 'SELESAI', NULL),
('DQJXY', 'dwadkwa', 1001, 'Asia', '1 Januari 2023', 'Manado - Semarang', 'SELESAI', NULL),
('RSVFJ', 'Dika', 1002, 'Asia', '1 Januari 2023', 'Bali - Jayapura', 'TERDAFTAR', NULL),
('EQRDF', 'V', 3312, 'Batik', '5 April 2027', 'Bali - Jayapura', 'DIBATALKAN', NULL),
('CZHPQ', 'Dika', 3321, 'Asia', '1 Januari 2023', 'Bali - Jayapura', 'DIBATALKAN', NULL),
('OZCPF', 'dika', 6672182, 'Asia', '3 April 2024', 'Surabaya - Sorong', 'TERDAFTAR', NULL),
('NUGGA', 'Uzumaki Naruto', 1331, 'Batik', '4 April 2025', 'Manado - Semarang', 'SELESAI', NULL),
('RNBLO', 'AWW', 123, 'Asia', '1 Januari 2023', 'Bali - Jayapura', 'TERDAFTAR', NULL),
('USKQV', 'Andini', 3322, 'Batik', '5 April 2026', 'Jakarta - Ambon', 'TERDAFTAR', NULL);

--
-- Trigger `transaksi`
--
DELIMITER $$
CREATE TRIGGER `dup_User` BEFORE INSERT ON `transaksi` FOR EACH ROW BEGIN
  IF EXISTS (SELECT * FROM transaksi WHERE nik = NEW.nik and tanggal = NEW.tanggal) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Pengguna Telah Terdaftar';
  END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` varchar(5) NOT NULL,
  `password` varchar(5) DEFAULT NULL,
  `nama` text DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `password`, `nama`, `status`) VALUES
('admin', '12345', 'ADMIN', 1),
('CZHPQ', '89845', 'Dika', 0),
('DQJXY', '10569', 'dwadkwa', 0),
('EQRDF', '83393', 'V', 0),
('NTVFG', '43952', 'NDawda', 1),
('NUGGA', '30306', 'Uzumaki Naruto', 0),
('OZCPF', '02042', 'dika', 1),
('RNBLO', '68107', 'AWW', 1),
('RSVFJ', '89648', 'Dika', 1),
('TFMSB', '32533', 'dawd', 0),
('USKQV', '73299', 'Andini', 1),
('XXAQS', '02803', 'gWemflw', 1);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `maskapai`
--
ALTER TABLE `maskapai`
  ADD PRIMARY KEY (`id_maskapai`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
