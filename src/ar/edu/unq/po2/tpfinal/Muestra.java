package ar.edu.unq.po2.tpfinal;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpfinal.ubicacion.Ubicacion;

public class Muestra {
	private BufferedImage foto; 
	private Ubicacion ubicacion;
	private Usuario usuario;
	private LocalDate fechaCreacion = LocalDate.now();
	private Opinion opinion;
	
	private List <Opinion> opinionesExp = new ArrayList <>();
	private List <Opinion> opinionesBas = new ArrayList <>();
	
	private MuestraState validacionMuestra = new ValidacionMuestraBasico();
			
	public Muestra(Usuario usuario, Ubicacion u, BufferedImage foto, Opinion aOpinion) {
		this.setUbicacion(u); 
		this.setFoto(foto);
		this.setOpinion(aOpinion);
	} 

	public ClasificacionMuestra getTipo() {
		return this.getOpinion().getTipoMuestra();
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
	public MuestraState getValidacionMuestra() {
		return this.validacionMuestra;
	}
	
	public ClasificacionMuestra getMuestraValidadaActual() {
		return this.getValidacionMuestra().getMuestraValidadaActual(this);
	}
	
	public Boolean estaVerificada() {
		return this.getValidacionMuestra().esMuestraVerificada(this);
	}
	
	public LocalDate getUltimaFechaOpinion() {
		return this.getValidacionMuestra().getUltimaOpinion(this);
	}
	
	protected void setMuestraState(MuestraState aSampleState) {
		this.validacionMuestra = aSampleState;
	}
	//Opiniones
	
	private Opinion getOpinion(){ return this.opinion;}
	
	private void setOpinion(Opinion op){ this.opinion = op; }
	
	public List<Opinion> getOpinionesBasicos(){ return this.opinionesBas; }
	
	public List<Opinion> getOpinionesExpertos(){ return this.opinionesExp; }
	
	public List<Opinion> getOpiniones() {
		List<Opinion> reviews = new ArrayList<>();
		reviews.addAll(this.getOpinionesBasicos());
		reviews.addAll(this.getOpinionesExpertos());
		return reviews;
	}
	
	//Ubicacion
	private void setUbicacion(Ubicacion u) { this.ubicacion = u;}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	//Foto
	private void setFoto(BufferedImage f) { this.foto = f; }
	
	public BufferedImage getFoto() { return this.foto; }

	//Usuario
	public Usuario getUsuario() { return usuario; }
	
	public LocalDate getFechaCreacion(){
		return this.fechaCreacion;
	}
	
	public List<Muestra> muestasAMenosDe(double distancia, List<Muestra> muestras) {
		/**
		 * Retorna una sublista de @param muestras con las muestras a menos de @param distancia en de @param muestra1
		 */
		Ubicacion ubicacionMuestra =  this.getUbicacion();
		return muestras
				.stream()
				.filter(muestra -> ubicacionMuestra.distanciaEnKm(muestra.getUbicacion()) < distancia) //Filtrando muestras con ubicación menor a distancia
				.collect(Collectors.toList());
	}
	
}
