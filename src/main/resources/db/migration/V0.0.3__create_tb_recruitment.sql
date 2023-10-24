create table if not exists wanted7th.recruitment(
	id  			BIGINT              auto_increment,
	company_id		BIGINT,
	company_name 	VARCHAR(255),
	country			VARCHAR(255),
	region      	VARCHAR(255),
	position  		VARCHAR(255),
	compensation	BIGINT,
	technology		VARCHAR(255),
	contents		VARCHAR(255),
	created_at		TIMESTAMP DEFAULT CURRENT_TIMESTAMP		not NULL,
	updated_at		TIMESTAMP,
	constraint 		pk_recruitment 			PRIMARY KEY(id)
);