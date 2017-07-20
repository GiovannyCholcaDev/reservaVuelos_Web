package ec.utpl.controllers;

import java.io.IOException;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import ec.utpl.util.JsfUtil;

/**
 * @author Giovanny Cholca
 *
 */
@ManagedBean(name = "menuCtr")
@SessionScoped
public class MenuController {

	private PasoUnoFechaController pasoUnoCtrl;
	private PasoDosVueloController pasoDosCtrl;
	private PasoTresPrecioController pasoTresCtrl;
	private int stepIndex;

	public int getStepIndex() {
		return stepIndex;
	}

	public void setStepIndex(int stepIndex) {
		this.stepIndex = stepIndex;
	}

	public void setStepIndexByRemoteCommand() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> map = context.getExternalContext().getRequestParameterMap();
		String indexString = map.get("index");
		stepIndex = Integer.valueOf(indexString);
		System.out.println(stepIndex);
		this.directToPage(stepIndex);
	}

	public void directToPage(int stepIndex) {
		try {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			switch (stepIndex) {
			case 0:
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/pasoUnoFecha.jsf");
				break;
			case 1:
				pasoDosCtrl = (PasoDosVueloController) JsfUtil.obtenerObjetoSesion("pasoDosCtrl");
				pasoDosCtrl.obtenerItinerarioOrigen();
				pasoDosCtrl.obtenerItinerarioDestino();
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/pasoDosVuelos.jsf");
				break;
			case 2:
				pasoTresCtrl = (PasoTresPrecioController) JsfUtil.obtenerObjetoSesion("pasoTresCtrl");
				Boolean opcion = pasoTresCtrl.validarItinerarios();
				if(opcion){
					pasoTresCtrl.calcularVuelosPorPasajeros();
					ec.redirect(ec.getRequestContextPath() + "/pages/administracion/pasoTresPrecio.jsf");
				}else{
					JsfUtil.msgError("Las fechas seleccionadas no son validas");
				}
				break;
			case 3:
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/pasoCuatroPasajeros.jsf");
				break;
			case 4:
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/pasoCincoPago.jsf");
				break;
			case 5:
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/pasoSeisConfirmacion.jsf");
				break;
			default:
				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

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

}
