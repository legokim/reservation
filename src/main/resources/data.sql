
insert into member (mem_no, mem_name) values ('10001','사용자A');
insert into member (mem_no, mem_name) values ('20001','사용자B');
insert into member (mem_no, mem_name) values ('30001','사용자C');
insert into member (mem_no, mem_name) values ('40001','사용자D');

insert into room (room_no, room_name) values ('101','회의실A');
insert into room (room_no, room_name) values ('201','회의실B');
insert into room (room_no, room_name) values ('301','회의실C');
insert into room (room_no, room_name) values ('401','회의실D');
insert into room (room_no, room_name) values ('501','회의실E');
insert into room (room_no, room_name) values ('601','회의실F');
insert into room (room_no, room_name) values ('701','회의실G');

insert into reservation (reserve_no, mem_no, room_no, create_dt, start_dt, end_dt, repeat_cnt, update_dt)
  values ('1','10001','101', sysdate, to_date('201811051000','YYYYMMDDHH24MI'), to_date('201811051100','YYYYMMDDHH24MI'), '1', sysdate);
insert into reservation (reserve_no, mem_no, room_no, create_dt, start_dt, end_dt, repeat_cnt, update_dt)
  values ('2','20001','102', sysdate, to_date('201811051200','YYYYMMDDHH24MI'), to_date('201811051400','YYYYMMDDHH24MI'), '1', sysdate);
insert into reservation (reserve_no, mem_no, room_no, create_dt, start_dt, end_dt, repeat_cnt, update_dt)
  values ('3','30001','103', sysdate, to_date('201811051000','YYYYMMDDHH24MI'), to_date('201811051100','YYYYMMDDHH24MI'), '1', sysdate);
insert into reservation (reserve_no, mem_no, room_no, create_dt, start_dt, end_dt, repeat_cnt, update_dt)
  values ('4','40001','104', sysdate, to_date('201811051000','YYYYMMDDHH24MI'), to_date('201811051100','YYYYMMDDHH24MI'), '1', sysdate);


-- insert into schedule (sch_no, start_dt, end_dt, use) values (1,  '0000', '0030', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (2,  '0030', '0100', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (3,  '0100', '0130', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (4,  '0130', '0200', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (5,  '0200', '0230', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (6,  '0230', '0300', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (7,  '0300', '0330', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (8,  '0330', '0400', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (9,  '0400', '0430', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (10, '0430', '0500', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (11, '0500', '0530', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (12, '0530', '0600', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (13, '0600', '0630', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (14, '0630', '0700', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (15, '0700', '0730', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (16, '0730', '0800', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (17, '0800', '0830', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (18, '0830', '0900', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (19, '0900', '0930', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (20, '0930', '1000', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (21, '1000', '1030', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (22, '1030', '1100', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (23, '1100', '1130', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (24, '1130', '1200', 1 );
--
-- insert into schedule (sch_no, start_dt, end_dt, use) values (25, '1200', '1230', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (26, '1230', '1300', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (27, '1300', '1330', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (28, '1330', '1400', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (29, '1400', '1430', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (30, '1430', '1500', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (31, '1500', '1530', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (32, '1530', '1600', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (33, '1600', '1630', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (34, '1630', '1700', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (35, '1700', '1730', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (36, '1730', '1800', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (37, '1800', '1830', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (38, '1830', '1900', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (39, '1900', '1930', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (40, '1930', '2000', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (41, '2000', '2030', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (42, '2030', '2100', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (43, '2100', '2130', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (44, '2130', '2200', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (45, '2200', '2230', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (46, '2230', '2300', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (47, '2300', '2330', 1 );
-- insert into schedule (sch_no, start_dt, end_dt, use) values (48, '2330', '2400', 1 );