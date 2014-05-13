CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(35) DEFAULT NULL,
  `phoneNo` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `active` binary(1) DEFAULT NULL,
  PRIMARY KEY (`userId`)
)  ;


CREATE TABLE `groups` (
  `groupid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `advanceday` int(11) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  PRIMARY KEY (`groupid`),
  KEY `grp_user` (`userid`),
  CONSTRAINT `grp_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)  ;


CREATE TABLE `occasions` (
  `occasionid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`occasionid`)
)  ;


CREATE TABLE `contacts` (
  `contactid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(35) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `phoneno` varchar(20) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`contactid`),
  KEY `contact_user` (`userid`),
  CONSTRAINT `contact_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
)  ;


CREATE TABLE `contactoccasion` (
  `contactoccId` int(11) NOT NULL AUTO_INCREMENT,
  `occasionId` int(11) DEFAULT NULL,
  `contactid` int(11) DEFAULT NULL,
  PRIMARY KEY (`contactoccId`),
  KEY `link_contact` (`contactid`),
  KEY `link_occasion` (`occasionId`),
  CONSTRAINT `link_contact` FOREIGN KEY (`contactid`) REFERENCES `contacts` (`contactid`),
  CONSTRAINT `link_occasion` FOREIGN KEY (`occasionId`) REFERENCES `occasions` (`occasionid`)
)  ;


CREATE TABLE `grpcontacts` (
  `grpContactid` int(11) NOT NULL AUTO_INCREMENT,
  `grpid` int(11) DEFAULT NULL,
  `contactid` int(11) DEFAULT NULL,
  PRIMARY KEY (`grpContactid`),
  KEY `grp_link` (`grpid`),
  KEY `contact_link` (`contactid`),
  CONSTRAINT `grp_link` FOREIGN KEY (`grpid`) REFERENCES `groups` (`groupid`),
  CONSTRAINT `contact_link` FOREIGN KEY (`contactid`) REFERENCES `contacts` (`contactid`)
)  ;


CREATE TABLE `usergroups` (
  `GrpId` int(11) NOT NULL,
  `GrpName` varchar(20) DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL
)  ;

