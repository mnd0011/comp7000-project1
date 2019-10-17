BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Purchases" (
	"Date"	TEXT NOT NULL,
	"PurchaseID"	INTEGER NOT NULL UNIQUE,
	"CustomerID"	INTEGER NOT NULL,
	"ProductID"	INTEGER NOT NULL,
	"Price"	REAL NOT NULL,
	"Quantity"	INTEGER NOT NULL,
	"Cost"	REAL NOT NULL,
	"Tax"	REAL NOT NULL,
	"TotalCost"	REAL NOT NULL,
	PRIMARY KEY("PurchaseID")
);
CREATE TABLE IF NOT EXISTS "Customers" (
	"CustomerID"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"Name"	TEXT NOT NULL,
	"Phone"	TEXT,
	"Address"	TEXT,
	"Email"	TEXT
);
CREATE TABLE IF NOT EXISTS "Products" (
	"ProductID"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"Name"	TEXT,
	"Description"	TEXT,
	"Price"	REAL,
	"Quantity"	INTEGER,
	"Image"	TEXT
);
INSERT INTO "Purchases" VALUES ('Wed Oct 16 22:21:22 CDT 2019',1,11,15,39.88,12,478.56,43.07,521.63);
INSERT INTO "Purchases" VALUES ('Wed Oct 16 22:21:22 CDT 2019',2,12,16,54.0,2,108.0,9.72,117.72);
INSERT INTO "Purchases" VALUES ('Wed Oct 16 22:21:22 CDT 2019',3,13,17,77.0,1,77.0,6.93,83.93);
INSERT INTO "Purchases" VALUES ('Wed Oct 16 22:21:22 CDT 2019',4,14,18,108.24,3,324.72,29.22,353.94);
INSERT INTO "Purchases" VALUES ('Wed Oct 16 22:21:22 CDT 2019',5,15,19,4.9,750,3675.0,330.75,4005.75);
INSERT INTO "Purchases" VALUES ('Wed Oct 16 22:21:22 CDT 2019',6,15,20,4.47,125,558.75,50.29,609.04);
INSERT INTO "Purchases" VALUES ('Wed Oct 16 22:21:22 CDT 2019',7,13,18,108.24,1,108.24,9.74,117.98);
INSERT INTO "Purchases" VALUES ('Wed Oct 16 22:21:22 CDT 2019',8,13,16,54.0,8,432.0,38.88,470.88);
INSERT INTO "Purchases" VALUES ('Wed Oct 16 22:21:22 CDT 2019',9,13,19,4.9,8000,39200.0,3528.0,42728.0);
INSERT INTO "Purchases" VALUES ('Wed Oct 16 22:21:22 CDT 2019',10,12,15,39.88,23,917.24,82.55,999.79);
INSERT INTO "Purchases" VALUES ('Wed Oct 16 22:28:27 CDT 2019',11,11,15,39.88,12,478.56,43.07,521.63);
INSERT INTO "Purchases" VALUES ('Wed Oct 16 22:35:29 CDT 2019',12,11,16,54.0,11,594.0,53.46,647.46);
INSERT INTO "Customers" VALUES (11,'Tom Jones','5555555555','123 Main Street, Huntsville, AL 35750','tom@yahoo.com');
INSERT INTO "Customers" VALUES (12,'Bill Smith','1211211212','1701 Suite B Highland, Provo, UT 84601','bil.smith@aol.com');
INSERT INTO "Customers" VALUES (13,'Marissa Wen','4445556689','W 50th Street, New York, NY 10019','12345Wen@wen.com');
INSERT INTO "Customers" VALUES (14,'Fran Whitehead','0000000000','PO Box 125, Fayetteville, TN 37334','fran1985@auburn.edu');
INSERT INTO "Customers" VALUES (15,'Ali Baba','1472583692','12 avenue du General Leclerc, Bourges, Paris 75016 ','baba_babey@gmail.com');
INSERT INTO "Customers" VALUES (16,'New Customer','5556661234','New Customer Address','customer@gmail.com');
INSERT INTO "Customers" VALUES (17,'Test Customer','1234568910','Test Customer Address','test@gmail.com');
INSERT INTO "Products" VALUES (15,'Little Tikes Adjustn Jam Pro Basketball Set','Sports Equipment',39.88,25,NULL);
INSERT INTO "Products" VALUES (16,'Fisher Procce Bounce and Spin Interactive Puppy','Toddler Toys',54.0,12,NULL);
INSERT INTO "Products" VALUES (17,'Wildluvs Juno My Baby Elephant Electronic Pet','Toddler Toys',77.0,1,NULL);
INSERT INTO "Products" VALUES (18,'Boss Office Products Black Reception Waiting Room Chair','Office Furniture',108.24,5,NULL);
INSERT INTO "Products" VALUES (19,'Expo Standard White Board Dry Eraser','Office Supplies',4.9,8236,NULL);
INSERT INTO "Products" VALUES (20,'Sharpie Ultra Fine Point Marker Set of 5, Black','Office Supplies',4.47,144,NULL);
INSERT INTO "Products" VALUES (21,'New Product','New Product ',12.0,2,NULL);
INSERT INTO "Products" VALUES (22,'Test Product','Test Product',123.56,78,NULL);
COMMIT;
