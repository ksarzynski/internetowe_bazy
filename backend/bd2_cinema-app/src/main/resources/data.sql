DELETE FROM cinema_db.seances;
DELETE FROM cinema_db.seats;
DELETE FROM cinema_db.cinema_halls;
DELETE FROM cinema_db.cinema_branches;
DELETE FROM cinema_db.movie_actor;
DELETE FROM cinema_db.reviews;
DELETE FROM cinema_db.movies;
DELETE FROM cinema_db.directors;
DELETE FROM cinema_db.actors;
DELETE FROM cinema_db.users WHERE user_id=99;


INSERT INTO cinema_db.cinema_branches VALUES (1, 'add1', 'wro', 'branch1'), (2, 'add2', 'wro', 'branch2'),
                                             (3, 'add3', 'krk', 'branch3');


INSERT INTO cinema_db.cinema_halls VALUES (1, 1, 'hall_1_1', 120, 1), (2, 0, 'hall_1_2', 120, 1),
                                          (3, 0, 'hall_2_1', 120, 2), (4, 1, 'hall_3_1', 120, 3);


INSERT INTO cinema_db.seats VALUES (1, 1, 1, 1, 12.10, 1), (2, 1, 1, 1, 15.21, 1), (3, 1, 1, 1, 21.37, 1),
    (4, 1, 1, 1, 13.40, 1), (5, 1, 1, 1, 12.34, 1), (6, 1, 1, 1, 15.00, 1), (7, 1, 1, 1, 19.18, 1),
    (8, 1, 1, 1, 14.13, 2), (9, 1, 1, 1, 15.10, 2), (10, 1, 1, 1, 11.10, 2), (11, 1, 1, 1, 7.10, 3),
    (12, 1, 1, 1, 21.21, 3), (13, 1, 1, 1, 20.20, 4), (14, 1, 1, 1, 9.9, 4);

INSERT INTO cinema_db.directors VALUES (1, 'great director', 'Alfred', 'Hitchcock'),
    (2, 'awesome director', 'Quentin', 'Tarantino'), (3, 'cool director', 'Stanley', 'Kubrick');

INSERT INTO cinema_db.actors VALUES (1, 'Guy from pirates of carribean', 'Johnny', 'Depp'),
    (2, 'aaaaa', 'Leonardo', 'DiCaprio'), (3, 'Hari Pota', 'Daniel', 'Radcliff'), (4, 'Space oddysey', 'Keir', 'Dullea');

INSERT INTO cinema_db.movies VALUES (1, 20.15, 'sci-fi', 'the most well known movie from kubrick',
                                    200, '2001: Odyseja kosmiczna', 13, 8.8, 3);

INSERT INTO cinema_db.movie_actor VALUES (1, 4);

INSERT INTO cinema_db.users VALUES (99, 8, 'xd@ex.com', 1, 1, 'hashedpass', 'reviewer_bot');

INSERT INTO cinema_db.reviews VALUES (1, 'I really enjoyed this movie', 9, 99, 1);

INSERT INTO cinema_db.seances VALUES(1, '2021-12-20 14:30:00', 100, 40.00, '2021-12-20 12:30:00', 1, 1),
                                     (2, '2021-12-20 19:30:00', 100, 40.00, '2021-12-20 17:30:00', 1, 1),
                                     (3, '2021-12-20 19:30:00', 100, 40.00, '2021-12-20 17:30:00', 1, 3);


