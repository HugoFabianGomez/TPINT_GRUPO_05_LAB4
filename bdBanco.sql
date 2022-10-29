drop schema bdbanco;
create schema bdbanco;

use bdbanco;

create table genero(
	id_genero int not null primary key,
    tipo_genero varcha(15)
);

create table Clientes
(
dni
cuil
nombre
apellido
nacionalidad
fecha_Nac
domicilio

nombreUsuario VARCHAR(25) NOT NULL PRIMARY KEY,
pass VARCHAR(25),
tipoUsuario INT,
dni VARCHAR(10),
nombre VARCHAR(50),
apellido VARCHAR(50)
);