package ec.utpl.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.utpl.reserva.vuelos.negocio.dao.ItinerarioDAO;

import ec.utpl.util.JsfUtil;
import modelo.vistas.ItinerarioTransient;

@ManagedBean(name = "pasoDosCtrl")
@SessionScoped()
public class PasoDosVueloController {
	
	private String lectura;
	private PasoUnoFechaController pasoUnoCtrl;
	private List<ItinerarioTransient> itinerariosCol;
	private ItinerarioTransient itinerarioSelect;
	
	@EJB
	private ItinerarioDAO itinerarioDao;
	
	public PasoDosVueloController(){
		pasoUnoCtrl = new PasoUnoFechaController();
	}
	
	@PostConstruct()
	private void start(){
	  pasoUnoCtrl = (PasoUnoFechaController) JsfUtil.obtenerObjetoSesion("pasoUnoCtr");
	  itinerariosCol =  itinerarioDao.obtenerItinerarios();
	}
	
	public void clicBoton(){
		System.out.println(pasoUnoCtrl.getAeropuertoIdaSelect().getNombreAeropuerto());
		System.out.println(pasoUnoCtrl.getAeropuertoLlegadaSelect().getNombreAeropuerto());
		itinerariosCol = itinerarioDao.obtenerItinerarios();
		itinerariosCol.size();
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

	public ItinerarioTransient getItinerarioSelect() {
		return itinerarioSelect;
	}

	public void setItinerarioSelect(ItinerarioTransient itinerarioSelect) {
		this.itinerarioSelect = itinerarioSelect;
	}

}
