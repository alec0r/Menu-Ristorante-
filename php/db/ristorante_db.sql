-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mar 28, 2024 alle 18:08
-- Versione del server: 10.4.24-MariaDB
-- Versione PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ristorante`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `allergeni`
--

CREATE TABLE `allergeni` (
  `ID_Allergene` int(10) UNSIGNED NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `allergeni`
--

INSERT INTO `allergeni` (`ID_Allergene`, `nome`) VALUES
(1, 'Glutine'),
(2, 'Lattosio'),
(3, 'Uova'),
(4, 'Pesce'),
(5, 'Lievito');

-- --------------------------------------------------------

--
-- Struttura della tabella `categorie`
--

CREATE TABLE `categorie` (
  `ID_Categoria` int(10) UNSIGNED NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `categorie`
--

INSERT INTO `categorie` (`ID_Categoria`, `nome`) VALUES
(1, 'Antipasto'),
(2, 'Primo Piatto'),
(3, 'Secondo Piatto'),
(4, 'Dolce');

-- --------------------------------------------------------

--
-- Struttura della tabella `ingredienti`
--

CREATE TABLE `ingredienti` (
  `ID_Ingrediente` int(10) UNSIGNED NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ingredienti`
--

INSERT INTO `ingredienti` (`ID_Ingrediente`, `nome`) VALUES
(1, 'Pomodoro'),
(2, 'Pane'),
(3, 'Aglio'),
(4, 'Basilico'),
(5, 'Spaghetti'),
(6, 'Uovo'),
(7, 'Guanciale'),
(8, 'Pecorino'),
(9, 'Pepe Nero'),
(10, 'Salmone'),
(11, 'Verdure'),
(12, 'Savoiardi'),
(13, 'Mascarpone'),
(14, 'Caffe'),
(15, 'Cacao'),
(16, 'Pomodoro'),
(17, 'Pane'),
(18, 'Aglio'),
(19, 'Basilico'),
(20, 'Carne Macinata'),
(21, 'Vino Rosso'),
(22, 'Cipolla'),
(23, 'Patate');

-- --------------------------------------------------------

--
-- Struttura della tabella `piatti`
--

CREATE TABLE `piatti` (
  `ID_Piatto` int(10) UNSIGNED NOT NULL,
  `nome` varchar(50) NOT NULL,
  `descrizione` text DEFAULT NULL,
  `prezzo` decimal(10,2) NOT NULL,
  `FK_Categoria` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `piatti`
--

INSERT INTO `piatti` (`ID_Piatto`, `nome`, `descrizione`, `prezzo`, `FK_Categoria`) VALUES
(1, 'Bruschetta al Pomodoro', 'Pane tostato con pomodoro fresco, aglio e basilico', '8.50', 1),
(2, 'Spaghetti alla Carbonara', 'Spaghetti con uovo, guanciale, pecorino e pepe nero', '12.99', 2),
(3, 'Filetto di Salmone', 'Filetto di salmone al vapore con contorno di verdure', '16.75', 3),
(4, 'Tiramisu', 'Dolce al cucchiaio con savoiardi, mascarpone, caffe e cacao', '7.99', 4),
(5, 'Gnocchi al Ragu', 'Gnocchi di patate di nonna Anna serviti con ragu di carne', '11.99', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `piatti_allergeni`
--

CREATE TABLE `piatti_allergeni` (
  `ID` int(10) UNSIGNED NOT NULL,
  `FK_Piatto` int(10) UNSIGNED DEFAULT NULL,
  `FK_Allergene` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `piatti_allergeni`
--

INSERT INTO `piatti_allergeni` (`ID`, `FK_Piatto`, `FK_Allergene`) VALUES
(1, 4, 1),
(2, 4, 2),
(3, 4, 3),
(4, 2, 1),
(5, 2, 3),
(6, 3, 4),
(7, 1, 1),
(8, 1, 2),
(9, 5, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `piatti_ingredienti`
--

CREATE TABLE `piatti_ingredienti` (
  `ID` int(10) UNSIGNED NOT NULL,
  `FK_Piatto` int(10) UNSIGNED DEFAULT NULL,
  `FK_Ingrediente` int(10) UNSIGNED DEFAULT NULL,
  `quantita` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `piatti_ingredienti`
--

INSERT INTO `piatti_ingredienti` (`ID`, `FK_Piatto`, `FK_Ingrediente`, `quantita`) VALUES
(1, 1, 1, 2),
(2, 1, 2, 1),
(3, 1, 3, 1),
(4, 1, 4, 1),
(5, 2, 5, 300),
(6, 2, 6, 2),
(7, 2, 7, 100),
(8, 2, 8, 50),
(9, 2, 9, 2),
(10, 3, 10, 1),
(11, 3, 11, 1),
(12, 4, 12, 8),
(13, 4, 13, 200),
(14, 4, 14, 1),
(15, 4, 15, 1),
(16, 4, 6, NULL),
(17, 5, 8, 300),
(18, 5, 1, 300),
(19, 5, 2, 1),
(20, 5, 3, 1),
(21, 5, 4, 1),
(22, 5, 16, 300),
(23, 5, 17, 50),
(24, 5, 18, 1);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `allergeni`
--
ALTER TABLE `allergeni`
  ADD PRIMARY KEY (`ID_Allergene`);

--
-- Indici per le tabelle `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`ID_Categoria`);

--
-- Indici per le tabelle `ingredienti`
--
ALTER TABLE `ingredienti`
  ADD PRIMARY KEY (`ID_Ingrediente`);

--
-- Indici per le tabelle `piatti`
--
ALTER TABLE `piatti`
  ADD PRIMARY KEY (`ID_Piatto`),
  ADD KEY `pia_cat` (`FK_Categoria`);

--
-- Indici per le tabelle `piatti_allergeni`
--
ALTER TABLE `piatti_allergeni`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `pa_pia` (`FK_Piatto`),
  ADD KEY `pa_all` (`FK_Allergene`);

--
-- Indici per le tabelle `piatti_ingredienti`
--
ALTER TABLE `piatti_ingredienti`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `pi_pia` (`FK_Piatto`),
  ADD KEY `pi_ing` (`FK_Ingrediente`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `allergeni`
--
ALTER TABLE `allergeni`
  MODIFY `ID_Allergene` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `categorie`
--
ALTER TABLE `categorie`
  MODIFY `ID_Categoria` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `ingredienti`
--
ALTER TABLE `ingredienti`
  MODIFY `ID_Ingrediente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT per la tabella `piatti`
--
ALTER TABLE `piatti`
  MODIFY `ID_Piatto` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `piatti_allergeni`
--
ALTER TABLE `piatti_allergeni`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT per la tabella `piatti_ingredienti`
--
ALTER TABLE `piatti_ingredienti`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `piatti`
--
ALTER TABLE `piatti`
  ADD CONSTRAINT `pia_cat` FOREIGN KEY (`FK_Categoria`) REFERENCES `categorie` (`ID_Categoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `piatti_allergeni`
--
ALTER TABLE `piatti_allergeni`
  ADD CONSTRAINT `pa_all` FOREIGN KEY (`FK_Allergene`) REFERENCES `allergeni` (`ID_Allergene`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pa_pia` FOREIGN KEY (`FK_Piatto`) REFERENCES `piatti` (`ID_Piatto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `piatti_ingredienti`
--
ALTER TABLE `piatti_ingredienti`
  ADD CONSTRAINT `pi_ing` FOREIGN KEY (`FK_Ingrediente`) REFERENCES `ingredienti` (`ID_Ingrediente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pi_pia` FOREIGN KEY (`FK_Piatto`) REFERENCES `piatti` (`ID_Piatto`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
