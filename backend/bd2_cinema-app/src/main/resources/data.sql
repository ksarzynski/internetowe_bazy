-- noinspection SqlDialectInspectionForFile

DELETE FROM cinema_db.reservation_seat^;
DELETE FROM cinema_db.reservations^;

DELETE FROM cinema_db.seances^;
DELETE FROM cinema_db.seats^;
DELETE FROM cinema_db.cinema_halls^;
DELETE FROM cinema_db.cinema_branches^;
DELETE FROM cinema_db.movie_actor^;
DELETE FROM cinema_db.reviews^;
DELETE FROM cinema_db.movies^;
DELETE FROM cinema_db.directors^;
DELETE FROM cinema_db.actors^;
DELETE FROM cinema_db.users WHERE user_id>=99^;


INSERT INTO cinema_db.cinema_branches VALUES (1, 'add1', 'wro', 'branch1'), (2, 'add2', 'wro', 'branch2'),
                                             (3, 'add3', 'krk', 'branch3')^;


INSERT INTO cinema_db.cinema_halls VALUES (1, 1, 'hall_1_1', 120, 1), (2, 0, 'hall_1_2', 120, 1),
                                          (3, 0, 'hall_2_1', 120, 2), (4, 1, 'hall_3_1', 120, 3)^;


-- INSERT INTO cinema_db.seats VALUES (1, 1, 1, 1, 12.10, 1), (2, 1, 1, 1, 15.21, 1), (3, 1, 1, 1, 21.37, 1),
--     (4, 1, 1, 1, 13.40, 1), (5, 1, 1, 1, 12.34, 1), (6, 1, 1, 1, 15.00, 1), (7, 1, 1, 1, 19.18, 1),
--     (8, 1, 1, 1, 14.13, 2), (9, 1, 1, 1, 15.10, 2), (10, 1, 1, 1, 11.10, 2), (11, 1, 1, 1, 7.10, 3),
--     (12, 1, 1, 2, 21.21, 3), (13, 1, 1, 3, 20.20, 4), (14, 1, 1, 1, 9.9, 4);

INSERT INTO cinema_db.directors VALUES (1, 'great director', 'Alfred', 'http://t1.gstatic.com/licensed-image?q=tbn:ANd9GcSMHUuQ-vBCak8z5E9_mWMAzohLhvPRXH9HZth2yYZI6UMapKx3-Jm5DBGbTZE8', 'Hitchcock'),
                                       (2, 'awesome director', 'Quentin', 'https://www.rmfclassic.pl/scratch/classic2013/static-images/68/f7e51dbd95e7e8ac.jpg', 'Tarantino'),
                                       (3, 'cool director', 'Stanley', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSkRk54WD6EEJiHBC8ZFcZXO6a1JdaMOo2iwSiPboORJzqsNFl0', 'Kubrick')^;

INSERT INTO cinema_db.actors VALUES (1, 'Guy from pirates of carribean', 'Johnny', 'https://upload.wikimedia.org/wikipedia/commons/4/43/JohnnyDeppOct2011.jpg', 'Depp'),
                                    (2, 'aaaaa', 'Leonardo', 'http://t2.gstatic.com/licensed-image?q=tbn:ANd9GcQTZE6ZxVumFL3ga6AiETDuiRobav4wFmLjcBf9D1D85Q_B2zk5wlNlw-UrcI4f', 'DiCaprio'),
                                    (3, 'Hari Pota', 'Daniel', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYLQjqRAL2Gj8NGIt_bhmjaV3OfM73zIwC6JgTxGL6xBQqudDf', 'Radcliff'),
                                    (4, 'Space oddysey', 'Keir', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTLSzBq766XLVGTUioBl7BRwJjwZsJT_R1VvPnSQWH0EjYSXFgj', 'Dullea')^;

INSERT INTO cinema_db.movies VALUES (1, 20.15, 'sci-fi', 'the most well known movie from kubrick',
                                    200, 'https://ocdn.eu/pulscms-transforms/1/JyYk9kqTURBXy8xMjMyOWMyMTg2MGRhNWY4OTcwMjEzNjdiNjQxZWUzMi5qcGVnk5UDAADNA8rNAiGTBc0DFM0BvJMJpmZhOWU4MAaBoTAB/2001-odyseja-kosmiczna-kadr-z-filmu.jpg', '2001: Odyseja kosmiczna', 13, 8.8, 3)^;

INSERT INTO cinema_db.movie_actor VALUES (1, 4)^;

INSERT INTO cinema_db.users VALUES (99, 8, 'xd@ex.com', 1, 1, 'hashedpass', 'client', 'reviewer_bot'),
                                   (100, 0, 'admin@ex.com', 0, 0, '$2a$10$AVKHWozHcJwISL3hHtBNCumYaOsxy9XzW8u3G.zkltbKN3A2yVPFu', 'admin', 'admin'),
                                   (101, NULL, 'client@ex.com', NULL, NULL, '$2a$10$IeWETWF4pSrz9faX2kCJfOOmt9CiW8T.s75fih.RphiHXCdIFhILS', 'client', 'client')^;

INSERT INTO cinema_db.reviews VALUES (1, 'I really enjoyed this movie', 9, 99, 1)^;

INSERT INTO cinema_db.seances VALUES (1, '2021-12-20 14:30:00', 'https://fwcdn.pl/fpo/14/58/1458/7592150.3.jpg', 100, 40.00, '2021-12-20 12:30:00', 1, 1),
                                     (2, '2021-12-20 19:30:00', 'https://fwcdn.pl/fpo/14/58/1458/7592150.3.jpg', 100, 40.00, '2021-12-20 17:30:00', 1, 1),
                                     (3, '2021-12-20 19:30:00', 'https://fwcdn.pl/fpo/14/58/1458/7592150.3.jpg', 100, 40.00, '2021-12-20 17:30:00', 3, 1)^;



DROP PROCEDURE IF EXISTS `cinema_db`.create_seats^;
CREATE PROCEDURE `cinema_db`.create_seats()
BEGIN

 DECLARE var, var2, var3, var4 INT;
 SET var = 0, var3 = 0, var4 = 1;
 WHILE var4 < 5 DO
	SET var = 0;
    SET var3 = 0;
	 WHILE var < 8 DO
		SET var2 = 0;
		WHILE var2 < 15 DO
			INSERT INTO seats VALUES ((var4*1000)+var3, MOD(RAND()*10, 2), var+1, var2+1, 5+MOD(RAND()*10, 3)-1, var4);
			SET var2 = var2 + 1;
			SET var3 = var3 + 1;
END WHILE;
	  SET var = var + 1;
END WHILE;
     SET var4 = var4 + 1;
END WHILE;

END ^;

call cinema_db.create_seats()^;

DROP PROCEDURE IF EXISTS `cinema_db`.create_reservations^;
CREATE PROCEDURE `cinema_db`.create_reservations()
BEGIN

 DECLARE var, var2, n INT;
 SET var = 1, n=5;
 WHILE var < 4 DO
	SET var2 = 0;
    INSERT INTO reservations VALUES (var*10, '2021-12-20 14:30:00', 12.34, var, 99);
    WHILE var2 < n DO
	    INSERT INTO reservation_seat VALUES (var*10, var*1000+MOD(RAND()*1000, 120));
		SET var2 = var2 + 1;
	END WHILE;
    SET var = var + 1;
END WHILE;

END ^;

call cinema_db.create_reservations()^;

-- INSERT IGNORE INTO cinema_db.reservations VALUES (1, '2021-12-20 14:30:00', 12.34, 2, 99), (2, '2021-12-20 14:30:00', 12.34, 3, 99)^;
-- INSERT IGNORE INTO cinema_db.reservation_seat VALUES (1, 1003), (1, 1004), (2, 12), (2, 11)^;
