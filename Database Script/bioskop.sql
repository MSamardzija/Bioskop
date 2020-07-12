SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bioskop`
--

-- --------------------------------------------------------

--
-- Table structure for table `bioskop`
--

CREATE TABLE `bioskop` (
  `id` int(11) NOT NULL,
  `Naziv` varchar(255) NOT NULL,
  `Adresa` varchar(255) NOT NULL,
  `Telefon` varchar(255) NOT NULL,
  `Opis` text NOT NULL,
  `MenadzerID` int(11) NOT NULL,
  `Slika` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bioskop`
--

INSERT INTO `bioskop` (`id`, `Naziv`, `Adresa`, `Telefon`, `Opis`, `MenadzerID`, `Slika`) VALUES
(1, 'Cineplexx Usce', 'Bulevar Mihajla Pupina, Beograd 11070', '011 3113370', 'Blagajne bioskopa se otvaraju pola sata pre prve projekcije filma...', 3, 'CineplexxUsce.jpg'),
(2, 'Cineplexx Plaza', 'Bulevar Kraljice Marije 56, Kragujevac 34000', '034 6195030', 'Radno vreme bioskopa zavisi od pocetka prve projekcije.', 3, 'CineplexxUsce.jpg'),
(6, 'Tuckwood Cineplex', 'Kneza Milosa 7a, Beograd 11000', '011 3236517', 'Uzivajte u dobrim filmovima..', 5, 'tuckwood.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `filmovi`
--

CREATE TABLE `filmovi` (
  `id` int(11) NOT NULL,
  `Naziv` varchar(255) NOT NULL,
  `Opis` text NOT NULL,
  `Slika` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `filmovi`
--

INSERT INTO `filmovi` (`id`, `Naziv`, `Opis`, `Slika`) VALUES
(1, 'Inception...', 'U alternativnoj buducnosti ljudski um je otkriven. Nekolicina ima sposobnost da u snovima ulazi u umove drugih ljudi gde manipulisu njegovim mislima, secanjima i tajnama. U tom procesu nit koja razdvaja san i javu skoro se gubi i svaki pogresan korak moze dovesti vecnog ostajanja u Limbu, svetu koji je je negde izmedju zivota i smrti.', 'inception.jpg'),
(3, 'The Irishman', 'Snimljen u produkciji striming giganta \"Netfliks\", \"Irac\" je najskuplji Skorsezeov film do sada, a vrhunsku glumacku ekipu predvode Robert de Niro, Al Pacino i DÅ¾o Pesi.', 'irishman.jpg'),
(4, 'Ekipa', 'Ekipa novi film bla bla bla', 'logoBioskop.jpg'),
(5, 'Black panter', 'sadgvmjkhgf', 'ITS-logo2017.png');

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL,
  `KorisnickoIme` varchar(255) NOT NULL,
  `Lozinka` text NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Telefon` varchar(255) NOT NULL,
  `Poeni` int(11) NOT NULL,
  `TipKorisnika` enum('Klijent','Menadzer','Administrator','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `KorisnickoIme`, `Lozinka`, `Email`, `Telefon`, `Poeni`, `TipKorisnika`) VALUES
(1, 'Pera', 'pera123', 'pera@gmail.com', '+381 11 3163 966', 0, 'Klijent'),
(2, 'Admin1', 'admin1', 'admin@gmail.com', '060 22 55 22', 0, 'Administrator'),
(3, 'Menadzer1', 'menadzer1', 'menadzer1@gmail.com', '061 22 55 22', 0, 'Menadzer'),
(5, 'menadzer2', 'menadzer2', 'menadzer2@gmail.com', '062/25-25-256', 0, 'Menadzer'),
(6, 'nemanja', 'nemanja', 'nemanja@gmail.com', '060/22-00-220', 0, 'Administrator');

-- --------------------------------------------------------

--
-- Table structure for table `projekcije`
--

CREATE TABLE `projekcije` (
  `id` int(11) NOT NULL,
  `cenaKarte` float NOT NULL,
  `datumProjekcije` varchar(255) NOT NULL,
  `idBioskopa` int(11) NOT NULL,
  `idFilma` int(11) NOT NULL,
  `idSale` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projekcije`
--

INSERT INTO `projekcije` (`id`, `cenaKarte`, `datumProjekcije`, `idBioskopa`, `idFilma`, `idSale`) VALUES
(1, 400, '2020-05-08 00:00:00', 2, 1, 1),
(2, 400, '2020-05-14T20:30', 2, 3, 1),
(3, 300, '2020-05-20T19:20', 2, 4, 1),
(4, 300, '2020-05-21T21:45', 1, 1, 2),
(5, 400, '2020-05-14T20:30', 6, 3, 3),
(6, 400, '2020-05-21T20:30', 6, 5, 3);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
  `id` int(11) NOT NULL,
  `idFilma` int(11) NOT NULL,
  `cenaKarte` float NOT NULL,
  `datumPocetkaFilma` varchar(255) NOT NULL,
  `idBioskopa` int(11) NOT NULL,
  `BrojKarata` int(11) NOT NULL,
  `idKorisnika` int(11) NOT NULL,
  `poeni` float NOT NULL,
  `idProjekcije` int(11) NOT NULL,
  `idSale` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`id`, `idFilma`, `cenaKarte`, `datumPocetkaFilma`, `idBioskopa`, `BrojKarata`, `idKorisnika`, `poeni`, `idProjekcije`, `idSale`) VALUES
(7, 1, 1200, '2020-05-08 00:00:00', 2, 3, 1, 12, 1, 1),
(8, 1, 2000, '2020-05-20T20:30', 1, 5, 1, 20, 4, 1),
(9, 1, 1500, '2020-05-21T21:45', 1, 5, 1, 15, 4, 2),
(10, 3, 2000, '2020-05-14T20:30', 6, 5, 1, 20, 5, 3);

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE `sale` (
  `id` int(11) NOT NULL,
  `Opis` varchar(255) NOT NULL,
  `brojMesta` int(11) NOT NULL,
  `BrojSlobodnihMesta` int(11) NOT NULL,
  `idBioskopa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`id`, `Opis`, `brojMesta`, `BrojSlobodnihMesta`, `idBioskopa`) VALUES
(1, 'Sala 1', 200, 189, 1),
(2, 'Sala Usce', 300, 184, 1),
(3, 'Sala Tuckwood', 300, 295, 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bioskop`
--
ALTER TABLE `bioskop`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `filmovi`
--
ALTER TABLE `filmovi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `projekcije`
--
ALTER TABLE `projekcije`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idBioskopa` (`idBioskopa`),
  ADD KEY `idFilma` (`idFilma`),
  ADD KEY `idSale` (`idSale`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idBioskopa` (`idBioskopa`),
  ADD KEY `idFilma` (`idFilma`),
  ADD KEY `idKorisnika` (`idKorisnika`),
  ADD KEY `idProjekcije` (`idProjekcije`),
  ADD KEY `idSale` (`idSale`);

--
-- Indexes for table `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idBioskopa` (`idBioskopa`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bioskop`
--
ALTER TABLE `bioskop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `filmovi`
--
ALTER TABLE `filmovi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `projekcije`
--
ALTER TABLE `projekcije`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `rezervacija`
--
ALTER TABLE `rezervacija`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `sale`
--
ALTER TABLE `sale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `projekcije`
--
ALTER TABLE `projekcije`
  ADD CONSTRAINT `projekcije_ibfk_1` FOREIGN KEY (`idBioskopa`) REFERENCES `bioskop` (`id`),
  ADD CONSTRAINT `projekcije_ibfk_2` FOREIGN KEY (`idFilma`) REFERENCES `filmovi` (`id`),
  ADD CONSTRAINT `projekcije_ibfk_3` FOREIGN KEY (`idSale`) REFERENCES `sale` (`id`);

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`idBioskopa`) REFERENCES `bioskop` (`id`),
  ADD CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`idFilma`) REFERENCES `filmovi` (`id`),
  ADD CONSTRAINT `rezervacija_ibfk_3` FOREIGN KEY (`idKorisnika`) REFERENCES `korisnik` (`id`),
  ADD CONSTRAINT `rezervacija_ibfk_4` FOREIGN KEY (`idProjekcije`) REFERENCES `projekcije` (`id`),
  ADD CONSTRAINT `rezervacija_ibfk_5` FOREIGN KEY (`idSale`) REFERENCES `sale` (`id`);

--
-- Constraints for table `sale`
--
ALTER TABLE `sale`
  ADD CONSTRAINT `sale_ibfk_1` FOREIGN KEY (`idBioskopa`) REFERENCES `bioskop` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
