package clasesConcretas;

import org.json.JSONException;
import org.json.JSONObject;

//import java.sql.Date;

import clasesAbstractas.Denuncia;

public class DenunciaMaltratoAnimal extends Denuncia{
	
	transient public static String KEY_DENUNCIALEGAL = "denunciaLegal";

	private boolean denunciaLegal;

	//Constructores
	
	public DenunciaMaltratoAnimal(java.sql.Date fecha, int nroDenuncia, boolean solucionado, Domicilio direccion, boolean denunciaLegal) {
		super(fecha, nroDenuncia, solucionado, direccion);
		this.denunciaLegal = denunciaLegal;
	}
	
	public DenunciaMaltratoAnimal(boolean denunciaLegal) {
		super();
		this.denunciaLegal = denunciaLegal;
	}
	
	public DenunciaMaltratoAnimal(JSONObject jsonMaltratoAnimal) {
		super(jsonMaltratoAnimal);
		try {
			this.denunciaLegal = jsonMaltratoAnimal.getBoolean(KEY_DENUNCIALEGAL);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


//Getters
/**
 * Las denuncias por maltrato animal se hacen para llevar un registro interno y evitar asignar nuevas mascotas a entornos
 * potencialmente violentos. Al refugio le exceden las cuestiones legales, pero se considera relevante saber si además de
 * la denuncia en el refugio el denunciante manifiesta haber hecho la correspondiente denuncia legal (con comprobante 
 * escrito) 
 * @return True si se efectuó además una denuncia legal, False si no. 
 */
	public boolean isDenunciaLegal() {
		return denunciaLegal;
	}
	
	public String isDenunciaLegalString() {
		String mensaje = "No presenta denuncias legales";
		if(isDenunciaLegal()) {
			
			mensaje = "Se han hecho las denuncias legales correspondientes";
		}
		return mensaje;
	}

	//Setters
	public void setDenunciaLegal(boolean denunciaLegal) {
		this.denunciaLegal = denunciaLegal;
	}

	
	//Sobreescrito
	@Override
	public String toString() {
		return super.toString() + "\nTipo: MaltratoAnimal \n" + isDenunciaLegalString();
	}
//Otros
	@Override //Desde Denuncia
	public JSONObject DenunciaTOJsonObject() {
		
		JSONObject jsonMaltratoAnimal = super.DenunciaTOJsonObject();
		try {
			
			jsonMaltratoAnimal.put(KEY_DENUNCIALEGAL, denunciaLegal);
		}
		catch (JSONException e){
			
			e.getStackTrace();
		}
		return jsonMaltratoAnimal;
	}




}
