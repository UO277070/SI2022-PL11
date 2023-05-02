package PlanificaActividad;

import java.util.LinkedList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class PlanificaActividad_Controller {
	private PlanificaActividad_Model model;
	private PlanificaActividad_View view;
	private int idPeriodo, idInstalacion;
	private String nombre, tipo, fechaini, fechafin, estado;
	private int plazas, precio, precionosocio;
	
	public PlanificaActividad_Controller(PlanificaActividad_Model model, PlanificaActividad_View view) {
		this.model = model;
		this.view = view;
		this.idInstalacion = 0;
		this.idPeriodo = 0;
		this.nombre = "";
		this.tipo = "";
		this.fechafin = "";
		this.fechaini = "";
		this.estado = "";
		this.plazas = 0;
		this.precio = 0;
		this.precionosocio = 0;
		this.initView();
	}
	
	public void initController() {
		view.getbtnCrear().addActionListener((e -> crearActividad()));
	}
	
	
	public void initView() {
		view.getFrame().setVisible(true); 
		this.getInstalaciones();
		this.getPeriodos();
	
	}
	
	public void getPeriodos() {
		List<Object[]> periodos = model.getPeriodos();
		ComboBoxModel combo = SwingUtil.getComboModelFromList(periodos);
		view.getComboBoxPeriodo().setModel(combo);
		
	}
	
	public void getInstalaciones() {
		List<Object[]> intalaciones = model.getListaInstalaciones();
		ComboBoxModel model = SwingUtil.getComboModelFromList(intalaciones);
		view.getComboBoxInstalacion().setModel(model);
	}
	
	public void crearActividad() {
		this.idPeriodo = (int) model.getIdPeriodo(view.getComboBoxPeriodo().getSelectedItem().toString()).get(0)[0];
		this.idInstalacion = (int) model.getIdInstalacion(view.getComboBoxInstalacion().getSelectedItem().toString()).get(0)[0];
		this.nombre = view.getTextFieldNombre().getText();
		this.tipo = view.getTextFieldTipo().getText();
		if(view.getdCini() != null) {
			this.fechaini = Util.dateToIsoString(view.getdCini().getDate());
		}
		
		this.fechafin = Util.dateToIsoString(view.getdCfin().getDate());
		this.plazas = Integer.parseInt(view.getTextFieldAforo().getText());
		this.precio = Integer.parseInt(view.getTextFieldSocios().getText());
		this.precionosocio = Integer.parseInt(view.getTextFieldNoSocios().getText());
		
		List<Dia> dias = new LinkedList<Dia>();
		
		if(view.getTextFieldNombre().equals("") || view.getTextFieldTipo().equals("") || Integer.parseInt(view.getTextFieldNoSocios().getText())<0 || Integer.parseInt(view.getTextFieldSocios().getText())<0)
			SwingUtil.showMessage("Hay por los menos un campo vacio ", "ERROR", JOptionPane.ERROR_MESSAGE);
		if(view.getdCini().getDate().after(view.getdCfin().getDate())){
			SwingUtil.showMessage("La fecha de fin es antes que la de inicio ", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		//Comprobamos que dias estan seleccionados y los añadimos la lista dias
		if(view.getCheckBoxLunes().isSelected()) {
			int ini = Integer.parseInt(view.getSpinnerLunesIni().getValue().toString());
			int fin = Integer.parseInt(view.getSpinnerLunesFin().getValue().toString());
			String diasem = view.getCheckBoxLunes().getText();
			Dia d = new Dia(diasem, ini,fin);
			dias.add(d);		
		}
		if(view.getCheckBoxMartes().isSelected()) {
			int ini = Integer.parseInt(view.getSpinnerMartesIni().getValue().toString());
			int fin = Integer.parseInt(view.getSpinnerMartesFin().getValue().toString());
			String diasem = view.getCheckBoxMartes().getText();
			Dia d = new Dia(diasem, ini,fin);
			dias.add(d);		
		}
		if(view.getCheckBoxMiercoles().isSelected()) {
			int ini = Integer.parseInt(view.getSpinnerMiercolesIni().getValue().toString());
			int fin = Integer.parseInt(view.getSpinnerMiercolesFin().getValue().toString());
			String diasem = view.getCheckBoxMiercoles().getText();
			Dia d = new Dia(diasem, ini,fin);
			dias.add(d);		
		}
		if(view.getCheckBoxJueves().isSelected()) {
			int ini = Integer.parseInt(view.getSpinnerJuevesIni().getValue().toString());
			int fin = Integer.parseInt(view.getSpinnerJuevesFin().getValue().toString());
			String diasem = view.getCheckBoxJueves().getText();
			Dia d = new Dia(diasem, ini,fin);
			dias.add(d);		
		}
		if(view.getCheckBoxViernes().isSelected()) {
			int ini = Integer.parseInt(view.getSpinnerViernesIni().getValue().toString());
			int fin = Integer.parseInt(view.getSpinnerViernesFin().getValue().toString());
			String diasem = view.getCheckBoxViernes().getText();
			Dia d = new Dia(diasem, ini,fin);
			dias.add(d);		
		}
		if(view.getCheckBoxSabado().isSelected()) {
			int ini = Integer.parseInt(view.getSpinnerSabadoIni().getValue().toString());
			int fin = Integer.parseInt(view.getSpinnerSabadoFin().getValue().toString());
			String diasem = view.getCheckBoxSabado().getText();
			Dia d = new Dia(diasem, ini,fin);
			dias.add(d);		
		}
		if(view.getCheckBoxDomingo().isSelected()) {
			int ini = Integer.parseInt(view.getSpinnerDomingoIni().getValue().toString());
			int fin = Integer.parseInt(view.getSpinnerDomingoFin().getValue().toString());
			String diasem = view.getCheckBoxDomingo().getText();
			Dia d = new Dia(diasem, ini,fin);
			dias.add(d);		
		}
		//Insertamos la actividad y el horario
		model.insertaActividad(this.idPeriodo, this.idInstalacion, this.nombre, this.tipo, this.plazas, this.precio, this.precionosocio, this.fechaini, this.fechafin);
		int idActividad = (int)model.getIdActividad(this.nombre).get(0)[0];
		model.insertaHorario(dias, idActividad);
	}
	
}
