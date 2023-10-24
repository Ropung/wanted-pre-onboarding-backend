  create table if not exists wanted7th.member (
    id          bigint              auto_increment,
    name        varchar(255),
    constraint 	pk_member 			PRIMARY KEY(id),
	constraint 	uq_member_username 	UNIQUE(name)
  );
