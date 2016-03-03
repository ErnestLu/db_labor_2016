set character_set_results=utf8;

set character_set_client=utf8;

drop database db_labor_2016;

create database db_labor_2016;

use db_labor;

create table t_person (
    serialNo varchar(15) not null primary key comment '��ˮ��',/*1*/
    number varchar(10) not null comment '���',/*2*/
    name varchar(20) not null comment '����',/*3*/
    sex integer not null comment '�Ա� 1-�� 2-Ů',/*4*/
    nation varchar(2) not null comment '����',/*5*/
    idNo varchar(18) comment '���֤��',/*6*/
    identity integer not null comment '��� 1-���� 2-�ɲ�',/*7*/
    borntime varchar(10) not null comment '������������',/*8*/
    jointime varchar(10) not null comment '�μӹ���ʱ��',/*9*/
    type integer not null comment '����',/*10*/
    approvetime varchar(10) not null comment '����ʱ��',/*11*/
    office integer not null comment '����',/*12*/
    acceptNo varchar(20) comment '������',/*13*/
    acceptTime varchar(10) not null comment '����ʱ��',/*14*/
	phonenumber varchar(15) comment '�绰',/*15*/
    remark varchar(50) comment '��ע',/*16*/
    approveperson integer not null comment '������Ա',/*17*/
    etirenum varchar(10) comment '���˺�',/*18*/
    company varchar(60) comment '��˾',/*19*/
    ifaddorcut varchar(1) comment '�����Ƿ������� 0-�� 1-�� 2-��',/*20*/
    addorcutbegin varchar(10) comment '������ʼʱ��',/*21*/
    addorcutend varchar(10) comment '��������ʱ��',/*22*/
    addtime varchar(19) comment '���ʱ��',/*23*/
    ifuse varchar(1) comment '�Ƿ����� 1-���� 0-����',/*24*/
    ifcalculate varchar(1) comment '�Ƿ���� 1-���� 0-û��'/*25*/
);



create table t_person_temp (
	serialNo varchar(15) NOT NULL PRIMARY KEY comment '��ˮ��',
  	acceptNo varchar(16)  comment '������',
  	idNo varchar(18) comment '���֤��',
  	name varchar(20) comment '����',
  	company varchar(60) comment '��˾',
  	office integer comment '����',
  	sex integer comment '�Ա�',
  	accepttime varchar(16) comment '����ʱ��',
  	phonenumber varchar(15) comment '�绰',
  	addtime varchar(19) comment '���ʱ��',
  	ifuse varchar(1) comment '�Ƿ����� 1-���� 0-����',
  	ifprint varchar(1) comment '�Ƿ��ӡ 1-�Ѵ�ӡ 0-δ��ӡ',
  	ifSpecial varchar(1) comment '�Ƿ����⹤�� 1-���� 3-���⹤��'
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
	Normal int DEFAULT 0,		/*����*/
	disease int DEFAULT 0,		/*����*/
	special int default 0,		/*���⹤��*/
	collapse int default 0,		/*�Ʋ�*/
	retirement int default 0,	/*��ְ*/
	zhuanzhi int default 0,		/*ת����ҵ*/
	number int default 0		/*����*/
);

insert into SEQUENCE (NORMAL, DISEASE, SPECIAL, zhuanzhi, collapse, retirement, NUMBER) values(0, 0, 0, 0, 0, 0, 0);


/*���Ҵ����*/
create table dm_office (
	id integer,
	name varchar(10)
);
insert into dm_office values (1,'ҵ��һ��');
insert into dm_office values (2,'ҵ�����');
insert into dm_office values (3,'ҵ������');
insert into dm_office values (4,'ֱ����');


/*�Ա�����*/
create table dm_sex (
	id integer,
	name varchar(10)
);
insert into DM_SEX values (1,'��');
insert into DM_SEX values (2,'Ů');


/*��ݴ����*/
create table dm_identity (
	id integer ,
	name varchar(10)
);
insert into DM_IDENTITY values ( 1, '����');
insert into DM_IDENTITY values ( 2, '�ɲ�');


/*���ʹ����*/
create table dm_type (
	id integer,
	name varchar(10)
);
insert into DM_TYPE values (1,'����');
insert into DM_TYPE values (2,'��');
insert into DM_TYPE values (3,'���⹤��');
insert into DM_TYPE values (4,'��ְ');


show databases;