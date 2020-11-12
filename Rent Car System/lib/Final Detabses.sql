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
		CONSTRAINT PRIMARY KEY (rID),
		CONSTRAINT  FOREIGN KEY (cID) REFERENCES customer(cID)
		);
	
	create table rentdtails(
		rID VARCHAR (50) NOT NULL,
		rentDate VARCHAR (50) NOT NULL,
		vID VARCHAR (50) NOT NULL,
		chargePerday DECIMAL (8,2),
		rAdvance DECIMAL (8,2) ,
		rStatus VARCHAR (50) NOT NULL,
		CONSTRAINT PRIMARY Key (rID),
		CONSTRAINT FOREIGN KEY (rID) REFERENCES rent(rID),
		CONSTRAINT FOREIGN KEY (vID) REFERENCES vehicle(vID)
		);

	create table returndtails(
		returnID VARCHAR (50) NOT NULL,
		rID VARCHAR (50) NOT NULL,
		cID VARCHAR (50) NOT NULL,
		rentDate VARCHAR (50) NOT NULL,
		vID VARCHAR (50) NOT NULL,
		returnDate VARCHAR (50) NOT NULL,
		chargePerday DECIMAL (8,2) ,
		rAdvance DECIMAL (8,2) ,
		CONSTRAINT PRIMARY Key (returnID),
		CONSTRAINT FOREIGN KEY (cID) REFERENCES customer (cID),
		CONSTRAINT FOREIGN KEY (rID) REFERENCES rent(rID),
		CONSTRAINT FOREIGN KEY (vID) REFERENCES vehicle(vID)
		);

	create table payment(
		cID VARCHAR (50) NOT NULL,
		pID VARCHAR (50) NOT NULL,
        pDate VARCHAR (50)NOT NULL,
		payment DECIMAL (8,2),
		CONSTRAINT PRIMARY KEY (pID),
		CONSTRAINT FOREIGN KEY (cID) REFERENCES customer(cID)
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


	
		insert into vehicle values("V002","CHR","Good","2016 NEW","Car","White");
		insert into vehicle values("V003","Audi","Good","2020 OLD","Car","Black");
		insert into vehicle values("V004","BMW","Good","2016 NEW","Car","White");
		insert into vehicle values("V005","Cvic","Good","2016 NEW","Car","White");
		insert into vehicle values("V006","Lancer","Good","2016 NEW","Car","White");

		insert into vehicle values("V007","Nisaan","Good","2016 NEW","Van","White");
		insert into vehicle values("V008","Toyota","Good","2020 NEW","Van","White");
		insert into vehicle values("V009","Toyota Hightroop","Good","2020 NEW","Van","White");
		insert into vehicle values("V010","Toyota","Good","2020 NEW","Van","White");
		insert into vehicle values("V011","Toyota","Good","2020 NEW","Van","White");

		insert into vehicle values("V012","Mitshubishi","Good","2020 NEW","Bus","Blue");
		insert into vehicle values("V013","Mitshubishi","Good","2020 NEW","Bus","Blue");
		insert into vehicle values("V014","Mitshubishi","Good","2020 NEW","Bus","Blue");
		insert into vehicle values("V015","Mitshubishi","Good","2020 NEW","Bus","Blue");
		insert into vehicle values("V016","Mitshubishi","Good","2020 NEW","Bus","Blue");


		insert into vehicle values("V017","TVS","Good","2020 NEW","Bike","Blue");
		insert into vehicle values("V018","TVS","Good","2020 NEW","Bike","Blue");
		insert into vehicle values("V019","TVS","Good","2020 NEW","Bike","Blue");
		insert into vehicle values("V020","TVS","Good","2020 NEW","Bike","Blue");
		insert into vehicle values("V021","TVS","Good","2020 NEW","Bike","Blue");
		


