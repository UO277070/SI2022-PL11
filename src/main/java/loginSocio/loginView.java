package loginSocio;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class loginView extends JDialog {

	private JPanel contentPane;
	private JTextField tFSocio;
	private JPasswordField pFPass;
	public boolean POK;
	private JButton btnLogin;


	/**
	 * Create the frame.
	 */
	public loginView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public loginView() {
        this(null,true);
    	initComponents();
    }
	
	private void initComponents() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Socio:");
		lblNewLabel.setBounds(44, 35, 37, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setBounds(12, 64, 69, 16);
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
		tFSocio.setBounds(93, 33, 104, 20);
		contentPane.add(tFSocio);
		tFSocio.setColumns(10);
		
		pFPass = new JPasswordField();
		pFPass.setBounds(93, 62, 104, 20);
		contentPane.add(pFPass);
		
		btnLogin = new JButton("Login");
	
		btnLogin.setBounds(129, 95, 100, 26);
		contentPane.add(btnLogin);
	}
	

	public JTextField gettFSocio() {
		return tFSocio;
	}

	public JPasswordField getpFPass() {
		return pFPass;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setPOK(boolean pOK) {
		POK = pOK;
	}
	
	public boolean getPOK() {
		return POK;
	}
	
	
}
