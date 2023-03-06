package reservaInstalacionSocio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ReservaInstalacionSocio extends JFrame {

	private JPanel contentPane;
	private JTextField tFSocio;
	private final ButtonGroup bGPago = new ButtonGroup();
	private JComboBox cBInstalacion;
	private JLabel lblCosteTotal;
	private JSpinner spHoras;
	private JComboBox cBListaFechas;
	private JComboBox cBListaHoras;
	private JButton btnReservar;
	private JRadioButton rdbtnPagoInstalacion;
	private JRadioButton rdbtnCuotaMensual;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ReservaInstalacionSocio() {
		initComponents();
	}
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 57, 48, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Socio:");
		lblNewLabel_1.setBounds(20, 83, 38, 14);
		contentPane.add(lblNewLabel_1);
		
		tFSocio = new JTextField();
		tFSocio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()<'0'||e.getKeyChar()>'9') {
					e.consume();
				}
			}
		});
		tFSocio.setBounds(61, 80, 144, 20);
		contentPane.add(tFSocio);
		tFSocio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de reserva:");
		lblNewLabel_2.setBounds(20, 112, 113, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hora:");
		lblNewLabel_3.setBounds(20, 143, 48, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nº de horas:");
		lblNewLabel_4.setBounds(20, 179, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Instalación:");
		lblNewLabel_5.setBounds(10, 15, 84, 14);
		contentPane.add(lblNewLabel_5);
		
		spHoras = new JSpinner();
		spHoras.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		spHoras.setBounds(101, 176, 30, 20);
		contentPane.add(spHoras);
		
		cBInstalacion = new JComboBox();
		cBInstalacion.setBounds(78, 11, 144, 22);
		contentPane.add(cBInstalacion);
		
		JLabel lblNewLabel_6 = new JLabel("Coste total:");
		lblNewLabel_6.setBounds(17, 226, 84, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Forma de pago");
		lblNewLabel_7.setBounds(221, 226, 106, 14);
		contentPane.add(lblNewLabel_7);
		
		rdbtnPagoInstalacion = new JRadioButton("Pago en instalación");
		rdbtnPagoInstalacion.setSelected(true);
		bGPago.add(rdbtnPagoInstalacion);
		rdbtnPagoInstalacion.setBounds(234, 249, 144, 23);
		contentPane.add(rdbtnPagoInstalacion);
		
		rdbtnCuotaMensual = new JRadioButton("Cantidad añadida a su cuota mensual");
		bGPago.add(rdbtnCuotaMensual);
		rdbtnCuotaMensual.setBounds(234, 277, 267, 23);
		contentPane.add(rdbtnCuotaMensual);
		
		btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnReservar.setBounds(12, 310, 89, 23);
		contentPane.add(btnReservar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(396, 310, 89, 23);
		contentPane.add(btnCancelar);
		
		lblCosteTotal = new JLabel("");
		lblCosteTotal.setBounds(89, 224, 38, 16);
		contentPane.add(lblCosteTotal);
		
		cBListaHoras = new JComboBox();
		cBListaHoras.setBounds(62, 138, 143, 25);
		contentPane.add(cBListaHoras);
		
		cBListaFechas = new JComboBox();
		cBListaFechas.setBounds(132, 107, 126, 25);
		contentPane.add(cBListaFechas);
	}
	
	public JComboBox getcBInstalaciones() {
		return this.cBInstalacion;
	}
	public ReservaInstalacionSocio getFrame() {
		return this;
	}

	public JLabel getLblCosteTotal() {
		return lblCosteTotal;
	}

	public JSpinner getSpHoras() {
		return spHoras;
	}

	public JComboBox getcBListaFechas() {
		return cBListaFechas;
	}

	public JComboBox getcBListaHoras() {
		return cBListaHoras;
	}

	public JButton getBtnReservar() {
		return btnReservar;
	}

	public JRadioButton getRdbtnPagoInstalacion() {
		return rdbtnPagoInstalacion;
	}

	public JRadioButton getRdbtnCuotaMensual() {
		return rdbtnCuotaMensual;
	}

	public JTextField gettFSocio() {
		return tFSocio;
	}
}
