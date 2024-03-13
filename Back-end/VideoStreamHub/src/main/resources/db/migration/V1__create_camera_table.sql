create table camera(

    id bigint not null auto_increment,
    manufacturer varchar(10) not null,
    customer_id bigint not null,
    environment varchar(100) not null,
    model varchar(100) not null,
    nick_name varchar(50) not null,
    serial_number varchar(50) not null,

    primary key(id)

);