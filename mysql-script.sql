create database dev;
use dev;
create table client (cd_client int not null auto_increment, nm_client varchar(30), nm_email varchar(35), CONSTRAINT client_pk PRIMARY KEY(cd_client));
insert into client (nm_client, nm_email) values ('Richard Marques', 'rseberin@br.ibm.com');
insert into client (nm_client, nm_email) values ('Mario Ernesto', 'mario@ibm.com');
