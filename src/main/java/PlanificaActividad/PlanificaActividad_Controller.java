package PlanificaActividad;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import giis.demo.util.SwingUtil;

public class PlanificaActividad_Controller {
	private PlanificaActividad_Model model;
	private PlanificaActividad_View view;
	private int idPeriodo, idInstalacion;
	private String nombre, tipo, fechaini, fechafin, estado;
	private int plazas, precio, precionosocio;
	
	public PlanificaActividad_Controller(PlanificaActividad_Model model, PlanificaActividad_View view) {
		this.model = model;
		this.view = view;
		
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
		List<Object []> intalaciones = model.getListaInstalaciones();
		ComboBoxModel model = SwingUtil.getComboModelFromList(intalaciones);
		view.getComboBoxInstalacion().setModel(model);
	}
	
	public void crearActividad() {
		this.idPeriodo = (int) model.getIdPeriodo(view.getComboBoxPeriodo().getSelectedItem().toString()).get(0)[0];
		this.idInstalacion = (int) model.getIdInstalacion(view.getComboBoxInstalacion().getSelectedItem().toString()).get(0)[0];
		this.nombre = view.getTextFieldNombre().getText();
		this.tipo = view.getTextFieldTipo().getText();
		this.fechaini = view.getdCini().getDateFormatString();
		this.fechafin = view.getdCfin().getDateFormatString();
		this.plazas = (int)view.getSpinnerAforo().getValue();
		this.precio = Integer.parseInt(view.getTextFieldSocios().getText());
		this.precionosocio = Integer.parseInt(view.getTextFieldNoSocios().getText());
		
		if(view.getTextFieldNombre().equals("") || view.getTextFieldTipo().equals("") || Integer.parseInt(view.getTextFieldNoSocios().getText())<0 || Integer.parseInt(view.getTextFieldSocios().getText())<0)
			SwingUtil.showMessage("Hay por los menos un campo vacio ", "ERROR", JOptionPane.ERROR_MESSAGE);
		else if(view.getdCini().getDate().after(view.getdCfin().getDate())){
			SwingUtil.showMessage("La fecha de fin es antes que la de inicio ", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else {
			model.insertaActividad(this.idPeriodo, this.idInstalacion, this.nombre, this.tipo, this.plazas, this.precio, this.precionosocio, this.fechaini, this.fechafin);
		}
	}
	
}
