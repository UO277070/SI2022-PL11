package InscribirSocio;

import java.io.IOException;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import InscribirAdmin.NoSocio;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;
import loginSocio.*;

public class InscribirSocioC {
	
	private InscribirSocioM model;
	private InscribirSocioV view;
	private Date fechaActual;
	private loginController controller;
	private SocioEntity socioLog;
	private Actividades actividad;
	private int idSocio;
	private int idActividad;
	private int plazaslibres;
	
	public InscribirSocioC(InscribirSocioM model, InscribirSocioV view) {
		this.model = model;
		this.view = view;
		this.fechaActual = new Date();
		
		
		
		
		this.initView();
	}
	
	public void initController() {
		view.getComboBoxActividad().addItemListener(e -> getActividad());
		view.getComboBoxActividad().addItemListener(e -> getInscripciones());
		view.getButtonInscribir().addActionListener(e -> inscribir());
	}
	
	
	public void initView() {
		this.getListaActividadesEnPeriodo();
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		controller=new loginController(new loginModel(), new loginView());
		controller.initController();
		boolean POK = controller.showDialog();
		if (POK) {
			socioLog = controller.getSocio();
			view.getFrame().setVisible(true);
		}
	}
	
	public void setSocio() {
		view.getFrame().setTitle(view.getFrame().getTitle()+" - " + socioLog.getNombre());
	}
	
	public void getListaActividadesEnPeriodo() {
		List <Object[]> actividades = model.getListaActividadesEnPeriodoSocio(Util.dateToIsoString(fechaActual));
		ComboBoxModel combo = SwingUtil.getComboModelFromList(actividades);
		view.getComboBoxActividad().setModel(combo);
	}
	
	public void getActividad() {		
		this.actividad = model.getActividad(view.getComboBoxActividad().getSelectedItem().toString()).get(0);
		
		view.getLabelTipo().setText(this.actividad.getTipo());
		view.getLabelPrecio().setText(""+this.actividad.getPrecio());
		view.getLabelFechaIni().setText(actividad.getFechaini());
		view.getLabelFechaFin().setText(actividad.getFechafin());
		view.getLabelHoraIni().setText(actividad.getHoraini());
		view.getLabelHoraFin().setText(actividad.getHorafin());
		view.getLabelDias().setText(actividad.getDiasem());
		view.getLabelAforo().setText(""+model.getNumInscripcionesEnActividad(this.idActividad).get(0)[0]+"/"+""+actividad.getPlazas());
	}
	
	public void getInscripciones() {
		this.actividad = model.getActividad(view.getComboBoxActividad().getSelectedItem().toString()).get(0);
		this.idActividad = actividad.getIdActividad();
		this.plazaslibres =  Math.max(0, this.actividad.getPlazas() - (Integer) model.getNumInscripcionesEnActividad(this.idActividad).get(0)[0]);
	}
	
	
	public void inscribir() {
		this.actividad = model.getActividad(view.getComboBoxActividad().getSelectedItem().toString()).get(0);
		this.idActividad = actividad.getIdActividad();
		this.idSocio = this.socioLog.getIdSocio();
		this.getInscripciones();
		
		if(this.plazaslibres != 0) {
			model.insertInscripcionActividadSocio(this.idActividad, this.idSocio);
		}
		this.resguardo(actividad);
		JOptionPane.showMessageDialog(null,"Inscripcion realizada","Inscripcion", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void resguardo(Actividades detalles) {
		Formatter out = null;
		try {
			//Ruta para llegar a la carpeta de descargas
			String home = System.getProperty("user.home");
			out = new Formatter(home+"\\Downloads\\resguardo.txt");
			
			//Texto del txt
			out.format("Resguardo de su inscripción\n"+
						"Actividad: "+detalles.nombre+"\n"+
						"Instalacion: "+detalles.idInstalacion+"\n"+
						"Tipo: "+detalles.tipo+"\n"+
						"Fecha de Inicio: "+detalles.fechaini+"\n"+
						"Fecha de Fin: "+detalles.fechafin+"\n"+
						"Hora de Inicio: "+detalles.horaini+"\n"+
						"Hora de Fin: "+detalles.horafin+"\n"+
						"Días de realización: "+detalles.diasem+"\n"+
						"Plazas Totales: "+detalles.plazas+"\n");
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (out !=null) out.close();
		}
	}
	
}
