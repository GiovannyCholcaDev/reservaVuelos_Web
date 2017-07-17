package ec.utpl.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ec.utpl.util.JsfUtil;
import modelo.Cliente;

@ManagedBean(name = "pasoCuatroCtrl")
@SessionScoped()
public class PasoCuatroPasajeroController {

	private String lectura;
	private PasoUnoFechaController pasoUnoCtrl;
	private PasoDosVueloController pasoDosCtrl;
	private PasoTresPrecioController pasoTresCtrl;
	private List<Cliente> clienteCol;
	
	public PasoCuatroPasajeroController() {
		System.out.println("CONTROLLER PASO CUATRO");
		pasoUnoCtrl = new PasoUnoFechaController();
		pasoDosCtrl = new PasoDosVueloController();
		pasoTresCtrl = new PasoTresPrecioController();
		clienteCol = new ArrayList<Cliente>();
	}
	
	@PostConstruct()
	private void start() {
		System.out.println("POST CONTRUCTOR CONTROLLER PASO CUATRO");
		pasoUnoCtrl = (PasoUnoFechaController) JsfUtil.obtenerObjetoSesion("pasoUnoCtr");
		pasoDosCtrl = (PasoDosVueloController) JsfUtil.obtenerObjetoSesion("pasoDosCtrl");
		pasoTresCtrl = (PasoTresPrecioController) JsfUtil.obtenerObjetoSesion("pasoTresCtrl");
	}
	
	
	public void agregarCliente(ActionEvent actionEvent){
		
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

	public PasoTresPrecioController getPasoTresCtrl() {
		return pasoTresCtrl;
	}

	public void setPasoTresCtrl(PasoTresPrecioController pasoTresCtrl) {
		this.pasoTresCtrl = pasoTresCtrl;
	}

	public List<Cliente> getClienteCol() {
		return clienteCol;
	}

	public void setClienteCol(List<Cliente> clienteCol) {
		this.clienteCol = clienteCol;
	}
}
