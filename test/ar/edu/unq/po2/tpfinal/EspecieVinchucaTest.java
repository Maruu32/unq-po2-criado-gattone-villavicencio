package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.muestra.EspecieVinchuca;

class EspecieVinchucaTest {

	@Test
	void testIsVichuca_return_true() {
		EspecieVinchuca SUT = EspecieVinchuca.VICHUCA_GUASAYANA;
		
		assertTrue(SUT.esVinchuca());
	}
}
