package ec.utpl.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.utpl.reserva.vuelos.negocio.dao.ClienteDAO;
import com.utpl.reserva.vuelos.negocio.dao.ReservaDAO;

import ec.utpl.util.JsfUtil;
import modelo.Cliente;
import modelo.Itinerario;
import modelo.Reserva;
import modelo.Tarifa;
import modelo.Vuelo;

@ManagedBean(name = "pasoSeisCtrl")
@SessionScoped()
public class PasoSeisController {
	private String lectura;
	private PasoUnoFechaController pasoUnoCtrl;
	private PasoDosVueloController pasoDosCtrl;
	private PasoTresPrecioController pasoTresCtrl;
	private PasoCuatroPasajeroController pasoCuatroCrtl;
	private PasoCincoPagoController pasoCincoCrtl;
	
	@EJB
	private ClienteDAO clienteDao;
	
	@EJB
	private ReservaDAO reservaDao;
	
	
	public PasoSeisController() {
		pasoUnoCtrl = new PasoUnoFechaController();
		pasoDosCtrl = new PasoDosVueloController();
		pasoTresCtrl = new PasoTresPrecioController();
		pasoCuatroCrtl = new PasoCuatroPasajeroController();
		pasoCincoCrtl = new PasoCincoPagoController();
	}
	
	@PostConstruct
	public void start(){
		pasoUnoCtrl = (PasoUnoFechaController) JsfUtil.obtenerObjetoSesion("pasoUnoCtr");
		pasoDosCtrl = (PasoDosVueloController) JsfUtil.obtenerObjetoSesion("pasoDosCtrl");
		pasoTresCtrl = (PasoTresPrecioController) JsfUtil.obtenerObjetoSesion("pasoTresCtrl");
		pasoCuatroCrtl = (PasoCuatroPasajeroController) JsfUtil.obtenerObjetoSesion("pasoCuatroCtrl");
		pasoCincoCrtl = (PasoCincoPagoController) JsfUtil.obtenerObjetoSesion("pasoCincoCtrl");
	}
	
	
	public void guardarVuelo(ActionEvent actionEvent) {
		//guardar clientes
		List<Cliente> pasajeroCol = pasoCuatroCrtl.getClienteCol();
		if(pasajeroCol.isEmpty()){
			return;
		}else{
			Integer idVueloIda = pasoDosCtrl.getItinerarioIdaSelect().getIdVuelo();
			Integer idItinerarioIda = pasoDosCtrl.getItinerarioIdaSelect().getIdItinerario();
			
			Integer idVueloRetorno = pasoDosCtrl.getItinerarioVueltaSelect().getIdVuelo();
			Integer idItinerarioRetorno = pasoDosCtrl.getItinerarioVueltaSelect().getIdItinerario();
			
			for (Cliente cliente : pasajeroCol) {
					 cliente = clienteDao.guardarCliente(cliente);
					
					 Reserva reservaVuelo = new Reserva();
					 Vuelo vueloIda = new Vuelo();
					 vueloIda.setIdVuelo(idVueloIda);
					 Itinerario itinerarioIda = new Itinerario();
					 itinerarioIda.setIdItinerario(idItinerarioIda);
					 vueloIda.setItinerario(itinerarioIda);
					 Tarifa tarifaIda = new Tarifa();
					 tarifaIda.setIdTarifa(2);
					 vueloIda.setTarifa(tarifaIda);
					 vueloIda.setNumeroVuelo(1);
					 
					 reservaVuelo.setCliente(cliente);
					 reservaVuelo.setVuelo(vueloIda);
					 reservaVuelo = reservaDao.guardarReserva(reservaVuelo);
					 
					 
					 Reserva reservaRetorno = new Reserva();
					 Vuelo vueloRetorno = new Vuelo();
					 vueloRetorno.setIdVuelo(idVueloRetorno);
					 Itinerario itinerarioRetorno = new Itinerario();
					 itinerarioRetorno.setIdItinerario(idItinerarioRetorno);
					 vueloRetorno.setItinerario(itinerarioRetorno);
					 Tarifa tarifaRetorno = new Tarifa();
					 tarifaRetorno.setIdTarifa(3);
					 vueloRetorno.setTarifa(tarifaRetorno);
					 vueloRetorno.setNumeroVuelo(1);
					 
					 reservaRetorno.setCliente(cliente);
					 reservaRetorno.setVuelo(vueloRetorno);
					 reservaRetorno = reservaDao.guardarReserva(reservaRetorno);
					 
			}
		}
		
		
    }
     
	
	public String validarPasoSeis(){
		if(pasoCincoCrtl.getNombreTarjetaSelect() == null || pasoCincoCrtl.getNombreTarjetaSelect() == ""){
			return "Seleccione una tarjeta de cr\u00e9dito";
		}
		
		if(pasoCincoCrtl.getEmitidaEnSelect() == null || pasoCincoCrtl.getEmitidaEnSelect() == ""){
			return "Seleccionar el pa\u00eds de emisi\u00f3n de la tarjeta";
		}
		
		if(pasoCincoCrtl.getNombreBancoEmisorSelect() == null || pasoCincoCrtl.getNombreBancoEmisorSelect() == ""){
			return "Seleccione el tipo de banco emisor";
		}
		
		if(pasoCincoCrtl.getNombreIdentificacion() == null || pasoCincoCrtl.getNombreIdentificacion() == ""){
			return "Seleccione el tipo de identificaci\u00f3n";
		}
		
		if(pasoCincoCrtl.getNumeroTarjetahabienteSelect() == null || pasoCincoCrtl.getNumeroTarjetahabienteSelect() == ""){
			return "Ingrese el n\u00famero de documento de la tarjeta";
		}
		
		if(pasoCincoCrtl.getNombrePaisEmisionSelect() == null || pasoCincoCrtl.getNombrePaisEmisionSelect() == ""){
			return "Seleccione el pa\u00eds de emisi\u00f3n";
		}
		
		if(pasoCincoCrtl.getConfirmar() == null || !pasoCincoCrtl.getConfirmar()){
			return "Debe aceptar los terminos de condiciones";
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
	public PasoCuatroPasajeroController getPasoCuatroCrtl() {
		return pasoCuatroCrtl;
	}
	public void setPasoCuatroCrtl(PasoCuatroPasajeroController pasoCuatroCrtl) {
		this.pasoCuatroCrtl = pasoCuatroCrtl;
	}
	public PasoCincoPagoController getPasoCincoCrtl() {
		return pasoCincoCrtl;
	}
	public void setPasoCincoCrtl(PasoCincoPagoController pasoCincoCrtl) {
		this.pasoCincoCrtl = pasoCincoCrtl;
	}

	public void setClienteDao(ClienteDAO clienteDao) {
		this.clienteDao = clienteDao;
	}

	public void setReservaDao(ReservaDAO reservaDao) {
		this.reservaDao = reservaDao;
	}
	
	
}
