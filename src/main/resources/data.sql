--Datos para carga inicial de la base de datos

--Para giis.demo.tkrun:
delete from Actividad; 

insert into Actividad(idActividad,idPeriodoinscrip,idInstalacion,Nombre,Tipo,Plazas,Precio,Precionosocio,Fechaini,Fechafin,Estado) values  

(1, 1, 1, 'Natacion' , 'tipo1', 200, 50, 80, '2023-01-17', '2023-06-17', 'Estado1'), 

(2, 2, 1, 'Tenis' , 'tipo1', 150, 25, 65, '2023-04-2', '2023-06-17', 'Iniciada'), 

(3, 2, 1, 'Padel' ,'tipo1', 100, 15, 40, '2023-04-17', '2023-07-17', 'En espera'), 

(4, 3, 1, 'Yoga' , 'tipo1', 200, 50, 80, '2023-01-17', '2023-03-17', 'Estado1'), 

(5, 2, 1, 'Pilates' , 'tipo1', 200, 20, 30, '2023-04-01', '2023-08-17', 'Iniciada'); 

  

insert into Actividadhorario(idActividad, diasem, Horaini, Horafin) values 

(1, '2023-03-01', 08, 10), 

(2, '2023-03-01', 08, 10), 

(3, '2023-03-01', 08, 10), 

(4, '2023-03-01', 08, 10),

(5, '2023-04-12', 12, 14); 

insert into Socio (idSocio, nombre, apellido1, apellido2, correo, cuota, moroso) values 

(1, 'Ramon','Perez','González','Correo@ejemplo.com', 35, false), 

(2, 'Pedro','Perez2','González2','Correo2@ejemplo.com', 35, 'true'); 

  

  

insert into Inscripcion (idActividad, idSocio, idNosocio) values  

(1 ,5 ,1),
(2,1,1),
(3,4,1),
(5,4,1); 

  

insert into Instalacion (idInstalacion, nombre, Preciohora) values 

(1, 'Instalacion1', 10), 

(2, 'Instalacion2', 20), 

(3, 'Instalacion3', 20), 

(4, 'Instalacion4', 30), 

(5, 'Instalacion5', 30), 

(6, 'Instalacion6', 20), 

(7,'Instalacion7', 30), 

(8,'Instalacion8', 40), 

(9, 'Instalacion9', 50), 

(10,'Instalacion10', 10); 

  

insert into Nosocio (idNosocio, Dni, Nombre, Apellido1, Apellido2, Correo) values 

(1 ,1234567 ,'n1' ,'a1 ','a2','correo1@gmail.com' ), 

(2 ,1234567 ,'n2' ,'a12' ,'a22' ,'correo2@gmail.com '), 

(3 ,1234567 ,'n3' ,'a13' ,'a23' ,'correo3@gmail.com '), 

(4 ,1234567 ,'n4' ,'a14 ','a24' ,'correo4@gmail.com '), 

(5 ,1234567 ,'n5' ,'a15 ','a25' ,'correo5@gmail.com' ), 

(6 ,1234567 ,'n6' ,'a16' ,'a26' ,'correo6@gmail.com '), 

(7 ,1234567 ,'n7' ,'a17' ,'a27' ,'correo7@gmail.com '); 

  

insert into Pago (idPago, Importe, Fecha, Estado, idSocio, idNosocio, idReserva) values 

(1, 10, '2022-01-17','completo',1 ,1,1); 



insert into PeriodoInscripcion (idPeriodoinscrip ,Nombre,Fechainscripini,Fechainscripfin,Fechainscripfinnosocio) values 

(1,'Enero','2023-01-01','2023-02-02','2023-01-15'), 

(2,'Abril','2023-04-01','2023-05-01','2023-04-15'),

(3,'Septiembre','2023-09-01','2023-10-01','2023-09-15'); 


insert into Reserva (idReserva, idSocio, idInstalacion , fecha, horaIni, horafin, estado ,reservadoPor, idActividad) values 

(1,1,2,'2023-04-01', 10, 18, 'pagado','Pepe', NULL ), 

(2,1,1,'2023-03-01', 15, 16,'pagado', 'Ramon', NULL), 

(3,1,2,'2023-03-01', 08, 09,'pagado', 'Juan', NULL), 

(4,1,2,'2023-03-01', 10, 14, 'pagado','Pedro', NULL), 

(5,1,2,'2023-03-01', 10, 14,'pagado', 'Pedro', NULL), 

(13,1,1,'2022-03-09', 9, 12,'pagado', 'Actividad1', 1 ), 

(6,1,1,'2022-03-09', 08, 09,'pagado', 'Ramon', NULL ), 

  

  

(7,1,2,'2022-04-10', 10, 12, 'pagado','Pepe', NULL ), 

(8,1,2,'2022-04-10', 12, 14, 'pagado','Pepe', NULL ), 

(9,1,2,'2022-04-10', 10, 14, 'pagado','Pepe', NULL ), 

(10,2,3,'2022-04-10', 10, 14, 'pagado','Pepe', NULL ), 

(11,2,3,'2022-04-10', 10, 14, 'pagado','Pepe', NULL ), 

(12,2,3,'2022-04-10', 10, 14, 'pagado','Pepe', NULL ); 
