Create database Puerto;

Use Puerto;

create table Muelle (
id_muelle int(9) primary key not null auto_increment,
size varchar(25) not null,
ocupado tinyint(1)
) engine=InnoDB;

create table Barco (
id_barco int(9) primary key not null auto_increment,
nombre varchar(25) not null,
size varchar(25) not null,
tipo varchar(25) not null,
tonelaje double(10,3) not null
) engine=InnoDB;

create table Estancia(
id_estancia int(9) primary key not null auto_increment,
id_barco int(9) not null,
id_muelle int(9) not null,
fecha_entrada datetime,
fecha_salida datetime,
FOREIGN KEY (id_barco) REFERENCES Barco (id_barco),
FOREIGN KEY (id_muelle) REFERENCES Muelle (id_muelle)
) engine=InnoDB;

create table Mercancia (
id_mercancia int(9) primary key not null,
nombre varchar(25) not null,
peso double(10,3) not null
) engine=InnoDB;

create table Inventario (
id_inventario int(9) primary key not null auto_increment,
id_barco int(9) not null,
id_mercancia int(9) not null,
cantidad int(10) not null,
peso double(10,3) not null,
FOREIGN KEY (id_barco) REFERENCES Barco (id_barco),
FOREIGN KEY (id_mercancia) REFERENCES Mercancia (id_mercancia)
) engine=InnoDB;


insert into Muelle values (1,'grande',1);
insert into Muelle values (2,'grande',1);
insert into Muelle values (3,'mediano',0);
insert into Muelle values (4,'mediano',1);
insert into Muelle values (5,'mediano',0);
insert into Muelle values (6,'mediano',0);
insert into Muelle values (7,'pequeño',1);
insert into Muelle values (8,'pequeño',0);


insert into Barco values (1,'Barco1','grande','Triple E',200);
insert into Barco values (2,'Barco2','mediano','Panamax',80);
insert into Barco values (3,'Barco3','pequeño','1st Gen',30);
insert into Barco values (4,'Barco4','grande','Triple E',180);


insert into Estancia values (1,1,1,'2017-01-30 12:00:00','2017-02-08 12:00:00');
insert into Estancia values (2,2,4,'2017-02-12 13:52:12',null);
insert into Estancia values (3,3,7,'2017-02-13 11:14:22',null);
insert into Estancia values (4,4,1,'2017-02-14 09:00:00',null);
insert into Estancia values (5,1,2,'2017-02-15 09:00:00',null);


insert into Mercancia values (1,'Alimento',100.0);
insert into Mercancia values (2,'Madera',150.0);
insert into Mercancia values (3,'Hierro',250.0);
insert into Mercancia values (4,'Piedra',320.0);


insert into Inventario values (1,1,1,40,4000.0);
insert into Inventario values (2,2,2,20,3000.0);
insert into Inventario values (3,2,3,30,4500.0);
insert into Inventario values (4,4,4,10,3200.0);







