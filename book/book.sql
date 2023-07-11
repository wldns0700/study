drop table book;
create table book(
idx number(4) primary key,
title varchar2(50) not null,
content varchar2(200) not null,
price number(7) not null
);

drop sequence book_idx_seq;
create sequence book_idx_seq increment by 1 start with 1;

insert into book values(book_idx_seq.nextval,'쉬운 경제학','쉽게 풀어쓴 경제학 책입니다.','20000');

select * from book;

select * from board where idx=1;

update book set title='어려운 경제학을 쉽게 풀어쓴 경제학', content='경제학책입니다.',price=15000 where idx=1;

delete from book where idx=1;