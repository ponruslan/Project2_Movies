create table movie (
    id bigint not null auto_increment,
    name varchar(255),
    category varchar(255),
    description varchar(255),
    director varchar(255),
    primary key (id)
);

create table review (
    id integer not null auto_increment,
    liked bit not null,
    review_message longtext,
    movie_id bigint,
    user_id bigint,
    primary key (id)
);

create table user (
    id bigint not null auto_increment,
    username varchar(255),
    password varchar(255),
    primary key (id)
);

create table user_role (
    user_id bigint not null,
    roles varchar(255)
);

alter table review add constraint review_movie_fk foreign key (movie_id) references movie (id);
alter table review add constraint review_user_fk foreign key (user_id) references user (id);
alter table user_role add constraint user_role_fk foreign key (user_id) references user (id);