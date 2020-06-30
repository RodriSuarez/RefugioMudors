package excepciones;

public class DenunciaActivaException extends Exception {
	
	String nombre;
	String denuncia;
	public DenunciaActivaException(String msg, String nombre, String denuncia) {
		super(msg);
		this.nombre = nombre;
		this.denuncia = denuncia;
		
	}
	
	
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage() + " " + nombre +"\nDenuncia:  "+denuncia;
	} 
}
