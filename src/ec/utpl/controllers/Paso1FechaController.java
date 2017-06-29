package ec.utpl.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.utpl.reserva.vuelos.negocio.cliente.IAdminCrud;
import com.utpl.reserva.vuelos.negocio.dao.AeropuertoDAO;

import modelo.Aeropuerto;
import modelo.Clasificacioncabina;

@ManagedBean(name = "paso1Ctr")
@ViewScoped
public class Paso1FechaController {

	private Boolean soloIda;
	private List<Aeropuerto> listaAeropuertoIda;
	private List<Aeropuerto> listaAeropuertoLLegada;
	private List<Clasificacioncabina> listaCabina;

	@EJB
	private IAdminCrud adminCrud;

	@EJB
	private AeropuertoDAO aeropuertoDao;

	public Paso1FechaController() {
		listaAeropuertoIda = new ArrayList<Aeropuerto>();
		listaAeropuertoLLegada = new ArrayList<Aeropuerto>();
		listaCabina = new ArrayList<Clasificacioncabina>();
	}

	@PostConstruct
	private void start() {
		try {
			List<Aeropuerto> listaAeropuerto = new ArrayList<Aeropuerto>();
			// listaAeropuertoIda = (List<Aeropuerto>)
			// this.adminCrud.consultarTodos(Aeropuerto.class);
			// evidenciasConceptoProceso =
			// this.adminCrud.findByNamedQuery("Aeropuerto.findAll", null);
			listaAeropuerto = aeropuertoDao.obtenerListaAeropuertos();

			listaAeropuerto.size();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buscarLista() {
		System.out.println("entro en metodo");
	}

	public Boolean getSoloIda() {
		return soloIda;
	}

	public void setSoloIda(Boolean soloIda) {
		this.soloIda = soloIda;
	}

	public List<Aeropuerto> getListaAeropuertoIda() {
		return listaAeropuertoIda;
	}

	public void setListaAeropuertoIda(List<Aeropuerto> listaAeropuertoIda) {
		this.listaAeropuertoIda = listaAeropuertoIda;
	}

	public List<Aeropuerto> getListaAeropuertoLLegada() {
		return listaAeropuertoLLegada;
	}

	public void setListaAeropuertoLLegada(List<Aeropuerto> listaAeropuertoLLegada) {
		this.listaAeropuertoLLegada = listaAeropuertoLLegada;
	}

	public List<Clasificacioncabina> getListaCabina() {
		return listaCabina;
	}

	public void setListaCabina(List<Clasificacioncabina> listaCabina) {
		this.listaCabina = listaCabina;
	}

	public void setAdminCrud(IAdminCrud adminCrud) {
		this.adminCrud = adminCrud;
	}

	public void setAeropuertoDao(AeropuertoDAO aeropuertoDao) {
		this.aeropuertoDao = aeropuertoDao;
	}

}
