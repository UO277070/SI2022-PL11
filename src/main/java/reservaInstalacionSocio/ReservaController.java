package reservaInstalacionSocio;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ComboBoxModel;
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
		view.getListaInstalaciones().addItemListener(e -> getPrecio());
	}
	
	public void initView() {
		//Inicializa la fecha de hoy a un valor que permitira mostrar carreras en diferentes fases 
		//y actualiza los datos de la vista
		this.getListaInstalacion();
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 
	}
	
	public void getListaInstalacion() {
		//A modo de demo, se muestra tambien la misma informacion en forma de lista en un combobox
		List<Object[]> instalacionList=model.getInstalaciones();
		ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(instalacionList);
		view.getListaInstalaciones().setModel(lmodel);
	}
	
	public void getPrecio() {
		String nombre = ""+view.getListaInstalaciones().getSelectedItem();
		view.getLblCosteTotal().setText(""+model.getPrecio(nombre)*((Integer)view.getSpHoras().getValue()));
	}
}
