package ReservarInstalacionComoSocio;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import com.toedter.calendar.JCalendar;



public class ReservaSocio_Vista extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaSocio_Vista frame = new ReservaSocio_Vista();
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
	public ReservaSocio_Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecciona una Instalacion");
		lblNewLabel.setBounds(10, 10, 135, 29);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(196, 14, 112, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione la fecha de la reserva");
		lblNewLabel_1.setBounds(10, 66, 166, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hora inicial de la reserva");
		lblNewLabel_2.setBounds(10, 138, 135, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Hora final de la reserva");
		lblNewLabel_2_1.setBounds(10, 180, 142, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(155, 135, 30, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(155, 177, 30, 20);
		contentPane.add(spinner_1);
		
		
		// Referencias a otros ficheros
		model = new ReservaSocio_Model ();
		entity= new ReservaSocio_Entity ();
		dto = new ReservaSocio_DTO();
		controler = new ReservaSocio_Controler();	//hay que pasarle esta ventana de parametro
		
		calendario= new Calendar();
	}
	
	Calendar calendario;
	ReservaSocio_Model model;
	ReservaSocio_Entity entity;
	ReservaSocio_DTO dto;
	ReservaSocio_Controler controler;


	public void pepe () {		//con eso se sacan las fechas
		Date a =calendario.getCalendar().getDate();
		
		
	}


}
