package AdmCrearPeriodoInscripcion;

import javax.swing.JOptionPane;

import giis.demo.util.SwingUtil;

public class CrearPeriodoC {
	
	private CrearPeriodoM model;
	private CrearPeriodoInscripcionView view;
	
	public CrearPeriodoC(CrearPeriodoM m, CrearPeriodoInscripcionView a) {
		this.model = m;
		this.view =a;
		
		this.initView();
	}

	public void initController() {
		//Boton cerar peridodo
		view.getBtnCrear().addActionListener(e ->CrearPeriodo());
		//view.getBtnCrear(.addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaCarreras()));
		
	}
	
	public void initView() {
		view.getFrmCrearPeriodoDe().setVisible(true); 
	}

	
	public void CrearPeriodo(){
		
		//Comprobar que los campos no esten vacios
		if( view.getTfNombrePI().getText().equals("")||view.getDcInicio().getDate()==null||view.getDcFinSocios().getDate()==null||view.getDcFinNoSocios().getDate()==null){
			SwingUtil.showMessage("El Hay por lo menos un campo vacio ", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		///se compreuba que las fecahsa sean correctas 
		else if(view.getDcInicio().getDate().after(view.getDcFinSocios().getDate())){
			SwingUtil.showMessage("la fecha de fin es antes que la de inicio ", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else if(view.getDcFinSocios().getDate().after(view.getDcFinNoSocios().getDate())){
			SwingUtil.showMessage("la fecha de fin no socios es antes que la de fin de socios", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		//Todo correcto, se inserta
		else
			model.insertaPeriodo(view.getTfNombrePI().getText(), view.getDcInicio().getDate(), view.getDcFinSocios().getDate(), view.getDcFinNoSocios().getDate());

	}
	
	
	

}
