package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.muestra.EspecieNoDefinida;

class EspecieNoDefinidaTest {

	@Test
	void testEsVinchuca_return_true() {
		EspecieNoDefinida SUT = EspecieNoDefinida.UNDEFINED;
		
		assertFalse(SUT.esVinchuca());
	}
}
