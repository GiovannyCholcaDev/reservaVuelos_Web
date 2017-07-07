package ec.utpl.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.utpl.util.JsfUtil;

@ManagedBean(name = "pasoDosCtrl")
@SessionScoped()
public class PasoDosVueloController {
	
	PasoUnoFechaController pasoUnoCtrl;
	
	public PasoDosVueloController(){
		pasoUnoCtrl = new PasoUnoFechaController();
	}
	
	@PostConstruct()
	private void start(){
	  pasoUnoCtrl = (PasoUnoFechaController) JsfUtil.obtenerObjetoSesion("pasoUnoCtr");
	  pasoUnoCtrl.getFechaIdaSelect();
	}
	
	
	public void clicBoton(){
		System.out.println(pasoUnoCtrl.getAeropuertoIdaSelect().getNombreAeropuerto());
		System.out.println(pasoUnoCtrl.getAeropuertoLlegadaSelect().getNombreAeropuerto());
	}

	public PasoUnoFechaController getPasoUnoCtrl() {
		return pasoUnoCtrl;
	}

	public void setPasoUnoCtrl(PasoUnoFechaController pasoUnoCtrl) {
		this.pasoUnoCtrl = pasoUnoCtrl;
	}

}
