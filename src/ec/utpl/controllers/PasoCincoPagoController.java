package ec.utpl.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pasoCincoCtrl")
@SessionScoped()
public class PasoCincoPagoController {
	
	private String lectura;
	private Boolean confirmar;
	

	public PasoCincoPagoController() {
	
	}

	@PostConstruct()
	private void start() {
		
	}

	public String getLectura() {
		return lectura;
	}

	public void setLectura(String lectura) {
		this.lectura = lectura;
	}

	public Boolean getConfirmar() {
		return confirmar;
	}

	public void setConfirmar(Boolean confirmar) {
		this.confirmar = confirmar;
	}
	
}
