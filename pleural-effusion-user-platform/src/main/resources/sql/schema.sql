drop table if exists sys_user;
drop table if exists sys_resource;
drop table if exists sys_role;

create table sys_user (
  id bigint auto_increment,
  username varchar(100),
  password varchar(100),
  telphone varchar(100),
  salt varchar(100),
  role_id bigint,
  locked bool default false,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  constraint pk_sys_user primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_sys_user_username on sys_user(username);

create table sys_resource (
  id bigint auto_increment,
  name varchar(100),
  type varchar(50),
  url varchar(200),
  parent_id bigint,
  available bool default false,
	create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  constraint pk_sys_resource primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_sys_resource_parent_id on sys_resource(parent_id);

create table sys_role (
  id bigint auto_increment,
  role varchar(100),
  description varchar(100),
  available bool default false,
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
	update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  constraint pk_sys_role primary key(id)
) charset=utf8 ENGINE=InnoDB;

create TABLE sys_role_resource(
  role_id bigint,
  resource_id bigint,
)charset=utf8 ENGINE=InnoDB;
create index idx_sys_role_resource_role_id on sys_role_resource(role_id);