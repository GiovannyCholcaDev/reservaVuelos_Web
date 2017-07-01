package ec.utpl.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.utpl.reserva.vuelos.negocio.cliente.IAdminCrud;
import com.utpl.reserva.vuelos.negocio.dao.AeropuertoDAO;
import com.utpl.reserva.vuelos.negocio.dao.ClasificacionCabinaDAO;

import modelo.Aeropuerto;
import modelo.Clasificacioncabina;

@ManagedBean(name = "paso1Ctr")
@ViewScoped
public class Paso1FechaController {

	private Boolean soloIda;
	private String idayVuela;
	private List<Aeropuerto> listaAeropuertoIda;
	private List<Aeropuerto> listaAeropuertoLLegada;
	private List<Clasificacioncabina> listaCabina;
	private Aeropuerto aeropuertoIdaSelect;
	private Aeropuerto aeropuertoLlegadaSelect;
	
	@EJB
	private IAdminCrud adminCrud;

	@EJB
	private AeropuertoDAO aeropuertoDao;

	@EJB
	private ClasificacionCabinaDAO clasificacionCabinaDao;

	public Paso1FechaController() {
		
		listaAeropuertoIda = new ArrayList<Aeropuerto>();
		listaAeropuertoLLegada = new ArrayList<Aeropuerto>();
		listaCabina = new ArrayList<Clasificacioncabina>();
	}

	@PostConstruct
	private void start() {
		try {
			System.out.println("entro en start");
			List<Aeropuerto> listaAeropuerto = new ArrayList<Aeropuerto>();
			listaAeropuerto = aeropuertoDao.obtenerListaAeropuertos();
			listaAeropuertoIda = new ArrayList<Aeropuerto>(listaAeropuerto);
			listaAeropuertoLLegada = new ArrayList<Aeropuerto>(listaAeropuerto);

			listaCabina = clasificacionCabinaDao.obtenerClasificacionCabina();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Aeropuerto> completeAeropuerto(String query){
		System.out.println("query: ");
		System.out.println(query); 
		
        List<Aeropuerto> resultsAeropuerto = new ArrayList<Aeropuerto>();
        resultsAeropuerto = listaAeropuertoIda;
        return resultsAeropuerto;
	}
	
	public void buscarLista() {
		System.out.println("entro en metodo");
		System.out.println(aeropuertoIdaSelect);
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

	public void setClasificacionCabinaDao(ClasificacionCabinaDAO clasificacionCabinaDao) {
		this.clasificacionCabinaDao = clasificacionCabinaDao;
	}

	public String getIdayVuela() {
		return idayVuela;
	}

	public void setIdayVuela(String idayVuela) {
		this.idayVuela = idayVuela;
	}

	public Aeropuerto getAeropuertoIdaSelect() {
		return aeropuertoIdaSelect;
	}

	public void setAeropuertoIdaSelect(Aeropuerto aeropuertoIdaSelect) {
		this.aeropuertoIdaSelect = aeropuertoIdaSelect;
	}

	public Aeropuerto getAeropuertoLlegadaSelect() {
		return aeropuertoLlegadaSelect;
	}

	public void setAeropuertoLlegadaSelect(Aeropuerto aeropuertoLlegadaSelect) {
		this.aeropuertoLlegadaSelect = aeropuertoLlegadaSelect;
	}


}
