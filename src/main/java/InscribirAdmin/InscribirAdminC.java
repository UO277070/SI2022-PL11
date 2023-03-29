package InscribirAdmin;

import java.util.List;

import javax.swing.ComboBoxModel;

import ActividadesOfertadas.ActividadesOfertadas_Model;
import ActividadesOfertadas.ActividadesOfertadas_View;
import giis.demo.util.SwingUtil;

public class InscribirAdminC {
	
	private InscribirAdminM model;
	private InscribirAdminV view;
	
	public InscribirAdminC(InscribirAdminM model, InscribirAdminV view) {
		this.model = model;
		this.view = view;
		
		this.initView();
	}
	
	
	public void initView() {
		view.getFrame().setVisible(true);
	}
	
	
	public void getListaSocios() {
		List <Object[]> socios = model.getListaSocios();
		
		ComboBoxModel combo = SwingUtil.getComboModelFromList(socios) ;
	}
	
	public void getListaActividades() {
		
	}
}
