package SocioVerDisponibilidadInstalaciones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DisponibilidadInstalacionesView {

	private JFrame frame;
	private JTable tDisponInstal;
	
	String ruta="C:\\Users\\User\\Desktop\\Sistemas Informacion";
	
	JPanel panel = new JPanel();
	JButton btnVerDisponb = new JButton("Ver disponibilidad");
	JComboBox cbSelecInst = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisponibilidadInstalacionesView window = new DisponibilidadInstalacionesView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DisponibilidadInstalacionesView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccionar instalación:");
		lblNewLabel.setBounds(15, 16, 174, 20);
		frame.getContentPane().add(lblNewLabel);
		
		cbSelecInst.setBounds(204, 12, 181, 28);
		frame.getContentPane().add(cbSelecInst);
		
		btnVerDisponb.setBounds(465, 12, 159, 29);
		frame.getContentPane().add(btnVerDisponb);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 52, 674, 282);
		frame.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(panel);
		
		tDisponInstal = new JTable();
		tDisponInstal.setModel(new DefaultTableModel(
			new Object[][] {
				{"Horas", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"8:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"9:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"10:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"11:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"12:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"13:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"14:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"15:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"16:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"17:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"18:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"19:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"20:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{"21:00", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		panel.add(tDisponInstal);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public JComboBox<Object> getcbSelecInst(){
		return cbSelecInst;
	}
	
	public void setcbSelecInst(JComboBox<Object> cbSelecInst) {
		this.cbSelecInst = cbSelecInst ;
	}
	
	public JButton getbtnVerDisponb() {
		return btnVerDisponb;
	}
	
	public void setbtnVerDisponb(JButton btnVerDisponb) {
		this.btnVerDisponb = btnVerDisponb;
	}
	
	public JPanel getContentPane() {
		return panel;
	}

	public void setContentPane(JPanel contentPane) {
		this.panel = contentPane;
	}
	
	public JTable getTDisponInstal() {
		return tDisponInstal;
	}

	public void setTDisponInstal(JTable tDisponInstal) {
		this.tDisponInstal = tDisponInstal;
	}

}
