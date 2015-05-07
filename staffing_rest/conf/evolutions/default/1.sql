# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table login (
  username                  varchar(255) not null,
  password                  varchar(255),
  auth_token                varchar(255),
  user_id                   integer,
  constraint pk_login primary key (username))
;

create table project (
  id                        integer auto_increment not null,
  start_date                datetime,
  end_date                  datetime,
  service_line_id           integer,
  domain                    varchar(255),
  constraint pk_project primary key (id))
;

create table project_members (
  id                        integer auto_increment not null,
  project_id                integer,
  member_id                 integer,
  start_date                datetime,
  end_date                  datetime,
  part_time                 tinyint(1) default 0,
  part_time_allocation      integer,
  constraint pk_project_members primary key (id))
;

create table role (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_role primary key (id))
;

create table skill (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_skill primary key (id))
;

create table user_detail (
  id                        integer auto_increment not null,
  role_id                   integer,
  name                      varchar(255),
  constraint pk_user_detail primary key (id))
;

create table user_skills (
  id                        integer auto_increment not null,
  user_id                   integer,
  skill_id                  integer,
  level                     integer,
  constraint pk_user_skills primary key (id))
;

alter table login add constraint fk_login_userDetail_1 foreign key (user_id) references user_detail (id) on delete restrict on update restrict;
create index ix_login_userDetail_1 on login (user_id);
alter table project_members add constraint fk_project_members_project_2 foreign key (project_id) references project (id) on delete restrict on update restrict;
create index ix_project_members_project_2 on project_members (project_id);
alter table project_members add constraint fk_project_members_member_3 foreign key (member_id) references user_detail (id) on delete restrict on update restrict;
create index ix_project_members_member_3 on project_members (member_id);
alter table user_detail add constraint fk_user_detail_role_4 foreign key (role_id) references role (id) on delete restrict on update restrict;
create index ix_user_detail_role_4 on user_detail (role_id);
alter table user_skills add constraint fk_user_skills_userDetail_5 foreign key (user_id) references user_detail (id) on delete restrict on update restrict;
create index ix_user_skills_userDetail_5 on user_skills (user_id);
alter table user_skills add constraint fk_user_skills_skill_6 foreign key (skill_id) references skill (id) on delete restrict on update restrict;
create index ix_user_skills_skill_6 on user_skills (skill_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table login;

drop table project;

drop table project_members;

drop table role;

drop table skill;

drop table user_detail;

drop table user_skills;

SET FOREIGN_KEY_CHECKS=1;

