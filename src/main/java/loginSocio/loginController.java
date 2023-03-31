package loginSocio;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class loginController {
	private loginModel model;
	private loginView view;
	private SocioEntity socio;
	
	public loginController(loginModel rm, loginView ri) {
		this.model = rm;
		this.view = ri;
		
		initView();
	}
	
	public void initController() {
		view.getBtnLogin().addActionListener(e -> checkSocio());
		
	}
	
	public void initView() {
		//Inicializa todos los datos de la ventana
		//y actualiza los datos de la vista
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		
	}
	
	public SocioEntity getSocio() {
		return socio;
	}
	
	public boolean showDialog() {
        view.setPOK(false);
        view.setVisible(true);
        return view.getPOK();
    }
	
	@SuppressWarnings("deprecation")
	public void checkSocio() {
		if(!(view.gettFSocio().getText().equals(""))) {
			int id = Integer.parseUnsignedInt(view.gettFSocio().getText());
			String pass = view.getpFPass().getText();
			SocioEntity tmp = model.getSocio(id);
			if(tmp !=null) {
				if (pass.equals("1234")) {
					view.setVisible(false);
					view.gettFSocio().setText(""+id);
					socio = tmp;
					view.POK = true;
				}
				else
					JOptionPane.showMessageDialog(view,"Contraseña incorrecta","Aviso",JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(view,"Socio no encontrado","Aviso",JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(view,"Introduce un socio","Aviso",JOptionPane.ERROR_MESSAGE);
		
	}

}
