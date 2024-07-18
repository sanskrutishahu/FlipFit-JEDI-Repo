CREATE TABLE userDetails (
                             userId INT AUTO_INCREMENT PRIMARY KEY,
                             userName VARCHAR(100),
                             userEmail VARCHAR(100),
                             userPassword VARCHAR(100),
                             userAddress VARCHAR(100),
                             userPhoneNumber VARCHAR(100),
                             roleID INT,
                             FOREIGN KEY (roleId) REFERENCES roleDetails(roleId)
);

CREATE TABLE roleDetails (
                             roleId INT PRIMARY KEY,
                             roleName VARCHAR(100),
                             roleDescription VARCHAR(200)
);

CREATE TABLE adminDetails (
                              userId INT PRIMARY KEY,
                              customerUserName VARCHAR(100)
);

CREATE TABLE customer (
                          userId INT PRIMARY KEY,
                          aadhaarNumber VARCHAR(100),
                          weight INT
);

CREATE TABLE gymOwner (
                          userId INT PRIMARY KEY,
                          ownerGstNum VARCHAR(100),
                          ownerPanNum VARCHAR(100),
                          approvalStatus VARCHAR(100)
);

CREATE TABLE gymDetails (
                            centerId INT AUTO_INCREMENT PRIMARY KEY,
                            userId INT,
                            centerName VARCHAR(100),
                            centerAddress VARCHAR(200),
                            noOfSlots INT,
                            approvalStatus INT,
                            FOREIGN KEY (userId) REFERENCES userDetails(userId)
);

CREATE TABLE slotDetails (
                             slotId INT AUTO_INCREMENT PRIMARY KEY,
                             centreId INT,
                             startTime DATETIME,
                             endTime DATETIME,
                             noOfSeats INT,
                             FOREIGN KEY (centreId) REFERENCES gymDetails(centreId)
);

CREATE TABLE booking (
                         bookingId INT AUTO_INCREMENT PRIMARY KEY,
                         userId INT,
                         slotId INT,
                         bookingStatus INT,
                         transactionId INT,
                         bookingAmount INT,
                         FOREIGN KEY (userId) REFERENCES userDetails(userId),
                         FOREIGN KEY (slotId) REFERENCES slotDetails(slotId)
);

CREATE TABLE payments (
                          transactionId INT AUTO_INCREMENT PRIMARY KEY,
                          paymentDetails VARCHAR(100),
                          expiryDate DATE,
                          modeOfPayment VARCHAR(100)
);





