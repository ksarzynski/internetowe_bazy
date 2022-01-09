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


INSERT INTO cinema_db.cinema_branches VALUES (1, 'Żołnierska 55', 'Wroclaw', 'Żołnierz'),
											 (2, 'Miedziana 82', 'Wroclaw', 'Miedź'),
											 (3, 'Świętokrzyska 13', 'Wroclaw', 'Świat'),
											 (4, 'Spacerowa 21', 'Wroclaw', 'Spacer'),
											 (5, 'Niedziałkowskiego 1', 'Nowa Ruda', 'Niedziałkowski'),
											 (6, 'Tuwima 19', 'Szczecin', 'Tuwim'),
											 (7, 'Sportowa 22', 'Szczecin', 'Sport'),
											 (8, 'Sowia 34', 'Kłodzko', 'Sowa'),
											 (9, 'Spacerowa 99', 'Kłodzko', 'Spacer'),
											 (10, 'Sądowa 12', 'Busko-Zdrój', 'Sąd'),
											 (11, 'Małopolska 32', 'Lidzbark Warmiński', 'Małopolskie'),
											 (12, 'Legnicka 75', 'Konstancin-Jeziorna', 'Legion'),
											 (13, 'Modrzejewskiej 45', 'Jastarnia', 'Modrzew'),
											 (14, 'Puławska 3', 'Wałbrzych', 'Puławskiego'),
											 (15, 'Lawendowa 6', 'Wałbrzych', 'Lawenda'),
											 (16, 'Polna 96', 'Olkusz', 'Pole'),
											 (17, 'Piwna 21', 'Lubliniec', 'Browar'),
											 (18, 'Dobra 37', 'Chojnice', 'Dobre'),
											 (19, 'Krótka 4', 'Gorzów Wielkopolski', 'Short'),
                                             (20, 'Urocza 20', 'Gorzów Wielkopolski', 'Bella')^;


INSERT INTO cinema_db.cinema_halls VALUES (1, 1, 'sala_1_1', 120, 1), (2, 0, 'sala_1_2', 90, 1), (3, 0, 'sala_1_3', 60, 1),
										  (4, 1, 'sala_2_1', 120, 2), (5, 0, 'sala_2_2', 120, 2), (6, 0, 'sala_2_3', 90, 2),
										  (7, 1, 'sala_3_1', 120, 3), (8, 0, 'sala_3_2', 120, 3),
										  (9, 1, 'sala_4_1', 120, 4), (10, 0, 'sala_4_2', 80, 4), (11, 0, 'sala_4_3', 120, 4), (12, 0, 'sala_4_4', 60, 4),
										  (13, 1, 'sala_5_1', 120, 5), (14, 0, 'sala_5_2', 60, 5), (15, 0, 'sala_5_3', 30, 5),
										  (16, 1, 'sala_6_1', 120, 6), (17, 0, 'sala_6_2', 120, 6),
										  (18, 1, 'sala_7_1', 120, 7), (19, 0, 'sala_7_2', 120, 7), (20, 0, 'sala_7_3', 90, 7), (21, 0, 'sala_7_4', 60, 7),
										  (22, 1, 'sala_8_1', 120, 8), (23, 0, 'sala_8_2', 120, 8),
										  (24, 1, 'sala_9_1', 120, 9), (25, 0, 'sala_9_2', 120, 9),
										  (26, 1, 'sala_10_1', 120, 10), (27, 0, 'sala_10_2', 120, 10), (28, 0, 'sala_10_3', 60, 10), (29, 0, 'sala_10_4', 60, 10),
										  (30, 1, 'sala_11_1', 120, 11), (31, 0, 'sala_11_2', 120, 11), (32, 0, 'sala_11_3', 90, 11),
										  (33, 1, 'sala_12_1', 120, 12), (34, 0, 'sala_12_2', 120, 12),
										  (35, 1, 'sala_13_1', 120, 13), (36, 0, 'sala_13_2', 120, 13), (37, 0, 'sala_13_3', 90, 13),
										  (38, 1, 'sala_14_1', 120, 14), (39, 0, 'sala_14_2', 120, 14),
										  (40, 1, 'sala_15_1', 120, 15), (41, 0, 'sala_15_2', 120, 15),
										  (42, 1, 'sala_16_1', 120, 16), (43, 0, 'sala_16_2', 120, 16), (44, 0, 'sala_16_3', 90, 16), (45, 0, 'sala_16_4', 60, 16),
										  (46, 1, 'sala_17_1', 120, 17), (47, 0, 'sala_17_2', 120, 17),
										  (48, 1, 'sala_18_1', 120, 18), (49, 0, 'sala_18_2', 120, 18),
										  (50, 1, 'sala_19_1', 120, 19), (51, 0, 'sala_19_2', 120, 19), (52, 0, 'sala_19_3', 90, 19),
										  (53, 1, 'sala_20_1', 120, 20), (54, 0, 'sala_20_2', 120, 20)^;



-- INSERT INTO cinema_db.seats VALUES (1, 1, 1, 1, 12.10, 1), (2, 1, 1, 1, 15.21, 1), (3, 1, 1, 1, 21.37, 1),
--     (4, 1, 1, 1, 13.40, 1), (5, 1, 1, 1, 12.34, 1), (6, 1, 1, 1, 15.00, 1), (7, 1, 1, 1, 19.18, 1),
--     (8, 1, 1, 1, 14.13, 2), (9, 1, 1, 1, 15.10, 2), (10, 1, 1, 1, 11.10, 2), (11, 1, 1, 1, 7.10, 3),
--     (12, 1, 1, 2, 21.21, 3), (13, 1, 1, 3, 20.20, 4), (14, 1, 1, 1, 9.9, 4);

INSERT INTO cinema_db.directors VALUES (1, 'great director', 'Alfred', 'http://t1.gstatic.com/licensed-image?q=tbn:ANd9GcSMHUuQ-vBCak8z5E9_mWMAzohLhvPRXH9HZth2yYZI6UMapKx3-Jm5DBGbTZE8', 'Hitchcock'),
                                       (2, '8,89', 'Quentin', 'https://www.rmfclassic.pl/scratch/classic2013/static-images/68/f7e51dbd95e7e8ac.jpg', 'Tarantino'),
                                       (3, '8,83', 'Sergio', 'https://pl.wikipedia.org/wiki/Sergio_Leone#/media/Plik:SERGIO_LEONE.jpg', 'Leone'),
                                       (4, '8,77', 'Francis', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Francis_Ford_Coppola_2011_CC.jpg/294px-Francis_Ford_Coppola_2011_CC.jpg', 'Coppola'),
                                       (5, '8,70', 'Wes', 'https://fwcdn.pl/ppo/65/19/46519/450254.2.jpg', 'Anderson'),
                                       (6, '8,68', 'Christopher', 'https://fwcdn.pl/ppo/08/96/40896/449999.2.jpg', 'Nolan'),
                                       (7, '8,65', 'David', 'https://fwcdn.pl/ppo/04/59/10459/450510.2.jpg', 'Fincher'),
                                       (8, '8,64', 'Milos', 'https://fwcdn.pl/ppo/03/39/339/450701.2.jpg', 'Forman'),
                                       (9, '8,61', 'Martin', 'https://fwcdn.pl/ppo/00/96/96/450689.2.jpg', 'Scorsese'),
                                       (10, '8,89', 'Stanley', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSkRk54WD6EEJiHBC8ZFcZXO6a1JdaMOo2iwSiPboORJzqsNFl0', 'Kubrick')^;

INSERT INTO cinema_db.actors VALUES (1, 'Jack Sparrow', 'Johnny', 'https://upload.wikimedia.org/wikipedia/commons/4/43/JohnnyDeppOct2011.jpg', 'Depp'),
                                    (2, 'Calvin Candie', 'Leonardo', 'http://t2.gstatic.com/licensed-image?q=tbn:ANd9GcQTZE6ZxVumFL3ga6AiETDuiRobav4wFmLjcBf9D1D85Q_B2zk5wlNlw-UrcI4f', 'DiCaprio'),
                                    (3, 'Harry Potter', 'Daniel', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYLQjqRAL2Gj8NGIt_bhmjaV3OfM73zIwC6JgTxGL6xBQqudDf', 'Radcliff'),
                                    (4, 'Joker', 'Joaquin', 'https://fwcdn.pl/ppo/50/28/5028/449870.2.jpg', 'Phoenix'),
                                    (5, 'Jack Torrance', 'Jack', 'https://fwcdn.pl/ppo/00/75/75/449648.2.jpg', 'Nicholson'),
                                    (6, 'Jordan Belfort', 'Leonardo', 'https://fwcdn.pl/ppo/00/30/30/449647.2.jpg', 'DiCaprio'),
                                    (7, 'Michael Corleone', 'Al', 'https://fwcdn.pl/ppo/00/78/78/449651.2.jpg', 'Pacino'),
                                    (8, 'Severus Snape', 'Alan', 'https://fwcdn.pl/ppo/00/89/89/449650.2.jpg', 'Rickman'),
                                    (9, 'Tony Stark', 'Robert', 'https://fwcdn.pl/ppo/00/31/31/449654.2.jpg', 'Downey Jr.'),
                                    (10, 'Dave Bowman', 'Keir', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTLSzBq766XLVGTUioBl7BRwJjwZsJT_R1VvPnSQWH0EjYSXFgj', 'Dullea')^;

INSERT INTO cinema_db.movies VALUES (1, 20.15, 'sci-fi', 'The most well known movie from Kubrick',
                                    200, 'https://ocdn.eu/pulscms-transforms/1/JyYk9kqTURBXy8xMjMyOWMyMTg2MGRhNWY4OTcwMjEzNjdiNjQxZWUzMi5qcGVnk5UDAADNA8rNAiGTBc0DFM0BvJMJpmZhOWU4MAaBoTAB/2001-odyseja-kosmiczna-kadr-z-filmu.jpg', '2001: Odyseja kosmiczna', 13, 8.8, 10),
                                    (2, 23.99, 'western', 'Story about freedom',
                                    180, 'https://fwcdn.pl/fpo/05/41/620541/7504936.3.jpg', 'Django: Unchained', 18, 8.3, 2),
                                    (3, 19.99, 'western', 'Firefights and journey in the desert',
                                    130, 'https://static.posters.cz/image/750/plakaty/the-good-the-bad-and-the-ugly-i8932.jpg', 'Good, bad and the ugly', 16, 8.2, 3),
                                    (4, 19.99, 'crime', 'Movie about Sicilian mafia',
                                    120, 'https://marudzenie.pl/wp-content/uploads/2012/12/godfather.jpg', 'The Godfather', 18, 8.6, 4)^;


INSERT INTO cinema_db.movie_actor VALUES (1, 4),
										 (2, 6)^;

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
