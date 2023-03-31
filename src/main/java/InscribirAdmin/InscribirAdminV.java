package InscribirAdmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class InscribirAdminV {

	private JFrame frmInscribir;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldDNI;
	private JTextField textFieldCorreo;
	private JComboBox comboBoxID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscribirAdminV window = new InscribirAdminV();
					window.frmInscribir.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InscribirAdminV() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInscribir = new JFrame();
		frmInscribir.setTitle("Inscribir a Actividad");
		frmInscribir.setBounds(100, 100, 518, 300);
		frmInscribir.getContentPane().setLayout(null);
		
		
		
		JLabel labelID = new JLabel("ID Socio:");
		labelID.setBounds(27, 82, 49, 16);
		frmInscribir.getContentPane().add(labelID);
		
		JLabel lableNombre = new JLabel("Nombre:");
		lableNombre.setBounds(27, 107, 48, 16);
		frmInscribir.getContentPane().add(lableNombre);
		
		JLabel labelApellidos = new JLabel("Apellidos:");
		labelApellidos.setBounds(27, 132, 55, 16);
		frmInscribir.getContentPane().add(labelApellidos);
		
		JLabel labelDNI = new JLabel("DNI:");
		labelDNI.setBounds(27, 157, 22, 16);
		frmInscribir.getContentPane().add(labelDNI);
		
		JLabel labelCorreo = new JLabel("Correo:");
		labelCorreo.setBounds(27, 182, 42, 16);
		frmInscribir.getContentPane().add(labelCorreo);
		
		JComboBox comboBoxID = new JComboBox();
		comboBoxID.setEnabled(false);
		comboBoxID.setBounds(83, 78, 156, 22);
		frmInscribir.getContentPane().add(comboBoxID);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(83, 104, 156, 20);
		frmInscribir.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(83, 129, 156, 20);
		frmInscribir.getContentPane().add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(83, 154, 156, 20);
		frmInscribir.getContentPane().add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(83, 179, 156, 20);
		frmInscribir.getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JLabel labelActividad = new JLabel("Actividad:");
		labelActividad.setBounds(283, 32, 55, 16);
		frmInscribir.getContentPane().add(labelActividad);
		
		JComboBox comboBoxActividades = new JComboBox();
		comboBoxActividades.setBounds(344, 28, 148, 22);
		frmInscribir.getContentPane().add(comboBoxActividades);
		
		JButton buttonInscribir = new JButton("Inscribir");
		buttonInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonInscribir.setBounds(403, 227, 89, 23);
		frmInscribir.getContentPane().add(buttonInscribir);
		
		JCheckBox checkBoxSocio = new JCheckBox("Socio");
		checkBoxSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxSocio.isSelected()) {
					comboBoxID.setEnabled(true);
					textFieldNombre.setEnabled(false);
					textFieldApellidos.setEnabled(false);
					textFieldDNI.setEnabled(false);
					textFieldCorreo.setEnabled(false);
				}
			}
		});
		checkBoxSocio.setBounds(27, 28, 57, 24);
		frmInscribir.getContentPane().add(checkBoxSocio);
	}

	public JComboBox getComboBoxID() {
		return comboBoxID;
	}

	public void setComboBoxID(JComboBox comboBoxID) {
		this.comboBoxID = comboBoxID;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}

	public JTextField getTextFieldApellidos() {
		return textFieldApellidos;
	}

	public void setTextFieldApellidos(JTextField textFieldApellidos) {
		this.textFieldApellidos = textFieldApellidos;
	}

	public JTextField getTextFieldDNI() {
		return textFieldDNI;
	}

	public void setTextFieldDNI(JTextField textFieldDNI) {
		this.textFieldDNI = textFieldDNI;
	}

	public JTextField getTextFieldCorreo() {
		return textFieldCorreo;
	}

	public void setTextFieldCorreo(JTextField textFieldContacto) {
		this.textFieldCorreo = textFieldContacto;
	}

	public JFrame getFrame() {
		return this.frmInscribir;
	}
}
