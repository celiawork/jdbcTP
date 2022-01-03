-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 15 déc. 2021 à 04:23
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `compta`
--
CREATE DATABASE IF NOT EXISTS `compta` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `compta`;

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `ID` int(11) NOT NULL,
  `REF` varchar(13) NOT NULL,
  `DESIGNATION` varchar(255) NOT NULL,
  `PRIX` decimal(7,2) NOT NULL,
  `ID_FOU` int(11) NOT NULL
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`ID`, `REF`, `DESIGNATION`, `PRIX`, `ID_FOU`) VALUES
(1, 'A01', 'Perceuse P1', '74.99', 1),
(2, 'F01', 'Boulon laiton 4 x 40 mm (sachet de 10)', '2.25', 2),
(3, 'F02', 'Boulon laiton 5 x 40 mm (sachet de 10)', '4.45', 2),
(4, 'D01', 'Boulon laiton 5 x 40 mm (sachet de 10)', '4.40', 3),
(5, 'A02', 'Meuleuse 125mm', '37.85', 1),
(6, 'D03', 'Boulon acier zingué 4 x 40mm (sachet de 10)', '1.80', 3),
(7, 'A03', 'Perceuse à colonne', '185.25', 1),
(8, 'D04', 'Coffret mêches à bois', '12.25', 3),
(9, 'F03', 'Coffret mêches plates', '6.25', 2),
(10, 'F04', 'Fraises d’encastrement', '8.14', 2);

-- --------------------------------------------------------

--
-- Structure de la table `bon`
--

DROP TABLE IF EXISTS `bon`;
CREATE TABLE `bon` (
  `ID` int(11) NOT NULL,
  `NUMERO` int(11) DEFAULT NULL,
  `DATE_CMDE` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `DELAI` int(11) DEFAULT NULL,
  `ID_FOU` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bon`
--

INSERT INTO `bon` (`ID`, `NUMERO`, `DATE_CMDE`, `DELAI`, `ID_FOU`) VALUES
(1, 1, '2019-02-08 09:30:00', 3, 1),
(2, 2, '2019-03-02 09:30:00', 5, 2),
(3, 3, '2019-04-03 17:30:00', 2, 3),
(4, 4, '2019-04-05 11:40:00', 2, 3),
(5, 5, '2019-05-15 14:45:00', 7, 2),
(6, 6, '2019-06-24 18:55:00', 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `compo`
--

DROP TABLE IF EXISTS `compo`;
CREATE TABLE `compo` (
  `ID` int(11) NOT NULL,
  `ID_ART` int(11) DEFAULT NULL,
  `ID_BON` int(11) DEFAULT NULL,
  `QTE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compo`
--

INSERT INTO `compo` (`ID`, `ID_ART`, `ID_BON`, `QTE`) VALUES
(1, 1, 1, 3),
(2, 5, 1, 4),
(3, 7, 1, 1),
(4, 2, 2, 25),
(5, 3, 2, 15),
(6, 9, 2, 8),
(7, 10, 2, 11),
(8, 4, 3, 25),
(9, 6, 3, 40),
(10, 8, 3, 15),
(11, 4, 4, 10),
(12, 6, 4, 15),
(13, 8, 4, 8),
(14, 2, 5, 17),
(15, 3, 5, 13),
(16, 10, 5, 9);

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE `fournisseur` (
  `ID` int(11) NOT NULL,
  `NOM` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`ID`, `NOM`) VALUES
(1, 'Française d’Imports'),
(2, 'FDM SA'),
(3, 'Dubois & Fils');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `bon`
--
ALTER TABLE `bon`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `compo`
--
ALTER TABLE `compo`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `bon`
--
ALTER TABLE `bon`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `compo`
--
ALTER TABLE `compo`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

--
-- LES CONTRAINTES
--

ALTER TABLE article
ADD CONSTRAINT fk_article_idfou FOREIGN KEY (ID_FOU) REFERENCES fournisseur(id);

ALTER TABLE bon
ADD CONSTRAINT fk_bon_idfou FOREIGN KEY (ID_FOU) REFERENCES fournisseur(id);

ALTER TABLE compo
ADD CONSTRAINT fk_compo_idart FOREIGN KEY (ID_ART) REFERENCES article(id);

ALTER TABLE compo
ADD CONSTRAINT fk_compo_idbon FOREIGN KEY (ID_BON) REFERENCES bon(id);



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
