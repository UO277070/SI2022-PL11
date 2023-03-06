package AdmCrearPeriodoInscripcion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CrearPeriodoInscripcionView {

	private JFrame frmCrearPeriodoDe;
	private JTextField tfNombrePI;
	
	JDateChooser dcInicio = new JDateChooser();
	JDateChooser dcFinSocios = new JDateChooser();
	JDateChooser dcFinNoSocios = new JDateChooser();
	JButton btnCrear = new JButton("Crear");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPeriodoInscripcionView window = new CrearPeriodoInscripcionView();
					window.frmCrearPeriodoDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrearPeriodoInscripcionView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrearPeriodoDe = new JFrame();
		frmCrearPeriodoDe.setTitle("Crear periodo de inscripción");
		frmCrearPeriodoDe.setBounds(100, 100, 560, 330);
		frmCrearPeriodoDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrearPeriodoDe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre periodo de inscripción: ");
		lblNewLabel.setBounds(33, 35, 246, 20);
		frmCrearPeriodoDe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha inicio:");
		lblNewLabel_1.setBounds(33, 85, 101, 20);
		frmCrearPeriodoDe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha fin socios:");
		lblNewLabel_2.setBounds(33, 127, 141, 20);
		frmCrearPeriodoDe.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha fin no socios:");
		lblNewLabel_3.setBounds(33, 163, 141, 20);
		frmCrearPeriodoDe.getContentPane().add(lblNewLabel_3);
		
		dcInicio.setBounds(219, 85, 91, 26);
		frmCrearPeriodoDe.getContentPane().add(dcInicio);
		
		dcFinSocios.setBounds(219, 121, 91, 26);
		frmCrearPeriodoDe.getContentPane().add(dcFinSocios);
		
		dcFinNoSocios.setBounds(219, 157, 91, 26);
		frmCrearPeriodoDe.getContentPane().add(dcFinNoSocios);
		
		tfNombrePI = new JTextField();
		tfNombrePI.setBounds(294, 32, 193, 26);
		frmCrearPeriodoDe.getContentPane().add(tfNombrePI);
		tfNombrePI.setColumns(10);
		
		btnCrear.setBounds(414, 246, 115, 29);
		frmCrearPeriodoDe.getContentPane().add(btnCrear);
	}

	public JTextField getTfNombrePI() {
		return tfNombrePI;
	}

	public void setTfNombrePI(JTextField tfNombrePI) {
		this.tfNombrePI = tfNombrePI;
	}

	public JDateChooser getDcInicio() {
		return dcInicio;
	}

	public void setDcInicio(JDateChooser dcInicio) {
		this.dcInicio = dcInicio;
	}

	public JDateChooser getDcFinSocios() {
		return dcFinSocios;
	}

	public void setDcFinSocios(JDateChooser dcFinSocios) {
		this.dcFinSocios = dcFinSocios;
	}

	public JDateChooser getDcFinNoSocios() {
		return dcFinNoSocios;
	}

	public void setDcFinNoSocios(JDateChooser dcFinNoSocios) {
		this.dcFinNoSocios = dcFinNoSocios;
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(JButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	public JFrame getFrmCrearPeriodoDe() {
		return frmCrearPeriodoDe;
	}

	public void setFrmCrearPeriodoDe(JFrame frmCrearPeriodoDe) {
		this.frmCrearPeriodoDe = frmCrearPeriodoDe;
	}
	
	
}
