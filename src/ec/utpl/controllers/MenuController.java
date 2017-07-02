package ec.utpl.controllers;

import java.io.IOException;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author Giovanny Cholca
 *
 */
@ManagedBean(name = "menuCtr")
@SessionScoped
public class MenuController {

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
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/paso1Fecha.jsf");
				break;
			case 1:
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/paso2Vuelos.jsf");
				break;
			case 2:
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/paso3Precio.jsf");
				break;
			case 3:
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/paso4Pasajeros.jsf");
				break;
			case 4:
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/paso5Pago.jsf");
				break;
			case 5:
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/paso6Confirmacion.jsf");
				break;
			default:
				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
