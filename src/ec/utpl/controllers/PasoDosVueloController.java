package ec.utpl.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.utpl.util.JsfUtil;

@ManagedBean(name = "pasoDosCtrl")
@SessionScoped()
public class PasoDosVueloController {
	
	
	public PasoDosVueloController(){
		
	}
	
	@PostConstruct()
	private void start(){
	 PasoUnoFechaController pasoUno = (PasoUnoFechaController) JsfUtil.obtenerObjetoSesion("pasoUnoCtr");
	 pasoUno.getClass();
	}
	
	
	public void clicBoton(){
		System.out.println("clic");
	}

}
