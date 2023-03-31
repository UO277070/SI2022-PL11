package pagosSocio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class PagosView extends JFrame {

	private JPanel contentPane;
	private JTable tablePagos;
	private JLabel lblTipo;
	private JLabel lblFecha;
	private JLabel lblHora;
	private JLabel lblActIns;
	private JLabel lblCantidad;

	
	/**
	 * Create the frame.
	 */
	public PagosView() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		tablePagos = new JTable();
		tablePagos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Fecha", "Cantidad", "New column"
			}
		));
		scrollPane.setViewportView(tablePagos);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos del pago");
		lblNewLabel.setBounds(10, 11, 87, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo:");
		lblNewLabel_1.setBounds(10, 36, 30, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha:");
		lblNewLabel_2.setBounds(10, 64, 38, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hora:");
		lblNewLabel_3.setBounds(137, 64, 31, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Instalación/Actividad:");
		lblNewLabel_4.setBounds(10, 97, 124, 16);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad:");
		lblNewLabel_5.setBounds(10, 153, 55, 16);
		panel.add(lblNewLabel_5);
		
		lblTipo = new JLabel("");
		lblTipo.setBounds(41, 36, 105, 16);
		panel.add(lblTipo);
		
		lblFecha = new JLabel("");
		lblFecha.setBounds(51, 64, 74, 16);
		panel.add(lblFecha);
		
		lblHora = new JLabel("");
		lblHora.setBounds(172, 64, 56, 16);
		panel.add(lblHora);
		
		lblActIns = new JLabel("");
		lblActIns.setBounds(10, 114, 193, 16);
		panel.add(lblActIns);
		
		lblCantidad = new JLabel("");
		lblCantidad.setBounds(67, 153, 56, 16);
		panel.add(lblCantidad);
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
	public JTable getTablePagos() {
		return tablePagos;
	}
	public JLabel getLblTipo() {
		return lblTipo;
	}
	public JLabel getLblFecha() {
		return lblFecha;
	}
	public JLabel getLblHora() {
		return lblHora;
	}
	public JLabel getLblActIns() {
		return lblActIns;
	}
	public JLabel getLblCantidad() {
		return lblCantidad;
	}
	
	
}
