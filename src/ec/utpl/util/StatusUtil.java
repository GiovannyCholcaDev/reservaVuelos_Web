package ec.utpl.util;

import java.util.Locale;
import java.util.Properties;

import javax.faces.application.ViewExpiredException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class StatusUtil {

    private Locale locale = FacesContext.getCurrentInstance().getViewRoot()
	    .getLocale();

    public StatusUtil() {
	setLanguage("es", "EC");
    }

    /**
     * 
     * Metodo para mostrar un mensaje de si el sistema esta en test o en
     * produccion
     * 
     * @author fochoa
     * @version 04/06/2014 - 9:20:09
     * @return
     */

    public String carga() {

	String temp = "";
	Properties properties = new Properties();
	ExternalContext ec = FacesContext.getCurrentInstance()
	        .getExternalContext();

	try {
	    properties.load(ec
		    .getResourceAsStream("/WEB-INF/status.properties"));
	    String var = properties.getProperty("Test");
	    System.out.println(var);

	    if (Boolean.parseBoolean(var)) {
		temp = properties.getProperty("mensaje");
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return temp;
    }

    public Locale getLocale() {

	return locale;
    }

    public String getLanguage() {

	return locale.getLanguage();
    }

    public void setLanguage(String language, String region) {
	locale = new Locale(language, region);
	FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    public void excepcion() {
	throw new ViewExpiredException();
    }
}
