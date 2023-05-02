package InscribirAdmin;

import java.util.Date;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import ActividadesOfertadas.ActividadesOfertadas_Model;
import ActividadesOfertadas.ActividadesOfertadas_View;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;
import loginSocio.SocioEntity;
import loginSocio.loginController;
import loginSocio.loginModel;
import loginSocio.loginView;

public class InscribirAdminC {
	
	private InscribirAdminM model;
	private InscribirAdminV view;
	//private loginController controller;
	//private SocioEntity socioLog;
	private Date fechaActual;
	private int plazaslibres;
	private int idActividad;
	private int idSocio;
	private int idNoSocio;
	private boolean esSocio;
	 
	
	public InscribirAdminC(InscribirAdminM model, InscribirAdminV view) {
		this.model = model;
		this.view = view;
		this.fechaActual = new Date();
		this.plazaslibres = 0;
		this.idActividad = 0;
		this.idSocio = 0;
		this.idNoSocio = 0;
		this.esSocio = false;
		
		this.initView();
	}
	
	public void initController() {
		//view.getComboBoxActividades().addItemListener(e -> getListaActividadesEnPeriodo());
		view.getButtonInscribir().addActionListener(e -> inscribir());
		view.getCheckBoxSocio().addItemListener(e -> getListaActividadesEnPeriodo());

		
	}
	
	
	public void initView() {
		this.getListaActividadesEnPeriodo();
		this.getListaSocios();
		view.getFrame().setVisible(true);
		
		
		/*//Abre la ventana (sustituye al main generado por WindowBuilder)
		controller=new loginController(new loginModel(), new loginView());
		controller.initController();
		boolean POK = controller.showDialog();
		if (POK) {
			socioLog = controller.getSocio();
		    view.getFrame().setVisible(true);
		}*/
	}
	
	
	public void getListaSocios() {
		List <Object[]> socios = model.getListaSocios();
		
		ComboBoxModel comboId = SwingUtil.getComboModelFromList(socios);
		view.getComboBoxID().setModel(comboId);
		
	}
	
	public void getListaActividadesEnPeriodo() {
		if(view.getCheckBoxSocio().isSelected()) {
			this.esSocio = true;
		}
		List <Object[]> actividades;
		ComboBoxModel comboActividades;
		if(esSocio) {
			actividades = model.getListaActividadesEnPeriodoSocio(Util.dateToIsoString(fechaActual));
			comboActividades = SwingUtil.getComboModelFromList(actividades);
		}
		else{
			actividades = model.getListaActividadesEnPeriodoNoSocio(Util.dateToIsoString(fechaActual));
			comboActividades = SwingUtil.getComboModelFromList(actividades);
		}
		view.getComboBoxActividades().setModel(comboActividades);
	}
	
	/*public void inscribir() {
		this.idActividad = (int) model.getIdActividad(view.getComboBoxActividades().getSelectedItem().toString()).get(0)[0];
		this.idSocio = (Integer) view.getComboBoxID().getSelectedItem();
		this.plazaslibres = Math.max(0,  (Integer) model.getPlazasTotalesActividad(this.idActividad).get(0)[0]
				- (Integer) model.getNumInscripcionesEnActividad(this.idActividad).get(0)[0]);
		
		//Es socio y hay plazas libres
		if((this.plazaslibres != 0) && (this.esSocio)) {
			model.insertInscripcionActividadSocio(this.idActividad, this.idSocio);
			JOptionPane.showMessageDialog(null,"Inscripcion realizada","Inscripcion", JOptionPane.INFORMATION_MESSAGE);
		}
		
		//No es socio y hay plazas libres
		if((this.plazaslibres != 0) && (!this.esSocio)) {
			model.insertNoSocio(view.getTextFieldDNI().getText(), view.getTextFieldNombre().getText(), view.getTextFieldPrimerApellido().getText(), view.getTextFieldSegundoApellido().getText(), view.getTextFieldCorreo().getText());
			List<NoSocio> noSocio = model.getNoSocio(view.getTextFieldDNI().getText());
			this.idNoSocio = noSocio.get(0).getIdNoSocio();
			model.insertInscripcionActividadNoSocio(idActividad, this.idNoSocio);
			JOptionPane.showMessageDialog(null,"Inscripcion realizada","Inscripcion", JOptionPane.INFORMATION_MESSAGE);
		}
		
		//NO hay plazas libres
		else {
			//Es socio y se le inserta en la lista de espera de socios
			if(this.esSocio) {
				int max, min, pos;
				max = 1;
				min = Integer.MAX_VALUE;
				List<ListaEsperaSocio> listaEspera = model.getListaEsperaSocioActividad(this.idActividad);
				Iterator<ListaEsperaSocio> itr = listaEspera.iterator();
				if(!itr.hasNext()) min = 1;
				while (itr.hasNext()) {
			        ListaEsperaSocio espera = itr.next();
			        pos = espera.getPosicion();
			        if (espera.getIdSocio() == this.idSocio) {
			            JOptionPane.showMessageDialog(null,"Ya está en la lista de espera para esta actividad.","Inscripcion", JOptionPane.INFORMATION_MESSAGE);
			            return;
			        }
			        if(pos >= max) max = pos + 1;
					if(pos <= min) min = pos;
			        
			    }
				model.insertListaEsperaSocio(this.idActividad, this.idSocio, max);
				JOptionPane.showMessageDialog(null,"Se ha inscrito al socio " + idSocio + " en lista de espera de socios para la actividad " + idActividad + " con éxito.\n" +
						"Posición en lista de espera de socios: " + (max - min + 1));
			}
			//No es socio y se le inserta en la lita de espera de no socios
			if(!this.esSocio) {
				int max, min, pos;
				max = 1;
				min = Integer.MAX_VALUE;
				List<ListaEsperaSocio> listaEspera = model.getListaEsperaNoSocioActividad(this.idActividad);
				Iterator<ListaEsperaSocio> itr = listaEspera.iterator();
				if(!itr.hasNext()) min = 1;
				while(itr.hasNext()) {
					ListaEsperaSocio espera = itr.next();
			        pos = espera.getPosicion();
			        if (espera.getIdSocio() == this.idNoSocio) {
			            JOptionPane.showMessageDialog(null,"Ya está en la lista de espera para esta actividad.","Inscripcion", JOptionPane.INFORMATION_MESSAGE);
			            return;
			        }
					if(pos >= max) max = pos + 1;
					if(pos <= min) min = pos;
				}
				model.insertListaEsperaNoSocio(this.idActividad, this.idNoSocio, max);
				JOptionPane.showMessageDialog(null,"Se ha inscrito al no-socio " + idNoSocio + " en lista de espera de no-socios para la actividad " + idActividad + " con éxito.\n" +
						"Posición en lista de espera de no-socios: " + (max - min + 1));
			}
		}
		
	}
	*/
	public void inscribir() {
	    this.idActividad = (int) model.getIdActividad(view.getComboBoxActividades().getSelectedItem().toString()).get(0)[0];
	    this.plazaslibres = Math.max(0, (Integer) model.getPlazasTotalesActividad(this.idActividad).get(0)[0]
                - (Integer) model.getNumInscripcionesEnActividad(this.idActividad).get(0)[0]);
	    this.esSocio = view.getCheckBoxSocio().isSelected();
	    // Si es socio
	    if (this.esSocio) {
	        this.idSocio = (Integer) view.getComboBoxID().getSelectedItem();
	        List<ListaEsperaSocio> listaEsperaSocio = model.getListaEsperaSocioActividad(this.idActividad);
	        Iterator<ListaEsperaSocio> itrSocio = listaEsperaSocio.iterator();
	        

	        // Comprobar si el socio ya está inscrito en la actividad
	        if (!model.getInscripcionesEnActividadSocio(this.idActividad, this.idSocio).isEmpty()) {
	            JOptionPane.showMessageDialog(null, "El socio ya está inscrito en esta actividad.", "Inscripción",
	                    JOptionPane.INFORMATION_MESSAGE);
	            return;
	        }

	        // Comprobar si el socio ya está en la lista de espera de la actividad
	        
	        while(itrSocio.hasNext()) {
	        	ListaEsperaSocio espera = itrSocio.next();
		        if (espera.getIdSocio() == this.idSocio) {
		            JOptionPane.showMessageDialog(null,"Ya está en la lista de espera para esta actividad.","Inscripcion", JOptionPane.INFORMATION_MESSAGE);
		            return;
		        }
	        }
	        

	        // Si hay plazas libres, inscribir a los que hay en lista de espera hasta que no queden plazas, si no se inscribe el socio
	        while (this.plazaslibres > 0) {
	        	if(!listaEsperaSocio.isEmpty()) {
	        		int max = 1, min, pos;
	    			min = Integer.MAX_VALUE;
					//Obtener al primer socio en la lista de espera
					ListaEsperaSocio siguiente = listaEsperaSocio.get(0);
					int idSiguiente = siguiente.getIdSocio();
					int posicion = siguiente.getPosicion();
					//Eliminar al socio de la lista de espera
					model.deleteListaEsperaSocio(this.idActividad, idSiguiente);
					//Inscribir al socio en espera en la actividad
					model.insertInscripcionActividadSocio(this.idActividad, idSiguiente);
					JOptionPane.showMessageDialog(null,"Se ha inscrito automáticamente al siguiente socio (" +idSiguiente+") en lista de espera para la actividad " + idActividad + ".\n" +
			                "Posición en lista de espera de socios: " + posicion,"Inscripcion", JOptionPane.INFORMATION_MESSAGE);
					if(this.plazaslibres == 1) {
						if(!itrSocio.hasNext()) min = 1;
						while(itrSocio.hasNext()) {
							pos = itrSocio.next().getPosicion();
							if(pos >= max) max = pos + 1;
							if(pos <= min) min = pos;
						}
						model.insertListaEsperaSocio(this.idActividad, this.idSocio, max);
						JOptionPane.showMessageDialog(null,"El aforo para esta actividad esá completo.\nSe ha inscrito en lista de espera de socios para la actividad " + idActividad + " con éxito.\n" +
								"Posición en lista de espera de socios: " + (max - min + 1),"Inscripcion", JOptionPane.INFORMATION_MESSAGE);
					}
					
	        	}
	        	else {
	        		model.insertInscripcionActividadSocio(this.idActividad, this.idSocio);
		            JOptionPane.showMessageDialog(null, "Inscripción realizada", "Inscripción", JOptionPane.INFORMATION_MESSAGE);
		            return;
	        	}
	        	this.plazaslibres = Math.max(0, (Integer) model.getPlazasTotalesActividad(this.idActividad).get(0)[0]
	                    - (Integer) model.getNumInscripcionesEnActividad(this.idActividad).get(0)[0]);
	        }

	        // Si no hay plazas libres, añadir al socio a la lista de espera
	        if(this.plazaslibres == 0) {
	        	int pos = listaEsperaSocio.size() + 1;
	 	        while (itrSocio.hasNext()) {
	 	            ListaEsperaSocio espera = itrSocio.next();
	 	            if (espera.getIdSocio() == this.idSocio) {
	 	                JOptionPane.showMessageDialog(null,
	 	                        "Ya está en la lista de espera para esta actividad.", "Inscripción",
	 	                        JOptionPane.INFORMATION_MESSAGE);
	 	                return;
	 	            }

	 	        }
	 	        model.insertListaEsperaSocio(this.idActividad, this.idSocio, pos);
	 	        JOptionPane.showMessageDialog(null, "Se ha inscrito al socio " + idSocio
	 	                + " en lista de espera de socios para la actividad " + idActividad + " con éxito.\n"
	 	                + "Posición en lista de espera de socios: " + pos);
	 	       this.plazaslibres = Math.max(0, (Integer) model.getPlazasTotalesActividad(this.idActividad).get(0)[0]
	                     - (Integer) model.getNumInscripcionesEnActividad(this.idActividad).get(0)[0]); 
	        }
	       

	    }
	    // Si no es socio
	    else {
	    	 String dni = view.getTextFieldDNI().getText();
	         String nombre = view.getTextFieldNombre().getText();
	         String primerApellido = view.getTextFieldPrimerApellido().getText();
	         String segundoApellido = view.getTextFieldSegundoApellido().getText();
	         String correo = view.getTextFieldCorreo().getText();
	         
	         List<NoSocio> noSocio = model.getNoSocio(dni);
	         List<ListaEsperaSocio> listaEsperaNosocio = model.getListaEsperaNoSocioActividad(idActividad);
	         Iterator<ListaEsperaSocio> itrNosocio = listaEsperaNosocio.iterator();
	         
	         if(noSocio.isEmpty()) {
	        	 model.insertNoSocio(dni, nombre, primerApellido, segundoApellido, correo);
	        	 noSocio = model.getNoSocio(dni); 
	         }
	         this.idNoSocio = noSocio.get(0).getIdNoSocio();
	         // Comprobar si el no socio ya está inscrito
	         if (!model.getInscripcionesEnActividadNoSocio(this.idActividad, this.idNoSocio).isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El no-socio ya está inscrito en esta actividad.", "Inscripción",
		                    JOptionPane.INFORMATION_MESSAGE);
		            return;
		     }
	         
	         // Comprobar si el no socio ya está en la lista de espera de la actividad   
	         while(itrNosocio.hasNext()) {
	        	 ListaEsperaSocio espera = itrNosocio.next();
	        	 if (espera.getIdSocio() == this.idNoSocio) {
	        		 JOptionPane.showMessageDialog(null,"Ya está en la lista de espera para esta actividad.","Inscripcion", JOptionPane.INFORMATION_MESSAGE);
	        		 return;
	        	 }
	         }
	        
	         // Si hay plazas libres, inscribir al socio si no hay nadie en lista de espera
	         while (this.plazaslibres > 0) {
	        	 if(!listaEsperaNosocio.isEmpty()) {
	        		 int max = 1, min, pos;
	        		 min = Integer.MAX_VALUE;
	        		 //Obtener al primer socio en la lista de espera
	        		 ListaEsperaSocio siguiente = listaEsperaNosocio.get(0);
	        		 int idSiguiente = siguiente.getIdSocio();
	        		 int posicion = siguiente.getPosicion();
	        		 //Eliminar al socio de la lista de espera
	        		 model.deleteListaEsperaNoSocio(this.idActividad, idSiguiente);
	        		 //Inscribir al socio en espera en la actividad
	        		 model.insertInscripcionActividadNoSocio(this.idActividad, idSiguiente);
	        		 JOptionPane.showMessageDialog(null,"Se ha inscrito automáticamente al siguiente no-socio en lista de espera para la actividad " + idActividad + ".\n" +
	        				 "Posición en lista de espera de no-socios: " + posicion,"Inscripcion", JOptionPane.INFORMATION_MESSAGE);
	        		 if(this.plazaslibres == 1) {
	        			 if(!itrNosocio.hasNext()) min = 1;
	        			 while(itrNosocio.hasNext()) {
	        				 pos = itrNosocio.next().getPosicion();
	        				 if(pos >= max) max = pos + 1;
	        				 if(pos <= min) min = pos;
	        			 }
	        			 model.insertListaEsperaNoSocio(this.idActividad, this.idNoSocio, max);
		        		 JOptionPane.showMessageDialog(null,"El aforo para esta actividad esá completo.\nSe ha inscrito en lista de espera de no-socios para la actividad " + idActividad + " con éxito.\n" +
		        				 "Posición en lista de espera de no-socios: " + (max - min + 1),"Inscripcion", JOptionPane.INFORMATION_MESSAGE);
	        		 }	 
	        	 }
	        	 else {
	        		 model.insertInscripcionActividadNoSocio(this.idActividad, this.idNoSocio);
		        	 JOptionPane.showMessageDialog(null, "Inscripción realizada", "Inscripción", JOptionPane.INFORMATION_MESSAGE);
		        	 return;
	        	 } 
	        	 this.plazaslibres = Math.max(0, (Integer) model.getPlazasTotalesActividad(this.idActividad).get(0)[0]
	                     - (Integer) model.getNumInscripcionesEnActividad(this.idActividad).get(0)[0]); 
	         }

	         // Si no hay plazas libres, añadir al socio a la lista de espera
	         if(this.plazaslibres == 0) {
	        	 int pos = listaEsperaNosocio.size() + 1;
	        	 while (itrNosocio.hasNext()) {
	        		 ListaEsperaSocio espera = itrNosocio.next();
	        		 pos = espera.getPosicion();
	        		 if (espera.getIdSocio() == this.idNoSocio) {
	        			 JOptionPane.showMessageDialog(null,
	        					 "Ya está en la lista de espera para esta actividad.", "Inscripción",
	        					 JOptionPane.INFORMATION_MESSAGE);
	        			 return;
	        		 }
	        	 }
	        	 model.insertListaEsperaNoSocio(this.idActividad, this.idNoSocio, pos);
	        	 JOptionPane.showMessageDialog(null, "Se ha inscrito al no-socio " + idNoSocio
	        			 + " en lista de espera de no-socios para la actividad " + idActividad + " con éxito.\n"
	        			 + "Posición en lista de espera de no-socios: " + pos);
	        	 this.plazaslibres = Math.max(0, (Integer) model.getPlazasTotalesActividad(this.idActividad).get(0)[0]
	                     - (Integer) model.getNumInscripcionesEnActividad(this.idActividad).get(0)[0]); 
	         }
	    }
	}
}
