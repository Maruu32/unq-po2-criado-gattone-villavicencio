package ar.edu.unq.po2.tpfinal;

public class Organizacion implements ObserverZona{
	
	protected Ubicacion ubicacion;
	protected TipoOrganizacion tipo;
	protected Integer trabajdores;
	protected FuncionalidadExterna accionProgramadaNuevaMuestra;
	protected FuncionalidadExterna accionProgramadaMuestraValidada;
	
	/**
	 * @author Lenardo Criado
	 * 
	 * Esta clase modela una organizacion que tiene como variables de instancia una ubicacion, tipo de organizacion, cantidad de trabajadores.
	 * 
	 * Ademas se le configuran funcionalidades externas que se ejecutan cuando se carga o se valida una muestra las cuales pueden modificarse luego de instaciarse
	 * 
	 * @return
	 */
	
	
	//getters
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public TipoOrganizacion getTipo() {
		return tipo;
	}
	public Integer getTrabajadores() {
		return trabajdores;
	}
	public FuncionalidadExterna getAccionProgramadaNuevaMuestra() {
		return accionProgramadaNuevaMuestra;
	}
	public FuncionalidadExterna getAccionProgramadaMuestraValidada() {
		return accionProgramadaMuestraValidada;
	}
	
	
	//setters
	protected void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	protected void setTipo(TipoOrganizacion tipo) {
		this.tipo = tipo;
	}
	protected void setTrabajdores(Integer trabajdores) {
		this.trabajdores = trabajdores;
	}
	public void setAccionProgramadaNuevaMuestra(FuncionalidadExterna accionProgramadaNuevaMuestra) {
		this.accionProgramadaNuevaMuestra = accionProgramadaNuevaMuestra;
	}
	public void setAccionProgramadaMuestraValidada(FuncionalidadExterna accionProgramadaMuestraValidada) {
		this.accionProgramadaMuestraValidada = accionProgramadaMuestraValidada;
	}
	
	
	
	public Organizacion(Ubicacion ubicacion1, TipoOrganizacion tipo, Integer trabajadores, FuncionalidadExterna fe1,
						FuncionalidadExterna fe2) {
		this.setUbicacion(ubicacion1);
		this.setTipo(tipo);
		this.setTrabajdores(trabajadores);
		this.setAccionProgramadaNuevaMuestra(fe1);
		this.setAccionProgramadaMuestraValidada(fe2);
	}


	
	@Override
	public void update(ZonaDeCobertura zonaDeCobertura, Muestra muestra1, TipoAvisoZona tipoAviso) {//TODO: ver si se puede hacer mejor
		if (tipoAviso.equals(TipoAvisoZona.NUEVA_MUESTRA)) 
			this.getAccionProgramadaNuevaMuestra().nuevoEvento(this, zonaDeCobertura, muestra1);
		else 
			this.getAccionProgramadaMuestraValidada().nuevoEvento(this, zonaDeCobertura, muestra1);
		
	}

}
