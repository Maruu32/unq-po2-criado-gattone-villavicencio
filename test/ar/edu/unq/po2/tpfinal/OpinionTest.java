package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OpinionTest {

	@Test
	void testOpinion_set_sampleCase() {
		Usuario Usuario = Mockito.mock(Usuario.class);
		ClasificacionMuestra aCase = Mockito.mock(ClasificacionMuestra.class);
		
		Opinion SUT = new Opinion(Usuario, aCase);
		
		assertEquals(aCase, SUT.getTipoMuestra());
		
	}
	
	@Test
	void testOpinion_set_Usuario() {
		Usuario Usuario = Mockito.mock(Usuario.class);
		ClasificacionMuestra aCase = Mockito.mock(ClasificacionMuestra.class);
		
		Opinion SUT = new Opinion(Usuario, aCase);
		
		assertEquals(Usuario, SUT.getUsuario());
		
	}
	
	@Test
	void testOpinion_set_creation_date() {
		Usuario Usuario = Mockito.mock(Usuario.class);
		ClasificacionMuestra aCase = Mockito.mock(ClasificacionMuestra.class);
		
		Date beforeCreation = new Date();
		Opinion SUT = new Opinion(Usuario, aCase);
		Date afterCreation = new Date();
		Date result = SUT.getFechaCreacion();
		
		assertFalse(beforeCreation.after(result));
		assertFalse(afterCreation.before(result));
		
		
	}

}