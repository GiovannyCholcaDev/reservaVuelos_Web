package ec.utpl.controllers;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

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
	private BigDecimal totalValorTarifa;
	private BigDecimal totalImpuestosTasa;
	private BigDecimal totalPagarTarifaIndividual;
	private BigDecimal totalPagarTarifa;
	
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
	}
	
	
	public String validarItinerarios(){
		String msg = "";
		if(pasoDosCtrl.getItinerarioIdaSelect() == null){
			msg = "Seleccione el Initerario de Ida";
		}else{
			Date fechaIda = pasoDosCtrl.getItinerarioIdaSelect().getFechaOrigen();
			Time horaIda = pasoDosCtrl.getItinerarioIdaSelect().getHoraOrigen();
				if(pasoUnoCtrl.getIdayVuelaSelect().equals("true")){
					if(pasoDosCtrl.getItinerarioVueltaSelect() == null){
						msg =  "Seleccione Itinerario para un vuelo de Retorno";
					}else{
						Date fechaVuelta = pasoDosCtrl.getItinerarioVueltaSelect().getFechaOrigen();
						Time horaVuelta = pasoDosCtrl.getItinerarioVueltaSelect().getHoraDestino();
						if(fechaVuelta.before(fechaIda)){
							msg ="La fecha de Retorno no puede ser anterior a la Fecha de Ida";
						}
						
						if(fechaIda.compareTo(fechaVuelta) == 0) {
							if(fechaIda.compareTo(fechaVuelta) == 0 ){
								msg ="Las horas en el mismo dia no pueden ser iguales";
							}
							if(horaVuelta.before(horaIda)){
								msg ="La hora de retorno no puede ser anterior a la hora de Ida";
							}
						}
					}
				}
		}
		return msg;
	}
	
	public void calcularVuelosPorPasajeros() {
		
		BigDecimal valorTarifaIda = pasoDosCtrl.getItinerarioIdaSelect().getValorTarifa();
		BigDecimal impuestoTasaIda = pasoDosCtrl.getItinerarioIdaSelect().getImpuestoTasa();
		BigDecimal totalPagarIda = pasoDosCtrl.getItinerarioIdaSelect().getTotalPagarTarifa();
		BigDecimal valorTarifaVuelta = null;
		BigDecimal impuestoTasaVuelta = null;
		BigDecimal totalPagarVuelta = null;

		if(pasoUnoCtrl.getIdayVuelaSelect().equals("true")){
			 valorTarifaVuelta = pasoDosCtrl.getItinerarioVueltaSelect().getValorTarifa();
			 impuestoTasaVuelta = pasoDosCtrl.getItinerarioVueltaSelect().getImpuestoTasa();
			 totalPagarVuelta = pasoDosCtrl.getItinerarioVueltaSelect().getTotalPagarTarifa();
		}
		
		if(valorTarifaIda == null) valorTarifaIda = BigDecimal.ZERO;
		if(valorTarifaVuelta == null) valorTarifaVuelta = BigDecimal.ZERO;
		if(impuestoTasaIda == null)	impuestoTasaIda = BigDecimal.ZERO;
		if(impuestoTasaVuelta == null)impuestoTasaVuelta = BigDecimal.ZERO;
		if(totalPagarIda == null) totalPagarIda = BigDecimal.ZERO;
		if(totalPagarVuelta == null) totalPagarVuelta = BigDecimal.ZERO;
		
		totalValorTarifa = valorTarifaIda.add(valorTarifaVuelta);
		totalImpuestosTasa = impuestoTasaIda.add(impuestoTasaVuelta);
		totalPagarTarifaIndividual = totalPagarIda.add(totalPagarVuelta);
		Integer numeroPasajeros = pasoUnoCtrl.getNumPasajeroSelect();
		totalPagarTarifa = totalPagarTarifaIndividual.multiply(new BigDecimal(numeroPasajeros));
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

	public BigDecimal getTotalValorTarifa() {
		return totalValorTarifa;
	}

	public void setTotalValorTarifa(BigDecimal totalValorTarifa) {
		this.totalValorTarifa = totalValorTarifa;
	}

	public BigDecimal getTotalImpuestosTasa() {
		return totalImpuestosTasa;
	}

	public void setTotalImpuestosTasa(BigDecimal totalImpuestosTasa) {
		this.totalImpuestosTasa = totalImpuestosTasa;
	}

	public BigDecimal getTotalPagarTarifa() {
		return totalPagarTarifa;
	}

	public void setTotalPagarTarifa(BigDecimal totalPagarTarifa) {
		this.totalPagarTarifa = totalPagarTarifa;
	}

	public BigDecimal getTotalPagarTarifaIndividual() {
		return totalPagarTarifaIndividual;
	}

	public void setTotalPagarTarifaIndividual(BigDecimal totalPagarTarifaIndividual) {
		this.totalPagarTarifaIndividual = totalPagarTarifaIndividual;
	}
	
	

}
