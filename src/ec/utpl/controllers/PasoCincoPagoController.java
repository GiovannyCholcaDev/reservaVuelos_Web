package ec.utpl.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.utpl.util.JsfUtil;

@ManagedBean(name = "pasoCincoCtrl")
@SessionScoped()
public class PasoCincoPagoController {
	
	private String lectura;
	private Boolean confirmar;
	private PasoUnoFechaController pasoUnoCtrl;
	private PasoDosVueloController pasoDosCtrl;
	private PasoTresPrecioController pasoTresCtrl;
	private PasoCuatroPasajeroController pasoCuatroCrtl;
	
	private Integer idTarjetaSelect;
	private String nombreTarjetaSelect;
	
	private String emitidaEnSelect;
	private String nombreBancoEmisorSelect;
	private String nombreIdentificacion;
	private String numeroTarjetahabienteSelect;
	private String nombrePaisEmisionSelect;
	private Integer numeroTarjetaPago;
	
	private List<String> banconEmisoresCol;
	private List<String> tipoDocumentosCol;
	
	public PasoCincoPagoController() {
		pasoUnoCtrl = new PasoUnoFechaController();
		pasoDosCtrl = new PasoDosVueloController();
		pasoTresCtrl = new PasoTresPrecioController();
		pasoCuatroCrtl = new PasoCuatroPasajeroController();
		
		banconEmisoresCol = new ArrayList<String>();
		tipoDocumentosCol = new ArrayList<String>();
	}

	@PostConstruct()
	private void start() {
		pasoUnoCtrl = (PasoUnoFechaController) JsfUtil.obtenerObjetoSesion("pasoUnoCtr");
		pasoDosCtrl = (PasoDosVueloController) JsfUtil.obtenerObjetoSesion("pasoDosCtrl");
		pasoTresCtrl = (PasoTresPrecioController) JsfUtil.obtenerObjetoSesion("pasoTresCtrl");
		pasoCuatroCrtl = (PasoCuatroPasajeroController) JsfUtil.obtenerObjetoSesion("pasoCuatroCtrl");
		this.obtenerBancosEmisores();
		this.obtenerTipoDocumento();
	}
	
	private void obtenerBancosEmisores(){
		banconEmisoresCol.add("Bancos locales");
		banconEmisoresCol.add("Bancos Internacionales");
	}
	
	private void obtenerTipoDocumento(){
		tipoDocumentosCol.add("C\u00e9dula");
		tipoDocumentosCol.add("Pasaporte");
	}
	
	public String validarPageCinco(){
		if(pasoCuatroCrtl.getClienteCol().isEmpty()){
			return "Registre los pasajeros";
		}
		if (pasoCuatroCrtl.getClienteCol().size() < pasoUnoCtrl.getNumPasajeroSelect()){
			return "Debe ingresar el total de: " + pasoUnoCtrl.getNumPasajeroSelect() + " pasajeros";
		}
		return null;
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

	public Integer getIdTarjetaSelect() {
		return idTarjetaSelect;
	}

	public void setIdTarjetaSelect(Integer idTarjetaSelect) {
		this.idTarjetaSelect = idTarjetaSelect;
	}

	public String getNombreTarjetaSelect() {
		return nombreTarjetaSelect;
	}

	public void setNombreTarjetaSelect(String nombreTarjetaSelect) {
		this.nombreTarjetaSelect = nombreTarjetaSelect;
	}

	public String getEmitidaEnSelect() {
		return emitidaEnSelect;
	}

	public void setEmitidaEnSelect(String emitidaEnSelect) {
		this.emitidaEnSelect = emitidaEnSelect;
	}


	public String getNombrePaisEmisionSelect() {
		return nombrePaisEmisionSelect;
	}

	public void setNombrePaisEmisionSelect(String nombrePaisEmisionSelect) {
		this.nombrePaisEmisionSelect = nombrePaisEmisionSelect;
	}

	public String getNombreBancoEmisorSelect() {
		return nombreBancoEmisorSelect;
	}

	public void setNombreBancoEmisorSelect(String nombreBancoEmisorSelect) {
		this.nombreBancoEmisorSelect = nombreBancoEmisorSelect;
	}

	public List<String> getBanconEmisoresCol() {
		return banconEmisoresCol;
	}

	public void setBanconEmisoresCol(List<String> banconEmisoresCol) {
		this.banconEmisoresCol = banconEmisoresCol;
	}

	public List<String> getTipoDocumentosCol() {
		return tipoDocumentosCol;
	}

	public void setTipoDocumentosCol(List<String> tipoDocumentosCol) {
		this.tipoDocumentosCol = tipoDocumentosCol;
	}

	public String getNombreIdentificacion() {
		return nombreIdentificacion;
	}

	public void setNombreIdentificacion(String nombreIdentificacion) {
		this.nombreIdentificacion = nombreIdentificacion;
	}

	public String getNumeroTarjetahabienteSelect() {
		return numeroTarjetahabienteSelect;
	}

	public void setNumeroTarjetahabienteSelect(String numeroTarjetahabienteSelect) {
		this.numeroTarjetahabienteSelect = numeroTarjetahabienteSelect;
	}

	public Integer getNumeroTarjetaPago() {
		return numeroTarjetaPago;
	}

	public void setNumeroTarjetaPago(Integer numeroTarjetaPago) {
		this.numeroTarjetaPago = numeroTarjetaPago;
	}
	
}
