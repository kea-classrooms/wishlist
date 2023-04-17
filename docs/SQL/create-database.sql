CREATE DATABASE IF NOT EXISTS WISHLISTS DEFAULT CHARACTER SET utf8;
USE WISHLISTS;
DROP TABLE IF EXISTS BUILD_PART;
DROP TABLE IF EXISTS COMPUTERPART;
DROP TABLE IF EXISTS SHARED_LIST;
DROP TABLE IF EXISTS BUILD;
DROP TABLE IF EXISTS USERR;

CREATE TABLE USERR (
uName VARCHAR(255) NOT NULL, 
userID INT PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE COMPUTERPART (
partID INT PRIMARY KEY AUTO_INCREMENT,
pName VARCHAR(255) UNIQUE NOT NULL ,
pPrice INT,
pType VARCHAR(255)
);

CREATE TABLE BUILD (
buildID INT PRIMARY KEY AUTO_INCREMENT,
userID INT,
buildName VARCHAR(255) NOT NULL,
FOREIGN KEY (userID) REFERENCES USERR(userID)
);

CREATE TABLE BUILD_PART (
partID INT NOT NULL,
numberCount INT,
buildID INT,
isWish BIT,
PRIMARY KEY (partID, buildID),
FOREIGN KEY (buildID) REFERENCES BUILD(buildID),
FOREIGN KEY (partID) REFERENCES COMPUTERPART(partID)
);

CREATE TABLE SHARED_LIST (
buildID INT NOT NULL,
sharedToUserID INT NOT NULL,
PRIMARY KEY(buildID, sharedToUserID),
FOREIGN KEY(buildID) REFERENCES BUILD(buildID),
FOREIGN KEY(sharedToUserID) REFERENCES USERR(userID)
);

