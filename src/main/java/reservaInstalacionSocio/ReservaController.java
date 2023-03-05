package reservaInstalacionSocio;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicScrollPaneUI.ViewportChangeHandler;
import javax.swing.table.TableModel;

import giis.demo.tkrun.CarreraDisplayDTO;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class ReservaController {
	private ReservaModel model;
	private ReservaInstalacionSocio view;
	
	public ReservaController(ReservaModel rm, ReservaInstalacionSocio ri) {
		this.model = rm;
		this.view = ri;
		initView();
	}
	
	public void initController() {
		//ActionListener define solo un metodo actionPerformed(), es un interfaz funcional que se puede invocar de la siguiente forma:
		//view.getBtnTablaCarreras().addActionListener(e -> getListaCarreras());
		//ademas invoco el metodo que responde al listener en el exceptionWrapper para que se encargue de las excepciones
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
		//Inicializa la fecha de hoy a un valor que permitira mostrar carreras en diferentes fases 
		//y actualiza los datos de la vista
		this.getListaInstalacion();
		this.getFechas();
		this.getHoras();
		this.getNumHoras();
		this.getPrecio();
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 
	}
	
	public void getListaInstalacion() {
		//A modo de demo, se muestra tambien la misma informacion en forma de lista en un combobox
		List<Object[]> instalacionList=model.getInstalaciones();
		ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(instalacionList);
		view.getcBInstalaciones().setModel(lmodel);
	}
	
	public void getFechas() {
		SimpleDateFormat formato =new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String fechas[] = new String[15];
		fechas[0] = "Hora";
		for(int i = 0; i<15;i++) {
			fechas[i] = ""+formato.format(cal.getTime());
			cal.add(Calendar.DATE, 1); 
		}
		view.getcBListaFechas().setModel(new DefaultComboBoxModel(fechas));
	}
	
	public void getPrecio() {
		String nombre = ""+view.getcBInstalaciones().getSelectedItem();
		view.getLblCosteTotal().setText(""+model.getPrecio(nombre)*((Integer)view.getSpHoras().getValue()));
	}
	
	public void getHoras() {
		String horas[] = new String[13];
		for(int i = 0; i<13; i++) {
			horas[i] = String.format("%d", 8+i);
		}
		DefaultComboBoxModel modeloHora = new DefaultComboBoxModel(horas);
		String instalacion = (String) view.getcBInstalaciones().getSelectedItem();
		String fecha = (String) view.getcBListaFechas().getSelectedItem();
		List<Object[]> horasocupadas = model.getHorasOcupadas(instalacion,fecha);
		for(int i = 0; i<horasocupadas.size(); i++) {
			int horaini = (int)horasocupadas.get(i)[0];
			int horafin = (int)horasocupadas.get(i)[1];
			for (int j = horaini; j<horafin;j++) {
				//System.out.print(j);
				modeloHora.removeElement(""+j);
			}
		}
		view.getcBListaHoras().setModel(modeloHora);
		
	}
	
	public void getNumHoras() {
		DefaultComboBoxModel horas = (DefaultComboBoxModel)view.getcBListaHoras().getModel();
		String horaSeleccionada = (String) view.getcBListaHoras().getSelectedItem();
		int index = horas.getIndexOf(horaSeleccionada);
		int siguienteHora = Integer.parseUnsignedInt(horas.getElementAt(index).toString())+1;
		System.out.print(siguienteHora);
		if (index+1<horas.getSize()) {
			System.out.print(horas.getElementAt(index+1));
			if (horas.getElementAt(index+1).equals(""+siguienteHora)) {
				view.getSpHoras().setModel(new SpinnerNumberModel(1, 1, 2, 1));
			}
			else
				view.getSpHoras().setModel(new SpinnerNumberModel(1, 1, 1, 1));
		}
		else
			view.getSpHoras().setModel(new SpinnerNumberModel(1, 1, 1, 1));
		
	}
	
	public boolean validacionSocio(int idsocio, SocioEntity socio) {
		System.out.print(socio.Nombre);
		if (socio.getMoroso()) {
			return false;
		}
		return true;
	}
	
	public boolean validacionHorario(int idInstalacion,String fecha, int horaini, int horafin) {
		boolean reservado = model.horaocupada(idInstalacion, fecha, horaini, horafin);
		if (reservado) {
			return false;
		}
		return true;
	}
	
	public void validacionReserva() {
		int idsocio = Integer.parseUnsignedInt(view.gettFSocio().getText());
		SocioEntity socio = model.getSocio(idsocio);
		String fecha = view.getcBListaFechas().getSelectedItem().toString();
		int idInstalacion = model.getIdInstalacion(view.getcBInstalaciones().getSelectedItem().toString());
		int horaini = Integer.parseUnsignedInt(view.getcBListaHoras().getSelectedItem().toString());
		int horafin = horaini + (int) view.getSpHoras().getValue();
		boolean socioCheck = validacionSocio(idsocio,socio);
		boolean fechaCheck = validacionHorario(idInstalacion,fecha,horaini,horafin);
		
		if(socioCheck && fechaCheck) {
			model.reservaInstalacion(idsocio, idInstalacion, fecha, horaini, horafin, socio.getNombre());
			ReservaEntity detalles = model.reservaDetalles(idsocio, idInstalacion, fecha, horaini, horafin);
			double newcuota = socio.cuota + Double.parseDouble(view.getLblCosteTotal().getText());
			String metodo = metodopago(newcuota,socio.idSocio);
			resguardo(detalles,metodo);
			List<Object[]> lista = model.Prueba();
			for(int i=0;i<lista.size();i++) {
				for(int j=0;j<lista.get(i).length;j++) {
					System.out.printf("%s ", lista.get(i)[j]);
				}
				System.out.println();
			}
			JOptionPane.showMessageDialog(view,"Reserva completada. Guarde su resguardo","Reserva",JOptionPane.INFORMATION_MESSAGE);
			view.dispose();
		}
		else {
			if(!socioCheck) {
				JOptionPane.showMessageDialog(view,"Cuota mensual no pagada","Aviso",JOptionPane.ERROR_MESSAGE);
				view.dispose();
			}
			else {
				JOptionPane.showMessageDialog(view,"La hora ya no esta disponible","Aviso",JOptionPane.ERROR_MESSAGE);
				view.dispose();
			}
		}
	}
	
	private String metodopago(double cuota,int idSocio) {
		if(view.getRdbtnCuotaMensual().isSelected()) {
			model.updateCuotaMensual(cuota, idSocio);
			return "Añadido a su cuota mensual";
		}
		else {
			return "Pago pendiente en instalación";
		}
	}
	
	public void resguardo(ReservaEntity detalles, String metodo) {
		Formatter out = null;
		try {
			String home = System.getProperty("user.home");
			out = new Formatter(home+"\\Downloads\\resguardo.txt");
		
			out.format("Resguardo de su reserva\n"+
						"Reserva: "+detalles.idReserva+"\n"+
						"Instalacion: "+detalles.idInstalacion+"\n"+
						"Reservado a nombre de: "+detalles.reservadopor+" SocioID: "+detalles.idSocio+"\n"+
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
