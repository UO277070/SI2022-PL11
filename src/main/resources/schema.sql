--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
drop table Reserva; 

CREATE TABLE Reserva ( 

idReserva INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 

idSocio INTEGER, 

idInstalacion INTEGER, 

fecha TEXT, 

horaini INTEGER, 

horafin INTEGER, 

estado TEXT, 

reservadopor TEXT, 

idActividad INTEGER, 

FOREIGN KEY (idInstalacion) REFERENCES Instalacion(idInstalacion) 

); 

  

drop table Pago; 

CREATE TABLE Pago ( 

idpago INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 

importe NUMERIC, 

fecha TEXT, 

estado TEXT, 

idSocio INTEGER, 

idNosocio INTEGER, 

idReserva INTEGER 

); 

  

drop table Listaesperanosocio; 

CREATE TABLE Listaesperanosocio ( 

idActividad INTEGER, 

idNosocio INTEGER, 

posicion INTEGER 

); 

  

drop table Nosocio; 

CREATE TABLE Nosocio ( 

idNosocio INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 

dni TEXT, 

nombre TEXT, 

apellido1 TEXT, 

apellido2 TEXT, 

correo TEXT 

); 

  

  

drop table Actividadhorario; 

  

CREATE TABLE Actividadhorario ( 

idActividad INTEGER NOT NULL, 

diasem TEXT, 

horaini INTEGER, 

horafin INTEGER 

); 

  

  

  

drop table Socio; 

  

CREATE TABLE Socio ( 

idSocio INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL, 

Nombre TEXT, 

apellido1 TEXT, 

apellido2 TEXT, 

correo TEXT, 

cuota NUMERIC, 

moroso  TEXT 

); 

  

  

  

drop table Listaesperasocio; 

CREATE TABLE Listaesperasocio ( 

idActividad INTEGER, 

IdSocio INTEGER, 

posicion NUMERIC 

); 

  

  

drop table Instalacion; 

CREATE TABLE Instalacion ( 

idInstalacion INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 

nombre TEXT, 

preciohora NUMERIC 

); 

  

drop table Inscripcion; 

  

CREATE TABLE Inscripcion ( 

idActividad INTEGER, 

idSocio INTEGER, 

idNosocio INTEGER 

); 

  

  

drop table Actividad; 

CREATE TABLE Actividad ( 

idActividad INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL, 

idPeriodoinscrip INTEGER, 

idInstalacion INTEGER, 

nombre TEXT, 

tipo TEXT, 

plazas NUMERIC, 

precio NUMERIC, 

precionosocio NUMERIC, 

fechaini TEXT, 

fechafin TEXT, 

estado TEXT 

); 

  

drop table PeriodoInscripcion; 

  

CREATE TABLE PeriodoInscripcion ( 

idPeriodoinscrip INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL, 

nombre TEXT, 

fechainscripini TEXT, 

fechainscripfin TEXT, 

fechainscripininosocio TEXT, 

fechainscripfinnosocio TEXT 

); 

