package InscribirAdmin;

import java.util.List;

import javax.swing.ComboBoxModel;

import ActividadesOfertadas.ActividadesOfertadas_Model;
import ActividadesOfertadas.ActividadesOfertadas_View;
import giis.demo.util.SwingUtil;
import loginSocio.SocioEntity;
import loginSocio.loginController;
import loginSocio.loginModel;
import loginSocio.loginView;

public class InscribirAdminC {
	
	private InscribirAdminM model;
	private InscribirAdminV view;
	private loginController controller;
	private SocioEntity socioLog;
	
	public InscribirAdminC(InscribirAdminM model, InscribirAdminV view) {
		this.model = model;
		this.view = view;
		
		this.initView();
	}
	
	public void initController() {
		
	}
	
	
	public void initView() {
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		controller=new loginController(new loginModel(), new loginView());
		controller.initController();
		boolean POK = controller.showDialog();
		if (POK) {
			socioLog = controller.getSocio();
		    view.getFrame().setVisible(true);
		}
	}
	
	
	public void getListaSocios() {
		List <Object[]> socios = model.getListaSocios();
		
		ComboBoxModel combo = SwingUtil.getComboModelFromList(socios) ;
	}
	
	public void getListaActividades() {
		
	}
}
