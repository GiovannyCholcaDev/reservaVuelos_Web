package ec.utpl.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.utpl.reserva.vuelos.negocio.cliente.IAdminCrud;
import com.utpl.reserva.vuelos.negocio.dao.AeropuertoDAO;
import com.utpl.reserva.vuelos.negocio.dao.ClasificacionCabinaDAO;

import ec.utpl.service.AeropuertoService;
import modelo.Aeropuerto;
import modelo.Clasificacioncabina;

@ManagedBean(name = "pasoUnoCtr")
@SessionScoped
public class PasoUnoFechaController {
	private String lectura;
	private Boolean soloIda;
	private String idayVuelaSelect;
	private List<Aeropuerto> listaAeropuertoIda;
	private List<Aeropuerto> listaAeropuertoLLegada;
	private List<Clasificacioncabina> listaCabina;
	private Aeropuerto aeropuertoIdaSelect;
	private Aeropuerto aeropuertoLlegadaSelect;
	private Integer idAeropuertoSelect;
	private Date fechaIdaSelect;
	private Date fechaVueltaSelect;
	private Clasificacioncabina cabinaSelect;
	private Integer idCabinaSelect;
	private List<Integer> numPasajeros;
	private Integer numPasajeroSelect;

	@EJB
	private IAdminCrud adminCrud;

	@EJB
	private AeropuertoDAO aeropuertoDao;

	@EJB
	private ClasificacionCabinaDAO clasificacionCabinaDao;

	@ManagedProperty("#{aeropuertoService}")
	private AeropuertoService aeropuertoservice;

	public PasoUnoFechaController() {
		System.out.println("PasoUnoFechaController...");
		listaAeropuertoIda = new ArrayList<Aeropuerto>();
		listaAeropuertoLLegada = new ArrayList<Aeropuerto>();
		aeropuertoIdaSelect = new Aeropuerto();
		aeropuertoLlegadaSelect = new Aeropuerto();
		numPasajeros = new ArrayList<Integer>();
		idCabinaSelect = 0;
		numPasajeroSelect =0;
		
		listaCabina = new ArrayList<Clasificacioncabina>();
		cabinaSelect = new Clasificacioncabina();
		
	}

	@PostConstruct
	private void start() {
		try {
			System.out.println("entro en start: PasoUnoFechaController");
			 List<Aeropuerto> listaAeropuerto = new ArrayList<Aeropuerto>();
			 listaAeropuerto = aeropuertoDao.obtenerListaAeropuertos();
			 listaAeropuertoIda = new ArrayList<Aeropuerto>(listaAeropuerto);
			 listaAeropuertoLLegada = new ArrayList<Aeropuerto>(listaAeropuerto);
			 listaCabina = clasificacionCabinaDao.obtenerClasificacionCabina();
			this.idayVuelaSelect = "true";
			this.obtenerNumPasajeros();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void obtenerNumPasajeros() {
		for (int i = 1; i <= 10; i++) {
			numPasajeros.add(i);
		}
	}

	public List<Aeropuerto> completeAeropuertoOrigen(String query) {
		System.out.println("entro en complete query: ");
		System.out.println(query);
		List<Aeropuerto> resultsAeropuerto = new ArrayList<Aeropuerto>();
		resultsAeropuerto = aeropuertoservice.getAeropuertos();
		return resultsAeropuerto;
	}

	public List<Aeropuerto> completeAeropuertoDestino(String query) {
		System.out.println("entro en complete query destino: ");
		System.out.println(query);
		List<Aeropuerto> resultsAeropuerto = new ArrayList<Aeropuerto>();
		resultsAeropuerto = aeropuertoservice.getAeropuertos();
		return resultsAeropuerto;
	}

	public void buscarLista() {
		System.out.println("entro en metodo consulta parametros");
		System.out.println("aeropuertoIdaSelect");
		System.out.println(aeropuertoIdaSelect.getNombreAeropuerto());
		System.out.println("listaAeropuertoLLegada");
		System.out.println(aeropuertoLlegadaSelect.getNombreAeropuerto());
		System.out.println("id-cabina");
		System.out.println(idCabinaSelect);
		System.out.println("idayVuelaSelect");
		System.out.println(idayVuelaSelect);
		System.out.println(cabinaSelect.getTipoClase());
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

	public Integer getIdAeropuertoSelect() {
		return idAeropuertoSelect;
	}

	public void setIdAeropuertoSelect(Integer idAeropuertoSelect) {
		this.idAeropuertoSelect = idAeropuertoSelect;
	}

	public void setAeropuertoservice(AeropuertoService aeropuertoservice) {
		this.aeropuertoservice = aeropuertoservice;
	}

	public Date getFechaIdaSelect() {
		return fechaIdaSelect;
	}

	public void setFechaIdaSelect(Date fechaIdaSelect) {
		this.fechaIdaSelect = fechaIdaSelect;
	}

	public Date getFechaVueltaSelect() {
		return fechaVueltaSelect;
	}

	public void setFechaVueltaSelect(Date fechaVueltaSelect) {
		this.fechaVueltaSelect = fechaVueltaSelect;
	}

	public Clasificacioncabina getCabinaSelect() {
		return cabinaSelect;
	}

	public void setCabinaSelect(Clasificacioncabina cabinaSelect) {
		this.cabinaSelect = cabinaSelect;
	}

	public Integer getIdCabinaSelect() {
		return idCabinaSelect;
	}

	public void setIdCabinaSelect(Integer idCabinaSelect) {
		this.idCabinaSelect = idCabinaSelect;
	}

	public List<Integer> getNumPasajeros() {
		return numPasajeros;
	}

	public void setNumPasajeros(List<Integer> numPasajeros) {
		this.numPasajeros = numPasajeros;
	}

	public Integer getNumPasajeroSelect() {
		return numPasajeroSelect;
	}

	public void setNumPasajeroSelect(Integer numPasajeroSelect) {
		this.numPasajeroSelect = numPasajeroSelect;
	}

	public String getIdayVuelaSelect() {
		return idayVuelaSelect;
	}

	public void setIdayVuelaSelect(String idayVuelaSelect) {
		this.idayVuelaSelect = idayVuelaSelect;
	}

	public String getLectura() {
		return lectura;
	}

	public void setLectura(String lectura) {
		this.lectura = lectura;
	}

}
