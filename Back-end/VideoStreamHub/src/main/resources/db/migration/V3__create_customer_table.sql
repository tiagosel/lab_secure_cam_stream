drop table customer;
create table customer(

    id bigint not null auto_increment,
    name varchar(100) not null,
    master_email varchar(100) not null,
    phone varchar(15) not null,
    document varchar(50) not null,
    category varchar(50) not null,

    primary key(id)

);