package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

public class MayorIgual implements OperadorRelacionalFechas {

	@Override
	public boolean evaluar(LocalDate parse, LocalDate parse2) {
		// TODO Auto-generated method stub
		return parse.equals(parse2) || parse.isAfter(parse2);
	}

}
