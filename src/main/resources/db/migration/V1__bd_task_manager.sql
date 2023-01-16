drop table if exists projects cascade;
drop table if exists tasks cascade;
drop table if exists team_projects cascade;
drop table if exists users cascade;

create table projects (
    id uuid not null,
    date_of_creation timestamp,
    description varchar(255),
    name varchar(255),
    user_id uuid not null,
    primary key (id)
);
create table tasks (
    id uuid not null,
    date_of_creation timestamp,
    deadline timestamp,
    description varchar(255),
    name varchar(255),
    status varchar(255),
    time_estimate time,
    time_spent time,
    project_id uuid not null,
    user_id uuid not null,
    primary key (id)
);
create table team_projects (
    project_id uuid not null,
    primary key (project_id)
);
create table users (
    id uuid not null,
    email varchar(255),
    firstname varchar(255),
    lastname varchar(255),
    password varchar(255),
    role varchar(255),
    user_app_name varchar(255),
    primary key (id)
);

alter table if exists projects
    add constraint projects_users_fk
    foreign key (user_id) references users on delete cascade;

alter table if exists tasks
    add constraint tasks_projects_fk
    foreign key (project_id) references projects on delete cascade;

alter table if exists tasks
    add constraint tasks_users_fk
    foreign key (user_id) references users on delete cascade;

-- alter table if exists team_projects_users
--     add constraint FK3c2uujcb7vhsdurmwc0av186w
--     foreign key (users_id) references users;
--
-- alter table if exists team_projects_users
--     add constraint FK4829a8bb3f2ad7acn51hwd3oa
--     foreign key (team_projects_project_id) references team_projects;