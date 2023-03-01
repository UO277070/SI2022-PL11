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
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

public class PLanificaActividad {

	private JFrame frmPlanificarActividad;
	private JTextField textFieldSocios;
	private JTextField textFieldNoSocios;
	private JTable tableHorario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PLanificaActividad window = new PLanificaActividad();
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
	public PLanificaActividad() {
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
		LabelInstalacion.setBounds(10, 24, 74, 14);
		frmPlanificarActividad.getContentPane().add(LabelInstalacion);
		
		JComboBox comboBoxInstalacion = new JComboBox();
		comboBoxInstalacion.setBounds(10, 45, 162, 22);
		frmPlanificarActividad.getContentPane().add(comboBoxInstalacion);
		
		JLabel LabelActvividad = new JLabel("Tipo de Actividad:");
		LabelActvividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelActvividad.setBounds(10, 78, 132, 22);
		frmPlanificarActividad.getContentPane().add(LabelActvividad);
		
		JComboBox comboBoxActividad = new JComboBox();
		comboBoxActividad.setBounds(10, 103, 162, 22);
		frmPlanificarActividad.getContentPane().add(comboBoxActividad);
		
		JLabel LabelAforo = new JLabel("Aforo:");
		LabelAforo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelAforo.setBounds(252, 24, 59, 14);
		frmPlanificarActividad.getContentPane().add(LabelAforo);
		
		JSpinner spinnerAforo = new JSpinner();
		spinnerAforo.setBounds(252, 46, 59, 20);
		frmPlanificarActividad.getContentPane().add(spinnerAforo);
		
		JLabel LabelSocios = new JLabel("Cuota Socios:\r\n");
		LabelSocios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelSocios.setBounds(340, 24, 89, 14);
		frmPlanificarActividad.getContentPane().add(LabelSocios);
		
		JLabel LabelNoSocios = new JLabel("Cuota No Socios:\r\n");
		LabelNoSocios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelNoSocios.setBounds(453, 24, 114, 14);
		frmPlanificarActividad.getContentPane().add(LabelNoSocios);
		
		textFieldSocios = new JTextField();
		textFieldSocios.setBounds(340, 46, 48, 20);
		frmPlanificarActividad.getContentPane().add(textFieldSocios);
		textFieldSocios.setColumns(10);
		
		textFieldNoSocios = new JTextField();
		textFieldNoSocios.setColumns(10);
		textFieldNoSocios.setBounds(453, 46, 48, 20);
		frmPlanificarActividad.getContentPane().add(textFieldNoSocios);
		
		JLabel LabelInscripcion = new JLabel("Periodo de Inscripción:");
		LabelInscripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelInscripcion.setBounds(440, 163, 154, 14);
		frmPlanificarActividad.getContentPane().add(LabelInscripcion);
		
		JLabel lblNewLabel = new JLabel("Fecha de Inicio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(412, 188, 89, 14);
		frmPlanificarActividad.getContentPane().add(lblNewLabel);
		
		JLabel lblFechaDeFinal = new JLabel("Fecha de Fin:");
		lblFechaDeFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaDeFinal.setBounds(412, 242, 74, 14);
		frmPlanificarActividad.getContentPane().add(lblFechaDeFinal);
		
		JDateChooser dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(412, 213, 132, 20);
		frmPlanificarActividad.getContentPane().add(dateChooserInicio);
		
		JDateChooser dateChooserFin = new JDateChooser();
		dateChooserFin.setBounds(412, 267, 132, 20);
		frmPlanificarActividad.getContentPane().add(dateChooserFin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(400, 136, 194, 2);
		frmPlanificarActividad.getContentPane().add(separator);
		
		tableHorario = new JTable();
		tableHorario.setBorder(null);
		tableHorario.setModel(new DefaultTableModel(
			new Object[][] {
				{"Horario:", "Lunes", "Martes", "Mi\u00E9rcoles", "Jueves", "Viernes", "S\u00E1bado", "Domingo"},
				{"8:00", null, null, null, null, null, null, null},
				{"9:00", null, null, null, null, null, null, null},
				{"10:00", null, null, null, null, null, null, ""},
				{"11:00", null, null, null, null, null, null, null},
				{"12:00", null, null, null, null, null, null, null},
				{"13:00", null, null, null, null, null, null, null},
				{"14:00", null, null, null, null, null, null, null},
				{"15:00", null, null, null, null, null, null, null},
				{"16:00", null, null, null, null, null, null, null},
				{"17:00", null, null, null, null, null, null, null},
				{"18:00", null, null, null, null, null, null, null},
				{"19:00", null, null, null, null, null, null, null},
				{"20:00", null, null, null, null, null, null, null},
			},
			new String[] {
				"Horario", "Lunes", "Martes", "Mi\u00E9rcoles", "Jueves", "Viernes", "S\u00E1bado", "Domingo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableHorario.setBounds(10, 163, 390, 183);
		frmPlanificarActividad.getContentPane().add(tableHorario);
		
		JButton ButtonCrear = new JButton("Crear");
		ButtonCrear.setBounds(535, 323, 59, 23);
		frmPlanificarActividad.getContentPane().add(ButtonCrear);
	}
}
