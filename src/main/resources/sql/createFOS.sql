
create table user(
	user_id int(10) not null auto_increment,
    username varchar(30) not null,
    salt varbinary(100) not null,
    passwd varbinary(200) not null,
    email varchar(100) not null,
    dob date not null,
    isActive varchar(1) not null,
    createdby varchar(30) not null, 
    createdOn datetime not null, 
    lastModifiedDate datetime null,
    lastModifiedBy varchar(30) null,
	PRIMARY KEY(user_id),
    CONSTRAINT usernameConstraint UNIQUE (username),
    CONSTRAINT emailConstraint UNIQUE (email)
    
) ;



create table profil(
	profile_id int(10) not null auto_increment,
    user_id int(10) not null,
    firstname varchar(30) not null,
    lastname varchar(30) not null,
    sex varchar(1) not null,
    city varchar(45) not null,
    state varchar(2) not null,
    createdby varchar(30) not null, 
    createdOn datetime not null, 
    lastModifiedDate datetime null,
    lastModifiedBy varchar(30) null,
    PRIMARY KEY(profile_id), 
    
    CONSTRAINT profil_user 
	FOREIGN KEY (user_id) 
	REFERENCES  user(user_id)
    
) ;


create table media(
	media_id int(10) not null auto_increment,
    user_id int(10) not null,
    media_name varchar(30) not null,
    isActive varchar(1) not null,
    createdby varchar(30) not null, 
    createdOn datetime not null, 
    lastModifiedDate datetime null,
    lastModifiedBy varchar(30) null,
    PRIMARY KEY(media_id),
    
    CONSTRAINT media_user 
	FOREIGN KEY (user_id) 
	REFERENCES  user(user_id)
	    
) ;
 
create table friends(
	friend_id int(10) not null ,
    user_id int(10) not null,
    isBlocked varchar(1) not null,
    isSuspended varchar(1) not null,
    createdby varchar(30) not null, 
    createdOn datetime not null,
    
    CONSTRAINT friend_user 
	FOREIGN KEY (user_id) 
	REFERENCES  user(user_id)
    
) ;



create table comments(
	comment_id int(10) not null auto_increment,
    user_id int(10) not null,
    comments varchar(300) not null,
    isActive varchar(1) not null,
    createdby varchar(30) not null, 
    createdOn datetime not null, 
    lastModifiedDate datetime null,
    PRIMARY KEY(comment_id),
    
    CONSTRAINT comment_user 
	FOREIGN KEY (user_id) 
	REFERENCES  user(user_id)
    
) ;


create table lols(
	lol_id int(10) not null auto_increment,
    user_id int(10) not null,
    comment_id int(10) not null,
    media_id int(10) not null,
    isActive varchar(1) not null,
    createdby varchar(30) not null, 
    createdOn datetime not null, 
    PRIMARY KEY(lol_id),
    
    CONSTRAINT lol_user 
	FOREIGN KEY (user_id) 
	REFERENCES  user(user_id)
    
) ;




create table subscribers(
	sub_id int(10) not null auto_increment,
    sub_name varchar(50) not null,
    isActive varchar(1) not null,
    createdby varchar(30) not null, 
    createdOn datetime not null, 
    PRIMARY KEY(sub_id)
    
    
    
) ;

create table publishers(
	pub_id int(10) not null auto_increment,
    pub_name varchar(50) not null,
    isActive varchar(1) not null,
    createdby varchar(30) not null, 
    createdOn datetime not null, 
    PRIMARY KEY(pub_id) 
    
    
    
) ;


create table pub_sub(
	pub_id int(10) not null, 
    sub_id int(10) not null, 
    primary key(pub_id,sub_id),
    
    CONSTRAINT sub_pub_fk 
	FOREIGN KEY (sub_id) 
	REFERENCES  subscribers(sub_id), 
    
    CONSTRAINT pub_sub_fk 
	FOREIGN KEY (pub_id) 
	REFERENCES  publishers(pub_id)
    
);





