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

public class ActividadesOfertadas_View {

	private JFrame frmActividadesOfertadas;
	private JTable table;

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
		frmActividadesOfertadas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmActividadesOfertadas.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Periodo:");
		lblNewLabel.setBounds(10, 15, 47, 14);
		frmActividadesOfertadas.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(67, 15, 73, 18);
		frmActividadesOfertadas.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 452, 184);
		frmActividadesOfertadas.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nombre", "Tipo", "Fecha Inicio", "Fecha Fin", "Plazas", "Precio Socio", null},
			},
			new String[] {
				"Nombre", "Tipo", "Fecha Inicio", "Fecha Fin", "Plazas", "Precio Socio", "Precio No Socio"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(88);
		scrollPane.setRowHeaderView(table);
		
		JButton btnNewButton = new JButton("Ver Actividades Ofertadas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(271, 235, 191, 23);
		frmActividadesOfertadas.getContentPane().add(btnNewButton);
		
		table.getTableHeader().setVisible(true);
	}
}
