package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import java.util.ArrayList;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpfinal.muestra.ClasificacionMuestra;
import ar.edu.unq.po2.tpfinal.muestra.Opinion;
import ar.edu.unq.po2.tpfinal.persona.Usuario;


class OpinionTest { 


	@Test
	void testOpinion_set_sampleCase() {
		Usuario Usuario = Mockito.mock(Usuario.class);
		ClasificacionMuestra aCase = Mockito.mock(ClasificacionMuestra.class);
		
		Opinion SUT = new Opinion(Usuario, null, aCase);

		
		assertEquals(aCase, SUT.getTipoMuestra());
		
	}
	
	@Test
	void testOpinion_set_Usuario() {
		Usuario Usuario = Mockito.mock(Usuario.class);
		ClasificacionMuestra aCase = Mockito.mock(ClasificacionMuestra.class);
		

		Opinion SUT = new Opinion(Usuario, null, aCase);

		
		assertEquals(Usuario, SUT.getUsuario());
		
	}
	


}