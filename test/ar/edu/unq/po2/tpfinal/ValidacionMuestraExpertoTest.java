package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import org.mockito.Mockito;


class ValidacionMuestraExpertoTest {
	ValidacionMuestraExperto SUT = new ValidacionMuestraExperto();
	
	@Test
	void testusrBasicoPuedeOpinar_return_false() {
		Muestra aMuestra = Mockito.mock(Muestra.class);
		Boolean result = SUT.usrBasicoPuedeOpinar(aMuestra);
		assertFalse(result);
	}
	
	@Test
	void testusrExpertoPuedeOpinar_return_false_if_current_Review_status_is_undefined() {
		Muestra aMuestra = Mockito.mock(Muestra.class);
		Mockito.when(aMuestra.getMuestraValidadaActual()).thenReturn(EspecieNoDefinida.UNDEFINED);
		Boolean result = SUT. usrExpertoPuedeOpinar(aMuestra);
		assertFalse(result);
	}
	
	@Test
	void testusrExpertoPuedeOpinar_return_false_if_current_Review_status_is_not_undefined_and_experts_Review_are_only_one() {
		Muestra aMuestra = Mockito.mock(Muestra.class);
		ClasificacionMuestra aCase = Mockito.mock(ClasificacionMuestra.class);
		Mockito.when(aMuestra.getMuestraValidadaActual()).thenReturn(aCase);
		List <Opinion> Opinions = new ArrayList <Opinion> ();
		Opinions.add(Mockito.mock(Opinion.class));
		Mockito.when(aMuestra.getOpinionesExpertos()).thenReturn(Opinions);		
		
		Boolean result = SUT.usrExpertoPuedeOpinar(aMuestra);
		
		assertFalse(result);

	}
	
	@Test
	void testusrExpertoPuedeOpinar_return_false_if_current_Review_status_is_undefined_and_experts_Reviews_are_more_to_one() {
		Muestra aMuestra = Mockito.mock(Muestra.class);
		Mockito.when(aMuestra.getMuestraValidadaActual()).thenReturn(EspecieNoDefinida.UNDEFINED);
		List <Opinion> Opinions = new ArrayList <Opinion> ();
		Opinions.add(Mockito.mock(Opinion.class));
		Opinions.add(Mockito.mock(Opinion.class));
		Mockito.when(aMuestra.getOpinionesExpertos()).thenReturn(Opinions);
		
		Boolean result = SUT.esMuestraVerificada(aMuestra);
		
		assertFalse(result);
	}
	
	@Test
	void testEsMuestraVerificada_return_true_if_current_Review_status_is_not_undefined_and_experts_Reviews_are_more_to_one() {
		Muestra aMuestra = Mockito.mock(Muestra.class);
		ClasificacionMuestra aCase = Mockito.mock(ClasificacionMuestra.class);
		Mockito.when(aMuestra.getMuestraValidadaActual()).thenReturn(aCase);
		List <Opinion> Opinions = new ArrayList <Opinion> ();
		Opinions.add(Mockito.mock(Opinion.class));
		Opinions.add(Mockito.mock(Opinion.class));
		Mockito.when(aMuestra.getOpinionesExpertos()).thenReturn(Opinions);
		
		Boolean result = SUT.esMuestraVerificada(aMuestra);
		
		assertTrue(result);

	}
	
	@Test
	void testEsMuestraVerificada_return_false_if_current_Review_status_is_not_undefined_and_experts_Reviews_are_only_one() {
		Muestra aMuestra = Mockito.mock(Muestra.class);
		List <Opinion> Opinions = new ArrayList <Opinion> ();
		Opinions.add(Mockito.mock(Opinion.class));
		Mockito.when(aMuestra.getOpinionesExpertos()).thenReturn(Opinions);
		ClasificacionMuestra aCase = Mockito.mock(ClasificacionMuestra.class);
		
		Mockito.when(aMuestra.getMuestraValidadaActual()).thenReturn(aCase);
		
		Boolean result = SUT.esMuestraVerificada(aMuestra);
		
		assertFalse(result);

	}
	
	@Test
	void testgetMuestraValidadaActual_return_Sample_getWinnerReviewCase_called_with_experts_Reviews() {
		Muestra aMuestra = Mockito.mock(Muestra.class);
		ClasificacionMuestra aCase = Mockito.mock(ClasificacionMuestra.class);
		List <Opinion> expertOpinions = new ArrayList <Opinion>();
		Mockito.when(aMuestra.getOpinionesExpertos()).thenReturn(expertOpinions);
		Mockito.when(aMuestra.getTipoGanadorActual(expertOpinions)).thenReturn(aCase);
				
		ClasificacionMuestra result = SUT.getMuestraValidadaActual(aMuestra);
		
		Mockito.verify(aMuestra, Mockito.times(1)).getTipoGanadorActual(expertOpinions);
		assertEquals(aCase, result);
	}
	
	

}