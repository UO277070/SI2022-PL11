drop table Reserva; 

CREATE TABLE Reserva ( 

idReserva INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 

--si la reserva es de una actividad este campo es null 

idSocio INTEGER, 

idInstalacion INTEGER, 

fecha TEXT, 

horaini INTEGER, 

horafin INTEGER, 

  

-- 2 opciones "pagado" "sinpagar"  

estado TEXT,  

-- Nombre del cliente/nombre de la actividad , el que lo reservase 

reservadopor TEXT, 

--si reservo un socio este campo es null (por defecto si no lo metes ya se queda null) 

idActividad INTEGER, 

FOREIGN KEY (idInstalacion) REFERENCES Instalacion(idInstalacion) 

); 

  

drop table Pago; 

CREATE TABLE Pago ( 

idpago INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 

importe NUMERIC, 

fecha TEXT, 

  

-- 2 opciones "pagado" "sinpagar"  

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

  

--este campo es una fecha completa (año-mes-dia) como las demas 

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