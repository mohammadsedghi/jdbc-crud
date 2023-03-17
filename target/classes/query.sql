create database irmaktab;
create schema public
    create table person(
                           id serial primary key ,
                           name varchar(20) not null ,
                           family varchar(20)not null
    );
insert into irmaktab.person(id, name, family) VALUES (1,'ali','sedghi');
insert into irmaktab.person(id, name, family) VALUES (2,'arman','zanbily');
insert into irmaktab.person(id, name, family) VALUES (3,'mahan','nakhei');
delete from person where id=1;
UPDATE person
SET name='mohammad'
WHERE id=1;
drop table person
select * from person where id=2