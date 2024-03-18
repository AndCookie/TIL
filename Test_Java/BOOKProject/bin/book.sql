
/* Drop Tables */

DROP TABLE DETAILS CASCADE CONSTRAINTS;
DROP TABLE BOOK CASCADE CONSTRAINTS;
DROP TABLE PURCHASE CASCADE CONSTRAINTS;
DROP TABLE MEMBERS CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE BOOK
(
	ISBN number(50) NOT NULL,
	TITLE varchar2(50) NOT NULL,
	WRITER varchar2(20) DEFAULT '���ڹ̻�',
	PUBLISH varchar2(20) NOT NULL,
	PRICE number(7) NOT NULL,
	GENRE varchar2(20),
	PRIMARY KEY (ISBN)
);


CREATE TABLE DETAILS
(
	SEQ_NO number NOT NULL,
	QUANTITY number DEFAULT 0,
	ISBN number(50) NOT NULL,
	PURCHASE_NO number(20) NOT NULL,
	PRIMARY KEY (SEQ_NO)
);


CREATE TABLE MEMBERS
(
	ID varchar2(20) NOT NULL,
	PW varchar2(20) NOT NULL,
	NAME varchar2(20) NOT NULL,
	ADDRESS varchar2(50) NOT NULL,
	TEL varchar2(20),
	BIRTHDAY varchar2(20),
	PRIMARY KEY (ID)
);


CREATE TABLE PURCHASE
(
	PURCHASE_NO number(20) NOT NULL,
	AMOUNT number(15) DEFAULT 0,
	PURCHASE_DATE varchar2(20),
	ID varchar2(20) NOT NULL,
	PRIMARY KEY (PURCHASE_NO)
);



/* Create Foreign Keys */

ALTER TABLE DETAILS
	ADD FOREIGN KEY (ISBN)
	REFERENCES BOOK (ISBN)
;


ALTER TABLE PURCHASE
	ADD FOREIGN KEY (ID)
	REFERENCES MEMBERS (ID)
;


ALTER TABLE DETAILS
	ADD FOREIGN KEY (PURCHASE_NO)
	REFERENCES PURCHASE (PURCHASE_NO)
;



