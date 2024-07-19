CREATE TABLE roleDetails (
                             roleId INT PRIMARY KEY,
                             roleName VARCHAR(100),
                             roleDescription VARCHAR(200)
);

CREATE TABLE userDetails (
                             userId INT AUTO_INCREMENT PRIMARY KEY,
                             userEmail VARCHAR(100),
                             userPassword VARCHAR(100),
                             roleID INT,
                             FOREIGN KEY (roleId) REFERENCES roleDetails(roleId)
);


CREATE TABLE adminDetails (
                              adminId INT PRIMARY KEY,
                              customerUserName VARCHAR(100),
                              FOREIGN KEY (adminId) REFERENCES userDetails(userId)
);

CREATE TABLE customer (
                          customerId INT PRIMARY KEY,
                          weight INT,
                          age INT,
                          gender VARCHAR(100),
                          customerName VARCHAR(100),
                          customerPhone VARCHAR(100),
                          customerAddress VARCHAR(200),
                          FOREIGN KEY (customerId) REFERENCES userDetails(userId)
);

CREATE TABLE gymOwner (
                          ownerId INT PRIMARY KEY,
                          ownerName VARCHAR(100),
                          ownerGstNum VARCHAR(100),
                          ownerPanNum VARCHAR(100),
                          approvalStatus VARCHAR(100),
                          ownerAddress VARCHAR(100),
                          ownerPhone VARCHAR(100),
                          FOREIGN KEY (ownerId) REFERENCES userDetails(userId)
);

CREATE TABLE gymDetails (
                            gymId INT AUTO_INCREMENT PRIMARY KEY,
                            gymOwnerId INT,
                            gymName VARCHAR(100),
                            gymAddress VARCHAR(200),
                            noOfSlots INT,
                            approvalStatus INT,
                            FOREIGN KEY (gymOwnerId) REFERENCES gymOwner(ownerId)
);

CREATE TABLE slotDetails (
                             slotId INT AUTO_INCREMENT PRIMARY KEY,
                             gymId INT,
                             date VARCHAR(100),
                             startTime VARCHAR(100),
                             endTime VARCHAR(100),
                             noOfSeats INT,
                             FOREIGN KEY (gymId) REFERENCES gymDetails(gymId)
);

CREATE TABLE booking (
                         bookingId INT AUTO_INCREMENT PRIMARY KEY,
                         customerId INT,
                         slotId INT,
                         bookingStatus INT,
                         transactionId INT,
                         bookingAmount INT,
                         bookingDate VARCHAR(100),
                         bookingTimeSlotStart VARCHAR(100),
                         bookingTimeSlotEnd VARCHAR(100),
                         FOREIGN KEY (customerId) REFERENCES customer(customerId),
                         FOREIGN KEY (slotId) REFERENCES slotDetails(slotId)
);

CREATE TABLE payments (
                          transactionId INT AUTO_INCREMENT PRIMARY KEY,
                          paymentDetails VARCHAR(100),
                          expiryDate VARCHAR(100),
                          modeOfPayment VARCHAR(100)
);