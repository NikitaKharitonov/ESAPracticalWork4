INSERT INTO public._group (id, year) VALUES (1, 3);
INSERT INTO public._group (id, year) VALUES (2, 2);
INSERT INTO public._group (id, year) VALUES (3, 1);

INSERT INTO public.course (id, hours, name, group_id) VALUES (1, 18, 'Geography', 2);
INSERT INTO public.course (id, hours, name, group_id) VALUES (2, 36, 'Sport', 3);
INSERT INTO public.course (id, hours, name, group_id) VALUES (3, 18, 'History', 3);
INSERT INTO public.course (id, hours, name, group_id) VALUES (4, 36, 'Chemistry', 2);
INSERT INTO public.course (id, hours, name, group_id) VALUES (5, 18, 'English', 3);
INSERT INTO public.course (id, hours, name, group_id) VALUES (6, 36, 'Technology', 2);
INSERT INTO public.course (id, hours, name, group_id) VALUES (7, 36, 'Physics', 1);
INSERT INTO public.course (id, hours, name, group_id) VALUES (8, 36, 'Biology', 2);
INSERT INTO public.course (id, hours, name, group_id) VALUES (9, 18, 'Literature', 2);
INSERT INTO public.course (id, hours, name, group_id) VALUES (10, 36, 'Math', 1);

INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (1, '1994-04-11', 'Roman', 'Romanov', 2);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (2, '1991-01-03', 'Petr', 'Petrov', 1);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (3, '1996-06-17', 'Olga', 'Olgova', 2);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (4, '1990-10-01', 'Ivan', 'Ivanov', 1);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (5, '1997-07-19', 'Nina', 'Ninova', 3);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (6, '1999-09-30', 'Petr', 'Ivanov', 3);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (7, '1992-02-05', 'Zakhar', 'Zakharov', 1);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (8, '1993-03-07', 'Anna', 'Annova', 2);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (9, '1998-08-23', 'Ivan', 'Petrov', 3);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (10, '1995-05-13', 'Vika', 'Vikova', 2);
