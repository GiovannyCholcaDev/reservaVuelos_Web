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
	private ItinerarioTransient itinerarioIdaSelect;
	private ItinerarioTransient itinerarioVueltaSelect;
	
	@EJB
	private ItinerarioDAO itinerarioDao;
	
	public PasoDosVueloController(){
		System.out.println("CONTROLLER PASO DOS");
		pasoUnoCtrl = new PasoUnoFechaController();
		itinerarioIdaSelect = new ItinerarioTransient();
		itinerarioVueltaSelect = new ItinerarioTransient();
	}
	
	@PostConstruct()
	private void start(){
	  System.out.println("@PostConstruct PASO DOS");
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
	
	  public void onRowSelectOrigen(SelectEvent event) {
		  	System.out.println("entro select");
		  	itinerarioIdaSelect = ((ItinerarioTransient) event.getObject());
		  	System.out.println("nombre aeropuesto origen");
		  	System.out.println(itinerarioIdaSelect.getNombreAeropuertoOrigen() + "  " + itinerarioIdaSelect.getIdVuelo());
	        /*FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
	        FacesContext.getCurrentInstance().addMessage(null, msg);*/
	  }
	 
	   public void onRowUnselectOrigen(UnselectEvent event) {
		   	System.out.println("entro Un select");
		   	itinerarioIdaSelect = ((ItinerarioTransient) event.getObject());
		  	System.out.println("nombre aeropuesto origen");
		  	System.out.println(itinerarioIdaSelect.getNombreAeropuertoOrigen() + "  " + itinerarioIdaSelect.getIdVuelo());
	        /*FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
	        FacesContext.getCurrentInstance().addMessage(null, msg);*/
	  }
	   
		  public void onRowSelectDestino(SelectEvent event) {
			  	System.out.println("entro select");
			  	itinerarioVueltaSelect = ((ItinerarioTransient) event.getObject());
			  	System.out.println("nombre aeropuesto origen");
			  	System.out.println(itinerarioVueltaSelect.getNombreAeropuertoOrigen() + "  " + itinerarioVueltaSelect.getIdVuelo());
		        /*FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
		        FacesContext.getCurrentInstance().addMessage(null, msg);*/
		  }
		 
		   public void onRowUnselectDestino(UnselectEvent event) {
			   	System.out.println("entro Un select");
			   	itinerarioVueltaSelect = ((ItinerarioTransient) event.getObject());
			  	System.out.println("nombre aeropuesto origen");
			  	System.out.println(itinerarioVueltaSelect.getNombreAeropuertoOrigen() + "  " + itinerarioVueltaSelect.getIdVuelo());
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

	public List<ItinerarioTransient> getItinerariosDestinoCol() {
		return itinerariosDestinoCol;
	}

	public void setItinerariosDestinoCol(List<ItinerarioTransient> itinerariosDestinoCol) {
		this.itinerariosDestinoCol = itinerariosDestinoCol;
	}

	public ItinerarioTransient getItinerarioIdaSelect() {
		return itinerarioIdaSelect;
	}

	public void setItinerarioIdaSelect(ItinerarioTransient itinerarioIdaSelect) {
		this.itinerarioIdaSelect = itinerarioIdaSelect;
	}

	public ItinerarioTransient getItinerarioVueltaSelect() {
		return itinerarioVueltaSelect;
	}

	public void setItinerarioVueltaSelect(ItinerarioTransient itinerarioVueltaSelect) {
		this.itinerarioVueltaSelect = itinerarioVueltaSelect;
	}



}
