package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.muestra.NoEsVinchuca;

class NoEsVinchucaTest {

	@Test
	void testEsVinchuca_return_false() {
		NoEsVinchuca SUT = NoEsVinchuca.CHINCHE_FOLIADA;
		
		assertFalse(SUT.esVinchuca());
	}
}
