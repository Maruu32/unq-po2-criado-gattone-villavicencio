package ar.edu.unq.po2.tpfinal.muestra;

public enum NivelVerificacion {
	/**
	 * @author Lenardo Criado
	 * 
	 */
	VOTADA,
	VALIDADA;
	
	public boolean value() {
		return this.ordinal() == 0 ? false : true; 
	}
}

