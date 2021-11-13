insert into course(id,fullname,created_date,last_updated_date) values(10001,'JPA_TRAINING',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10002,'SPRING_TRAINING',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10003,'SPRINGBOOT_TRAINING',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10004,'WEBTech_TRAINING',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10005,'Dummy1',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10006,'Dummy2',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10007,'Dummy3',sysdate(),sysdate());
insert into course(id,fullname,created_date,last_updated_date) values(10008,'Dummy4',sysdate(),sysdate());

insert into passport(id,number) values(40001,'E123456');
insert into passport(id,number) values(40002,'N125678');
insert into passport(id,number) values(40003,'L145678');

insert into student(id,fullname,passport_id) values(20001,'Ranga',40001);
insert into student(id,fullname,passport_id) values(20002,'Adam',40002);
insert into student(id,fullname,passport_id) values(20003,'Jane',40003);

insert into review(id,rating,description,course_id) values(50001,'5','Great Course',10001);
insert into review(id,rating,description,course_id) values(50002,'4','Wonderful Course',10001);
insert into review(id,rating,description,course_id) values(50003,'3','Awsome Course',10003);

insert into student_course(student_id,course_id) values(20001,10001);
insert into student_course(student_id,course_id) values(20002,10002);
insert into student_course(student_id,course_id) values(20003,10003);
insert into student_course(student_id,course_id) values(20001,10003);