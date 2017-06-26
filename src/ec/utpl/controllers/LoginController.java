package ec.utpl.controllers;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

/**
 * @author Giovanny Cholca
 *
 */
@ManagedBean(name = "loginCtr")
@ViewScoped
public class LoginController {

	private String nombreUsuario;
	private String clave;

	public LoginController() {

	}

	public void loginAcceso(ActionEvent event) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;
		//String direct = null;
		ExternalContext ec = FacesContext.getCurrentInstance()
		        .getExternalContext();
		if (nombreUsuario != null && nombreUsuario.equals("admin") && clave != null && clave.equals("admin")) {
			try {
				loggedIn = true;
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", nombreUsuario);
				ec.redirect(ec.getRequestContextPath() + "/pages/administracion/paso1Fecha.jsf");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Datos incorrectos");
			//direct = null;
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", loggedIn);
		//return direct;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}
