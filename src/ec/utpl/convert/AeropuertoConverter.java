package ec.utpl.convert;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import ec.utpl.service.AeropuertoService;
import modelo.Aeropuerto;

@FacesConverter("aeropuertoConverter")
public class AeropuertoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				AeropuertoService service = (AeropuertoService) fc.getExternalContext().getApplicationMap().get("aeropuertoService");
				Integer index =  Integer.parseInt(value) - 1;
				if(index >= 0){
					return service.getAeropuertos().get(index);
				}else{
					return new Aeropuerto();
				}
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid aeropuerto."));
			}
		} else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Aeropuerto) object).getIdAeropuerto());
		} else {
			return null;
		}
	}

}
