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
	private Cliente clienteIngreso;
	private List<String> paisesCol;
	
	public PasoCuatroPasajeroController() {
		System.out.println("CONTROLLER PASO CUATRO");
		pasoUnoCtrl = new PasoUnoFechaController();
		pasoDosCtrl = new PasoDosVueloController();
		pasoTresCtrl = new PasoTresPrecioController();
		clienteCol = new ArrayList<Cliente>();
		clienteIngreso = new Cliente();
		paisesCol = new ArrayList<String>();
	}
	
	@PostConstruct()
	private void start() {
		System.out.println("POST CONTRUCTOR CONTROLLER PASO CUATRO");
		pasoUnoCtrl = (PasoUnoFechaController) JsfUtil.obtenerObjetoSesion("pasoUnoCtr");
		pasoDosCtrl = (PasoDosVueloController) JsfUtil.obtenerObjetoSesion("pasoDosCtrl");
		pasoTresCtrl = (PasoTresPrecioController) JsfUtil.obtenerObjetoSesion("pasoTresCtrl");
		
		this.obtenerListaPaises();
	}
	
	private void obtenerListaPaises(){
		paisesCol.add("Ecuador");
		paisesCol.add("Peru");
		paisesCol.add("Bolivia");
		paisesCol.add("Colombia");
		paisesCol.add("Brazil");
		paisesCol.add("Argentina");
	}
	
	
	public void agregarCliente(ActionEvent actionEvent){
		String msg = this.validarPasajetosAdd(clienteIngreso);
		if(msg != null && msg != ""){
			JsfUtil.msgError(msg);
			return;
		}
		clienteCol.add(clienteIngreso);
		clienteIngreso = new Cliente();
	}
	
	public void remove(Cliente cliente) {
		try {
			clienteCol.remove(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String validarPasajetosAdd(Cliente clienteIngreso){
		
		if(pasoUnoCtrl.getNumPasajeroSelect().equals(clienteCol.size())){
			return "No puede agregar m\u00e1s pasajeros";
		}
		
		if(clienteIngreso.getNombreCli() == null || clienteIngreso.getNombreCli() == ""){
			return "Ingrese el nombre del pasajero";
		}
		
		if(clienteIngreso.getApellidoCli() == null || clienteIngreso.getApellidoCli() == ""){
			return "Ingreses apellido del cliente";
			
		}
		
		if(clienteIngreso.getPasaporte() == null || clienteIngreso.getPasaporte() == ""){
			return "Ingreses el n\u00famero de identificaci\u00f3n";
		}
		
		if(clienteIngreso.getNacionalidad() == null || clienteIngreso.getNacionalidad() == ""){
			return "Ingrese el pa\u00eds de emisi\u00f3n";
		}
		
		return null;
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

	public Cliente getClienteIngreso() {
		return clienteIngreso;
	}

	public void setClienteIngreso(Cliente clienteIngreso) {
		this.clienteIngreso = clienteIngreso;
	}

	public List<String> getPaisesCol() {
		return paisesCol;
	}

	public void setPaisesCol(List<String> paisesCol) {
		this.paisesCol = paisesCol;
	}
}
