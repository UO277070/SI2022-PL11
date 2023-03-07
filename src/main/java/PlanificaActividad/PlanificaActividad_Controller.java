package PlanificaActividad;

import java.util.List;

import javax.swing.JOptionPane;

import giis.demo.util.SwingUtil;

public class PlanificaActividad_Controller {
	private PlanificaActividad_Model model;
	private PlanificaActividad_View view;
	
	
	public PlanificaActividad_Controller(PlanificaActividad_Model model, PlanificaActividad_View view) {
		this.model = model;
		this.view = view;
		
		this.initView();
	}
	
	
	public void initView() {
		this.model.getListaInstalaciones();
		this.model.getPeriodos();
		view.getFrame().setVisible(true); 
	
	}
	
	public void getPeriodos() {
		List<PeriodosInscripcion> periodos = model.getPeriodos();
		this.view.addPeriodo(periodos);
	}
	
	public void getIntalaciones() {
		List<Instalaciones> intalaciones = model.getListaInstalaciones();
		this.view.addIntalaciones(intalaciones);
	}
	
	public void crearActividad() {
		if(view.getTextFieldNombre().equals("") || view.getTextFieldTipo().equals("") || Integer.parseInt(view.getTextFieldNoSocios().getText())<0 || Integer.parseInt(view.getTextFieldSocios().getText())<0)
			SwingUtil.showMessage("Hay por los menos un campo vacio ", "ERROR", JOptionPane.ERROR_MESSAGE);
		else if(view.getdCini().getDate().after(view.getDcFinSocios().getDate())){
			SwingUtil.showMessage("la fecha de fin es antes que la de inicio ", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
