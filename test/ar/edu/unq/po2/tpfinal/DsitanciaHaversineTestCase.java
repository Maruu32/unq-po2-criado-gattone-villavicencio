package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DsitanciaHaversineTestCase {
	
	DistanciaHaversine heversine;

	@BeforeEach
	void setUp() throws Exception {
		
		heversine = new DistanciaHaversine();
	}

	@Test
	void test() {
		assertEquals(1346.84d,heversine.distanciaEnKm(20, 40, 35, 45), 0.1d);
	}

}
