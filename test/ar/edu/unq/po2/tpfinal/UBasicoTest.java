package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpfinal.persona.UBasico;
import ar.edu.unq.po2.tpfinal.persona.Usuario;

class UBasicoTest {
	UBasico basico; //sut
	Usuario usr; //doc
	AplicacionWeb ap; //doc
	Muestra muestra = new Muestra(usr, null, null,null);//doc
	
	
	
	

	@BeforeEach
	void setUp(){
		ap = new AplicacionWeb();
		usr = new Usuario(null, basico);
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
		
		basico = new UBasico(usr, muestra1);
		ap.registarUsuario("pepe", basico);
		Opinion opi1 = new Opinion(usr, muestra, null);
		Opinion opi2 = new Opinion(usr, muestra, null);
		Opinion opi3 = new Opinion(usr, muestra, null); 
		Opinion opi4 = new Opinion(usr, muestra, null);
		Opinion opi5 = new Opinion(usr, muestra, null);
		Opinion opi6 = new Opinion(usr, muestra, null);
		Opinion opi7 = new Opinion(usr, muestra, null);
		Opinion opi8 = new Opinion(usr, muestra, null);
		Opinion opi9 = new Opinion(usr, muestra, null);
		Opinion opi10 = new Opinion(usr, muestra, null);
		Opinion opi11 = new Opinion(usr, muestra, null);
		Opinion opi12 = new Opinion(usr, muestra, null);
		Opinion opi13 = new Opinion(usr, muestra, null);
		Opinion opi14 = new Opinion(usr, muestra, null);
		Opinion opi15 = new Opinion(usr, muestra, null);
		Opinion opi16 = new Opinion(usr, muestra, null);
		Opinion opi17 = new Opinion(usr, muestra, null);
		Opinion opi18 = new Opinion(usr, muestra, null);
		Opinion opi19 = new Opinion(usr, muestra, null);
		Opinion opi20 = new Opinion(usr, muestra, null);
		
		muestra.agregarOpinion(opi1);
		usr.agregarOpinion(opi20);
		

		
		
		
		

	}
	
	@Test
	void test_realizoMuestras() {
		
		assertFalse(basico.relizoDiezMuestras(usr));
		
	}
	
	@Test
	void test_realizoOpinion() {
		
		assertFalse(basico.realizoVeinteOpiniones(usr)); 
	}
	
	@Test
	void test_puedeopinar() {
		
		
		assertFalse(basico.puedeOpinar(muestra)); 
		
		
	}
	
	@Test
	void test_contar_dias() {
		
		LocalDate inicio = LocalDate.of(2022, 1, 1);
		LocalDate fin = LocalDate.of(2023, 1, 1);
		
		
		
		assertEquals(365,basico.contarDias(inicio, fin)); 
	}

}
