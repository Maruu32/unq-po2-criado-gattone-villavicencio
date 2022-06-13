package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ValidacionMuestraBasicaTest {

	ValidacionMuestraBasico SUT = new ValidacionMuestraBasico(); 

	
	@Test
	void testGetLastReview_return_the_last_basic_review_date(){
		Muestra aMuestra= Mockito.mock(Muestra.class);
		Opinion Opinion1 = Mockito.mock(Opinion.class);
		Opinion Opinion2 = Mockito.mock(Opinion.class);
		Opinion Opinion3 = Mockito.mock(Opinion.class);

		LocalDate aDate = LocalDate.now();
		List <Opinion> reviews = new ArrayList <Opinion>();
		reviews.add(Opinion1);
		reviews.add(Opinion2);
		reviews.add(Opinion3);
		Mockito.when(Opinion3.getFechaCreacion()).thenReturn(aDate);
		Mockito.when(aMuestra.getOpinionesBasicos()).thenReturn(reviews);
		
	}
	
	@Test
	void testUsrBasicoPuedeOpinar_return_true() {
		Muestra aMuestra = Mockito.mock(Muestra.class);
		Boolean result = SUT.usrBasicoPuedeOpinar(aMuestra);
		assertTrue(result);
	}
	
	@Test
	void testUsrExpertoPuedeOpinar_return_true() {
		Muestra aMuestra = Mockito.mock(Muestra.class);		
		Boolean result = SUT.usrExpertoPuedeOpinar(aMuestra);
		assertTrue(result);
	}
	
	@Test
	void testEsMuestraVerificada_return_false() {
		Muestra aMuestra = Mockito.mock(Muestra.class);
		Boolean result = SUT.esMuestraVerificada(aMuestra);
		assertFalse(result);
	}
	
}