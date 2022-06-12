package ar.edu.unq.po2.tpfinal;

import java.util.HashSet;

public class Buscador {

	private AplicacionWeb appWeb;
	private BuscarPor estrategiaBusqueda;
	
	/**@author Lenardo Criado
	 * 
	 * Esta clase ejecuta una estrategia de busqueda que utiliza un set de Muestras como parametro.
	 * 
	 * @param app
	 */

	public Buscador(AplicacionWeb app) {
		this.setAppWeb(app);
	}

	//Setters
	private void setAppWeb(AplicacionWeb app) {
		this.appWeb = app;
	}
	private void setEstrategiaDeBusqueda(BuscarPor eBusqueda1) {
		this.estrategiaBusqueda = eBusqueda1;	
	}
	
	//Getters
	BuscarPor getEstrategiaDeBusqueda() {
		return this.estrategiaBusqueda;
	}
	

	public HashSet<Muestra> buscar(BuscarPor eBusqueda1) {
		/**
		 * retorna un Set de muestras de appWeb segun la estrategia de busqueda seteada por parametro
		 */
		this.setEstrategiaDeBusqueda(eBusqueda1);
		BuscarPor eBusqueda =  this.getEstrategiaDeBusqueda();
		HashSet<Muestra> muestrasSet = new HashSet<Muestra>(appWeb.getMuestras()); //pasamos ArrayList a Set
		return eBusqueda.buscar(muestrasSet);
		
	}

	

	
	
}
