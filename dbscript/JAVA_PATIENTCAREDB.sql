--USE master; 

--DROP DATABASE PatientCareDB; 
--CREATE DATABASE PatientCareDB; 

--USE PatientCareDB;
 
IF Object_id('tblStaff', 'U') IS NOT NULL 
  DROP TABLE tblStaff; 
GO 

CREATE TABLE tblStaff 
( 
    staff_id        INT IDENTITY(1, 1) NOT NULL, 
    first_name      VARCHAR(50) NOT NULL, 
    last_name       VARCHAR(50) NOT NULL, 
    staff_type      VARCHAR(50) NOT NULL, 
    join_date       VARCHAR(50) NOT NULL, 
    available_hours VARCHAR(50) NOT NULL, 
    position        VARCHAR(50) NOT NULL, 
    qualification   VARCHAR(50) NOT NULL, 
    specialization  VARCHAR(50) NOT NULL, 
    createdBy       VARCHAR(50) NULL, 
    createdDate     VARCHAR(50) NULL, 
    modifiedBy      VARCHAR(50) NULL, 
    modifiedDate    VARCHAR(50) NULL, 
); 

IF Object_id('tblPatient', 'U') IS NOT NULL 
  DROP TABLE tblPatient; 
GO 

CREATE TABLE tblPatient 
( 
    patient_id         INT IDENTITY(1, 1) NOT NULL, 
    first_name         VARCHAR(50) NOT NULL, 
    last_name          VARCHAR(50) NOT NULL, 
    sex                VARCHAR(50) NOT NULL, 
    dob                VARCHAR(50) NOT NULL, 
    street_number      VARCHAR(50) NOT NULL, 
    address_full       VARCHAR(50) NOT NULL, 
    city               VARCHAR(50) NOT NULL, 
    country            VARCHAR(50) NOT NULL, 
    postal_code        VARCHAR(50) NOT NULL, 
    sin_id             VARCHAR(50) NOT NULL UNIQUE, 
    contact_number     VARCHAR(50) NOT NULL, 
    alternative_number VARCHAR(50) NOT NULL, 
    insurance_id       VARCHAR(50) NOT NULL, 
    email_id           VARCHAR(50) NOT NULL, 
    blood_group        VARCHAR(50) NOT NULL, 
    marital_status     VARCHAR(50) NOT NULL, 
    room_id            INT NULL, 
    createdBy          VARCHAR(50) NULL, 
    createdDate        VARCHAR(50) NULL, 
    modifiedBy         VARCHAR(50) NULL, 
    modifiedDate       VARCHAR(50) NULL, 
); 

IF Object_id('tblUser', 'U') IS NOT NULL 
  DROP TABLE tblUser; 
GO 

CREATE TABLE tblUser 
( 
    userid       INT IDENTITY(1, 1) NOT NULL, 
    username     VARCHAR(50) NOT NULL, 
    pwd          VARCHAR(50) NOT NULL, 
    referid      INT NOT NULL, 
    usertype     VARCHAR(50) NOT NULL, 
    createdBy    VARCHAR(50) NULL, 
    createdDate  VARCHAR(50) NULL, 
    modifiedBy   VARCHAR(50) NULL, 
    modifiedDate VARCHAR(50) NULL, 
); 

IF Object_id('tblBilling', 'U') IS NOT NULL 
  DROP TABLE tblBilling; 
GO

CREATE TABLE tblBilling 
( 
    billing_id        INT IDENTITY(1, 1) NOT NULL, 
    mode_of_payment   VARCHAR(50) NOT NULL, 
    payment_due_date  VARCHAR(50) NOT NULL, 
    billing_timestamp VARCHAR(50) NOT NULL, 
    insurance_number  INT NOT NULL, 
    payer_name        VARCHAR(50) NOT NULL, 
    bill_amount       FLOAT(10) NOT NULL, 
    paymentstatus     VARCHAR(50) NOT NULL, 
    createdBy         VARCHAR(50) NULL, 
    createdDate       VARCHAR(50) NULL, 
    modifiedBy        VARCHAR(50) NULL, 
    modifiedDate      VARCHAR(50) NULL, 
); 

IF Object_id('tblPatientBilling', 'U') IS NOT NULL 
  DROP TABLE tblPatientBilling; 
GO

CREATE TABLE tblPatientBilling 
( 
    billing_id   INT NOT NULL, 
    patient_id   INT NOT NULL, 
    createdBy    VARCHAR(50) NULL, 
    createdDate  VARCHAR(50) NULL, 
    modifiedBy   VARCHAR(50) NULL, 
    modifiedDate VARCHAR(50) NULL, 
); 

IF Object_id('tblRoom', 'U') IS NOT NULL 
  DROP TABLE tblRoom; 
GO

CREATE TABLE tblRoom 
( 
    room_id         INT IDENTITY(1, 1) NOT NULL, 
    room_number     INT NOT NULL, 
    total_beds      INT NOT NULL, 
    occupied_beds   INT NOT NULL, 
    room_type       VARCHAR(50) NOT NULL, 
    building_number VARCHAR(50) NOT NULL, 
    createdBy       VARCHAR(50) NULL, 
    createdDate     VARCHAR(50) NULL, 
    modifiedBy      VARCHAR(50) NULL, 
    modifiedDate    VARCHAR(50) NULL, 
); 

IF Object_id('tblDiagnosis', 'U') IS NOT NULL 
  DROP TABLE tblDiagnosis; 
GO

CREATE TABLE tblDiagnosis 
( 
    medication_id   INT IDENTITY(1, 1) NOT NULL, 
    medication_name VARCHAR(50) NOT NULL, 
    medication_type VARCHAR(50) NOT NULL, 
    illness         VARCHAR(50) NOT NULL, 
    dosage          VARCHAR(50) NOT NULL, 
    createdBy       VARCHAR(50) NULL, 
    createdDate     VARCHAR(50) NULL, 
    modifiedBy      VARCHAR(50) NULL, 
    modifiedDate    VARCHAR(50) NULL, 
); 

IF Object_id('tblPatientDiagnosis', 'U') IS NOT NULL 
  DROP TABLE tblPatientDiagnosis; 
GO 

CREATE TABLE tblPatientDiagnosis 
( 
    patient_id    INT NOT NULL, 
    medication_id INT NOT NULL, 
    createdBy     VARCHAR(50) NULL, 
    createdDate   VARCHAR(50) NULL, 
    modifiedBy    VARCHAR(50) NULL, 
    modifiedDate  VARCHAR(50) NULL 
); 

IF Object_id('tblEvent', 'U') IS NOT NULL 
  DROP TABLE tblEvent; 
GO

CREATE TABLE tblEvent 
( 
    event_id     INT IDENTITY(1, 1) NOT NULL, 
    patient_id   INT NOT NULL, 
    staff_id     INT NOT NULL, 
    event_type   VARCHAR(50) NOT NULL, 
    event_date   VARCHAR(50) NULL,
    event_time   VARCHAR(50) NULL,
    createdBy    VARCHAR(50) NULL, 
    createdDate  VARCHAR(50) NULL, 
    modifiedBy   VARCHAR(50) NULL, 
    modifiedDate VARCHAR(50) NULL, 
);


-----------------------INSERT----------------------
INSERT INTO tblStaff(first_name,last_name,staff_type,join_date,available_hours,position,qualification,specialization,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES('ADMIN','ADMIN','ADMIN',GETDATE(),'20','ADMIN','ADMIN','ADMIN','admin',GETDATE(),'','');
INSERT INTO tblUser(username,pwd,referId,userType,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES('admin','admin',1,'ADMIN','admin','10/30/2019','','');
INSERT INTO tblPatient (first_name,last_name,sex,dob,street_number,address_full,city,country,postal_code,sin_id,contact_number,alternative_number,insurance_id,email_id,blood_group,marital_status)
VALUES('abc','def','Male','2017-11-13','42','Heatherside Drive','TORONTO','Canada','M1W1T7','345','345','765','567','abc@xyz.com','A+','Single');
----------------------------------------------------
SELECT staff_id,first_name,last_name,staff_type,join_date,available_hours,position,qualification,specialization,createdBy,createdDate,modifiedBy,modifiedDate
FROM tblStaff;
SELECT userId,username,pwd,referId,userType,createdBy,createdDate,modifiedBy,modifiedDate 
FROM tblUser;
SELECT patient_id,first_name,last_name,sex,dob,street_number,address_full,city,country,postal_code,sin_id,contact_number,alternative_number,insurance_id,email_id,blood_group,marital_status 
FROM tblPatient;
-----------------------------------------------------
INSERT INTO tblBilling (mode_of_payment,payment_due_date,billing_timestamp,insurance_number,payer_name,bill_amount)
VALUES('cash',GETDATE(),GETDATE(),567,'ghi',10.0);
INSERT INTO tblBilling (mode_of_payment,payment_due_date,billing_timestamp,insurance_number,payer_name,bill_amount)
VALUES('cash',GETDATE(),GETDATE(),567,'ghi',10.0);
INSERT INTO tblBilling (mode_of_payment,payment_due_date,billing_timestamp,insurance_number,payer_name,bill_amount)
VALUES('cash',GETDATE(),GETDATE(),567,'ghi',10.0);

SELECT billing_id,mode_of_payment,payment_due_date,billing_timestamp,insurance_number,payer_name 
FROM tblBilling;

INSERT INTO tblPatientBilling (billing_id,patient_id)
VALUES(1,2);
INSERT INTO tblPatientBilling (billing_id,patient_id)
VALUES(1,2);
INSERT INTO tblPatientBilling (billing_id,patient_id)
VALUES(1,2);

SELECT billing_id,patient_id 
FROM tblPatientBilling;

INSERT INTO tblRoom (total_beds,occupied_beds,room_type,building_number)
VALUES(1,0,'operation room','A101');
INSERT INTO tblRoom (total_beds,occupied_beds,room_type,building_number)
VALUES(1,0,'operation room','A101');
INSERT INTO tblRoom (total_beds,occupied_beds,room_type,building_number)
VALUES(1,0,'operation room','A101');

SELECT room_number,total_beds,occupied_beds,room_type,building_number 
FROM tblRoom;

INSERT INTO tblStaff(first_name,last_name,staff_type,join_date,available_hours,position,qualification,specialization,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES('Jinal','Shah','Doctor',GETDATE(),'20','Doctor','MS','Neurologist','admin',GETDATE(),'','');
INSERT INTO tblStaff(first_name,last_name,staff_type,join_date,available_hours,position,qualification,specialization,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES('Dolly','Shah','Doctor',GETDATE(),'20','Doctor','MS','Gynecologists','admin',GETDATE(),'','');
INSERT INTO tblStaff(first_name,last_name,staff_type,join_date,available_hours,position,qualification,specialization,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES('Olivia','Martin','Nurse',GETDATE(),'20','Nurse','ADN','Gynecologists','admin',GETDATE(),'','');
INSERT INTO tblStaff(first_name,last_name,staff_type,join_date,available_hours,position,qualification,specialization,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES('Sophia','Wilson','Nurse',GETDATE(),'20','Nurse','RNs','Physiology','admin',GETDATE(),'','');

SELECT staff_id,first_name,last_name,staff_type,join_date,available_hours,position,qualification,specialization,createdBy,createdDate,modifiedBy,modifiedDate
FROM tblStaff;

INSERT INTO tblDiagnosis (medication_name,medication_type,illness,dosage,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES ('soparamizine','tablet','fever','3','ADMIN',GETDATE(),'','');
INSERT INTO tblDiagnosis (medication_name,medication_type,illness,dosage,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES ('paracetamol','tablet','fever','3','ADMIN',GETDATE(),'','');
INSERT INTO tblDiagnosis (medication_name,medication_type,illness,dosage,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES ('azithromizine','tablet','fever','3','ADMIN',GETDATE(),'','');

SELECT medication_id,medication_name,medication_type,illness,dosage,createdBy,createdDate,modifiedBy,modifiedDate
FROM tblDiagnosis;

INSERT INTO tblPatientDiagnosis (medication_id,createdBy,createdDate,modifiedBy,modifiedDate) 
VALUES (1,'ADMIN',GETDATE(),'','');
INSERT INTO tblPatientDiagnosis (medication_id,createdBy,createdDate,modifiedBy,modifiedDate) 
VALUES (2,'ADMIN',GETDATE(),'','');
INSERT INTO tblPatientDiagnosis (medication_id,createdBy,createdDate,modifiedBy,modifiedDate) 
VALUES (3,'ADMIN',GETDATE(),'','');

SELECT medication_id,createdBy,createdDate,modifiedBy,modifiedDate
FROM tblPatientDiagnosis;

INSERT INTO tblEvent (patient_id,staff_id,event_type,event_date,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES (1,2,'operation',GETDATE(),'ADMIN',GETDATE(),'','');
INSERT INTO tblEvent (patient_id,staff_id,event_type,event_date,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES (1,2,'checkup',GETDATE(),'ADMIN',GETDATE(),'','');
INSERT INTO tblEvent (patient_id,staff_id,event_type,event_date,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES (1,2,'follow up',GETDATE(),'ADMIN',GETDATE(),'','');

SELECT patient_id,staff_id,event_type,event_date,createdBy,createdDate,modifiedBy,modifiedDate
FROM tblEvent;
 