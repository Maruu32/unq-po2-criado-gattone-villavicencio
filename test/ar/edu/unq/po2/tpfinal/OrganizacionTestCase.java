package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.organizacion.FuncionalidadExterna;
import ar.edu.unq.po2.tpfinal.organizacion.Organizacion;
import ar.edu.unq.po2.tpfinal.organizacion.TipoOrganizacion;
import ar.edu.unq.po2.tpfinal.ubicacion.Ubicacion;
import ar.edu.unq.po2.tpfinal.zonadecobertura.TipoAvisoZona;
import ar.edu.unq.po2.tpfinal.zonadecobertura.ZonaDeCobertura;

class OrganizacionTestCase {
	
	Organizacion orga1; //SUT
	FuncionalidadExterna fe1; //DOC
	FuncionalidadExterna fe2; //DOC
	FuncionalidadExterna fe3; //DOC
	ZonaDeCobertura zonaDeCobertura; //DOC
	Muestra muestra1;		//DOC
	Ubicacion ubicacion1; 	//DOC
	TipoOrganizacion tipo;	//DOC
	Integer trabajadores;	//DOC
	
	@BeforeEach
	void setUp() throws Exception {
		fe1 = mock(FuncionalidadExterna.class);
		fe2 = mock(FuncionalidadExterna.class);
		fe3 = mock(FuncionalidadExterna.class);
		ubicacion1 = mock(Ubicacion.class);
		//tipo = mock(TipoOrganizacion.class);
		trabajadores = 150; 
		orga1 = new Organizacion(ubicacion1, TipoOrganizacion.ASISTENCIA, trabajadores, fe1, fe2);
		zonaDeCobertura = mock(ZonaDeCobertura.class);
		muestra1 = mock(Muestra.class);
	}

	@Test
	void testFuncionalidadExterna() {

		// excersice		
		orga1.update(zonaDeCobertura, muestra1, TipoAvisoZona.NUEVA_MUESTRA);
		orga1.update(zonaDeCobertura, muestra1, TipoAvisoZona.MUESTRA_VALIDADA);
		
		// verify
		verify(fe1, times(1)).nuevoEvento(orga1, zonaDeCobertura, muestra1);
		verify(fe2, times(1)).nuevoEvento(orga1, zonaDeCobertura, muestra1);
	}
	
	@Test
	void testSetFuncionalidadExterna() {

		// excersice		
		orga1.setAccionProgramadaNuevaMuestra(fe2);
		orga1.setAccionProgramadaMuestraValidada(fe3);
		
		// verify
		assertEquals(fe2, orga1.getAccionProgramadaNuevaMuestra());
		assertEquals(fe3, orga1.getAccionProgramadaMuestraValidada());
	}
	
	@Test
	void testGetters() {

		assertEquals(TipoOrganizacion.ASISTENCIA,orga1.getTipo());
		assertEquals(150,orga1.getTrabajadores());
		assertEquals(ubicacion1,orga1.getUbicacion());
	}

	
}
