package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.awt.image.BufferedImage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.persona.UExperto;
import ar.edu.unq.po2.tpfinal.persona.Usuario;
import ar.edu.unq.po2.tpfinal.ubicacion.Ubicacion;

class UsuarioTest {
	private Usuario usuario; // sut
	private AplicacionWeb aplicacionWeb; // doc
	private UExperto experto; //doc
	private Opinion opinion;//doc
	private Ubicacion ubicacion; //doc
	private BufferedImage foto;// doc
	private Muestra muestra;//doc
	
	@BeforeEach
	void setUp(){
		experto=  new UExperto();
		muestra = new Muestra(usuario, null, null, null);
		ubicacion = mock(Ubicacion.class);
		foto = mock(BufferedImage.class);
		aplicacionWeb = new AplicacionWeb();
		usuario = new Usuario("villa", experto);
		usuario.nuevaMuestra(aplicacionWeb,EspecieVinchuca.VICHUCA_GUASAYANA, ubicacion, foto, opinion); 
		usuario.opinar(EspecieVinchuca.VICHUCA_GUASAYANA, muestra);
		
	
	} 

	@Test
	void test() {
		usuario.setEstadoUsuario(experto);
	}

}
