package ReservarInstalacionComoSocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ReservaSocio_Controler {

	public ReservaSocio_Controler () {
		model= new ReservaSocio_Model();
		vista= new ReservaSocio_Vista(this);
		
	}
	
	//Parametros para validar
	
	//horas maximas de reserva
	int HorasMaxReserva= 2;
	//horas maxims 1dia
	int HorasMaxDia= 4;
	//horas maximas por periodo (DiasMargen)
	int HorasMaxPeriodo= 10;			// CAMBIAR CAMBIAR CAMBIAR
	//Margen superior de cuando puede reservar
	int DiasMargen_sup=15;
	//Hora a la que abre el negocio
	int HoraApertura_Reservas= 8;
	//Hora a la que cierra el negocio
	int HoraCierre_Reservas=21;
	
	
	
	 
	public void init() {
		vista.getFrame().setVisible(true);

	}
	
	public List<InstalacionEntity> getInstalaciones() {
		return model.getNombreinstalaciones();
		
	}
	public int SacaridReserva(String idSocio,String instalacion,String Fecha, int ini,int fin) {
		
		return model.SacaridReserva(idSocio, model.getidInstalacion(instalacion), Fecha, ini, fin);
	}

	
	public Integer getprecio(String idInstalacion) {	//Necesito saber bien como va lo del periodo para hacer esto
		return model.getprecio(idInstalacion);
	}
	
	
	public void Insertapago(int importe, String fecha, String estado, String idSocio, int idReserva) {
		model.Insertapago(importe, fecha, estado, idSocio, idReserva);
	}

	public void reservarInstalacion(String instalacion, String dia, String mes, String año, int ini, int fin, String idSocio,String NombreSocio) {
		

		
		model.ReservarInstalacion(idSocio, model.getidInstalacion(instalacion), ""+año+"-"+mes+"-"+dia, ini, fin, NombreSocio);
	}
	
	public String ReservaSocioOk(String instalacion, String dia, String mes, String año, int ini, int fin, String idSocio,String NombreSocio) {



		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String reserva=""+año+"-"+mes+"-"+dia;
		Date FechaReserva= new Date();
		try {
			FechaReserva = sdf.parse(reserva);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// La fecha actual
		
		Date fechaactual = new Date(System.currentTimeMillis());
		

		float milisecondsByDay = 86400000;
		long fechaReservaf= (FechaReserva.getTime())+ini*60*60*1000;
		long fechaActualf= (fechaactual.getTime());
		
		//Numero de dias de diferendia al actual positivo si es despues temporalmente negativo si ya paso la fecha
		float dias = (float) ((fechaReservaf-fechaActualf)/milisecondsByDay);
		
		//comprobaciones
		
		if(dias>=DiasMargen_sup) {
			return "Debes reservar con un maximo de "+DiasMargen_sup+" de antelacion.";			
		}
		else if(dias<0) {
			return "No puedes reservar para una fecha ya pasada.";						
		}
		else if(fin<=ini) {
			return "Selecciona bien la hora de inicio y fin de la reserva.";

		}
		else if(fin-ini>HorasMaxReserva) {
			return "Debes reservar un maximo de "+HorasMaxReserva+" por cada reserva.";
		}

		else if(ini<HoraApertura_Reservas || fin>HoraCierre_Reservas) {
			return "El horario para las reservas es de "+HoraApertura_Reservas+" a "+HoraCierre_Reservas+".";						
		}
		else {
			//Empezamos con las llamadas a la base de datos para comprobar todo
			
			
			//Saber que el socio existe
			if(!model.getSocioidExiste(idSocio,NombreSocio)) {	//En caso de que no exista
				return "El dni/Nombre no son correctos.";
			}
			
			//En este punto existe el socio busquemos sus reservas y a comparar tiempos
			List<ReservaEntity> l=model.getReservasSocio(idSocio);
			int horasTotales=0;
			
			for(ReservaEntity obj:l) {
				horasTotales+= obj.horafin- obj.horaini;
			}
			if(horasTotales+(fin-ini)>HorasMaxPeriodo) {
				return "Ya tienes un total de "+horasTotales+" horas reservadas, no puedes reservar "+(fin-ini)+" mas, el limite por periodo es de "+HorasMaxPeriodo+".";
			}
			
			//
			int HorasDia=0;
			for(ReservaEntity obj:l) {
				if(obj.fecha==FechaReserva.toString()) {
					HorasDia+= obj.horafin- obj.horaini;					
				}
			}
			if(HorasDia+(fin-ini)>HorasMaxDia) {
				return "Ya tienes un total de "+HorasDia+" horas reservadas hoy, no puedes reservar "+(fin-ini)+" mas, el limite por dia es de "+HorasMaxDia+".";				
			}
			
			// En este punto absolutamente todas las restricciones del socio se cumplen, solo queda que este disponible la instalación.
			List<ReservaEntity> ResInst=model.getReservaInstalacion(model.getidInstalacion(instalacion), sdf.format(FechaReserva));
			boolean ocupada=false;
			for(ReservaEntity obj:ResInst) {
				if( (obj.horaini<fin && obj.horafin>ini) ) {
					return "La instalacion:"+instalacion+" ya esta ocupada, colision con idReserva:"+obj.idReserva+".";														
				}
			}
			
			//En este punto no esta ocupada osea que se puede reservar la instalacion,
			
//			model.ReservarInstalacion(idSocio, model.getidInstalacion(instalacion), sdf.format(FechaReserva), ini, fin, NombreSocio);
		}


		
		return null;
	}

	ReservaSocio_Model model;
	ReservaSocio_Vista vista;


	
}
