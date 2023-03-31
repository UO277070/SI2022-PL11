package pagosSocio;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import giis.demo.util.SwingUtil;
import loginSocio.SocioEntity;
import loginSocio.loginController;
import loginSocio.loginModel;
import loginSocio.loginView;

public class PagosController {
	private PagosModel model;
	private PagosView view;
	private SocioEntity socioLog;
	
	public PagosController(PagosModel rm, PagosView ri) {
		this.model = rm;
		this.view = ri;
		initView();
	}

	public void initController() {
		//view.getcBListaInstalaciones().addItemListener(e -> rellenaTabla());
		view.getTablePagos().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				getDatos();
			}
		});
	}

	public void initView() {
		//Inicializa los datos
		

		//Abre la ventana (sustituye al main generado por WindowBuilder)
		loginController controller=new loginController(new loginModel(), new loginView());
		controller.initController();
		boolean POK = controller.showDialog();
        if (POK) {
        	socioLog = controller.getSocio();
        	view.setVisible(true);
        	setSocio();
        	getPagos();
        }
	}
	
	public void setSocio() {
		view.setTitle("Sesión iniciada como: " + socioLog.getNombre());
	}
	
	public void getPagos() {
		List<Object []> pagos = model.getPagos(socioLog.getIdSocio());
		Object datos[][] = new Object[pagos.size()][3];
		for(int i=0; i<pagos.size(); i++) {
			datos[i][1] = pagos.get(i)[0];
			datos[i][2] = pagos.get(i)[1];
			datos[i][0] = pagos.get(i)[2];
		}
		
		DefaultTableModel model = new DefaultTableModel(datos,
				new String[] {
					"idPago", "Fecha", "Cantidad"
				}
		);
		view.getTablePagos().setModel(model);
	}
	
	public String getSelectedKey(JTable table) {
		int row=table.getSelectedRow(); //el item de primera columna es el id de carrera
		if (row>=0)
			return table.getModel().getValueAt(row,0).toString();
		else //no hay filas seleccionadas
			return "";
	}
	
	public void getDatos() {
		int id = Integer.parseInt(getSelectedKey(view.getTablePagos()));
		Object [] datos = model.getPagoDatos(id);
		view.getLblCantidad().setText(""+datos[0]);
		view.getLblFecha().setText(""+datos[1]);
		view.getLblHora().setText(datos[2]+"-"+datos[3]);
		if (datos[4]==null){
			view.getLblActIns().setText(""+datos[6]);
			view.getLblTipo().setText("Reserva");
		}
		else {
			view.getLblActIns().setText(""+datos[5]);
			view.getLblTipo().setText("Actividad");
		}
	}
}
