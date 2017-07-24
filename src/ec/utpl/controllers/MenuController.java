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
	private PasoCuatroPasajeroController pasoCuatroCtrl;
	private PasoCincoPagoController pasoCincoCtl;
	private PasoSeisController pasoSeisCtrl;
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
				String mensaje = pasoDosCtrl.validarPasoDos();
				if(mensaje == null || mensaje == ""){
					pasoDosCtrl.obtenerItinerarioOrigen();
					pasoDosCtrl.obtenerItinerarioDestino();
					ec.redirect(ec.getRequestContextPath() + "/pages/administracion/pasoDosVuelos.jsf");
				}else{
					this.stepIndex = stepIndex - 1;
					JsfUtil.msgError(mensaje);
				}
				break;
			case 2:
				pasoTresCtrl = (PasoTresPrecioController) JsfUtil.obtenerObjetoSesion("pasoTresCtrl");
				String opcion = pasoTresCtrl.validarItinerarios();
				if(opcion == null || opcion == ""){
					pasoTresCtrl.calcularVuelosPorPasajeros();
					ec.redirect(ec.getRequestContextPath() + "/pages/administracion/pasoTresPrecio.jsf");
				}else{
					this.stepIndex = stepIndex - 1;
					 JsfUtil.msgError(opcion);
				}
				break;
			case 3:
				pasoCuatroCtrl = (PasoCuatroPasajeroController) JsfUtil.obtenerObjetoSesion("pasoCuatroCtrl");
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/pasoCuatroPasajeros.jsf");
				break;
			case 4:
				pasoCincoCtl = (PasoCincoPagoController) JsfUtil.obtenerObjetoSesion("pasoCincoCtrl");
				String mensaj = pasoCincoCtl.validarPageCinco();
				if(mensaj != null && mensaj != ""){
					this.stepIndex = stepIndex - 1;
					 JsfUtil.msgError(mensaj);
				}else{
					ec.redirect(ec.getRequestContextPath() + "/pages/administracion/pasoCincoPago.jsf");
				}
				break;
			case 5:
				pasoSeisCtrl = (PasoSeisController) JsfUtil.obtenerObjetoSesion("pasoSeisCtrl");
				String msg = pasoSeisCtrl.validarPasoSeis();
				if(msg != null && msg != ""){
					this.stepIndex = stepIndex - 1;
					 JsfUtil.msgError(msg);
				}else{
					ec.redirect(ec.getRequestContextPath() + "/pages/administracion/pasoSeisConfirmacion.jsf");
				}
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

	public PasoCuatroPasajeroController getPasoCuatroCtrl() {
		return pasoCuatroCtrl;
	}

	public void setPasoCuatroCtrl(PasoCuatroPasajeroController pasoCuatroCtrl) {
		this.pasoCuatroCtrl = pasoCuatroCtrl;
	}

	public PasoCincoPagoController getPasoCincoCtl() {
		return pasoCincoCtl;
	}

	public void setPasoCincoCtl(PasoCincoPagoController pasoCincoCtl) {
		this.pasoCincoCtl = pasoCincoCtl;
	}

	public PasoSeisController getPasoSeisCtrl() {
		return pasoSeisCtrl;
	}

	public void setPasoSeisCtrl(PasoSeisController pasoSeisCtrl) {
		this.pasoSeisCtrl = pasoSeisCtrl;
	}

}
