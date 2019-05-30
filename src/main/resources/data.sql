insert into course(id, name) 
values(10001,'JPA in 50 Steps');
insert into course(id, name) 
values(10002,'Spring in 50 Steps');
insert into course(id, name) 
values(10003,'Java in 50 Steps');
insert into course(id, name) 
values(10004,'Hibernate in 50 Steps');

insert into passport(id, passport_number)
values(30001,'ADC1234E');
insert into passport(id, passport_number)
values(30002,'G927GHET');
insert into passport(id, passport_number)
values(30003,'KL9082DS');
insert into passport(id, passport_number)
values(30004,'LM9926GD');

insert into student(id, name, passport_id)
values(20001,'Sumit',30001);
insert into student(id, name, passport_id)
values(20002,'Subho',30002);
insert into student(id, name, passport_id)
values(20003,'Sekhar',30003);
insert into student(id, name, passport_id)
values(20004,'Sutanu',30004);


insert into review(id, rating, description)
values(40001,'5','Great Course');
insert into review(id, rating, description)
values(40002,'4','Good Course');
insert into review(id, rating, description)
values(40003,'1','Bad Course');
insert into review(id, rating, description)
values(40004,'3','Ok Course');