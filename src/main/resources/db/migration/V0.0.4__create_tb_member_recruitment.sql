create table if not exists wanted7th.member_recruitment(
	id					bigint              auto_increment,
	member_id  			bigint,
	recruitment_id 		bigint,
	constraint 	pk_member_recruitment		PRIMARY KEY(id)
);