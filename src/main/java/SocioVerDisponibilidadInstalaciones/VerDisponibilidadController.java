package SocioVerDisponibilidadInstalaciones;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;

import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

public class VerDisponibilidadController {
	private ActividadesModel model;
	private DisponibilidadInstalaciones view;
	
	private String fechaHoy;
	private String fecha30dias;
	
	public VerDisponibilidadController(ActividadesModel m, DisponibilidadInstalaciones v) {
		this.view=v;
		this.model=m;
		
		this.fechaHoy = "2023-03-08"; 
		
		DateFormat hoy = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		fechaHoy = hoy.format(date);
		
		Calendar c= Calendar.getInstance();
		c.setTime(Util.isoStringToDate(fechaHoy));
		c.add(Calendar.DAY_OF_MONTH, 30);
		this.fecha30dias = Util.CalendarToIsoString(c);
		
		initView();
	}
	
	public void initView() {
		
		this.getInstalaciones();
		this.setCabecerasTabla();

		DisponibilidadInstalaciones.frame.setVisible(true);
	}
	
	public void initController() {
		view.getbtnVerDisponb().addActionListener((e->SwingUtil.exceptionWrapper(() -> getListaActividadesActuales())));
	}

	private void getListaActividadesActuales() {
		setTodosLibres();
		List<Actividades> acts = model.getActividades(fechaHoy, fecha30dias, Character.getNumericValue(view.getcbSelecInst().getSelectedItem().toString().charAt(0)));
/*
		System.out.println(view.getInstalacionCB().getSelectedItem().toString());
		System.out.println(view.getTable().getColumnCount());
		System.out.println(view.getTable().getRowCount());
		System.out.println(acts.toString());
*/
		for(Actividades e: acts) {
			System.out.println(e.getActividad());
			String f = e.getFecha();
			int ini = e.getHora_ini();
			int fin = e.getHora_fin();
			for(int i = 0; i < view.getTDisponInstal().getColumnCount(); i++) {
				if(f.equals(view.getTDisponInstal().getValueAt(0, i))) {
						//System.out.println(e.toString() + " -> "+i);
						for(int j = 1; j < view.getTDisponInstal().getRowCount(); j++) {
							String hora = (String) view.getTDisponInstal().getValueAt(j, 0);
							String hrs[] = hora.split(":");
							if(ini <= Integer.parseInt(hrs[0]) && Integer.parseInt(hrs[0]) <= fin ) {
								//System.out.println(e.getActividad());
								if(e.getActividad() != null)
									view.getTDisponInstal().setValueAt(e.getActividad(), j, i);
								else
									view.getTDisponInstal().setValueAt("Administración", j, i);
							}
						}
				}
			}
		}
	}

	private void setTodosLibres() {
		for(int i = 1; i < view.getTDisponInstal().getColumnCount(); i++) {
			for(int j = 1; j < view.getTDisponInstal().getRowCount(); j++) {
				view.getTDisponInstal().setValueAt("Libre", j, i);
			}
		}
	}

	private void setCabecerasTabla() {
		Calendar c = Calendar.getInstance();
		c.setTime(Util.isoStringToDate(fechaHoy));
		for (int i=1 ; i<=30 ; i++) {
			view.getTDisponInstal().getModel().setValueAt(Util.dateToIsoString(c.getTime()), 0, i);
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
		
	}

	private void getInstalaciones() {
		List<Instalaciones> instalaciones = model.getInstalaciones();
		List<Object[]> instalacionesObject = new ArrayList<Object[]>(instalaciones.size());
		for (int i=0; i<instalaciones.size(); i++) {
			Object[] o = new Object[1];
			o[0] = instalaciones.get(i).toString();
			instalacionesObject.add(o);
		}
		ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(instalacionesObject);
		view.getcbSelecInst().setModel(lmodel);
		
	}

}
