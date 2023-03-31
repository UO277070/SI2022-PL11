package reservaInstalacionSocio;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import giis.demo.util.SwingUtil;
import giis.demo.util.UnexpectedException;
import loginSocio.SocioEntity;
import loginSocio.loginController;
import loginSocio.loginModel;
import loginSocio.loginView;

public class ReservaController {
	private ReservaModel model;
	private ReservaInstalacionSocio view;
	private SocioEntity socioLog;
	
	public ReservaController(ReservaModel rm, ReservaInstalacionSocio ri) {
		this.model = rm;
		this.view = ri;
		initView();
	}
	
	public void initController() {
		view.getSpHoras().addChangeListener(e -> getPrecio());
		view.getcBInstalaciones().addItemListener(e -> getPrecio());
		view.getcBInstalaciones().addItemListener(e -> getFechas());
		view.getcBInstalaciones().addItemListener(e -> getHoras());
		view.getcBInstalaciones().addItemListener(e -> getNumHoras());
		view.getcBListaFechas().addItemListener(e -> getHoras());
		view.getcBListaFechas().addItemListener(e -> getNumHoras());
		view.getcBListaFechas().addItemListener(e -> getPrecio());
		view.getcBListaHoras().addItemListener(e -> getNumHoras());
		view.getBtnReservar().addActionListener(e -> validacionReserva());
	}
	
	public void initView() {
		//Inicializa todos los datos de la ventana
		//y actualiza los datos de la vista
		this.getListaInstalacion();
		this.getFechas();
		this.getHoras();
		this.getNumHoras();
		this.getPrecio();
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		loginController controller=new loginController(new loginModel(), new loginView());
		controller.initController();
		boolean POK = controller.showDialog();
        if (POK) {
        	socioLog = controller.getSocio();
        	view.getFrame().setVisible(true);
        	setSocio();
        }
        
	}
	
	public void setSocio() {
		view.gettFSocio().setText(""+socioLog.getIdSocio());
		view.setTitle("Sesión iniciada como: " + socioLog.getNombre());
	}
	
	
	
	
	/**
	 * Introduce en cBInstalaciones todas las instalaciones presentes en la base de 
	 * datos cambiando su model 
	 */
	public void getListaInstalacion() {
		//Consulta con todas las instalaciones en una lista
		List<Object[]> instalacionList=model.getInstalaciones();
		//Creacion del modelo a partir de una lista
		ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(instalacionList);
		view.getcBInstalaciones().setModel(lmodel);
	}
	
	/**
	 * Introduce en cBListaFechas las fechas disponibles para un periodo de 15 dias desde 
	 * la fecha actual
	 */
	public void getFechas() {
		//Formato para la fecha
		SimpleDateFormat formato =new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		//Obtencion de la fecha actual
		cal.setTime(new Date());
		
		//Creacion de los datos para el modelo
		String fechas[] = new String[15];
		fechas[0] = "Hora";
		for(int i = 0; i<15;i++) {
			fechas[i] = ""+formato.format(cal.getTime());
			cal.add(Calendar.DATE, 1); 
		}
		view.getcBListaFechas().setModel(new DefaultComboBoxModel(fechas));
	}
	
	/**
	 * Calcula el precio para la reserva de la instalacion seleccionada
	 */
	public void getPrecio() {
		String nombre = ""+view.getcBInstalaciones().getSelectedItem();
		view.getLblCosteTotal().setText(""+model.getPrecio(nombre)*((Integer)view.getSpHoras().getValue()));
	}
	
	/**
	 * Introduce en cBListaHoras las horas disponibles para la reserva
	 */
	public void getHoras() {
		//Creacion de los datos para el modelo
		String horas[] = new String[13];
		for(int i = 0; i<13; i++) {
			horas[i] = String.format("%d", 8+i);
		}
		DefaultComboBoxModel modeloHora = new DefaultComboBoxModel(horas);
		
		String instalacion = (String) view.getcBInstalaciones().getSelectedItem();
		String fecha = (String) view.getcBListaFechas().getSelectedItem();
		//Consulta con las horas ocupadas en ese dia en una lista
		List<Object[]> horasocupadas = model.getHorasOcupadas(instalacion,fecha);
		for(int i = 0; i<horasocupadas.size(); i++) {
			int horaini = (int)horasocupadas.get(i)[0];
			int horafin = (int)horasocupadas.get(i)[1];
			for (int j = horaini; j<horafin;j++) {
				//Elimina las horas de cBListaHoras
				modeloHora.removeElement(""+j);
			}
		}
		view.getcBListaHoras().setModel(modeloHora);
		
	}
	
	/**
	 * Asigna a SpHoras el numero de horas disponibles para reservar 
	 */
	public void getNumHoras() {
		DefaultComboBoxModel horas = (DefaultComboBoxModel)view.getcBListaHoras().getModel();
		String horaSeleccionada = (String) view.getcBListaHoras().getSelectedItem();
		int index = horas.getIndexOf(horaSeleccionada);
		int siguienteHora = Integer.parseUnsignedInt(horas.getElementAt(index).toString())+1;
		//System.out.print(siguienteHora);
		//Comprueba si es la ultima hora disponible para eligir
		if (index+1<horas.getSize()) {
			//System.out.print(horas.getElementAt(index+1));
			//Comprueba si se pueden reservar 1 o 2 horas
			if (horas.getElementAt(index+1).equals(""+siguienteHora)) {
				view.getSpHoras().setModel(new SpinnerNumberModel(1, 1, 2, 1));
			}
			else
				view.getSpHoras().setModel(new SpinnerNumberModel(1, 1, 1, 1));
		}
		else
			view.getSpHoras().setModel(new SpinnerNumberModel(1, 1, 1, 1));
		
	}
	
	/**
	 * Comprueba si el socio esta al dia con los pagos
	 * @param socio
	 * @throws UnexpectedException
	 */
	public void validacionSocio(SocioEntity socio) throws UnexpectedException {
		//System.out.print(socio.Nombre);
		if (socio.getMoroso()) {
			throw new UnexpectedException("Pago mensual pendiente");
		}
	}
	
	/**
	 * Comprueba si la hora para ese dia esta disponible
	 * @param idInstalacion
	 * @param fecha
	 * @param horaini
	 * @param horafin
	 * @throws UnexpectedException
	 */
	public void validacionHorario(int idInstalacion,String fecha, int horaini, int horafin) throws UnexpectedException {
		//Consulta para comprobar si hay alguna reserva
		if (model.horaocupada(idInstalacion, fecha, horaini, horafin)) {
			throw new UnexpectedException("Hora ocupada");
		}
	}
	
	/**
	 * Comprueba que el socio no supera el limite de horas diarias y del periodo
	 * @param idSocio
	 * @throws UnexpectedException
	 */
	public void validacionHoras(int idSocio) throws UnexpectedException {
		ComboBoxModel fechas = view.getcBListaFechas().getModel();
		List<Object[]> fecha = model.socioHoras(idSocio,view.getcBListaFechas().getSelectedItem().toString());
		int horaini;
		int horafin;
		int count=0;
		
		//Horas diarias
		for(int i=0;i<fecha.size();i++) {
			horaini = (int)fecha.get(i)[0];
			horafin = (int)fecha.get(i)[1];
			count += horafin-horaini;
		}
		if(count >= 4)
			throw new UnexpectedException("Límite de horas reservadas diarias");
		
		count=0;
		//Horas periodo
		for(int i=0;i<fechas.getSize();i++) {
			fecha = model.socioHoras(idSocio,fechas.getElementAt(i).toString());
			for(int j=0;j<fecha.size();j++) {
				horaini = (int)fecha.get(j)[0];
				horafin = (int)fecha.get(j)[1];
				count += horafin-horaini;
			}
		}
		if(count >= 10)
			throw new UnexpectedException("Límite de horas reservadas para los siguientes 15 días");
		
		
	}
	
	/**
	 * Comprueba que todos los campos sean validos
	 */
	public void validacionReserva() {
		try {
			//Socio sin rellenar
			if(view.gettFSocio().getText().equals("")) {
				JOptionPane.showMessageDialog(view,"Introduce un socio","Aviso",JOptionPane.ERROR_MESSAGE);
			}
			else {
				int idsocio = Integer.parseUnsignedInt(view.gettFSocio().getText());
				//Consulta en busca del id del socio
				SocioEntity socio = model.getSocio(idsocio);
				//Comprobacion de si existe el socio si es null no existe
				if(socio == null) {
					JOptionPane.showMessageDialog(view,"Socio no encontrado","Aviso",JOptionPane.ERROR_MESSAGE);
				}
				else {
					String fecha = view.getcBListaFechas().getSelectedItem().toString();
					int idInstalacion = model.getIdInstalacion(view.getcBInstalaciones().getSelectedItem().toString());

					int horaini = Integer.parseUnsignedInt(view.getcBListaHoras().getSelectedItem().toString());
					int horafin = horaini + (int) view.getSpHoras().getValue();
					//Validacion de datos
					validacionSocio(socio);
					validacionHorario(idInstalacion,fecha,horaini,horafin);
					validacionHoras(idsocio);

					//Insercion en la tabla de reservas con los datos
					model.reservaInstalacion(idsocio, idInstalacion, fecha, horaini, horafin, socio.getNombre());
					
					//Consulta con los datos de la reserva que se acaba de hacer para el resguardo
					ReservaEntity detalles = model.reservaDetalles(idsocio, idInstalacion, fecha, horaini, horafin);
					double pago = Double.parseDouble(view.getLblCosteTotal().getText());
					
					//Metodo de pago con un pago o cambio de la cuota
					String metodo = metodopago(pago,socio.getIdSocio(),fecha,detalles.idReserva);
					//Resguardo con los datos de la reserva
					resguardo(detalles,metodo);
					/*List<Object[]> lista = model.Prueba();
					for(int i=0;i<lista.size();i++) {
						for(int j=0;j<lista.get(i).length;j++) {
							System.out.printf("%s ", lista.get(i)[j]);
						}
						System.out.println();
					}*/
					JOptionPane.showMessageDialog(view,"Reserva completada. Guarde su resguardo","Reserva",JOptionPane.INFORMATION_MESSAGE);
					view.dispose();
				}
			}
		}
		catch (UnexpectedException e) {
			JOptionPane.showMessageDialog(view,e.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE);
			view.dispose();
		}
	}
	

	/**
	 * Realiza una insercion en la tabla pagos o un cambio de la cuota dependiendo de la opcion seleccionada
	 * @param pago
	 * @param newcuota
	 * @param idSocio
	 * @param fecha
	 * @param idReserva
	 * @return un String con el metodo usado
	 */
	private String metodopago(double pago, int idSocio, String fecha, int idReserva) {
		String estado;
		if(view.getRdbtnCuotaMensual().isSelected()) {
			//Pago con cuota
			estado = "sinpagar"; 
			model.generaPago(pago,fecha,estado,idSocio,idReserva);
			return "Añadido a su cuota mensual";
		}
		else {
			//Insercion del pago
			estado = "pagado"; 
			model.generaPago(pago, fecha,estado,idSocio, idReserva);
			return "Pago con tarjeta";
		}
	}
	
	/**
	 * Genera el reguardo en formato txt en la carpeta de descargas
	 * @param detalles
	 * @param metodo
	 */
	public void resguardo(ReservaEntity detalles, String metodo) {
		Formatter out = null;
		try {
			//Ruta para llegar a la carpeta de descargas
			String home = System.getProperty("user.home");
			out = new Formatter(home+"\\Downloads\\resguardo.txt");
			
			//Texto del txt
			out.format("Resguardo de su reserva\n"+
						"Reserva: "+detalles.idReserva+"\n"+
						"Instalacion: "+detalles.idInstalacion+"\n"+
						"Reservado a nombre de: "+detalles.reservadopor+" con número de socio: "+detalles.idSocio+"\n"+
						"Fecha de reserva: "+detalles.fecha+"\n"+
						"Horario: "+detalles.horaini+"h-"+detalles.horafin+"h\n"+
						"Coste Total: "+view.getLblCosteTotal().getText()+" €\n"+
						"Método de pago: "+metodo);
				
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (out !=null) out.close();
		}
	}
}
