package ec.utpl.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.utpl.reserva.vuelos.negocio.dao.AeropuertoDAO;

import modelo.Aeropuerto;

@ManagedBean(name = "aeropuertoService", eager = true)
@ApplicationScoped
public class AeropuertoService {

	@EJB
	private AeropuertoDAO aeropuertoDao;
	
	private List<Aeropuerto> aeropuertos;

	@PostConstruct
	public void init() {
		System.out.println("inicio del service");
		aeropuertos = new ArrayList<Aeropuerto>();
		aeropuertos = aeropuertoDao.obtenerListaAeropuertos();

	}

	public void setAeropuertoDao(AeropuertoDAO aeropuertoDao) {
		this.aeropuertoDao = aeropuertoDao;
	}
	
	public List<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}

}
