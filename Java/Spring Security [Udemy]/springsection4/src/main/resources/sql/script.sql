create table users(
                      username varchar_ignorecase(50) not null primary key,
                      password varchar_ignorecase(500) not null,
                      enabled boolean not null
);

create table authorities (
                             username varchar_ignorecase(50) not null,
                             authority varchar_ignorecase(50) not null,
                             constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

INSERT IGNORE INTO `users` VALUES (NULL, 'happy','12345','1');
INSERT IGNORE INTO `authorities`values( null, 'happy', 'write');



CREATE TABLE `customer` (
                            `id` int not null auto_increment,
                            `email` varchar(45) not null,
                            `pwd` varchar(200) not null,
                            `role` varchar(45) not null,
                            primary key(`id`)
);


insert into `customer` ( `email`, `pwd`, `role`)
values('johndo@naver.com','54321','admin');
