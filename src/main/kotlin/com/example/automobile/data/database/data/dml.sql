--
-- Data Manipulation Language (DML) for database AutoMobile
--

USE `automobile`;

-- Insert data into `UserProfile` table
INSERT INTO `UserProfile` (`userProfileID`, `firstName`, `lastName`, `dateOfBirth`, `driversLicenceNumber`) VALUES
(1, 'Stephan', 'de Vries', '1976-03-20', 1146419821),
(2, 'Jochem', 'Janssen', '1965-07-02', 6022182635),
(3, 'Paula', 'Vermeer', '1998-08-23', 8006750144);

-- Insert data into `Account` table
INSERT INTO `Account` (`accountID`, `email`, `password`, `userProfileID`) VALUES
(1, 'stephandevries@hotmail.com', 'stephandevries123', 1),
(2, 'jochemjanssen@hotmail.com', 'jochemjanssen123', 2),
(3, 'paulavermeer@hotmail.com', 'paulavermeer123', 3);

-- Insert data into `Car` table
INSERT INTO `Car` (`carID`, `licencePlate`, `carBrand`, `vehicleType`, `amountOfPassengers`, `amountOfDoors`, `automatic`, `gpsAvailable`, `carPriceAmount`, `carPriceCurrency`, `userProfileID`) VALUES
(1, '44-SB-ZZ', 'Citroën', 'C4', 5, 5, false, false, 12.99, 'Euro', 1),
(2, 'RV-483-R', 'Renault', 'Megane', 5, 5, false, true, 10.85, 'Euro', 2),
(3, 'T-742-VX', 'BMW', '3-Serie', 5, 5, true, true, 15.00, 'Euro', 3);

-- Insert data into `CarAvailability` table
INSERT INTO `CarAvailability` (`carAvailabilityID`, `dateTimeFrom`, `dateTimeUntil`, `carID`) VALUES
(1, "2023-10-11 08:30:00", "2023-10-11 22:00:00", 1),
(2, "2023-09-30 10:30:00", "2023-09-30 20:00:00", 2),
(3, "2023-10-20 06:00:00", "2023-10-21 23:00:00", 3);

-- Insert data into `CarReservation` table
INSERT INTO `CarReservation` (`carReservationID`, `dateTimeFrom`, `dateTimeUntil`, `userProfileID`, `carID`) VALUES
(1, "2023-10-11 09:00:00", "2023-10-11 20:00:00", 1, 1),
(2, "2023-09-30 12:00:00", "2023-09-30 14:00:00", 2, 2),
(3, "2023-10-20 08:00:00", "2023-10-21 22:00:00", 3, 3);

-- Insert data into `Payment` table
INSERT INTO `Payment` (`paymentID`, `amount`, `currency`, `paymentMethod`, `dateTime`, `carReservationID`) VALUES
(1, 20.41, "Euro", "Mastercard", "2023-10-11 20:30:00", 1),
(2, 13.54, "Euro", "Mastercard", "2023-09-30 14:00:00", 2),
(3, 58.32, "Euro", "Mastercard", "2023-10-21 22:10:00", 3);

-- Insert data into `BonusPointsTransaction` table
INSERT INTO `BonusPointsTransaction` (`bonusPointsTransactionID`, `amount`, `userProfileID`, `carReservationID`) VALUES
(1, 500, 1, 1),
(2, 500, 2, 2),
(3, 500, 3, 3);