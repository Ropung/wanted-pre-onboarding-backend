  create table if not exists wanted7th.company (
    id              bigint          auto_increment,
    name            varchar(255),
    constraint 	pk_company 			PRIMARY KEY(id),
	constraint 	uq_company_name 	UNIQUE(name)
  );
