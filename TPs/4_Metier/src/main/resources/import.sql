insert into user (login, nom, prenom, pwd, telephone) values  ('clovis', 'THIBAU','David','secret', '0649706297');
insert into user (login, nom, prenom, pwd, telephone) values  ('louis', 'THIBAU','Louise','secret', '0649706298');
insert into user (login, nom, prenom, pwd, telephone) values  ('charlemagne', 'THIBAU','Léopold','secret', '0649706299');
insert into user (login, nom, prenom, pwd, telephone) values  ('charles', 'THIBAU','Myrna','secret', '0649706200');

insert into media (date_parution, titre) values ('2000-01-01', 'Les années Spoutnik');
insert into media (date_parution, titre) values ('2012-01-10', 'Le grand soir');
insert into media (date_parution, titre) values ('2004-01-10', 'Tékitoi');

insert into book (isbn, ecrivain,id_media) values ('20000101','Baru',1);
insert into dvd (duree, realisateur, id_media) values (135, 'Benoît Delépine et Gustave Kervern', 2);
insert into cd (artiste, duree, nb_titres, id_media) values ('Rachid Taha', 75, 12, 3);

insert into exemplaire (date_entree, media_id) values ('2020-01-10',1);
insert into exemplaire (date_entree, media_id) values ('2020-01-10',1);
insert into exemplaire (date_entree, media_id) values ('2020-01-10',1);
insert into exemplaire (date_entree, media_id) values ('2022-01-01',1);
insert into exemplaire (date_entree, media_id) values ('2020-01-10',2);
insert into exemplaire (date_entree, media_id) values ('2020-01-10',2);
insert into exemplaire (date_entree, media_id) values ('2022-01-01',2);
insert into exemplaire (date_entree, media_id) values ('2020-01-10',3);

-- Rachid Taha n'est plus disponible
insert into emprunt (date_emprunt, date_limite, user_id) values ('2022-03-15', '2022-03-22',1);
insert into emprunt_exemplaires (id_emprunt, id_exemplaire) values (1,1);
insert into emprunt_exemplaires (id_emprunt, id_exemplaire) values (1,8);

