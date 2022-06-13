package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UExpertoS {

	UExpertoSiempre experto; //sut
	 
	Usuario usr; //doc
	AplicacionWeb ap; //doc
	Muestra muestra;//doc
	
	@BeforeEach
	void setUp(){
		ap = new AplicacionWeb();
		usr = new Usuario(null, experto);
		Muestra muestra1 = new Muestra(usr, null, null, null);
		Muestra muestra2 = new Muestra(usr, null, null, null);
		Muestra muestra3 = new Muestra(usr, null, null, null);
		Muestra muestra4 = new Muestra(usr, null, null, null);
		Muestra muestra5 = new Muestra(usr, null, null, null);
		Muestra muestra6 = new Muestra(usr, null, null, null);
		Muestra muestra7 = new Muestra(usr, null, null, null);
		Muestra muestra8 = new Muestra(usr, null, null, null);
		Muestra muestra9 = new Muestra(usr, null, null, null);
		Muestra muestra10 = new Muestra(usr, null, null, null);
		
		experto = new UExpertoSiempre(usr, muestra1); 
		ap.registarUsuario("pepe", experto);
	
	
	}		
	
	@Test
	void test_opinar() {
		assertFalse(experto.puedeOpinar());
	}
		


}