drop database rentcar;

create database rentcar;
	use rentcar;
create table customer(
	cID VARCHAR (50) NOT NULL,
	cAddress VARCHAR (50) NOT NULL,
	cName VARCHAR (50) NOT NULL,
	cNumber VARCHAR (50) NOT NULL,
	CONSTRAINT PRIMARY KEY (cID)
	);
create table vehicle(
	vID VARCHAR (50) NOT NULL,
	vName VARCHAR (50) NOT NULL,
	vStates VARCHAR (50) NOT NULL,
	vModle  VARCHAR (50) NOT NULL,
	vType VARCHAR (50) NOT NULL,
	vColor VARCHAR (50) NOT NULL,
	CONSTRAINT PRIMARY KEY(vID)
	); 
create table system(
	sID VARCHAR (50) NOT NULL,
	sName VARCHAR (50) NOT NULL,
	sAddress VARCHAR (50) NOT NULL,
	sNumber VARCHAR (50) NOT NULL,		
	CONSTRAINT PRIMARY KEY (sID)
	);
create table systemDetails(
	sdID INT (50) NOT NULL AUTO_INCREMENT,
	sID VARCHAR (50) NOT NULL,
	sEmail VARCHAR (50) NOT NULL,
	sPassword VARCHAR (50) NOT NULL,
	CONSTRAINT PRIMARY KEY (sdID),
	CONSTRAINT FOREIGN KEY (sID) REFERENCES system(sID)
	);
create table rent(
	rID VARCHAR (50) NOT NULL,
	cID VARCHAR (50) NOT NULL,
        rcName VARCHAR (50) NOT NULL,
        vID VARCHAR (50) NOT NULL,
	CONSTRAINT PRIMARY KEY (rID),
	CONSTRAINT  FOREIGN KEY (cID) REFERENCES customer(cID),
	CONSTRAINT  FOREIGN KEY (vID) REFERENCES vehicle(vID)
	);
	
create table rentdtails(
	rID VARCHAR (50) NOT NULL,
	rentDate VARCHAR (50) NOT NULL,
	vID VARCHAR (50) NOT NULL,
	chargePerday DECIMAL (8,2),
	rAdvance DECIMAL (8,2) ,
	rStatus VARCHAR (50) NOT NULL,
	CONSTRAINT PRIMARY Key (rID,vID),
	CONSTRAINT FOREIGN KEY (rID) REFERENCES rent(rID),
	CONSTRAINT FOREIGN KEY (vID) REFERENCES vehicle(vID)
	);

create table returns(
	returnID VARCHAR (50) NOT NULL,
	rID VARCHAR (50) NOT NULL,
	cID VARCHAR (50) NOT NULL,
	returnDate VARCHAR (50) NOT NULL,
	CONSTRAINT PRIMARY Key (returnID),
	CONSTRAINT FOREIGN KEY (cID) REFERENCES customer (cID),
	CONSTRAINT FOREIGN KEY (rID) REFERENCES rent(rID)
	);

create table returndtails(
	returnID VARCHAR (50) NOT NULL,
	rentDate VARCHAR (50) NOT NULL,
	vID VARCHAR (50) NOT NULL,
	chargePerday DECIMAL (8,2) ,
	rAdvance DECIMAL (8,2),
	CONSTRAINT PRIMARY Key (returnID,vID),
	CONSTRAINT FOREIGN KEY (returnID) REFERENCES returns (returnID),
	CONSTRAINT FOREIGN KEY (vID) REFERENCES vehicle(vID)
	);

create table payment(
	returnID VARCHAR (50) NOT NULL,
	cID VARCHAR (50) NOT NULL,
	vID VARCHAR (50) NOT NULL,
        pDate VARCHAR (50)NOT NULL,
	payment DECIMAL (8,2),
	CONSTRAINT PRIMARY KEY (returnID,cID,vID),
	CONSTRAINT FOREIGN KEY (cID) REFERENCES customer(cID),
	CONSTRAINT FOREIGN KEY (returnID) REFERENCES returns(returnID),
	CONSTRAINT FOREIGN KEY (vID) REFERENCES vehicle(vID)
	);




create table breakdown(
	bID VARCHAR (50) NOT NULL,
	vID VARCHAR (50) NOT NULL,
	brokenDate VARCHAR(50) NOT NULL,
	CONSTRAINT PRIMARY KEY (bID),
	CONSTRAINT FOREIGN KEY (vID) REFERENCES vehicle (vID)
	); 
                                                  
create table breakdowndetails(
	bdID INT (50) NOT NULL AUTO_INCREMENT,
	bID VARCHAR (50) NOT NULL,
	breakdownStatus VARCHAR (50) NOT NULL,
	fixDate VARCHAR (50),
	CONSTRAINT PRIMARY KEY (bdID),
	CONSTRAINT FOREIGN KEY (bID) REFERENCES breakdown (bID)
	);





SELECT r.rID,r.rentDate,r.vID,r.chargePerday,r.rAdvance,s.rcName,s.cID FROM rentdtails r,rent s WHERE (r.rID= s.rID) and s.rID='R001';

select * from vehicle WHERE vStates='Good';

	SELECT r.rID,r.rentDate,r.vID,r.chargePerday,r.rAdvance,s.rcName,s.cID FROM rentdtails r,rent s WHERE (r.rID= s.rID) and s.rID='R001';

SELECT r.rID,r.rentDate,r.vID,r.chargePerday,r.rAdvance,s.rcName,s.cID FROM rentdtails r,rent s WHERE (r.vID= s.vID) and s.vID='V001';


SELECT s.id,s.studentName,s.address,s.contact,s.dob FROM student s,registration r,course c WHERE c.code=r.courseCode && r.studentId=s.id && c.code='C002';
