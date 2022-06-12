package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EspecieNoDefinidaTest {

	@Test
	void testEsVinchuca_return_true() {
		EspecieNoDefinida SUT = EspecieNoDefinida.UNDEFINED;
		
		assertFalse(SUT.esVinchuca());
	}
}
