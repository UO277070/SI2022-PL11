package InscribirSocio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class InscribirSocioV {

	private JFrame frmInscribirseAActividad;
	private JComboBox comboBoxActividad;
	private JTextField labelTipoCambio;
	private JTextField labelPrecioCambio;
	private JTextField labelFechaIniCambio;
	private JTextField labelFechaFinCambio;
	private JTextField labelHoraIniCambio;
	private JTextField labelHoraFinCambio;
	private JTextField labelDiasCambio;
	private JTextField labelAforoCambio;
	private JButton buttonInscribir;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscribirSocioV window = new InscribirSocioV();
					window.frmInscribirseAActividad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InscribirSocioV() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInscribirseAActividad = new JFrame();
		frmInscribirseAActividad.setTitle("Inscribirse a Actividad");
		frmInscribirseAActividad.setBounds(100, 100, 450, 300);
		frmInscribirseAActividad.getContentPane().setLayout(null);
		
		JLabel labelActividad = new JLabel("Actividad:");
		labelActividad.setBounds(10, 25, 48, 14);
		frmInscribirseAActividad.getContentPane().add(labelActividad);
		
		JComboBox comboBoxActividad = new JComboBox();
		comboBoxActividad.setBounds(68, 21, 124, 22);
		frmInscribirseAActividad.getContentPane().add(comboBoxActividad);
		
		JLabel labelTipo = new JLabel("Tipo:");
		labelTipo.setBounds(10, 57, 46, 14);
		frmInscribirseAActividad.getContentPane().add(labelTipo);
		
		JLabel labelPrecio = new JLabel("Precio:");
		labelPrecio.setBounds(10, 82, 33, 14);
		frmInscribirseAActividad.getContentPane().add(labelPrecio);
		
		JLabel labelFechaIni = new JLabel("Fecha de Inicio:");
		labelFechaIni.setBounds(10, 107, 76, 14);
		frmInscribirseAActividad.getContentPane().add(labelFechaIni);
		
		JLabel labelFechaFin = new JLabel("Fecha de Fin:");
		labelFechaFin.setBounds(10, 132, 65, 14);
		frmInscribirseAActividad.getContentPane().add(labelFechaFin);
		
		JLabel labelHoraIni = new JLabel("Hora de Inicio:");
		labelHoraIni.setBounds(10, 157, 70, 14);
		frmInscribirseAActividad.getContentPane().add(labelHoraIni);
		
		JLabel labelHoraFin = new JLabel("Hora de Fin:");
		labelHoraFin.setBounds(10, 182, 59, 14);
		frmInscribirseAActividad.getContentPane().add(labelHoraFin);
		
		JLabel labelDias = new JLabel("Días de Realización:");
		labelDias.setBounds(10, 205, 95, 14);
		frmInscribirseAActividad.getContentPane().add(labelDias);
		
		JLabel labelAforo = new JLabel("Aforo:");
		labelAforo.setBounds(10, 230, 31, 14);
		frmInscribirseAActividad.getContentPane().add(labelAforo);
		
		JButton buttonInscribir = new JButton("Inscribir");
		buttonInscribir.setBounds(335, 226, 71, 23);
		frmInscribirseAActividad.getContentPane().add(buttonInscribir);
		
		JLabel labelTipoCambio = new JLabel("");
		labelTipoCambio.setBounds(119, 57, 46, 14);
		frmInscribirseAActividad.getContentPane().add(labelTipoCambio);
		
		JLabel labelPrecioCambio = new JLabel("");
		labelPrecioCambio.setBounds(119, 82, 46, 14);
		frmInscribirseAActividad.getContentPane().add(labelPrecioCambio);
		
		JLabel labelFechaIniCambio = new JLabel("");
		labelFechaIniCambio.setBounds(119, 107, 46, 14);
		frmInscribirseAActividad.getContentPane().add(labelFechaIniCambio);
		
		JLabel labelFechaFinCambio = new JLabel("");
		labelFechaFinCambio.setBounds(119, 132, 46, 14);
		frmInscribirseAActividad.getContentPane().add(labelFechaFinCambio);
		
		JLabel labelHoraIniCambio = new JLabel("");
		labelHoraIniCambio.setEnabled(true);
		labelHoraIniCambio.setBounds(119, 157, 46, 14);
		frmInscribirseAActividad.getContentPane().add(labelHoraIniCambio);
		
		JLabel labelHoraFinCambio = new JLabel("");
		labelHoraFinCambio.setBounds(119, 182, 46, 14);
		frmInscribirseAActividad.getContentPane().add(labelHoraFinCambio);
		
		JLabel labelDiasCambio = new JLabel("");
		labelDiasCambio.setBounds(119, 205, 46, 14);
		frmInscribirseAActividad.getContentPane().add(labelDiasCambio);
		
		JLabel labelAforoCambio = new JLabel("");
		labelAforoCambio.setBounds(119, 230, 46, 14);
		frmInscribirseAActividad.getContentPane().add(labelAforoCambio);
	}

	public JFrame getFrmInscribirseAActividad() {
		return frmInscribirseAActividad;
	}

	public void setFrmInscribirseAActividad(JFrame frmInscribirseAActividad) {
		this.frmInscribirseAActividad = frmInscribirseAActividad;
	}

	public JComboBox getComboBoxActividad() {
		return comboBoxActividad;
	}

	public void setComboBoxActividad(JComboBox comboBoxActividad) {
		this.comboBoxActividad = comboBoxActividad;
	}

	public JTextField getLabelTipo() {
		return labelTipoCambio;
	}

	public void setLabelTipo(JTextField labelTipo) {
		this.labelTipoCambio = labelTipo;
	}

	public JTextField getLabelPrecio() {
		return labelPrecioCambio;
	}

	public void setLabelPrecio(JTextField labelPrecio) {
		this.labelPrecioCambio = labelPrecio;
	}

	public JTextField getLabelFechaIni() {
		return labelFechaIniCambio;
	}

	public void setLabelFechaIni(JTextField labelFechaIni) {
		this.labelFechaIniCambio = labelFechaIni;
	}

	public JTextField getLabelFechaFin() {
		return labelFechaFinCambio;
	}

	public void setLabelFechaFin(JTextField labelFechaFin) {
		this.labelFechaFinCambio = labelFechaFin;
	}

	public JTextField getLabelHoraIni() {
		return labelHoraIniCambio;
	}

	public void setLabelHoraIni(JTextField labelHoraIni) {
		this.labelHoraIniCambio = labelHoraIni;
	}

	public JTextField getLabelHoraFin() {
		return labelHoraFinCambio;
	}

	public void setLabelHoraFin(JTextField labelHoraFin) {
		this.labelHoraFinCambio = labelHoraFin;
	}

	public JTextField getLabelDias() {
		return labelDiasCambio;
	}

	public void setLabelDias(JTextField labelDias) {
		this.labelDiasCambio = labelDias;
	}

	public JTextField getLabelAforo() {
		return labelAforoCambio;
	}

	public void setLabelAforo(JTextField labelAforo) {
		this.labelAforoCambio = labelAforo;
	}
	
	public JFrame getFrame() {
		return this.frmInscribirseAActividad;
	}

	public JButton getButtonInscribir() {
		return buttonInscribir;
	}

	public void setButtonInscribir(JButton buttonInscribir) {
		this.buttonInscribir = buttonInscribir;
	}
	
}
