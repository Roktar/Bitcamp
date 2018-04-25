# 실습에 필요한 테이블 생성

## 게시판 테이블 생성
create table ex_board(
bno integer not null,
titl varchar(255) not null,
cont text,
rdt datetime
);

## 테이블의 기본키(primary key, PK)를 설정
alter table ex_board add constraint [ex_board_pk] primary key(bno);
- [] 사이의 문구는 제약조건 이름을 지정하는 것으로 개발자가 굳이 지정안해도 자동으로 생성은 된다.

## 기본키의 값이 자동으로 증가하도록 설정
alter table ex_board modify column bno int not null auto_increment;

## ex_board의 설정 상태 보기
desc ex_board;

## 데이터 삽입(insert)
insert into ex_board(titl, cont, rdt) values('subject1', 'contents1', now());
insert into ex_board(titl, cont, rdt) values('subject2', 'contents2', now());
insert into ex_board(titl, cont, rdt) values('subject3', 'contents3', now());
insert into ex_board(titl, cont, rdt) values('subject4', 'contents4', now());
insert into ex_board(titl, cont, rdt) values('subject5', 'contents5', now());
insert into ex_board(titl, cont, rdt) values('subject6', 'contents6', now());
insert into ex_board(titl, cont, rdt) values('subject7', 'contents7', now());
insert into ex_board(titl, cont, rdt) values('subject8', 'contents8', now());
insert into ex_board(titl, cont, rdt) values('subject9', 'contents9', now());
insert into ex_board(titl, cont, rdt) values('subject10', 'contents10', now());

## 데이터 조회
select bno,titl,cont,rdt from ex_board;

## 데이터 변경
update ex_board set titl='ok7' where bno=7;

## 데이터 삭제
delete from ex_board where bno = 8;