package ReservarInstalacionComoSocio;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;

public class Cobro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbEfectivo;
	private JRadioButton rbCuota;
	public boolean aceptado=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cobro dialog = new Cobro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	

	public Cobro() {
		setBounds(100, 100, 266, 245);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		rbEfectivo = new JRadioButton("Pagar ahora");
		buttonGroup.add(rbEfectivo);
		rbEfectivo.setBounds(41, 78, 85, 23);
		contentPanel.add(rbEfectivo);
		
		rbCuota = new JRadioButton("Cargar a la cuota");
		rbCuota.setSelected(true);
		buttonGroup.add(rbCuota);
		rbCuota.setBounds(41, 122, 109, 23);
		contentPanel.add(rbCuota);
		
		JLabel lblNewLabel = new JLabel("Seleccione metodo de pago");
		lblNewLabel.setBounds(41, 43, 260, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Pagar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Se cobra
						aceptado=true;
						dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}


	}
	
	public boolean mostrar() {
		aceptado = false;
        setModal(true);
        setLocationRelativeTo(null);
        setVisible(true);
	return aceptado;
}
	
	public JRadioButton getRdbtnEfectivo() {
		return rbEfectivo;
	}
	public JRadioButton getRdbtnCuota() {
		return rbCuota;
	}
}
