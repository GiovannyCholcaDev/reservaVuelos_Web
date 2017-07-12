package ec.utpl.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.utpl.reserva.vuelos.negocio.dao.ItinerarioDAO;

import ec.utpl.util.JsfUtil;
import modelo.vistas.ItinerarioTransient;

@ManagedBean(name = "pasoDosCtrl")
@SessionScoped()
public class PasoDosVueloController {
	
	private String lectura;
	private PasoUnoFechaController pasoUnoCtrl;
	private List<ItinerarioTransient> itinerariosCol;
	private List<ItinerarioTransient> itinerariosDestinoCol;
	private ItinerarioTransient itinerarioOrigenSelect;
	private ItinerarioTransient itinerarioDestinoSelect;
	
	@EJB
	private ItinerarioDAO itinerarioDao;
	
	public PasoDosVueloController(){
		pasoUnoCtrl = new PasoUnoFechaController();
		itinerarioOrigenSelect = new ItinerarioTransient();
		itinerarioDestinoSelect = new ItinerarioTransient();
	}
	
	@PostConstruct()
	private void start(){
	  pasoUnoCtrl = (PasoUnoFechaController) JsfUtil.obtenerObjetoSesion("pasoUnoCtr");
	  itinerariosCol =  itinerarioDao.obtenerItinerarios();
	  itinerariosDestinoCol =  itinerarioDao.obtenerItinerarios();
	}
	
	public void clicBoton(){
		System.out.println(pasoUnoCtrl.getAeropuertoIdaSelect().getNombreAeropuerto());
		System.out.println(pasoUnoCtrl.getAeropuertoLlegadaSelect().getNombreAeropuerto());
		itinerariosCol = itinerarioDao.obtenerItinerarios();
		itinerariosCol.size();
	}
	
	  public void onRowSelect(SelectEvent event) {
		  	System.out.println("entro select");
		  	itinerarioOrigenSelect = ((ItinerarioTransient) event.getObject());
		  	System.out.println("nombre aeropuesto origen");
		  	System.out.println(itinerarioOrigenSelect.getNombreAeropuertoOrigen() + "  " + itinerarioOrigenSelect.getIdVuelo());
	        /*FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
	        FacesContext.getCurrentInstance().addMessage(null, msg);*/
	  }
	 
	   public void onRowUnselect(UnselectEvent event) {
		   	System.out.println("entro Un select");
		   	itinerarioDestinoSelect = ((ItinerarioTransient) event.getObject());
		  	System.out.println("nombre aeropuesto origen");
		  	System.out.println(itinerarioDestinoSelect.getNombreAeropuertoOrigen() + "  " + itinerarioDestinoSelect.getIdVuelo());
	        /*FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
	        FacesContext.getCurrentInstance().addMessage(null, msg);*/
	  }
	

	public PasoUnoFechaController getPasoUnoCtrl() {
		return pasoUnoCtrl;
	}

	public void setPasoUnoCtrl(PasoUnoFechaController pasoUnoCtrl) {
		this.pasoUnoCtrl = pasoUnoCtrl;
	}

	public String getLectura() {
		return lectura;
	}

	public void setLectura(String lectura) {
		this.lectura = lectura;
	}

	public void setItinerarioDao(ItinerarioDAO itinerarioDao) {
		this.itinerarioDao = itinerarioDao;
	}

	public List<ItinerarioTransient> getItinerariosCol() {
		return itinerariosCol;
	}

	public void setItinerariosCol(List<ItinerarioTransient> itinerariosCol) {
		this.itinerariosCol = itinerariosCol;
	}

	public ItinerarioTransient getItinerarioOrigenSelect() {
		return itinerarioOrigenSelect;
	}

	public void setItinerarioOrigenSelect(ItinerarioTransient itinerarioOrigenSelect) {
		this.itinerarioOrigenSelect = itinerarioOrigenSelect;
	}

	public List<ItinerarioTransient> getItinerariosDestinoCol() {
		return itinerariosDestinoCol;
	}

	public void setItinerariosDestinoCol(List<ItinerarioTransient> itinerariosDestinoCol) {
		this.itinerariosDestinoCol = itinerariosDestinoCol;
	}

	public ItinerarioTransient getItinerarioDestinoSelect() {
		return itinerarioDestinoSelect;
	}

	public void setItinerarioDestinoSelect(ItinerarioTransient itinerarioDestinoSelect) {
		this.itinerarioDestinoSelect = itinerarioDestinoSelect;
	}

}
