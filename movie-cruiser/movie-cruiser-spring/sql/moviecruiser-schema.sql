drop database if exists moviecruiser;
create database moviecruiser;
use moviecruiser;

create table Movies (
movie_id int auto_increment primary key,
movie_title varchar(200) not null,
movie_box_office decimal(2,1) not null,
movie_active boolean not null,
movie_date_of_launch date not null,
movie_genre varchar(30) not null,
movie_teaser varchar(200) not null
);

create table Users (
user_id int auto_increment primary key,
user_first_name varchar(30) not null,
user_last_name varchar(30) default null
);

create table Favorites (
user_id int,
movie_id int,
constraint primary key(user_id,movie_id),
foreign key (user_id) references Users(user_id),
foreign key (movie_id) references Movies(movie_id)
);
