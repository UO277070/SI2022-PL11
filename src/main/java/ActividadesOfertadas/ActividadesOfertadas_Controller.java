package ActividadesOfertadas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import giis.demo.util.SwingUtil;

public class ActividadesOfertadas_Controller {
	private ActividadesOfertadas_Model model;
	private ActividadesOfertadas_View view;
	
	public ActividadesOfertadas_Controller(ActividadesOfertadas_Model model, ActividadesOfertadas_View view) {
		this.model = model;
		this.view = view;
		
		this.initView();
	}
	
	public void initView() {
		this.getPeriodos();
		view.getFrame().setVisible(true);
	}
	
	public void initController() {
		view.getbotonVer().addActionListener((e  -> getListaActividades()));
	}
	
	public void getListaActividades() {
		String periodo = view.getPeriodo().getSelectedObjects()[0].toString();
		
		List <Actividades> actividades = model.getListaActividades(periodo);
		
		TableModel tmodel = SwingUtil.getTableModelFromPojos(actividades, new String[] {"nombre", "tipo", "fechaini", "fechafin", "plazas", "precio", "precionosocio"});
		view.getTable().setModel(tmodel);
	}
	
	public void getPeriodos() {
		List<Object[]> periodos = model.getListaPeriodos();
		
		ComboBoxModel combo = SwingUtil.getComboModelFromList(periodos);
		view.getPeriodo().setModel(combo); 
	}
	
	
}
