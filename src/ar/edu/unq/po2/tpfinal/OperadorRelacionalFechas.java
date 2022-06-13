package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

public interface OperadorRelacionalFechas {
	/**@author Lenardo Criado
	 * 
	 * esta interface modela una evaluacion de un operador relacional con los parametros de izquierda a dereca
	 * 
	 * @param parse se compara contra  @param parse2
	 * @return
	 */

	boolean evaluar(LocalDate parse, LocalDate parse2);

}
