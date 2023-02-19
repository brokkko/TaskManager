drop table if exists users cascade;
drop table if exists projects cascade;
drop table if exists tasks cascade;
drop table if exists team_projects cascade;
drop table if exists user_team_projects cascade;

create table projects (
    id uuid not null,
    description varchar(255),
    created_at timestamp,
    updated_at timestamp,
    name varchar(60),
    user_id uuid not null,
    primary key (id)
);

create table tasks (
    id uuid not null,
    created_at timestamp,
    updated_at timestamp,
    deadline timestamp,
    description varchar(255),
    name varchar(100),
    status varchar(20),
    time_estimate time,
    time_spent time,
    project_id uuid not null,
    user_id uuid not null,
    primary key (id)
);

create table team_projects (
   team_project_id uuid not null,
   description varchar(255),
   name varchar(30),
   project_id uuid not null,
   primary key (team_project_id)
);

create table user_team_projects (
    position varchar(255),
    user_id uuid not null,
    team_project_team_project_id uuid,
    primary key (user_id)
);

create table users (
    id uuid not null,
    email varchar(50),
    firstname varchar(50),
    lastname varchar(50),
    password varchar(100),
    role varchar(20),
    user_app_name varchar(53),
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

alter table if exists team_projects
    add constraint team_projects_projects_fk
    foreign key (project_id) references projects on delete cascade;

alter table if exists user_team_projects
    add constraint user_team_projects_team_projects_fk
    foreign key (team_project_team_project_id) references team_projects;

alter table if exists user_team_projects
    add constraint user_team_projects_users_fk
    foreign key (user_id) references users;