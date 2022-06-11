package ar.edu.unq.po2.tpfinal;

public enum NivelVerificacion {
	/**
	 * @author Lenardo Criado
	 * 
	 */
	VOTADA,
	VALIDADA;
	
	public boolean value(boolean b) {
		return this.ordinal() == 0 ? !b : b; 
	}
}

