package clasesConcretas;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

public class Domicilio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2109776361171380725L;
	//para evitar líos de claves....
	transient public static String KEY_CALLE = "calle";
	transient public static String KEY_ALTURA = "altura";
	transient public static String KEY_DPTO = "dpto";
	transient public static String KEY_PISO = "piso";
	//el transient es para que no se guarde en el ARCHIVO
	
	private String calle;
	private int altura;
	private int dpto;
	private int piso;
	
///Constructores	
	public Domicilio() {
		this.calle = "";
		this.altura = 0;
		this.dpto = 0;
		this.piso = 0;
	}
	
	public Domicilio(String calle, int altura, int dpto, int piso) {
		this.calle = calle;
		this.altura = altura;
		this.dpto = dpto;
		this.piso = piso;
	}

	public Domicilio(JSONObject jsonDomilicio) {
		try {
		this.calle = jsonDomilicio.getString(KEY_CALLE);
		this.altura = jsonDomilicio.getInt(KEY_ALTURA);
		this.dpto = jsonDomilicio.getInt(KEY_DPTO);
		this.piso = jsonDomilicio.getInt(KEY_PISO);
		}
		catch (JSONException e) {
			
			e.getStackTrace();
		}
	}
	///Getters
	public String getCalle() {
		return calle;
	}

	public int getAltura() {
		return altura;
	}

	public int getDpto() {
		return dpto;
	}

	public int getPiso() {
		return piso;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}
	
///Setters
	public void setAltura(int altura) {
		this.altura = altura;
	}

	public void setDpto(int dpto) {
		this.dpto = dpto;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}
	
	
	
	///Sobreescritos Object
	@Override
	public String toString() {
		return "Domicilio [calle=" + calle + ", altura=" + altura + ", dpto=" + dpto + ", piso=" + piso + "]";
	}
	//TODO poner bonito Domicilio.toString

@Override
	public int hashCode() {
		return 1;
	}

/**
 * Domicilio compara por Calle, altura Y nro dpto
 */
	@Override
	public boolean equals(Object obj) {
	boolean rta = false;
		
		if (obj != null) {
			if (obj instanceof Domicilio) {
				
				Domicilio auxDomicilio = (Domicilio) obj;
				if ((getCalle().equalsIgnoreCase(auxDomicilio.getCalle()) && (getAltura() == auxDomicilio.getAltura()) && (getDpto() == auxDomicilio.getDpto()))){
					rta = true;
				}
			}
		}
		return rta;
	}
	
	/**
	 * Se vale de variables estáticas para ingresar los datos a un JSONObject auxiliar y retornarlo
	 * @return un JSONObject
	 */

	
	public JSONObject DomicilioTOJsonObject() { //o es static, o lo meto en un try-catch
		JSONObject jsonDomicilio = new JSONObject();
		try {
			jsonDomicilio.put(KEY_CALLE, calle);
			jsonDomicilio.put(KEY_ALTURA, altura);
			jsonDomicilio.put(KEY_DPTO, dpto);
			jsonDomicilio.put(KEY_PISO, piso);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return jsonDomicilio;
	}
}
