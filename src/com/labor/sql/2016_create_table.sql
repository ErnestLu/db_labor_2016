set character_set_results=utf8;

set character_set_client=utf8;

drop database db_labor_2016;

create database db_labor_2016;

use db_labor;

create table t_person (
    serialNo varchar(15) not null primary key comment '流水号',/*1*/
    number varchar(10) not null comment '编号',/*2*/
    name varchar(20) not null comment '姓名',/*3*/
    sex integer not null comment '性别 1-男 2-女',/*4*/
    nation varchar(2) not null comment '民族',/*5*/
    idNo varchar(18) comment '身份证号',/*6*/
    identity integer not null comment '身份 1-工人 2-干部',/*7*/
    borntime varchar(10) not null comment '档案出生年月',/*8*/
    jointime varchar(10) not null comment '参加工作时间',/*9*/
    type integer not null comment '类型',/*10*/
    approvetime varchar(10) not null comment '退休时间',/*11*/
    office integer not null comment '科室',/*12*/
    acceptNo varchar(20) comment '受理编号',/*13*/
    acceptTime varchar(10) not null comment '受理时间',/*14*/
	phonenumber varchar(15) comment '电话',/*15*/
    remark varchar(50) comment '备注',/*16*/
    approveperson integer not null comment '审批人员',/*17*/
    etirenum varchar(10) comment '病退号',/*18*/
    company varchar(60) comment '公司',/*19*/
    ifaddorcut varchar(1) comment '工龄是否有增减 0-无 1-增 2-减',/*20*/
    addorcutbegin varchar(10) comment '增减开始时间',/*21*/
    addorcutend varchar(10) comment '增减结束时间',/*22*/
    addtime varchar(19) comment '添加时间',/*23*/
    ifuse varchar(1) comment '是否在用 1-在用 0-不用',/*24*/
    ifcalculate varchar(1) comment '是否计算 1-计算 0-没算'/*25*/
);



create table t_person_temp (
	serialNo varchar(15) NOT NULL PRIMARY KEY comment '流水号',
  	acceptNo varchar(16)  comment '受理编号',
  	idNo varchar(18) comment '身份证号',
  	name varchar(20) comment '姓名',
  	company varchar(60) comment '公司',
  	office integer comment '科室',
  	sex integer comment '性别',
  	accepttime varchar(16) comment '受理时间',
  	phonenumber varchar(15) comment '电话',
  	addtime varchar(19) comment '添加时间',
  	ifuse varchar(1) comment '是否在用 1-在用 0-不用',
  	ifprint varchar(1) comment '是否打印 1-已打印 0-未打印',
  	ifSpecial varchar(1) comment '是否特殊工种 1-正常 3-特殊工种'
);



create table index_num (
	one int DEFAULT 1,
	two int DEFAULT 1,
	three int default 1,
	zhi int default 1,
	number int default 1,
	shoulinum int default 1
);

insert into index_num (one, two, three, zhi, number, shoulinum) values(0, 0, 0, 0, 0, 0);



create table sequence(
	Normal int DEFAULT 0,		/*正常*/
	disease int DEFAULT 0,		/*病退*/
	special int default 0,		/*特殊工种*/
	collapse int default 0,		/*破产*/
	retirement int default 0,	/*退职*/
	zhuanzhi int default 0,		/*转制企业*/
	number int default 0		/*总数*/
);

insert into SEQUENCE (NORMAL, DISEASE, SPECIAL, zhuanzhi, collapse, retirement, NUMBER) values(0, 0, 0, 0, 0, 0, 0);


/*科室代码表*/
create table dm_office (
	id integer,
	name varchar(10)
);
insert into dm_office values (1,'业务一科');
insert into dm_office values (2,'业务二科');
insert into dm_office values (3,'业务三科');
insert into dm_office values (4,'直属科');


/*性别代码表*/
create table dm_sex (
	id integer,
	name varchar(10)
);
insert into DM_SEX values (1,'男');
insert into DM_SEX values (2,'女');


/*身份代码表*/
create table dm_identity (
	id integer ,
	name varchar(10)
);
insert into DM_IDENTITY values ( 1, '工人');
insert into DM_IDENTITY values ( 2, '干部');


/*类型代码表*/
create table dm_type (
	id integer,
	name varchar(10)
);
insert into DM_TYPE values (1,'正常');
insert into DM_TYPE values (2,'因病');
insert into DM_TYPE values (3,'特殊工种');
insert into DM_TYPE values (4,'退职');


show databases;