package ec.utpl.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.utpl.util.JsfUtil;

@ManagedBean(name = "pasoTresCtrl")
@SessionScoped()
public class PasoTresPrecioController {
	
	private String lectura;
	private PasoUnoFechaController pasoUnoCtrl;
	private PasoDosVueloController pasoDosCtrl;
	
	public PasoTresPrecioController(){
		System.out.println("CONTROLLER PASO TRES");
		pasoUnoCtrl = new PasoUnoFechaController();
		pasoDosCtrl = new PasoDosVueloController();
	}
	
	@PostConstruct()
	private void start(){
			System.out.println("POST CONTRUCTOR CONTROLLER PASO TRES");
		  pasoUnoCtrl = (PasoUnoFechaController) JsfUtil.obtenerObjetoSesion("pasoUnoCtr");
		  pasoDosCtrl = (PasoDosVueloController) JsfUtil.obtenerObjetoSesion("pasoDosCtrl");
	}
	
	
	public void clicBoton(){
		System.out.println("boton");
		System.out.println(pasoDosCtrl.getItinerarioIdaSelect().getIdVuelo());
		System.out.println(pasoDosCtrl.getItinerarioIdaSelect().getIdVuelo());
	}
	
	public String getLectura() {
		return lectura;
	}
	public void setLectura(String lectura) {
		this.lectura = lectura;
	}
	public PasoUnoFechaController getPasoUnoCtrl() {
		return pasoUnoCtrl;
	}
	public void setPasoUnoCtrl(PasoUnoFechaController pasoUnoCtrl) {
		this.pasoUnoCtrl = pasoUnoCtrl;
	}
	public PasoDosVueloController getPasoDosCtrl() {
		return pasoDosCtrl;
	}
	public void setPasoDosCtrl(PasoDosVueloController pasoDosCtrl) {
		this.pasoDosCtrl = pasoDosCtrl;
	}
	
	

}
