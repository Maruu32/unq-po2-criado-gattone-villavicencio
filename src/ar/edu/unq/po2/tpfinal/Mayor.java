package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

public class Mayor implements OperadorRelacionalFechas {

	@Override
	public boolean evaluar(LocalDate parse, LocalDate parse2) {
		return parse.isAfter(parse2);
	}

}
