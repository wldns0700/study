drop table board;
create table board(
idx number primary key,
title varchar2(100) not null,
content clob,
readcount number(8) default(0) not null,
parentid number not null,
tab number not null,
writeid varchar2(30) not null,
writename varchar2(30) not null,
writeday date not null,
filename varchar2(260),
isdel number(1) check(isdel between 0 and 1),
kind varchar2(20) not null
);

create sequence board_idx_seq increment by 1 start with 1;
--오라클구문에서 idx sequence로 시작을 하지만 parentid=0
insert into board(idx,title,content, readcount, 
parentid, tab,
writeid,writename, writeday,
isdel,kind) 
values(board_idx_seq.nextval,'게시판 1번째 글','게시판 내용1', 0,
0,0,
'admin','김자바',sysdate,
0,'일반게시판');

select * from board;
delete from board;
drop sequence board_idx_seq;


insert into board(idx,title,content, readcount,parentid, tab,writeid,writename, writeday,isdel,kind) 
values(board_idx_seq.nextval,'게시판 2번째 글','게시판 내용2', 0,0,0,'admin','김자바',sysdate,0,'일반게시판');
insert into board(idx,title,content, readcount,parentid, tab,writeid,writename, writeday,isdel,kind) 
values(board_idx_seq.nextval,'게시판 3번째 글','게시판 내용3', 0,0,0,'admin','김자바',sysdate,0,'일반게시판');
insert into board(idx,title,content, readcount,parentid, tab,writeid,writename, writeday,isdel,kind) 
values(board_idx_seq.nextval,'게시판 4번째 글','게시판 내용4', 0,0,0,'admin','김자바',sysdate,0,'일반게시판');
insert into board(idx,title,content, readcount,parentid, tab,writeid,writename, writeday,isdel,kind) 
values(board_idx_seq.nextval,'게시판 5번째 글','게시판 내용5', 0,0,0,'admin','김자바',sysdate,0,'일반게시판');
insert into board(idx,title,content, readcount,parentid, tab,writeid,writename, writeday,isdel,kind) 
values(board_idx_seq.nextval,'게시판 6번째 글','게시판 내용6', 0,0,0,'admin','김자바',sysdate,0,'일반게시판');
insert into board(idx,title,content, readcount,parentid, tab,writeid,writename, writeday,isdel,kind) 
values(board_idx_seq.nextval,'게시판 7번째 글','게시판 내용7', 0,0,0,'admin','김자바',sysdate,0,'일반게시판');
insert into board(idx,title,content, readcount,parentid, tab,writeid,writename, writeday,isdel,kind) 
values(board_idx_seq.nextval,'게시판 8번째 글','게시판 내용8', 0,0,0,'admin','김자바',sysdate,0,'일반게시판');
insert into board(idx,title,content, readcount,parentid, tab,writeid,writename, writeday,isdel,kind) 
values(board_idx_seq.nextval,'게시판 9번째 글','게시판 내용9', 0,0,0,'admin','김자바',sysdate,0,'일반게시판');
insert into board(idx,title,content, readcount,parentid, tab,writeid,writename, writeday,isdel,kind) 
values(board_idx_seq.nextval,'게시판 10번째 글','게시판 내용10', 0,0,0,'admin','김자바',sysdate,0,'일반게시판');

--3번 댓글
insert into board(idx,title,content, readcount,parentid, tab,writeid,writename, writeday,isdel,kind) 
values(board_idx_seq.nextval,'게시판 3-1번째 글','게시판 내용3-1', 0,3,1,'admin','김자바',sysdate,0,'일반게시판');

--오라클 구문을 활용하여 댓글확인
select * from board start with parentid=0
connect by prior idx=parentid
order siblings by idx desc;

commit;

--오라클에서 반복문 사용방법(이구문은 pl/sql 즉 sqlplus에서만 실행, 마지막에 반드시 /포함)
--sql developer에서는 아래구문이 실행 가능 / 필요없음
--sql plus에서 begin~end;복사해서 입력하고 엔터 후 / 엔터
begin
	for i in 11..80 
	loop
		insert into board(idx,title,content, readcount, 
		parentid, tab,
		writeid,writename, writeday,
		isdel,kind) 
		values(board_idx_seq.nextval,'게시판 '||i||'번째 글','게시판 내용'||i, 0,
		0,0,
		'admin','김자바',sysdate,
		0,'일반게시판');
	end loop;
end;
/

commit;

--최신10개글을 출력 (select * from 테이블명)
select * from board; --입력한 순서대로 출력이 되지 않음
select * from board order by idx desc; --idx필드는 순차입력으로 처리되어 있으므로 순서가 있다.

select rownum, idx, title from
(select * from board start with parentid=0 connect 
by prior idx=parentid order siblings by idx desc)

select rownum, idx, title from
(select * from board start with parentid=0 connect 
by prior idx=parentid order siblings by idx desc) where rownum <11;


--rownum 11~20번 글을 출력하세요.
select rownum, idx, title from
(select * from board start with parentid=0 connect 
by prior idx=parentid order siblings by idx desc) 
where rownum >10 and rownum <21; --결과 안나옴

select rownum, idx, title from
(select * from board start with parentid=0 connect 
by prior idx=parentid order siblings by idx desc) 
where rownum between 11 and 20; --결과 안나옴

--결론 : 1차적인 rownum은 중간범위를 출력할 수 없음

--20번까지 글을 가지고 오세요.
select rownum, idx, title from
(select * from board start with parentid=0 connect 
by prior idx=parentid order siblings by idx desc) 
where rownum <=20;

--11~20번을 글을 원하므로 글순서를 desc로 바꾸어라
select rownum , idx, title from
(select * from board start with parentid=0 connect 
by prior idx=parentid order siblings by idx desc) 
where rownum <=20 order by rownum desc;

--위에서 작성한 테이블이 또다른 테이블로 됨, 상위 10개를 추출해서 다시 desc를 해줌
select rownum, r, idx, title from
(select rownum r, idx, title from
(select * from board start with parentid=0 connect 
by prior idx=parentid order siblings by idx desc) 
where rownum<=20 order by rownum desc)
where rownum<=10 order by r asc;

insert into 
board(idx,title,content,readcount,parentid,tab,writeid,writename,writeday,filename,isdel,kind) 
values(board_idx_seq.nextval,'dao test중','dao를 작성중에 있습니다.',0,0,0,'admin','길동이',sysdate,'a.txt',0,'일반게시판');

--페이지 1페이지 1~10
select rownum, t.* from
(select rownum r, t1.* from
(select * from board start with parentid=0 connect 
by prior idx=parentid order siblings by idx desc) t1 
where rownum<=10 order by rownum desc) t
where rownum<=20 order by r asc;
