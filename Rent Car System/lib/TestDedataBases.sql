DESC rent;
DESC rentdtails;
SELECT * FROM rentdtails;
SELECT r.rID,r.cID,r.rcName,r.endDate, rd.rentDate,rd.vID,rd.chargePerday,rd.rAdvance FROM rent r,vehicle v,rentdtails rd WHERE r.rID=rd.rID && v.vStates='OnUse'&& rd.vID='V002'; 
SHOW TABLES;
DESC rent;
