package clasesConcretas;

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;

import clasesAbstractas.Denuncia;

public class DenunciaAnimalesSueltos extends Denuncia{
	
	transient public static String KEY_RECUPERADO = "recuperado";
	transient public static String KEY_ESPECIE = "especie";
	
	/**
	 * adoptable: 1 si se trata de perros y/o gatos 0 si se trata de otros caballos
	 */
	private boolean recuperado;
	private boolean especie;
	
	//Constructores
	public DenunciaAnimalesSueltos(Date fecha, int nroDenuncia, boolean solucionado, Domicilio direccion,
			boolean recuperado, boolean especie) {
		super(fecha, nroDenuncia, solucionado, direccion);
		this.recuperado = recuperado;
		this.especie = especie;
	}
	
	public DenunciaAnimalesSueltos(JSONObject jsonAnimalesSueltos) {
		
		super(jsonAnimalesSueltos);
		try {
			this.recuperado = jsonAnimalesSueltos.getBoolean(KEY_RECUPERADO);
			this.especie = jsonAnimalesSueltos.getBoolean(KEY_ESPECIE);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//Getters
	/**
	 * 
	 * @return True si lo pasaron a buscar y llevaron al refugio, False si no
	 */
	public boolean isRecuperado() {
		return recuperado;
	}
	
	public String isRecuperadoString() {
		String mensaje = "Fue recuperado";
		if (!isRecuperado()) {
			mensaje = "Aún no fue recuperado";
		}
		return mensaje;
	}
	
/**
 * Determina la especie
 * @return True si es un perro, False si es un gato
 */
	public boolean isPerro() {
		return especie;
	}
	
	public String isPerroString() {
		String mensaje = "Es un gato";
		if(isPerro()) {
			mensaje = "Es un perro";
		}
		return mensaje;
	}
	
	
//Setters

	public void setRecuperado(boolean recuperado) {
		this.recuperado = recuperado;
	}

	public void setEspecie(boolean especie) {
		this.especie = especie;
	}

	
//Sobreescritos	
	@Override
	public String toString() {
		return super.toString() + "\nTipo: Animales Sueltos\n" + isPerroString() + "\n" + isRecuperadoString();
	}
	
	@Override //desde Denuncia
	public JSONObject DenunciaTOJsonObject(){
		
		JSONObject jsonAnimalesSueltos = super.DenunciaTOJsonObject();
		try {
			
			jsonAnimalesSueltos.put(KEY_RECUPERADO, recuperado);
			jsonAnimalesSueltos.put(KEY_ESPECIE, especie);
		}
		catch (JSONException e){
			
			e.getStackTrace();
		}
		return jsonAnimalesSueltos;
	}
}
