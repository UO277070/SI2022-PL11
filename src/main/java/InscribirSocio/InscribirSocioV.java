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
	private JLabel labelTipoCambio;
	private JLabel labelPrecioCambio;
	private JLabel labelFechaIniCambio;
	private JLabel labelFechaFinCambio;
	private JLabel labelHoraIniCambio;
	private JLabel labelHoraFinCambio;
	private JLabel labelDiasCambio;
	private JLabel labelAforoCambio;
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
		
		comboBoxActividad = new JComboBox();
		comboBoxActividad.setBounds(68, 21, 124, 22);
		frmInscribirseAActividad.getContentPane().add(comboBoxActividad);
		
		JLabel labelTipo = new JLabel("Tipo:");
		labelTipo.setBounds(10, 57, 118, 14);
		frmInscribirseAActividad.getContentPane().add(labelTipo);
		
		JLabel labelPrecio = new JLabel("Precio:");
		labelPrecio.setBounds(10, 82, 118, 14);
		frmInscribirseAActividad.getContentPane().add(labelPrecio);
		
		JLabel labelFechaIni = new JLabel("Fecha de Inicio:");
		labelFechaIni.setBounds(10, 107, 118, 14);
		frmInscribirseAActividad.getContentPane().add(labelFechaIni);
		
		JLabel labelFechaFin = new JLabel("Fecha de Fin:");
		labelFechaFin.setBounds(10, 132, 118, 14);
		frmInscribirseAActividad.getContentPane().add(labelFechaFin);
		
		JLabel labelHoraIni = new JLabel("Hora de Inicio:");
		labelHoraIni.setBounds(10, 157, 118, 14);
		frmInscribirseAActividad.getContentPane().add(labelHoraIni);
		
		JLabel labelHoraFin = new JLabel("Hora de Fin:");
		labelHoraFin.setBounds(10, 182, 118, 14);
		frmInscribirseAActividad.getContentPane().add(labelHoraFin);
		
		JLabel labelDias = new JLabel("Días de Realización:");
		labelDias.setBounds(10, 205, 118, 14);
		frmInscribirseAActividad.getContentPane().add(labelDias);
		
		JLabel labelAforo = new JLabel("Aforo:");
		labelAforo.setBounds(10, 230, 118, 14);
		frmInscribirseAActividad.getContentPane().add(labelAforo);
		
		buttonInscribir = new JButton("Inscribir");
		buttonInscribir.setBounds(335, 226, 71, 23);
		frmInscribirseAActividad.getContentPane().add(buttonInscribir);
		
		labelTipoCambio = new JLabel("");
		labelTipoCambio.setBounds(119, 57, 143, 14);
		frmInscribirseAActividad.getContentPane().add(labelTipoCambio);
		
		labelPrecioCambio = new JLabel("");
		labelPrecioCambio.setBounds(119, 82, 143, 14);
		frmInscribirseAActividad.getContentPane().add(labelPrecioCambio);
		
		labelFechaIniCambio = new JLabel("");
		labelFechaIniCambio.setBounds(119, 107, 143, 14);
		frmInscribirseAActividad.getContentPane().add(labelFechaIniCambio);
		
		labelFechaFinCambio = new JLabel("");
		labelFechaFinCambio.setBounds(119, 132, 143, 14);
		frmInscribirseAActividad.getContentPane().add(labelFechaFinCambio);
		
		labelHoraIniCambio = new JLabel("");
		labelHoraIniCambio.setEnabled(true);
		labelHoraIniCambio.setBounds(119, 157, 143, 14);
		frmInscribirseAActividad.getContentPane().add(labelHoraIniCambio);
		
		labelHoraFinCambio = new JLabel("");
		labelHoraFinCambio.setBounds(119, 182, 143, 14);
		frmInscribirseAActividad.getContentPane().add(labelHoraFinCambio);
		
		labelDiasCambio = new JLabel("");
		labelDiasCambio.setBounds(119, 205, 143, 14);
		frmInscribirseAActividad.getContentPane().add(labelDiasCambio);
		
		labelAforoCambio = new JLabel("");
		labelAforoCambio.setBounds(119, 230, 143, 14);
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

	public JLabel getLabelTipo() {
		return labelTipoCambio;
	}

	public void setLabelTipo(JLabel labelTipo) {
		this.labelTipoCambio = labelTipo;
	}

	public JLabel getLabelPrecio() {
		return labelPrecioCambio;
	}

	public void setLabelPrecio(JLabel labelPrecio) {
		this.labelPrecioCambio = labelPrecio;
	}

	public JLabel getLabelFechaIni() {
		return labelFechaIniCambio;
	}

	public void setLabelFechaIni(JLabel labelFechaIni) {
		this.labelFechaIniCambio = labelFechaIni;
	}

	public JLabel getLabelFechaFin() {
		return labelFechaFinCambio;
	}

	public void setLabelFechaFin(JLabel labelFechaFin) {
		this.labelFechaFinCambio = labelFechaFin;
	}

	public JLabel getLabelHoraIni() {
		return labelHoraIniCambio;
	}

	public void setLabelHoraIni(JLabel labelHoraIni) {
		this.labelHoraIniCambio = labelHoraIni;
	}

	public JLabel getLabelHoraFin() {
		return labelHoraFinCambio;
	}

	public void setLabelHoraFin(JLabel labelHoraFin) {
		this.labelHoraFinCambio = labelHoraFin;
	}

	public JLabel getLabelDias() {
		return labelDiasCambio;
	}

	public void setLabelDias(JLabel labelDias) {
		this.labelDiasCambio = labelDias;
	}

	public JLabel getLabelAforo() {
		return labelAforoCambio;
	}

	public void setlabelAforo(JLabel labelAforo) {
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
