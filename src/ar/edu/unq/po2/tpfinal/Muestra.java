package ar.edu.unq.po2.tpfinal;


import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Muestra {
	private BufferedImage foto;
	private Ubicacion ubicacion;
	private Usuario usuario;
	private Date fechaCreacion = new Date();
	private List <Opinion> opinionesExp = new ArrayList <>();
	private List <Opinion> opinionesBas = new ArrayList <>();
	
	private ValidacionMuestra validacionMuestra = new ValidacionMuestraBasica();
	
	private static List<Muestra> registradas = new ArrayList<>();
		
	public Muestra( Ubicacion u, BufferedImage foto, Opinion aOpinion) {
		this.setUbicacion(u); 
		this.setFoto(foto);
		
		/**
		 * @author LeO
		 * 
		 * no se está guardando la primer opinion
		 * 
		 */	
		
	}
	
	private void registrar() {
		registradas.add(this);
		/**
		 * @author LeO
		 * 
		 * Creo que el registrar está de mas ya que la lista de muestras se lleva desde la AplicacionWeb
		 * 
		 */
	}
	
//Devuelve la clasificacion de muestra que mas opiniones tuvo. 
	//Devuelve el tipo de muestra(Vinchuca, Chinche o no Definida ) ganadora en las opiniones.
	public ClasificacionMuestra getTipoGanadorActual(List<Opinion> opiniones) {
		//Creo un mapa para guardar el tipo de muestra con la cantidad de votos. 
		Map <ClasificacionMuestra, Integer> cajaVotos = new HashMap <ClasificacionMuestra, Integer>();
		ponerVotoEnLaCaja(opiniones, cajaVotos);
		return encontrarTipoGanador(cajaVotos);
	}
	
	//Calcula la cantidad de opiniones sobre el mismo tipo, toma una lista de opiniones y el map con los tipos:votos
	private void ponerVotoEnLaCaja(List<Opinion> ops, Map <ClasificacionMuestra, Integer> cv) {
		//Por cada opinion me fijo tipo y le sumo el voto en el mapa.
		for(Opinion op : ops) {
			ClasificacionMuestra tipo = op.getTipoMuestra();
			//containsKey(tipo) me da true o false si el tipo de muestra ya existe en el mapa. 
			//Si ya existe, con get(tipo) traigo el valor para ese tipo de muestra y le sumo uno, sino le asigno 1 
			cv.put(tipo, cv.containsKey(tipo) ? cv.get(tipo)+1 : 1);
		}
		
		/**@author Lenardo Criado
		 * 
		 * estaVerificada()
		 * 
		 * TODO: agregar aviso a zonas si la muestra, está validada.
		 */
	}
	
	//Devuelve el tipo de muestra que mas opiniones tuvo.
	private ClasificacionMuestra encontrarTipoGanador(Map <ClasificacionMuestra, Integer> cajaVotos) {
		ClasificacionMuestra ganador = EspecieNoDefinida.UNDEFINED;
		Integer maxVotos = 0;
		for (ClasificacionMuestra candidato: cajaVotos.keySet()) {
			Integer votos = cajaVotos.get(candidato);
			if (votos >= maxVotos) ganador = (votos > maxVotos) ? candidato : EspecieNoDefinida.UNDEFINED;
			if (votos >= maxVotos) maxVotos = votos;
		}
		return ganador;
	}
	
//Verificacion
	protected ValidacionMuestra getValidacionMuestra() {
		return this.validacionMuestra;
	}
	
	protected void setValidacionMuestra(ValidacionMuestra v) {
		this.validacionMuestra = v;
	}
	
	public ClasificacionMuestra getMuestraValidadaActual() {
		return this.getValidacionMuestra().getMuestraValidadaActual(this);
	}
	
	public List<Opinion> getOpinionesExpertos(){
		return this.opinionesExp;
	}
	
	public List <Opinion> getOpinionesBasicos() {
		return this.opinionesBas;
	}
	
	public Boolean estaVerificada() {
		return this.getValidacionMuestra().esMuestraVerificada(this);
	}
	
	private void setUbicacion(Ubicacion u) { this.ubicacion = u;}
	
	public Ubicacion getUbicacion() {
		// TODO Auto-generated method stub
		return ubicacion;
	}
	
	private void setFoto(BufferedImage f) {
		this.foto = f;
	}
	
	public BufferedImage getFoto() {
		return this.foto;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public Date getFechaCreacion(){
		return this.fechaCreacion;
	}
	
	

}
