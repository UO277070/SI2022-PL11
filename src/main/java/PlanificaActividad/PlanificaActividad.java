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

public class PlanificaActividad {

	private JFrame frmPlanificarActividad;
	private JTextField textFieldSocios;
	private JTextField textFieldNoSocios;
	private JTable tableHorario;
	private JTextField textFieldNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanificaActividad window = new PlanificaActividad();
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
	public PlanificaActividad() {
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
		
		JComboBox comboBoxActividad = new JComboBox();
		comboBoxActividad.setBounds(228, 36, 162, 22);
		frmPlanificarActividad.getContentPane().add(comboBoxActividad);
		
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
		
		JLabel LabelNombre = new JLabel("Nombre");
		LabelNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LabelNombre.setBounds(10, 11, 59, 14);
		frmPlanificarActividad.getContentPane().add(LabelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(10, 36, 162, 20);
		frmPlanificarActividad.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(412, 91, 167, 22);
		frmPlanificarActividad.getContentPane().add(comboBox);
	}
}
