package consultarReservas;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import giis.demo.util.SwingUtil;

public class ConsultasController {
	private ConsultasModel model;
	private ConsultasView view;
	
	public ConsultasController(ConsultasModel rm, ConsultasView ri) {
		this.model = rm;
		this.view = ri;
		initView();
	}
	
	public void initController() {
		//ActionListener define solo un metodo actionPerformed(), es un interfaz funcional que se puede invocar de la siguiente forma:
		//view.getBtnTablaCarreras().addActionListener(e -> getListaCarreras());
		//ademas invoco el metodo que responde al listener en el exceptionWrapper para que se encargue de las excepciones
		view.getcBListaInstalaciones().addItemListener(e -> rellenaTabla());
	}
	
	public void initView() {
		//Inicializa la fecha de hoy a un valor que permitira mostrar carreras en diferentes fases 
		//y actualiza los datos de la vista
		this.getListaInstalacion();
		this.rellenaTabla();
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 
	}
	
	public void getListaInstalacion() {
		//A modo de demo, se muestra tambien la misma informacion en forma de lista en un combobox
		List<Object[]> instalacionList=model.getInstalaciones();
		ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(instalacionList);
		view.getcBListaInstalaciones().setModel(lmodel);
	}
	
	public class StatusColumnCellRenderer extends DefaultTableCellRenderer {
		  @Override
		  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {

		    //Cells are by default rendered as a JLabel.
		    JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

		    //Get the status for the current row.
		    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		    if (value == "L") {
		    	l.setBackground(Color.GREEN);
		    }
		    else {
		    	l.setBackground(Color.red);
		    }
		    
		 // Centrar las celdas de la tabla
			//DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			this.setHorizontalAlignment( JLabel.CENTER );
			//table.setDefaultRenderer(Object.class, centerRenderer);
	

		  //Return the JLabel which renders the cell.
		  return l;

		}
	}
	
	public void rellenaTabla() {
		// Rellenar fechas de la tabla
		SimpleDateFormat formato =new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String fechas[] = new String[31];
		fechas[0] = "Hora";
		for(int i = 1; i<31;i++) {
			fechas[i] = ""+formato.format(cal.getTime());
			cal.add(Calendar.DATE, 1); 
		}
		Object columnas[][] = new Object[13][31];
		for(int i = 0; i<13; i++) {
			columnas[i][0] = String.format("%d-%d", 8+i,9+i );
		}
		for(int i = 0; i<13;i++) {
			for(int j = 1; j<31;j++) {
				columnas[i][j] = "L";
			}
		}
		actualizaTabla(fechas,columnas);
		for(int i = 1; i<31; i++) {
			view.getTable().getColumnModel().getColumn(i).setCellRenderer(new StatusColumnCellRenderer());
		}
	}
	
	public void actualizaTabla(String[] fechas, Object[][] columnas) {
		List<Object[]> lista;
		int horaini;
		int horafin;
		String cliente;
		String instalacion = view.getcBListaInstalaciones().getSelectedItem().toString();
		for(int i = 1;i<31;i++) {
			lista = model.getReservas(fechas[i], instalacion);
			for(int k = 0;k<lista.size();k++) {	
				System.out.print(""+lista.get(k)[0]+lista.get(k)[1]+lista.get(k)[2]);
				horaini = (int)lista.get(k)[1];
				horafin = (int)lista.get(k)[2];
				cliente = (String)lista.get(k)[0];
				if(horafin-horaini == 1) {
					columnas[horaini-8][i] = cliente;
				}
				else {
					for(int j = 0; j<(horafin-horaini);j++) {
						columnas[(horaini+j)-8][i] = cliente;
					}
				}
			}
		}
		view.getTable().setModel(new DefaultTableModel(columnas,fechas));
		view.getTable().getColumnModel().getColumn(0).setPreferredWidth(36);
		view.getTable().getColumnModel().getColumn(0).setMinWidth(36);
	}
	
}
