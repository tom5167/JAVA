
--ALTER LOGIN sa ENABLE ;  
--GO  
--ALTER LOGIN sa WITH PASSWORD = 'admin@123' ;  
--GO 

--DROP DATABASE PatientCareDB;
--CREATE DATABASE PatientCareDB;

USE PatientCareDB;

IF OBJECT_ID('tblStaff', 'U') IS NOT NULL
DROP TABLE tblStaff;
GO

-- staff type admin,doctor,receptionist

CREATE TABLE tblStaff
(
	staff_id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	staff_type VARCHAR(50) NOT NULL,
	join_date VARCHAR(50) NOT NULL,
	available_hours VARCHAR(50) NOT NULL,
	position VARCHAR(50) NOT NULL,
	qualification VARCHAR(50) NOT NULL,
	specialization VARCHAR(50) NOT NULL,
	createdBy VARCHAR(50) NULL,
	createdDate VARCHAR(50) NULL,
	modifiedBy VARCHAR(50) NULL,
	modifiedDate VARCHAR(50) NULL,
);
alter table tblStaff ADD constraint tblStaff_staff_id_pk PRIMARY KEY(staff_id);
INSERT INTO tblStaff(first_name,last_name,staff_type,join_date,
	available_hours,position,qualification,specialization,
	createdBy,createdDate,modifiedBy,modifiedDate)
VALUES('ADMIN','ADMIN','ADMIN',GETDATE(),
'20','ADMIN','ADMIN','ADMIN',
'admin',GETDATE(),'','');

SELECT staff_id,first_name,last_name,staff_type,join_date,
	available_hours,position,qualification,specialization,
	createdBy,createdDate,modifiedBy,modifiedDate
FROM tblStaff;

IF OBJECT_ID('tblPatient', 'U') IS NOT NULL
DROP TABLE tblPatient;
GO

CREATE TABLE tblPatient
(
    patient_id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	sex VARCHAR(50) NOT NULL,
	dob VARCHAR(50) NOT NULL,
	street_number VARCHAR(50) NOT NULL,
	address_full VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	country VARCHAR(50) NOT NULL,
	postal_code VARCHAR(50) NOT NULL,
	sin_id VARCHAR(50) NOT NULL unique ,
	contact_number VARCHAR(50) NOT NULL,
	alternative_number VARCHAR(50) NOT NULL,
	insurance_id VARCHAR(50) NOT NULL,
	email_id VARCHAR(50) NOT NULL,
	blood_group VARCHAR(50) NOT NULL,
	marital_status VARCHAR(50) NOT NULL,
	createdBy VARCHAR(50) NULL,
	createdDate VARCHAR(50) NULL,
	modifiedBy VARCHAR(50) NULL,
	modifiedDate VARCHAR(50) NULL,
	
);
alter table tblPatient ADD constraint tblPatient_patient_id_pk PRIMARY KEY(patient_id);
alter table tblPatient ADD constraint tblPatient_sin_id_uq Unique(sin_id);
alter table tblPatient ADD constraint tblPatient_sin_id_ck CHECK (sin_id>= 0 and sin_id<= 999999999 );
alter table tblPatient ADD constraint tblPatient_blood_group_ck CHECK (blood_group='AB+' or blood_group='AB-' or blood_group='A' or
								       blood_group='A-' or blood_group='B' or blood_group='B-' or blood_group='o+' or blood_group='o-');




INSERT INTO tblPatient (first_name,last_name,sex,dob,
	street_number,address_full,city,country,postal_code,sin_id,
	contact_number,alternative_number,insurance_id,email_id,blood_group,marital_status)
VALUES('abc','def','Male','2017-11-13',
	'42','Heatherside Drive','TORONTO','Canada','M1W1T7','345',
	'345','765','567','abc@xyz.com','A+','Single');
INSERT INTO tblPatient (first_name,last_name,sex,dob,
	street_number,address_full,city,country,postal_code,sin_id,
	contact_number,alternative_number,insurance_id,email_id,blood_group,marital_status)
VALUES('abc','def','Male','2017-11-13',
	'42','Heatherside Drive','TORONTO','Canada','M1W1T7','345',
	'345','765','567','abc@xyz.com','A+','Single');

SELECT patient_id,first_name,last_name,sex,dob,
	street_number,address_full,city,country,postal_code,sin_id,
	contact_number,alternative_number,insurance_id,email_id,blood_group,marital_status 
FROM tblPatient;

IF OBJECT_ID('tblUser', 'U') IS NOT NULL
DROP TABLE tblUser;
GO

CREATE TABLE tblUser
(
    userId INT IDENTITY(1,1) PRIMARY KEY  NOT NULL,
	username VARCHAR(50) NOT NULL,
	pwd VARCHAR(50) NOT NULL,
	referId VARCHAR(50) NOT NULL,
	userType VARCHAR(50) NOT NULL, 
	createdBy VARCHAR(50) NULL,
	createdDate VARCHAR(50) NULL,
	modifiedBy VARCHAR(50) NULL,
	modifiedDate VARCHAR(50) NULL,
);

INSERT INTO tblUser(username,pwd,referId,userType,createdBy,createdDate,modifiedBy,modifiedDate)
VALUES('admin','admin',1,'ADMIN','admin','10/30/2019','','');

SELECT userId,username,pwd,referId,userType,createdBy,createdDate,modifiedBy,modifiedDate 
FROM tblUser;

SELECT patient_id as referId,first_name,last_name,'PATIENT' as UserType FROM tblPatient;
SELECT staff_id as referId,first_name,last_name,staff_type as UserType FROM tblStaff;

SELECT tblUser.userId,A.referId,A.first_name,A.last_name,A.userType,tblUser.createdBy,tblUser.createdDate,tblUser.modifiedBy,tblUser.modifiedDate 
FROM (
SELECT patient_id as referId,first_name,last_name,'PATIENT' as userType FROM tblPatient
UNION ALL
SELECT staff_id as referId,first_name,last_name,staff_type as userType FROM tblStaff
) AS A
INNER JOIN tblUser
ON A.referId = tblUser.referId
AND A.userType = tblUser.userType
WHERE A.userType = 'ADMIN'
AND A.first_name LIKE 'admin';

SELECT userId,username,pwd,referId,userType,
createdBy,createdDate,modifiedBy,modifiedDate
FROM tblUser;

IF OBJECT_ID('tblBilling', 'U') IS NOT NULL
DROP TABLE tblBilling;
GO
CREATE TABLE tblBilling
(
    billing_id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    mode_of_payment VARCHAR(50) NOT NULL,
	payment_due_date date NOT NULL,
	billing_timestamp DATE NOT NULL,
	insurance_number INT NOT NULL,
	payer_name VARCHAR(50) NOT NULL,
	bill_amount FLOAT(10) NOT NULL,
	createdBy VARCHAR(50) NULL,
	createdDate VARCHAR(50) NULL,
	modifiedBy VARCHAR(50) NULL,
	modifiedDate VARCHAR(50) NULL,
);

INSERT INTO tblBilling (mode_of_payment,payment_due_date,billing_timestamp,insurance_number,payer_name,bill_amount)
VALUES('cash',GETDATE(),GETDATE(),567,'ghi',10.0);

SELECT billing_id,mode_of_payment,payment_due_date,billing_timestamp,insurance_number,payer_name 
FROM tblBilling;

IF OBJECT_ID('tblPatientBilling', 'U') IS NOT NULL
DROP TABLE tblPatientBilling;
GO
CREATE TABLE tblPatientBilling
(
    billing_id INT NOT NULL,
	patient_id INT NOT NULL,
	createdBy VARCHAR(50) NULL,
	createdDate VARCHAR(50) NULL,
	modifiedBy VARCHAR(50) NULL,
	modifiedDate VARCHAR(50) NULL,
);

INSERT INTO tblPatientBilling (billing_id,patient_id)
VALUES(1,2);

SELECT billing_id,patient_id 
FROM tblPatientBilling;

IF OBJECT_ID('tblInsurance', 'U') IS NOT NULL
DROP TABLE tblInsurance;
GO
CREATE TABLE tblInsurance
(
    insurance_id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    insurance_number VARCHAR(50) NOT NULL,
	insurance_company VARCHAR(50) NOT NULL,
	insurance_plan VARCHAR(50) NOT NULL,
	effective_date date NOT NULL,
	expiry date NOT NULL,
	createdBy VARCHAR(50) NULL,
	createdDate VARCHAR(50) NULL,
	modifiedBy VARCHAR(50) NULL,
	modifiedDate VARCHAR(50) NULL,
);

IF OBJECT_ID('tblRoom', 'U') IS NOT NULL
DROP TABLE tblRoom;
GO

CREATE TABLE tblRoom
(
    room_id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    room_number INT NOT NULL,
	total_beds INT NOT NULL,
	occupied_beds INT NOT NULL,
	room_type VARCHAR(50) NOT NULL,
	building_number VARCHAR(50) NOT NULL,
	createdBy VARCHAR(50) NULL,
	createdDate VARCHAR(50) NULL,
	modifiedBy VARCHAR(50) NULL,
	modifiedDate VARCHAR(50) NULL,
);

INSERT INTO tblRoom (total_beds,occupied_beds,room_type,building_number)
VALUES(1,0,'operation room','A101');

SELECT room_number,total_beds,occupied_beds,room_type,building_number 
FROM tblRoom;

IF OBJECT_ID('tblDiagnosis', 'U') IS NOT NULL
DROP TABLE tblDiagnosis;
GO
CREATE TABLE tblDiagnosis
(
	medication_id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	medication_name VARCHAR(50) NOT NULL,
	medication_type VARCHAR(50) NOT NULL,
	illness VARCHAR(50) NOT NULL,
	dosage VARCHAR(50) NOT NULL,
	createdBy VARCHAR(50) NULL,
	createdDate VARCHAR(50) NULL,
	modifiedBy VARCHAR(50) NULL,
	modifiedDate VARCHAR(50) NULL,
);

IF OBJECT_ID('tblPatientDiagnosis', 'U') IS NOT NULL
DROP TABLE tblPatientDiagnosis;
GO
CREATE TABLE tblPatientDiagnosis
(
    patient_id INT NOT NULL,
	medication_id INT NOT NULL,
	createdBy VARCHAR(50) NULL,
	createdDate VARCHAR(50) NULL,
	modifiedBy VARCHAR(50) NULL,
	modifiedDate VARCHAR(50) NULL,
);

IF OBJECT_ID('tblEvent', 'U') IS NOT NULL
DROP TABLE tblEvent;
GO
CREATE TABLE tblEvent
(
    event_id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	patient_id INT NOT NULL,
    staff_id INT NOT NULL,
	event_type VARCHAR(50) NOT NULL,
	event_date date NOT NULL,
	createdBy VARCHAR(50) NULL,
	createdDate VARCHAR(50) NULL,
	modifiedBy VARCHAR(50) NULL,
	modifiedDate VARCHAR(50) NULL,
);
