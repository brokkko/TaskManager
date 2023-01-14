alter table if exists boards drop constraint if exists boards_users_fk;
alter table if exists tasks drop constraint if exists tasks_boards_fk;

drop table if exists boards cascade;
drop table if exists tasks cascade;
drop table if exists users cascade;

create table boards (
    id uuid not null,
    name varchar(255),
    user_id uuid not null,
    primary key (id)
);

create table tasks (
    id uuid not null,
    description varchar(255),
    end_date timestamp,
    name varchar(255),
    start_date timestamp,
    status varchar(255),
    board_id uuid not null,
    primary key (id)
);

create table users (
    id uuid not null,
    email varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
);

alter table if exists boards
    add constraint boards_users_fk
    foreign key (user_id) references users on delete cascade;

alter table if exists tasks
    add constraint tasks_boards_fk
    foreign key (board_id) references boards on delete cascade;