
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

    create table Ammunition: (
       id  serial not null,
        price float8 not null,
        calibre_id int4,
        primary key (id)
    )

    create table Calibre: (
       id  serial not null,
        size float8 not null,
        primary key (id)
    )

    create table Fire arms: (
       id  serial not null,
        name varchar(255),
        price float8 not null,
        calibre_id int4,
        producer_id int4,
        primary key (id)
    )

    create table Producer of fire arms: (
       id  serial not null,
        producerName varchar(255),
        primary key (id)
    )

    alter table Ammunition: 
       add constraint FKr8l7abdjrxgg5y8k3sgkvm8vo 
       foreign key (calibre_id) 
       references Calibre:

    alter table Fire arms: 
       add constraint FKppskfvx8233uvb3ut2aogsd93 
       foreign key (calibre_id) 
       references Calibre:

    alter table Fire arms: 
       add constraint FKphltbqrbf5cqp77rdurw8lc1m 
       foreign key (producer_id) 
       references Producer of fire arms:

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
