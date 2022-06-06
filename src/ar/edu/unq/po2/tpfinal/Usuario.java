package ar.edu.unq.po2.tpfinal;

public class Usuario {
	private String usuario;
	private EstadoUsuario estadoUsuario;
	
	Usuario(Usuario usuario, EstadoUsuario estadoUsuario){
		
	}
	
	public void opinar() {
		estadoUsuario.opinar(this);
	}

	public void setEstadoUsuario(UExperto uExperto) {
		// TODO Auto-generated method stub 
		
	}
	

	


	
	

}
