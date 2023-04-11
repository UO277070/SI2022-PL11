package ActividadesOfertadas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ActividadesOfertadas_View {

	private JFrame frmActividadesOfertadas;
	private JTable table;
	private JComboBox periodo;
	private JButton botonVer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActividadesOfertadas_View window = new ActividadesOfertadas_View();
					window.frmActividadesOfertadas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getFrame() {
		return frmActividadesOfertadas;
	}

	public void setFrame(JFrame frame) {
		this.frmActividadesOfertadas = frame;
	}
	
	/**
	 * Create the application.
	 */
	public ActividadesOfertadas_View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmActividadesOfertadas = new JFrame();
		frmActividadesOfertadas.setTitle("Actividades Ofertadas");
		frmActividadesOfertadas.setBounds(100, 100, 505, 300);
		frmActividadesOfertadas.getContentPane().setLayout(null);
		
		JLabel LabelPeriodo = new JLabel("Periodo:");
		LabelPeriodo.setBounds(10, 15, 47, 14);
		frmActividadesOfertadas.getContentPane().add(LabelPeriodo);
		
		periodo = new JComboBox();
		periodo.setBounds(67, 15, 96, 18);
		frmActividadesOfertadas.getContentPane().add(periodo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 469, 184);
		frmActividadesOfertadas.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Tipo", "Fecha Inicio", "Fecha Fin", "Plazas", "Precio Socio", "Precio No Socio"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(52);
		table.getColumnModel().getColumn(4).setPreferredWidth(44);
		table.getColumnModel().getColumn(6).setPreferredWidth(88);
		scrollPane.setViewportView(table);
		
		botonVer = new JButton("Ver Actividades Ofertadas");
		botonVer.setBounds(271, 235, 191, 23);
		frmActividadesOfertadas.getContentPane().add(botonVer);
		
		table.getTableHeader().setVisible(true);
	}

	public JComboBox getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(JComboBox periodo) {
		this.periodo = periodo;
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public JButton getbotonVer() {
		return botonVer;
	}
	
	public void setbotonVer(JButton ver) {
		this.botonVer = ver;
	}
	
	
}
