package AdmCrearPeriodoInscripcion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PeriodoInscripcion extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombrePeriodo;
	private JButton btnCrear;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PeriodoInscripcion frame = new PeriodoInscripcion();
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
	public PeriodoInscripcion() {
		setTitle("Crear periodo de inscripción para una actividad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nombre periodo inscrición:");
		lblNewLabel.setBounds(15, 40, 132, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha inicio:");
		lblNewLabel_1.setBounds(15, 81, 86, 14);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha fin socio:");
		lblNewLabel_2.setBounds(15, 119, 157, 14);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha fin NO socio:");
		lblNewLabel_3.setBounds(15, 157, 109, 14);
		
		JDateChooser dcInicio = new JDateChooser();
		dcInicio.setBounds(176, 75, 70, 20);
		
		JDateChooser dcFinSocio = new JDateChooser();
		dcFinSocio.setBounds(176, 113, 70, 20);
		
		JDateChooser dcFinNoSocio = new JDateChooser();
		dcFinNoSocio.setBounds(176, 151, 70, 20);
		
		tfNombrePeriodo = new JTextField();
		tfNombrePeriodo.setBounds(176, 37, 170, 20);
		tfNombrePeriodo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Descripción:");
		lblNewLabel_4.setBounds(15, 189, 79, 14);
		
		JTextArea taDescripcion = new JTextArea();
		taDescripcion.setBounds(94, 194, 157, 58);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_4);
		contentPane.add(taDescripcion);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_1);
		contentPane.add(dcInicio);
		contentPane.add(dcFinSocio);
		contentPane.add(tfNombrePeriodo);
		contentPane.add(dcFinNoSocio);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(317, 270, 89, 23);
		contentPane.add(btnCrear);
	}
}
