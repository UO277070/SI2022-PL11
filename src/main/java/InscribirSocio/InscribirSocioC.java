package InscribirSocio;

import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;

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
		view.getLabelAforo().setText(""+this.plazaslibres+"/"+""+actividad.getPlazas());
	}
	
	public void getInscripciones() {
		this.actividad = model.getActividad(view.getComboBoxActividad().getSelectedItem().toString()).get(0);
		this.idActividad = actividad.getIdActividad();
		this.plazaslibres =  Math.max(0,  (Integer) model.getPlazasTotalesActividad(this.idActividad).get(0)[0]
				- (Integer) model.getNumInscripcionesEnActividad(this.idActividad).get(0)[0]);
	}
	
	
	public void inscribir() {
		this.actividad = model.getActividad(view.getComboBoxActividad().getSelectedItem().toString()).get(0);
		this.idActividad = actividad.getIdActividad();
		this.idSocio = this.socioLog.getIdSocio();
		
		
		if(this.plazaslibres != 0) {
			model.insertInscripcionActividadSocio(this.idActividad, this.idSocio);
		}
	}
	
}
