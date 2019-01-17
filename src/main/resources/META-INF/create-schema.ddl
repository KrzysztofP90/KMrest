
    create table Ammo (
       id  serial not null,
        price float8 not null,
        calibre_id int4,
        primary key (id)
    )

    create table Calibre (
       id  serial not null,
        size float8 not null,
        primary key (id)
    )

    create table FireArms (
       id  serial not null,
        name varchar(255),
        price float8 not null,
        calibre_id int4,
        producer_id int4,
        primary key (id)
    )

    create table Producer (
       id  serial not null,
        producerName varchar(255),
        primary key (id)
    )

    alter table Ammo 
       add constraint FK4uo9hs5e2h8tfvl23k5jy2qdy 
       foreign key (calibre_id) 
       references Calibre

    alter table FireArms 
       add constraint FKlhhnf9umodjruo6fiq0eg6ev3 
       foreign key (calibre_id) 
       references Calibre

    alter table FireArms 
       add constraint FKgahdso3ge7q2nhsvhumlbhohq 
       foreign key (producer_id) 
       references Producer

    create table Ammo (
       id  serial not null,
        price float8 not null,
        calibre_id int4,
        primary key (id)
    )

    create table Calibre (
       id  serial not null,
        size float8 not null,
        primary key (id)
    )

    create table FireArms (
       id  serial not null,
        name varchar(255),
        price float8 not null,
        calibre_id int4,
        producer_id int4,
        primary key (id)
    )

    create table Producer (
       id  serial not null,
        producerName varchar(255),
        primary key (id)
    )

    alter table Ammo 
       add constraint FK4uo9hs5e2h8tfvl23k5jy2qdy 
       foreign key (calibre_id) 
       references Calibre

    alter table FireArms 
       add constraint FKlhhnf9umodjruo6fiq0eg6ev3 
       foreign key (calibre_id) 
       references Calibre

    alter table FireArms 
       add constraint FKgahdso3ge7q2nhsvhumlbhohq 
       foreign key (producer_id) 
       references Producer

    create table Ammo (
       id  serial not null,
        price float8 not null,
        calibre_id int4,
        primary key (id)
    )

    create table Calibre (
       id  serial not null,
        size float8 not null,
        primary key (id)
    )

    create table FireArms (
       id  serial not null,
        name varchar(255),
        price float8 not null,
        calibre_id int4,
        producer_id int4,
        primary key (id)
    )

    create table Producer (
       id  serial not null,
        producerName varchar(255),
        primary key (id)
    )

    alter table Ammo 
       add constraint FK4uo9hs5e2h8tfvl23k5jy2qdy 
       foreign key (calibre_id) 
       references Calibre

    alter table FireArms 
       add constraint FKlhhnf9umodjruo6fiq0eg6ev3 
       foreign key (calibre_id) 
       references Calibre

    alter table FireArms 
       add constraint FKgahdso3ge7q2nhsvhumlbhohq 
       foreign key (producer_id) 
       references Producer

    create table Ammo (
       id  serial not null,
        price float8 not null,
        calibre_id int4,
        primary key (id)
    )

    create table Calibre (
       id  serial not null,
        size float8 not null,
        primary key (id)
    )

    create table FireArms (
       id  serial not null,
        name varchar(255),
        price float8 not null,
        calibre_id int4,
        producer_id int4,
        primary key (id)
    )

    create table Producer (
       id  serial not null,
        producerName varchar(255),
        primary key (id)
    )

    alter table Ammo 
       add constraint FK4uo9hs5e2h8tfvl23k5jy2qdy 
       foreign key (calibre_id) 
       references Calibre

    alter table FireArms 
       add constraint FKlhhnf9umodjruo6fiq0eg6ev3 
       foreign key (calibre_id) 
       references Calibre

    alter table FireArms 
       add constraint FKgahdso3ge7q2nhsvhumlbhohq 
       foreign key (producer_id) 
       references Producer
