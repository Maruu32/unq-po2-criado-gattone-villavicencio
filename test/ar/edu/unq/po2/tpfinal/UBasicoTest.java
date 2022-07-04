package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.persona.UBasico;
import ar.edu.unq.po2.tpfinal.persona.Usuario;
import ar.edu.unq.po2.tpfinal.ubicacion.Ubicacion;

class UBasicoTest {
	UBasico basico; //sut
	Usuario usr; //doc
	AplicacionWeb ap; //doc
	Muestra muestra = new Muestra(usr, null, null,null);//doc

	@BeforeEach
	void setUp(){
		ap = new AplicacionWeb(); 
		usr = new Usuario(null, basico, ap);
		

		Muestra muestra10 = new Muestra(usr, null, null, null); 
		
		usr.nuevaMuestra(null, null, null, null);
		usr.nuevaMuestra(null, null, null, null);
		usr.nuevaMuestra(null, null, null, null);
		usr.nuevaMuestra(null, null, null, null);
		usr.nuevaMuestra(null, null, null, null);
		usr.nuevaMuestra(null, null, null, null);
		usr.nuevaMuestra(null, null, null, null);
		usr.nuevaMuestra(null, null, null, null);
		usr.nuevaMuestra(null, null, null, null);
		usr.nuevaMuestra(null, null, null, null);
		
		
		basico = new UBasico();
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);
		basico.opinar(null, usr, muestra10);		

	}
	@Test
	void realizo21Opiniones() {
		
		assertEquals(21,usr.getSusOpiniones().size());
		
	}
	
	@Test
	void realizo10Muestras() {
		
		assertEquals(10,ap.getMuestras().size());
		
	}
	
	
	
	@Test
	void test_realizoMuestras() {
		
		assertTrue(basico.relizoDiezMuestras(usr));
		
	}
	
	@Test
	void test_realizoOpinion() {
		
		assertTrue(basico.realizoVeinteOpiniones(usr)); 
		
	}
	
	@Test
	void test_puedeopinar() {
		
		
		assertTrue(basico.puedeOpinar(muestra)); 
		
		
	}
	
	@Test
	void test_contar_dias() {
		
		LocalDate inicio = LocalDate.of(2022, 1, 1);
		LocalDate fin = LocalDate.of(2023, 1, 1);
		
		assertEquals(365,basico.contarDias(inicio, fin)); 
	}

}
