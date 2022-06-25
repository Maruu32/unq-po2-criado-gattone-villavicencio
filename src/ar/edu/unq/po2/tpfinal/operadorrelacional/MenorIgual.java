package ar.edu.unq.po2.tpfinal.operadorrelacional;

import java.time.LocalDate;

public class MenorIgual implements OperadorRelacionalFechas {

	@Override
	public boolean evaluar(LocalDate parse, LocalDate parse2) {
		// TODO Auto-generated method stub
		return parse.isEqual(parse2) || parse.isBefore(parse2);
	}

}
