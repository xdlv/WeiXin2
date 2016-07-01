-- CREATE DATABASE weixing DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
drop table if exists t_primary_key;
create table t_primary_key(
	table_name varchar(32) not null primary key,
	current_id   int not null
);
drop table if exists t_user;
create table t_user
(
	id     int primary key, 
	name varchar(15) not null,
	pwd varchar(10),
	mail varchar(20),
	user_role int
);
insert into t_user values(-10,'a','a','a@a.com',0);
insert into t_user values(-9,'b','b','b@b.com',1);

-- 用户绑定表
drop table IF EXISTS  t_userdz;
create table t_userdz
(
	phone varchar(15) primary key ,
	user_name varchar(50),
	wxid varchar(50)
);

drop table IF EXISTS  t_user_validate;
create table t_user_validate
(
    phone	varchar(15) not null,	
    validate_code varchar(6),
    status char(1),
	  validate_time datetime
);

drop table IF EXISTS  t_dzlist;
create table t_dzlist
(
	year int,
	month int,
	impdate date,
	userid varchar(15),
	Username varchar(50),
	Isok Char(1),
	Qmye float,
	zdxsk1 float,
	ysdsk1 float,
	zdfwk1 float,
	jb1 float,
	fl1 float,
	zdxsk2 float,
	jb2 float,
	fl2 float,
	zdfwk2 float,
	qtyfdk2 float -- credit_scope varchar(10)
);

drop table if exists t_user_company;
create table t_user_company
(
	code varchar(20),
	company_name varchar(200),
	area varchar(15),
	business char(1),
	wx_contract_name1 varchar(20),
	wx_contract_phone1 varchar(15),
	wx_contract_name2 varchar(20),
	wx_contract_phone2 varchar(15),
	manager_name varchar(20),
	remark_content varchar(100)
	-- --credit_scope varchar(10)
);

drop table if exists t_import_dz_record;
create table t_import_dz_record
(
	year SMALLINT not null,
	month SMALLINT not null,
	notification char(1),
	import_date date
);