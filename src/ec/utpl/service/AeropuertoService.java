package ec.utpl.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.utpl.reserva.vuelos.negocio.dao.AeropuertoDAO;
import com.utpl.reserva.vuelos.negocio.dao.ClasificacionCabinaDAO;

import modelo.Aeropuerto;
import modelo.Clasificacioncabina;

@ManagedBean(name = "aeropuertoService", eager = true)
@ApplicationScoped
public class AeropuertoService {

	@EJB
	private AeropuertoDAO aeropuertoDao;
	
	@EJB
	private ClasificacionCabinaDAO clasificacionCabinaDao;
	
	private List<Aeropuerto> aeropuertos;
	private List<Clasificacioncabina> clasificacionCabina;

	@PostConstruct
	public void init() {
		System.out.println("inicio del service");
		aeropuertos = new ArrayList<Aeropuerto>();
		aeropuertos = aeropuertoDao.obtenerListaAeropuertos();
		
		clasificacionCabina = new ArrayList<Clasificacioncabina>();
		clasificacionCabina = clasificacionCabinaDao.obtenerClasificacionCabina();
	}

	public void setAeropuertoDao(AeropuertoDAO aeropuertoDao) {
		this.aeropuertoDao = aeropuertoDao;
	}
	
	public List<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}

	public List<Clasificacioncabina> getClasificacionCabina() {
		return clasificacionCabina;
	}

	public void setClasificacionCabinaDao(ClasificacionCabinaDAO clasificacionCabinaDao) {
		this.clasificacionCabinaDao = clasificacionCabinaDao;
	}

}
