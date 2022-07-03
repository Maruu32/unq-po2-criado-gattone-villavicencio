package ar.edu.unq.po2.tpfinal.persona;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import ar.edu.unq.po2.tpfinal.ClasificacionMuestra;
import ar.edu.unq.po2.tpfinal.Muestra;
import ar.edu.unq.po2.tpfinal.Opinion;

public class UBasico implements EstadoUsuario  { 

	
	public UBasico() { 
		
	}
	

	@Override
	public void opinar(ClasificacionMuestra clasificacion, Usuario usuario, Muestra muestra) {
		//crea una opinion si puede opinar en la Muestra
		if (puedeOpinar(muestra)) { 
			 usuario.agregarOpinion(new Opinion(usuario, muestra, clasificacion));  
			 subirCategoria(usuario);	
		}
		
	}
	
	private void subirCategoria(Usuario usuario) {
		//Si cumple con la cantidad de muestras y opiniones sube de categoria
		if(relizoDiezMuestras(usuario) && realizoVeinteOpiniones(usuario)){
			usuario.setEstadoUsuario(new UExperto());
		}
	}


	public boolean realizoVeinteOpiniones(Usuario usuario){
		ArrayList<Opinion> resultado = new ArrayList<>();
		usuario.getSusOpiniones().parallelStream().filter(p->contarDias(p.getFechaCreacion(),LocalDate.now())<30).forEach(p -> resultado.add(p));
		return resultado.size() >= 20; 
	}


	public boolean relizoDiezMuestras(Usuario usuario) {
		ArrayList<Muestra> resultado = new ArrayList<>();
		usuario.getAppWeb().getMuestras().parallelStream().filter(p->contarDias(p.getFechaCreacion(),LocalDate.now())<30 ).forEach(p -> resultado.add(p));
		return resultado.size() >= 10;  
	}
	
	
	public boolean puedeOpinar(Muestra muestra) {
		//devuelve true la lista de opinones de experto esta vacia
		return muestra.getOpinionesExpertos().isEmpty();
	}
	
	public long contarDias(LocalDate inicio, LocalDate fin) {
		//me devuelve los que se llevan el incio y el fin
		 long dias = ChronoUnit.DAYS.between(inicio,fin);
		 return dias; 
	}






}
