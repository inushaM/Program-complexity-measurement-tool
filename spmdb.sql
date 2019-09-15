-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 15, 2019 at 12:00 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spmdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `maincode`
--

CREATE TABLE `maincode` (
  `ID` int(11) NOT NULL,
  `CODENUMBER` varchar(255) NOT NULL,
  `CODEKEYNAME` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maincode`
--

INSERT INTO `maincode` (`ID`, `CODENUMBER`, `CODEKEYNAME`) VALUES
(113, '78bd8e2c-90bb-4307-afd0-9e3366f9f228', 'code1'),
(114, 'ec4a20c7-cb5c-4c31-9733-436b0990eaae', 'code02'),
(115, 'f67fcc7d-3316-4f51-864d-5ff38afdd5be', 'code03'),
(116, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 'c8');

-- --------------------------------------------------------

--
-- Table structure for table `sourcecodes`
--

CREATE TABLE `sourcecodes` (
  `ID` int(11) NOT NULL,
  `CODENUMBER` varchar(255) NOT NULL,
  `LINENUMBER` int(11) NOT NULL,
  `PSTATEMENT` text,
  `FACTORS` varchar(255) DEFAULT NULL,
  `CS` int(11) NOT NULL,
  `CNC` int(11) NOT NULL,
  `CI` int(11) NOT NULL,
  `CTC` int(11) NOT NULL,
  `TW` int(11) NOT NULL,
  `CPS` int(11) NOT NULL,
  `CR` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sourcecodes`
--

INSERT INTO `sourcecodes` (`ID`, `CODENUMBER`, `LINENUMBER`, `PSTATEMENT`, `FACTORS`, `CS`, `CNC`, `CI`, `CTC`, `TW`, `CPS`, `CR`) VALUES
(1, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 1, 'package com.iterminal.iparliamentws.repository;', NULL, 3, 0, 4, 0, 4, 12, 24),
(2, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 2, '	public String sum(a+b){', NULL, 0, 0, 4, 0, 4, 0, 0),
(3, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 3, '		return  sum(a+b);', NULL, 0, 1, 4, 0, 5, 0, 0),
(4, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 4, '	}', NULL, 0, 0, 4, 0, 4, 0, 0),
(5, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 5, 'import com.iterminal.iparliamentws.model.CommitteeDetail;', NULL, 4, 0, 4, 0, 4, 16, 32),
(6, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 6, 'import java.util.List;', NULL, 2, 0, 4, 0, 4, 8, 16),
(7, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 7, 'import org.springframework.data.jpa.repository.JpaRepository;', NULL, 5, 0, 4, 0, 4, 20, 40),
(8, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 8, 'import org.springframework.data.jpa.repository.Query;', NULL, 5, 0, 4, 0, 4, 20, 40),
(9, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 9, '/**', NULL, 4, 0, 4, 0, 4, 16, 32),
(10, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 10, ' *', NULL, 2, 0, 4, 0, 4, 8, 16),
(11, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 11, ' * @author inusha', NULL, 3, 0, 4, 0, 4, 12, 24),
(12, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 12, ' */', NULL, 2, 0, 4, 0, 4, 8, 16),
(13, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 13, 'public interface CommitteeDetailRepository extends JpaRepository<CommitteeDetail, Integer>{', NULL, 1, 0, 4, 0, 4, 4, 8),
(14, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 14, '    ', NULL, 0, 0, 4, 0, 4, 0, 0),
(15, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 15, '    @Query(value=\"SELECT * FROM dms_view_comdetails\",nativeQuery=true)', NULL, 4, 0, 4, 0, 4, 16, 32),
(16, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 16, '    List<CommitteeDetail> getCommitteeDetailDetails();', NULL, 0, 0, 4, 0, 4, 0, 0),
(17, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 17, '	', NULL, 0, 0, 4, 0, 4, 0, 0),
(18, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 18, '	class myClass implements A,B,C{', NULL, 3, 0, 4, 0, 4, 12, 24),
(19, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 19, '		', NULL, 0, 0, 4, 0, 4, 0, 0),
(20, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 20, '	}', NULL, 0, 0, 4, 0, 4, 0, 0),
(21, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 21, '    @RequestMapping(value = \"/cpbmeetings/state/update\", method = RequestMethod.POST)', NULL, 4, 0, 4, 0, 4, 16, 32),
(22, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 22, '    public ResponseEntity<CommonResponse> updateOOBStatus(@RequestBody CpbMeetings cpbMeeting) {', NULL, 0, 0, 4, 0, 4, 0, 0),
(23, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 23, '        try {', NULL, 0, 0, 4, 0, 4, 0, 0),
(24, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 24, '            if (cpbMeeting.getSummoningLetterEnglishStatus() != null) {', NULL, 4, 1, 4, 1, 6, 24, 48),
(25, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 25, '                cpbmRepository.setSummoningLetterEnglishStatus(cpbMeeting.getId(), cpbMeeting.getSummoningLetterEnglishStatus());', NULL, 4, 0, 4, 0, 4, 16, 32),
(26, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 26, '            } else if (cpbMeeting.getSummoningLetterSinhalaStatus() != null) {', NULL, 4, 1, 4, 1, 6, 24, 48),
(27, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 27, '                cpbmRepository.setSummoningLetterSinhalaStatus(cpbMeeting.getId(), cpbMeeting.getSummoningLetterSinhalaStatus());', NULL, 4, 0, 4, 0, 4, 16, 32),
(28, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 28, '            } else if (cpbMeeting.getSummoningLetterTamilStatus() != null) {', NULL, 4, 1, 4, 1, 6, 24, 48),
(29, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 29, '                cpbmRepository.setSummoningLetterTamilStatus(cpbMeeting.getId(), cpbMeeting.getSummoningLetterTamilStatus());', NULL, 4, 0, 4, 0, 4, 16, 32),
(30, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 30, '            } else if (cpbMeeting.getAgendaEnglishStatus() != null) {', NULL, 4, 1, 4, 1, 6, 24, 48),
(31, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 31, '                cpbmRepository.setAgendaEnglishStatus(cpbMeeting.getId(), cpbMeeting.getAgendaEnglishStatus());', NULL, 4, 0, 4, 0, 4, 16, 32),
(32, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 32, '            } else if (cpbMeeting.getAgendaSinhalaStatus() != null) {', NULL, 4, 1, 4, 1, 6, 24, 48),
(33, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 33, '                cpbmRepository.setAgendaSinhalaStatus(cpbMeeting.getId(), cpbMeeting.getAgendaSinhalaStatus());', NULL, 4, 0, 4, 0, 4, 16, 32),
(34, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 34, '            } else if (cpbMeeting.getAgendaTamilStatus() != null) {', NULL, 4, 1, 4, 1, 6, 24, 48),
(35, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 35, '                cpbmRepository.setAgendaTamilStatus(cpbMeeting.getId(), cpbMeeting.getAgendaTamilStatus());', NULL, 4, 0, 4, 0, 4, 16, 32),
(36, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 36, '            } else if (cpbMeeting.getMinuteEnglishStatus() != null) {', NULL, 4, 1, 4, 1, 6, 24, 48),
(37, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 37, '                cpbmRepository.setMinuteEnglishStatus(cpbMeeting.getId(), cpbMeeting.getMinuteEnglishStatus());', NULL, 4, 0, 4, 0, 4, 16, 32),
(38, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 38, '            } else if (cpbMeeting.getMinuteSinhalaStatus() != null) {', NULL, 4, 1, 4, 1, 6, 24, 48),
(39, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 39, '                cpbmRepository.setMinuteSinhalaStatus(cpbMeeting.getId(), cpbMeeting.getMinuteSinhalaStatus());', NULL, 4, 0, 4, 0, 4, 16, 32),
(40, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 40, '            } else if (cpbMeeting.getMinuteTamilStatus() != null) {', NULL, 4, 1, 4, 1, 6, 24, 48),
(41, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 41, '                cpbmRepository.setMinuteTamilStatus(cpbMeeting.getId(), cpbMeeting.getMinuteTamilStatus());', NULL, 4, 0, 4, 0, 4, 16, 32),
(42, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 42, '            } else {', NULL, 0, 0, 4, 0, 4, 0, 0),
(43, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 43, '                return new ResponseEntity<>(new CommonResponse(\"ERROR\", \"Failed to update item\"), HttpStatus.OK);', NULL, 5, 1, 4, 0, 5, 25, 50),
(44, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 44, '            }', NULL, 0, 0, 4, 0, 4, 0, 0),
(45, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 45, '            return new ResponseEntity<>(new CommonResponse(\"SUCSESS\", \"Item successfully saved\"), HttpStatus.OK);', NULL, 5, 1, 4, 0, 5, 25, 50),
(46, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 46, '        } catch (Exception ex) {', NULL, 0, 0, 4, 0, 4, 0, 0),
(47, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 47, '            Logger logger = LoggerFactory.getLogger(CpbMeetingsController.class);', NULL, 3, 0, 4, 0, 4, 12, 24),
(48, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 48, '            logger.error(ex.getMessage());', NULL, 2, 0, 4, 0, 4, 8, 16),
(49, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 49, '            return new ResponseEntity<>(new CommonResponse(\"ERROR\", \"Failed to update item\"), HttpStatus.OK);', NULL, 5, 1, 4, 0, 5, 25, 50),
(50, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 50, '        }', NULL, 0, 0, 4, 0, 4, 0, 0),
(51, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 51, '    }', NULL, 0, 0, 4, 0, 4, 0, 0),
(52, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 52, '    ', NULL, 0, 0, 4, 0, 4, 0, 0),
(53, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 53, '        //---------------------------------------------------------------------------------------------------------', NULL, 0, 0, 4, 0, 4, 0, 0),
(54, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 54, '    ', NULL, 0, 0, 4, 0, 4, 0, 0),
(55, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 55, '    @RequestMapping(value = \"/cpbmeetings/delete/{id}\", method = RequestMethod.GET)', NULL, 4, 0, 4, 0, 4, 16, 32),
(56, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 56, '    public ResponseEntity<CommonResponse> deleteCpbMeetings(@PathVariable(value = \"id\") Integer id) {', NULL, 1, 0, 4, 0, 4, 4, 8),
(57, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 57, '        try {', NULL, 0, 0, 4, 0, 4, 0, 0),
(58, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 58, '            cpbmeetingsserviceimpl.deleteCpbById(id);', NULL, 1, 0, 4, 0, 4, 4, 8),
(59, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 59, '   ', NULL, 0, 0, 4, 0, 4, 0, 0),
(60, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 60, '            return new ResponseEntity<>(new CommonResponse(\"SUCSESS\", \"Item successfully deleted\"), HttpStatus.OK);', NULL, 5, 1, 4, 0, 5, 25, 50),
(61, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 61, '        } catch (Exception ex) {', NULL, 0, 0, 4, 0, 4, 0, 0),
(62, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 62, '            Logger logger = LoggerFactory.getLogger(CpbMeetingsController.class);', NULL, 3, 0, 4, 0, 4, 12, 24),
(63, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 63, '            logger.error(ex.getMessage());', NULL, 2, 0, 4, 0, 4, 8, 16),
(64, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 64, '            return new ResponseEntity<>(new CommonResponse(\"ERROR\", \"Failed to delete item\"), HttpStatus.OK);', NULL, 7, 1, 4, 0, 5, 35, 70),
(65, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 65, '        }', NULL, 0, 0, 4, 0, 4, 0, 0),
(66, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 66, '    }', NULL, 0, 0, 4, 0, 4, 0, 0),
(67, '51639b61-8b5a-40df-9c85-3bddc8b0c548', 67, '    ', NULL, 0, 0, 4, 0, 4, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `systemuser`
--

CREATE TABLE `systemuser` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `systemuser`
--

INSERT INTO `systemuser` (`ID`, `USERNAME`, `PASSWORD`, `EMAIL`) VALUES
(1, 'inusha', '123', 'inusham45@gmail.com'),
(2, 'inusham', '123', 'inusham45@gmail.com'),
(3, 'naduni', '123', 'naduni@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `maincode`
--
ALTER TABLE `maincode`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sourcecodes`
--
ALTER TABLE `sourcecodes`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `systemuser`
--
ALTER TABLE `systemuser`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `maincode`
--
ALTER TABLE `maincode`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=117;

--
-- AUTO_INCREMENT for table `sourcecodes`
--
ALTER TABLE `sourcecodes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT for table `systemuser`
--
ALTER TABLE `systemuser`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
