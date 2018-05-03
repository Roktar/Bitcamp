# 외래키
- 다른 테이블의 기본키를 참조하는 컬럼.

create table test1(
    no int not null primary key auto_increment,
    title varchar(255) not null,
    content text,
    rdt datetime not null
);


create table test2(
    fno int not null primary key auto_increment,
    filepath varchar(255),
    bno int not null
);

게시판 데이터 입력
```
insert into test1(title, rdt) values('aaa', now());
insert into test1(title, rdt) values('bbb', now());
insert into test1(title, rdt) values('ccc', now());;
insert into test1(title, rdt) values('ddd', now());
insert into test1(title, rdt) values('eee', now());
insert into test1(title, rdt) values('fff', now());
insert into test1(title, rdt) values('ggg', now());
insert into test1(title, rdt) values('hhh', now());
insert into test1(title, rdt) values('iii', now());
insert into test1(title, rdt) values('jjj', now());
```

첨부파일 데이터 입력
```
insert into test2(filepath, bno) values ('C:\downloads\a.gif', 1);
insert into test2(filepath, bno) values ('C:\downloads\b.gif', 1);
insert into test2(filepath, bno) values ('C:\downloads\c.gif', 1);
insert into test2(filepath, bno) values ('C:\downloads\d.gif', 5);
insert into test2(filepath, bno) values ('C:\downloads\e.gif', 5);
insert into test2(filepath, bno) values ('C:\downloads\f.gif', 10);
```
# 문제점
- 첨부파일 데이터 입력 시 존재하지 않는 게시물 번호가 입력되어도 오류임을 감지할 수 없다.

# 외래키
- 다른 테이블의 데이터와 연관된 데이터를 저장할 때 무효한 데이터가 입력되지않도록 하는 문법.
- 다른 테이블의 데이터가 참조하는 데이터를 임의로 지울 수 없도록 하는 문법.
- 데이터의 무결성을 유지할 수 있게 하는 문법.
=:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:>:
```
alter table [TABLE_NAME]
    add constraint [CONSTRAINT_NAME] foreign key ([COLUMN_NAME]) references [OTHER_TABLE_NAME](OTHER_COLUMN)
ex)
ALTER TABLE test2
    add constraint test2_bno_fk foreign key (bno) references test1(no);
```

test1처럼 다른 테이블에 의해 참조되는 테이블을 '부모 테이블' 이라고 한다.
test2처럼 다른 테이블의 데이터를 참조하는 테이블을 '자식 테이블'이라고 한다.


