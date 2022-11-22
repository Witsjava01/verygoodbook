USE movie;

CREATE TEMPORARY TABLE `temp_date_schedule`(
        `t_create_time` DATE,
        PRIMARY KEY(`t_create_time`)
    );
INSERT `temp_date_schedule` VALUES
	('2022-08-11'),('2022-08-12'),('2022-08-13'),('2022-08-14'),
    ('2022-08-15'),('2022-08-16'),('2022-08-17'),('2022-08-18'),
    ('2022-08-19'),('2022-08-20'),('2022-08-21'),('2022-08-22'),
    ('2022-08-23'),('2022-08-24'),('2022-08-25'),('2022-08-26'),
    ('2022-08-27'),('2022-08-28'),('2022-08-29'),('2022-08-30'),
    ('2022-08-31'),('2022-09-01'),('2022-09-02'),('2022-09-03'),
    ('2022-09-04'),('2022-09-05'),('2022-09-06'),('2022-09-07'),
    ('2022-09-08'),('2022-09-09'),('2022-09-10'),('2022-09-11'),
    ('2022-09-12'),('2022-09-13'),('2022-09-14'),('2022-09-15');
    
INSERT INTO movie_showtime_status(movie_id, show_date, show_time, seats)
  SELECT movie_id, `temp_date_schedule`.`t_create_time` as show_date, show_time,seats 
	FROM `temp_date_schedule` JOIN movie.movie_schedule ON movie_id=2;