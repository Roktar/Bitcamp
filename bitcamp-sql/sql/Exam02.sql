# data manipulation language
데이터 등록, 변경, 삭제를 다루는 SQL 문법

## insert
- 데이터를 입력할 때 사용하는 문법이다.

```
/* 연락처 테이블 생성 */
create table test1 (
  no int not null,
  name varchar(20) not null,
  tel varchar(20) not null,
  fax varchar(20),
  pstno varchar(5),
  addr varchar(200)
);

/* PK 컬럼 지정 */
alter table test1
  add constraint primary key (no);

/* 자동 증가 컬럼 지정 */
alter table test17
  modify column no int not null auto_increment;
  
```

- 전체 컬럼 값 입력하기
```
/* 컬럼을 지정하지 않으면 테이블을 생성할 때 선언한 컬럼 순서대로 값을 지정한다.*/
/* 즉, 위에서는 no, name 순으로 생성했으니 첫번째값은 no, 두번재값은 name이 된다.*/
insert into [TABLE_NAME] value(값,....);
insert into test1 values(null,'aaa','111','222','10101','seoul');

/* 컬럼을 명시할 수 있다. 이때 값을 입력하는 컬럼의 순서를 바꿀 수 있다. */
insert into 테이블명(컬럼,컬럼,...) values(값,값,...);
insert into test17(name,fax,tel,no,pstno,addr) 
    values('bbb','222','111',null,'10101','seoul');
```

- 값을 입력할 컬럼을 선택하기. 단 필수 입력 컬럼은 반드시 선택해야 한다.
```
/* no 컬럼은 필수 입력 컬럼이지만, 
  자동 증가 컬럼이기 때문에 값을 입력하지 않아도 된다.*/
insert into test17(name,tel) values('ccc','333');
```

### select 결과를 테이블에 insert하기
```
insert into test17(name,tel)
  select name, '000-0000-0000' from test16 where class='java100'; 
```

## update 
- 등록된 데이터를 변경할 때 사용하는 명령이다.
```
update 테이블명 set 컬럼명=값, 컬럼명=값, ... where 조건...;
update test17 set tel='111', fax='222' where no = 4;
update test17 set tel='222', fax='222' where no = 5;

/* 조건을 지정하지 않으면, 모든 데이터에 대해 변경한다.*/
update test17 set fax='333';
```

## Mysql은 autocommit 기본값이 true임. 
따라서 명령창에서 작업하면 실제 테이블에는 작업과 동시에 바로 반영된다.
수동으로 반영시키고싶으ㅜㄴ 경우에는 autocommit을 false로 바꾼 후 작업할 것.
> set autocommit=false;
수동 반영은 쿼리문 작업 후 commit을 보내주면 된다.
> commit;
이전 상태로 돌리고싶은 경우에는 rollback을 사용하면 된다.
> rollback;

## delete
- 데이터를 삭제할 때 사용하는 명령이다.
```
delete from 테이블명 where 조건;
delete from test17 where no=4 or no=5 or no=6;

/* 조건을 지정하지 않으면 모든 데이터가 삭제된다. 주의!*/
delete from test17;
```

















