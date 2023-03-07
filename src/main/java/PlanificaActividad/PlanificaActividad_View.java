package PlanificaActividad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.SpinnerListModel;

public class PlanificaActividad_View {

	private JFrame frmPlanificarActividad;
	private JTextField textFieldSocios;
	private JTextField textFieldNoSocios;
	private JTextField textFieldNombre;
	private JCalendar calendar;
	private JTextField textFieldTipo;
	private JComboBox comboBoxInstalacion, comboBoxPeriodo;
	private JDateChooser dCini, dCfin;
	private JTable tableDias;
	private JSpinner spinnerLunesIni;
	private JSpinner spinnerLunesFin;
	private JSpinner spinnerMartesIni;
	private JSpinner spinnerMartesFin;
	private JSpinner spinnerMiercolesIni;
	private JSpinner spinnerMiercolesFin;
	private JSpinner spinnerJuevesIni;
	private JSpinner spinnerJuevesFin;
	private JSpinner spinnerViernesIni;
	private JSpinner spinnerViernesFin;
	private JSpinner spinnerSabadoIni;
	private JSpinner spinnerSabadoFin;
	private JSpinner spinnerDomingoIni;
	private JSpinner spinnerDomingoFin;
	private JSpinner spinnerAforo;
	
	private JButton ButtonCrear = new JButton();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanificaActividad_View window = new PlanificaActividad_View();
					window.frmPlanificarActividad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlanificaActividad_View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlanificarActividad = new JFrame();
		frmPlanificarActividad.setTitle("Planificar Actividad");
		frmPlanificarActividad.setBounds(100, 100, 620, 396);
		frmPlanificarActividad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlanificarActividad.getContentPane().setLayout(null);
		
		JLabel LabelInstalacion = new JLabel("Instalación:");
		LabelInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelInstalacion.setBounds(412, 11, 74, 14);
		frmPlanificarActividad.getContentPane().add(LabelInstalacion);
		
		JComboBox comboBoxInstalacion = new JComboBox();
		comboBoxInstalacion.setBounds(412, 36, 162, 22);
		frmPlanificarActividad.getContentPane().add(comboBoxInstalacion);
		
		JLabel LabelActvividad = new JLabel("Tipo de Actividad:");
		LabelActvividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelActvividad.setBounds(228, 7, 132, 22);
		frmPlanificarActividad.getContentPane().add(LabelActvividad);
		
		JLabel LabelAforo = new JLabel("Aforo:");
		LabelAforo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelAforo.setBounds(10, 67, 59, 14);
		frmPlanificarActividad.getContentPane().add(LabelAforo);
		
		JSpinner spinnerAforo = new JSpinner();
		spinnerAforo.setBounds(10, 92, 59, 20);
		frmPlanificarActividad.getContentPane().add(spinnerAforo);
		
		JLabel LabelSocios = new JLabel("Cuota Socios:\r\n");
		LabelSocios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelSocios.setBounds(110, 67, 89, 14);
		frmPlanificarActividad.getContentPane().add(LabelSocios);
		
		JLabel LabelNoSocios = new JLabel("Cuota No Socios:\r\n");
		LabelNoSocios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelNoSocios.setBounds(228, 69, 114, 14);
		frmPlanificarActividad.getContentPane().add(LabelNoSocios);
		
		textFieldSocios = new JTextField();
		textFieldSocios.setBounds(110, 92, 74, 20);
		frmPlanificarActividad.getContentPane().add(textFieldSocios);
		textFieldSocios.setColumns(10);
		
		textFieldNoSocios = new JTextField();
		textFieldNoSocios.setColumns(10);
		textFieldNoSocios.setBounds(228, 92, 74, 20);
		frmPlanificarActividad.getContentPane().add(textFieldNoSocios);
		
		JLabel LabelInscripcion = new JLabel("Periodo de Inscripción:");
		LabelInscripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelInscripcion.setBounds(412, 67, 154, 14);
		frmPlanificarActividad.getContentPane().add(LabelInscripcion);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 136, 584, 2);
		frmPlanificarActividad.getContentPane().add(separator);
		
		JButton ButtonCrear = new JButton("Crear");
		ButtonCrear.setBounds(520, 323, 74, 23);
		frmPlanificarActividad.getContentPane().add(ButtonCrear);
		
		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelNombre.setBounds(10, 11, 59, 14);
		frmPlanificarActividad.getContentPane().add(LabelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(10, 36, 162, 20);
		frmPlanificarActividad.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JComboBox comboBoxPeriodo = new JComboBox();
		comboBoxPeriodo.setBounds(412, 91, 167, 22);
		frmPlanificarActividad.getContentPane().add(comboBoxPeriodo);
		
		JDateChooser dCini = new JDateChooser();
		dCini.setBounds(458, 224, 95, 20);
		frmPlanificarActividad.getContentPane().add(dCini);
		
		JDateChooser dCini_1 = new JDateChooser();
		dCini_1.setBounds(458, 280, 95, 20);
		frmPlanificarActividad.getContentPane().add(dCini_1);
		
		JLabel LabelDuracion = new JLabel("Duración:");
		LabelDuracion.setBounds(483, 176, 59, 14);
		frmPlanificarActividad.getContentPane().add(LabelDuracion);
		
		JLabel LabelInicio = new JLabel("Fecha Incio:");
		LabelInicio.setBounds(458, 199, 82, 14);
		frmPlanificarActividad.getContentPane().add(LabelInicio);
		
		JLabel lblFin = new JLabel("Fecha Fin:");
		lblFin.setBounds(458, 255, 82, 14);
		frmPlanificarActividad.getContentPane().add(lblFin);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(228, 37, 114, 20);
		frmPlanificarActividad.getContentPane().add(textFieldTipo);
		textFieldTipo.setColumns(10);
		
		tableDias = new JTable();
		tableDias.setModel(new DefaultTableModel(
			new Object[][] {
				{"Lunes"},
				{"Martes"},
				{"Mi\u00E9rcoles"},
				{"Jueves"},
				{"Viernes"},
				{"S\u00E1bado"},
				{"Domingo"},
			},
			new String[] {
				"New column"
			}
		));
		tableDias.setBounds(31, 176, 49, 112);
		frmPlanificarActividad.getContentPane().add(tableDias);
		
		JLabel lblNewLabel_1 = new JLabel("Hora Inicio:");
		lblNewLabel_1.setBounds(110, 149, 74, 14);
		frmPlanificarActividad.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hora Fin:");
		lblNewLabel_2.setBounds(223, 149, 46, 14);
		frmPlanificarActividad.getContentPane().add(lblNewLabel_2);
		
		JSpinner spinnerLunesIni = new JSpinner();
		spinnerLunesIni.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerLunesIni.setBounds(110, 173, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerLunesIni);
		
		JSpinner spinnerMartesIni = new JSpinner();
		spinnerMartesIni.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerMartesIni.setBounds(110, 193, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerMartesIni);
		
		JSpinner spinnerMiercolesIni = new JSpinner();
		spinnerMiercolesIni.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerMiercolesIni.setBounds(110, 213, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerMiercolesIni);
		
		JSpinner spinnerJuevesIni = new JSpinner();
		spinnerJuevesIni.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerJuevesIni.setBounds(110, 234, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerJuevesIni);
		
		JSpinner spinnerViernesIni = new JSpinner();
		spinnerViernesIni.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerViernesIni.setBounds(110, 252, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerViernesIni);
		
		JSpinner spinnerSabadoIni = new JSpinner();
		spinnerSabadoIni.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerSabadoIni.setBounds(110, 268, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerSabadoIni);
		
		JSpinner spinnerDomingoIni = new JSpinner();
		spinnerDomingoIni.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerDomingoIni.setBounds(110, 290, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerDomingoIni);
		
		JSpinner spinnerLunesFin = new JSpinner();
		spinnerLunesFin.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerLunesFin.setBounds(207, 173, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerLunesFin);
		
		JSpinner spinnerMartesFin = new JSpinner();
		spinnerMartesFin.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerMartesFin.setBounds(207, 193, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerMartesFin);
		
		JSpinner spinnerMiercolesFin = new JSpinner();
		spinnerMiercolesFin.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerMiercolesFin.setBounds(207, 213, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerMiercolesFin);
		
		JSpinner spinnerJuevesFin = new JSpinner();
		spinnerJuevesFin.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerJuevesFin.setBounds(207, 234, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerJuevesFin);
		
		JSpinner spinnerViernesFin = new JSpinner();
		spinnerViernesFin.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerViernesFin.setBounds(207, 252, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerViernesFin);
		
		JSpinner spinnerSabadoFin = new JSpinner();
		spinnerSabadoFin.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerSabadoFin.setBounds(207, 268, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerSabadoFin);
		
		JSpinner spinnerDomingoFin = new JSpinner();
		spinnerDomingoFin.setModel(new SpinnerListModel(new String[] {"0", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00"}));
		spinnerDomingoFin.setBounds(207, 290, 62, 20);
		frmPlanificarActividad.getContentPane().add(spinnerDomingoFin);
	}
	
	public JTextField getTextFieldTipo() {
		return textFieldTipo;
	}

	public void setTextFieldTipo(JTextField textFieldTipo) {
		this.textFieldTipo = textFieldTipo;
	}

	public JFrame getFrame() {
		return this.frmPlanificarActividad;
	}


	public JTextField getTextFieldSocios() {
		return textFieldSocios;
	}

	public void setTextFieldSocios(JTextField textFieldSocios) {
		this.textFieldSocios = textFieldSocios;
	}

	public JTextField getTextFieldNoSocios() {
		return textFieldNoSocios;
	}

	public void setTextFieldNoSocios(JTextField textFieldNoSocios) {
		this.textFieldNoSocios = textFieldNoSocios;
	}


	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public JCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(JCalendar calendar) {
		this.calendar = calendar;
	}
	
	public void addPeriodo(List<PeriodosInscripcion> periodos) {
		comboBoxPeriodo.addItem(periodos);
	}
	
	public void addIntalaciones(List<Instalaciones> instalaciones) {
		comboBoxInstalacion.addItem(instalaciones);
	}
	
	public JDateChooser getdCini() {
		return dCini;
	}
	
	
	public JDateChooser getdCfin() {
		return dCfin;
	}

	public JSpinner getSpinnerLunesIni() {
		return spinnerLunesIni;
	}

	public void setSpinnerLunesIni(JSpinner spinnerLunesIni) {
		this.spinnerLunesIni = spinnerLunesIni;
	}

	public JSpinner getSpinnerLunesFin() {
		return spinnerLunesFin;
	}

	public void setSpinnerLunesFin(JSpinner spinnerLunesFin) {
		this.spinnerLunesFin = spinnerLunesFin;
	}

	public JSpinner getSpinnerMartesIni() {
		return spinnerMartesIni;
	}

	public void setSpinnerMartesIni(JSpinner spinnerMartesIni) {
		this.spinnerMartesIni = spinnerMartesIni;
	}

	public JSpinner getSpinnerMartesFin() {
		return spinnerMartesFin;
	}

	public void setSpinnerMartesFin(JSpinner spinnerMartesFin) {
		this.spinnerMartesFin = spinnerMartesFin;
	}

	public JSpinner getSpinnerMiercolesIni() {
		return spinnerMiercolesIni;
	}

	public void setSpinnerMiercolesIni(JSpinner spinnerMiercolesIni) {
		this.spinnerMiercolesIni = spinnerMiercolesIni;
	}

	public JSpinner getSpinnerMiercolesFin() {
		return spinnerMiercolesFin;
	}

	public void setSpinnerMiercolesFin(JSpinner spinnerMiercolesFin) {
		this.spinnerMiercolesFin = spinnerMiercolesFin;
	}

	public JSpinner getSpinnerJuevesIni() {
		return spinnerJuevesIni;
	}

	public void setSpinnerJuevesIni(JSpinner spinnerJuevesIni) {
		this.spinnerJuevesIni = spinnerJuevesIni;
	}

	public JSpinner getSpinnerJuevesFin() {
		return spinnerJuevesFin;
	}

	public void setSpinnerJuevesFin(JSpinner spinnerJuevesFin) {
		this.spinnerJuevesFin = spinnerJuevesFin;
	}

	public JSpinner getSpinnerViernesIni() {
		return spinnerViernesIni;
	}

	public void setSpinnerViernesIni(JSpinner spinnerViernesIni) {
		this.spinnerViernesIni = spinnerViernesIni;
	}

	public JSpinner getSpinnerViernesFin() {
		return spinnerViernesFin;
	}

	public void setSpinnerViernesFin(JSpinner spinnerViernesFin) {
		this.spinnerViernesFin = spinnerViernesFin;
	}

	public JSpinner getSpinnerSabadoIni() {
		return spinnerSabadoIni;
	}

	public void setSpinnerSabadoIni(JSpinner spinnerSabadoIni) {
		this.spinnerSabadoIni = spinnerSabadoIni;
	}

	public JSpinner getSpinnerSabadoFin() {
		return spinnerSabadoFin;
	}

	public void setSpinnerSabadoFin(JSpinner spinnerSabadoFin) {
		this.spinnerSabadoFin = spinnerSabadoFin;
	}

	public JSpinner getSpinnerDomingoIni() {
		return spinnerDomingoIni;
	}

	public void setSpinnerDomingoIni(JSpinner spinnerDomingoIni) {
		this.spinnerDomingoIni = spinnerDomingoIni;
	}

	public JSpinner getSpinnerDomingoFin() {
		return spinnerDomingoFin;
	}

	public void setSpinnerDomingoFin(JSpinner spinnerDomingoFin) {
		this.spinnerDomingoFin = spinnerDomingoFin;
	}
	
	public JButton getbtnCrear() {
		return ButtonCrear;
	}
	
	public void setbtnCrear(JButton b) {
		this.ButtonCrear = b;
	}

	public int getSpinnerAforo() {
		return (int) spinnerAforo.getValue();
	}

	public void setSpinnerAforo(JSpinner spinnerAforo) {
		this.spinnerAforo = spinnerAforo;
	}
	
	
}
