package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizacionTestCase {
	
	Organizacion orga1; //SUT
	FuncionalidadExterna fe1; //DOC
	FuncionalidadExterna fe2; //DOC
	ZonaDeCobertura zonaDeCobertura; //DOC
	Muestra muestra1;		//DOC
	Ubicacion ubicacion1; 	//DOC
	TipoOrganizacion tipo;	//DOC
	Integer trabajadores;	//DOC
	
	@BeforeEach
	void setUp() throws Exception {
		fe1 = mock(FuncionalidadExterna.class);
		fe2 = mock(FuncionalidadExterna.class);
		ubicacion1 = mock(Ubicacion.class);
		tipo = mock(TipoOrganizacion.class);
		trabajadores = 150; 
		orga1 = new Organizacion(ubicacion1, tipo, trabajadores, fe1, fe2);
		zonaDeCobertura = mock(ZonaDeCobertura.class);
		muestra1 = mock(Muestra.class);
	}

	@Test
	void testFuncionalidadExterna() {

		// excersice		
		orga1.update(zonaDeCobertura, muestra1, "Nueva Muestra");
		orga1.update(zonaDeCobertura, muestra1, "Muestra validada");
		
		// verify
		verify(fe1, times(1)).nuevoEvento(orga1, zonaDeCobertura, muestra1);
		verify(fe2, times(1)).nuevoEvento(orga1, zonaDeCobertura, muestra1);
	}

}
