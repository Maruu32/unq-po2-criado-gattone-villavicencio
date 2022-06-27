package ar.edu.unq.po2.tpfinal.operadorrelacional;

import java.time.LocalDate;

public class Igual implements OperadorRelacionalFechas {

	@Override
	public boolean evaluar(LocalDate fecha1, LocalDate fecha2) {
		// TODO Auto-generated method stub
		return fecha1.isEqual(fecha2);
	}

}
