CREATE TABLE IF NOT EXISTS Users (
	ID INT auto_increment NOT NULL,
    saltpass VARCHAR(255) NOT NULL,
    salt VARCHAR(255) NOT NULL,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    UserType ENUM('user', 'instructor', 'admin') NOT NULL,
    TestsTaken INT,
    PRIMARY KEY (ID)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS Words (
	English VARCHAR(255) NOT NULL,
    Welsh VARCHAR(255) NOT NULL,
    gender ENUM ('M', 'F') NOT NULL,
    PRIMARY KEY (English, Welsh)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS Scores (
	ID INT NOT NULL,
	TestID INT auto_increment NOT NULL,
    Score INT NOT NULL,
    PRIMARY KEY (TestID),
    FOREIGN KEY (ID) REFERENCES Users(ID)
) ENGINE=InnoDB;