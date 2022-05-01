create database if not exists sports;
use sports;
drop table if exists sports;


create table Sports (
	id int(10) not null auto_increment,
    name varchar(50) not null,
    primary key(id)
    );
    
    insert into Sports(name) values("Football");
  select * from Sports;