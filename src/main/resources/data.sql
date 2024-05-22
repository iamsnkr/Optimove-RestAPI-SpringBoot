drop database if exists optimove;

create database optimove collate = utf8mb3_general_ci;
use optimove;


drop table if exists OPTIMOVEDATA;
Create table OPTIMOVEDATA (
	ID INT (11) UNSIGNED NOT NULL auto_increment,
	CUSTOMER_ID VARCHAR(75),
    INITIAL_CUSTOMER_ATTRIBUTE varchar(75),
    FINAL_CUSTOMER_ATTRIBUTE varchar(75),
    CUSTOMER_ATTRIBUTES varchar(800),
	PRIMARY KEY (ID)
);


drop table if exists MONGODB;

Create table MONGODB (
	ID INT (11) UNSIGNED NOT NULL auto_increment,
	SOURCE VARCHAR(75),
    DESTINATION varchar(75),
    OPTIMOVE_INSTANCE varchar(75),
    USECASE varchar(800),
    CUSTOMER_ATTRS varchar(75),
	PRIMARY KEY (ID)
);

Create table KAFKA_TOPIC (
	ID INT (11) UNSIGNED NOT NULL auto_increment,
	ACCOUNT_NAME VARCHAR(75),
    BRAND_TYPE varchar(75),
    CUSTOMER varchar(75),
	PRIMARY KEY (ID)
);

commit;
