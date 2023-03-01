package ReservarInstalacionComoSocio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class ReservaSocio_Vista {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	String ruta="D:\\Desktop\\Informes\\";
	
//	String ruta="C:\\Users\\uo276508\\Desktop\\Ficheros\\";
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaSocio_Vista window = new ReservaSocio_Vista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public ReservaSocio_Vista() {
		initialize();
	}

	public ReservaSocio_Vista(ReservaSocio_Controler c) {
		controler=c;
		initialize();	
		}

		ReservaSocio_Controler controler;
		private JTextField tfidSocio;
		private JTextField tfNombreSocio;
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 325);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecciona una Instalacion");
		lblNewLabel.setBounds(10, 63, 165, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione la fecha de la reserva");
		lblNewLabel_1.setBounds(10, 102, 196, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox cbInstalaciones = new JComboBox(); 
		
		//ponemos el combobox xcon las opciones de la base de datos
		List<InstalacionEntity> l=controler.getInstalaciones();
		DefaultComboBoxModel cbmodel=new DefaultComboBoxModel();
		
		for(int i=0;i<l.size();i++) {
			cbmodel.addElement(l.get(i).nombre);
		}
		cbInstalaciones.setModel(cbmodel);
		
		
		
		cbInstalaciones.setBounds(214, 63, 210, 21);
		frame.getContentPane().add(cbInstalaciones);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(214, 98, 112, 19);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		frame.getContentPane().add(dateChooser);
		
		JLabel lblNewLabel_2 = new JLabel("Hora inicial de la reserva");
		lblNewLabel_2.setBounds(10, 147, 196, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSpinner spini = new JSpinner();
		spini.setBounds(216, 147, 58, 20);
		frame.getContentPane().add(spini);
		
		JSpinner spFin = new JSpinner();
		spFin.setBounds(216, 189, 58, 20);
		frame.getContentPane().add(spFin);
		
		JLabel lblNewLabel_2_1 = new JLabel("Hora final de la reserva");
		lblNewLabel_2_1.setBounds(10, 192, 196, 13);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		
		
		JButton btReserva = new JButton("Realizar Reserva");
		btReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				DateFormat dateformatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
			    String fechaEscogida = new String( dateformatYYYYMMDD.format( dateChooser.getDate()) );
				
				String[] fechaLarga = fechaEscogida.split("-");
				String dia=  fechaLarga[2];
				String mes=  fechaLarga[1];
				String año=  fechaLarga[0];
				
				
				
				String respuesta;
				
					respuesta = controler.ReservaSocioOk((String)cbInstalaciones.getSelectedItem() ,dia,mes,año, 
							(int) spini.getValue(),(int) spFin.getValue(), tfidSocio.getText(), tfNombreSocio.getText());
					if(respuesta ==null) {
						//lamamos un dialogo de que los datos son correctos y efectuamos la reserva	
						JOptionPane.showMessageDialog(null, "La reserva se realizo con exito", "Reserva realizada", 1);
						//Crear un fichero con los datos de la reserva
						
						Cobro co=new Cobro();
						co.mostrar();
						
						if(co.aceptado) {
							
							//La base de datos refleja la reserva
							controler.reservarInstalacion(""+cbInstalaciones.getSelectedItem(), dia, mes, año, (int)spini.getValue(),(int)spFin.getValue() , tfidSocio.getText(), tfNombreSocio.getText());
							
							File fichero = new File (ruta+"reserva_"+tfNombreSocio.getText()+"_id"+tfidSocio.getText()+".txt");
							
							try {
								if (fichero.createNewFile()) {
									JOptionPane.showMessageDialog(null, "El fichero se ha creado correctamente", "Fichero creado", 1);
									FileWriter f= new FileWriter(fichero);
									
									int precio= controler.getprecio(""+cbInstalaciones.getSelectedItem());
									java.time.LocalDate fecha = LocalDate.now();
									
									precio=precio*(int)((int)(spFin.getValue()) -(int)spini.getValue());	
									Date Hora= new Date();

									//Para sacar idReserva;
									int idReserva= controler.SacaridReserva(tfidSocio.getText(), ""+cbInstalaciones.getSelectedItem(),""+año+"-"+mes+"-"+dia , (int)spini.getValue(), (int)spFin.getValue());
									
									String fich="Reserva realizada por:"+tfNombreSocio.getText()+" el dia: "+fecha.getDayOfMonth() +"-"+fecha.getMonthValue()+"-"+2023+" a las: "+Hora.getHours()+":"+Hora.getMinutes()+":"+
									 Hora.getSeconds()+" sobre la instalación: "+cbInstalaciones.getSelectedItem()+"\nEn la fecha: "+dia+"-"+mes+"-"+año+" de "+spini.getValue()+" a "+spFin.getValue() ;
									if(co.getRdbtnCuota().isSelected()) {
									//No se pago, se añade el pago como sin pagar a la base y se añade al fichero que no esta pagado;
										fich+="\nPago de la reserva cargada a la cuota del socio, total de coste: "+precio+";";
										controler.Insertapago(precio, ""+año+"-"+mes+"-"+dia, "incompleto", tfidSocio.getText(), idReserva);	//idReserva										
 
									}
									else{
										fich+="\nPago de la reserva pagado, total de coste: "+precio+".";
										//La base de datos refleja el pago del socio
										controler.Insertapago(precio, ""+año+"-"+mes+"-"+dia, "completo", tfidSocio.getText(), idReserva);
									}
										
									
									f.write(fich);
									f.close();

								}
								else
									JOptionPane.showMessageDialog(null, "No se ha podido crear el fichero.", "Fichero fallido", 0);
								} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
						}

						}
						}
						
						else {
						//Los datos son erroneos
							JOptionPane.showMessageDialog(null, respuesta, "Fallo en la reserva", 2);
							
						}

				
			}
		});
		btReserva.setBounds(290, 234, 134, 23);
		frame.getContentPane().add(btReserva);
		
		JLabel lblNewLabel_3 = new JLabel("id socio");
		lblNewLabel_3.setBounds(226, 28, 79, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		tfidSocio = new JTextField();
		tfidSocio.setBounds(315, 25, 112, 20);
		frame.getContentPane().add(tfidSocio);
		tfidSocio.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre Socio");
		lblNewLabel_4.setBounds(10, 28, 100, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfNombreSocio = new JTextField();
		tfNombreSocio.setBounds(120, 25, 86, 20);
		frame.getContentPane().add(tfNombreSocio);
		tfNombreSocio.setColumns(10);
		
	}
}
