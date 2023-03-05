package AdmCrearPeriodoInscripcion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CrearPeriodoInscripcion extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombrePI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPeriodoInscripcion frame = new CrearPeriodoInscripcion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrearPeriodoInscripcion() {
		setTitle("Crear periodo de inscripción");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre periodo de inscripción:");
		lblNewLabel.setBounds(39, 37, 158, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha inicio:");
		lblNewLabel_1.setBounds(39, 84, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha fin socios:");
		lblNewLabel_2.setBounds(39, 124, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha fin no socios:");
		lblNewLabel_3.setBounds(39, 164, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		JDateChooser dcInicio = new JDateChooser();
		dcInicio.setBounds(182, 84, 70, 20);
		contentPane.add(dcInicio);
		
		JDateChooser dcFinSocios = new JDateChooser();
		dcFinSocios.setBounds(182, 124, 70, 20);
		contentPane.add(dcFinSocios);
		
		JDateChooser dcFinNoSocios = new JDateChooser();
		dcFinNoSocios.setBounds(182, 164, 70, 20);
		contentPane.add(dcFinNoSocios);
		
		tfNombrePI = new JTextField();
		tfNombrePI.setBounds(207, 34, 137, 20);
		contentPane.add(tfNombrePI);
		tfNombrePI.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(335, 227, 89, 23);
		contentPane.add(btnCrear);
	}
}
