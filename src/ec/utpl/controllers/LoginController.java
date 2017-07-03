package ec.utpl.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.utpl.reserva.vuelos.negocio.cliente.ISeguridadCrud;

import modelo.seguridad.Login;

/**
 * @author Giovanny Cholca
 *
 */
@ManagedBean(name = "loginCtr")
@ViewScoped
public class LoginController {

	private String nombreUsuario;
	private String clave;

	@EJB
	private ISeguridadCrud seguridadCrud;

	public LoginController() {

	}

	public void loginAcceso(ActionEvent event) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;
		// String direct = null;
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		Login login = null;
		if (nombreUsuario != null && clave != null) {
			try {
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("pNombreUsuario", nombreUsuario);
				parameters.put("pClave", clave);
				login = (Login) this.seguridadCrud.findByNamedQuery("login.findAll", parameters);

				if (login != null) {
					loggedIn = true;
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", nombreUsuario);
					ec.redirect(ec.getRequestContextPath() + "/pages/administracion/pasoUnoFecha.jsf");
				} else {
					loggedIn = false;
					message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Datos incorrectos");
				}

				FacesContext.getCurrentInstance().addMessage(null, message);
				context.addCallbackParam("loggedIn", loggedIn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

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

	public void setSeguridadCrud(ISeguridadCrud seguridadCrud) {
		this.seguridadCrud = seguridadCrud;
	}
}
