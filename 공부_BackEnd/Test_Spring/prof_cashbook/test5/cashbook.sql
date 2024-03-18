-- test5용 테이블

drop table cashbook_info;
drop table  cashbook_member;

drop sequence cashbook_seq;
create table cashbook_member
(
    memberid varchar2(20) primary key
    , memberpw  varchar2(100) not null
    , membername varchar2(20) not null
    , enabled number(1) default 1
    , rolename varchar2(20)
);

create table cashbook_info
(
    infonum number primary key
    , memberid varchar2(20) not null references cashbook_member(memberid) on delete cascade
    , type varchar2(20) not null
    , memo varchar2(1000) not null
    , amount number default 0
    , inputdate date default sysdate
);

create sequence cashbook_seq;