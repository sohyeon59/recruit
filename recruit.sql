CREATE SEQUENCE seq_job START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_com START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_resume START WITH 1 INCREMENT BY 1;

------------------------ 개인 --------------------------
--  개인회원 
CREATE TABLE member (
    mid     VARCHAR2(50) PRIMARY KEY,
    mpw     VARCHAR2(100) NOT NULL,
    mname   VARCHAR2(50) NOT NULL,
    mbirth  DATE,
    memail  VARCHAR2(100) UNIQUE,
    mphone  VARCHAR2(20) UNIQUE
);
DROP TABLE member;
select * from member;

-- 지원서
CREATE TABLE resume (
    rno      NUMBER PRIMARY KEY,
    mid      VARCHAR2(50) NOT NULL,
    jno      NUMBER NOT NULL,
    address  VARCHAR2(200),
    univ     VARCHAR2(100),
    major    VARCHAR2(100),
    career   VARCHAR2(500),
    experi   VARCHAR2(500),
    intro    CLOB,
    FOREIGN KEY (mid) REFERENCES member(mid),
    FOREIGN KEY (jno) REFERENCES job(jno)
);

DROP TABLE resume;
select * from resume;

commit;
----------------------- 기업 -------------------------
-- 기업회원
CREATE TABLE company (
    cid     VARCHAR2(50) PRIMARY KEY,
    cpw     VARCHAR2(100) NOT NULL,
    cname   VARCHAR2(100) NOT NULL,
    csize   VARCHAR2(50)
);
SELECT * FROM company;
delete from company;

-- 구인공고
CREATE TABLE job (
    jno      NUMBER PRIMARY KEY,
    cid      VARCHAR2(50) NOT NULL,
    title    VARCHAR2(200) NOT NULL,
    content  CLOB,
    deadline DATE,
    FOREIGN KEY (cid) REFERENCES company(cid)
);
select * from job;
delete from job;

--댓글
create table comment1(
    comno number primary key,
    jno number,
    mid VARCHAR2(50),
    content varchar2(200),
    created_at date
);

drop table comment1;
select * from comment1;
delete from comment1;
-------------------------------------

