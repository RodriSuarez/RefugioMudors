package clasesAbstractas;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import clasesConcretas.InfoContacto;
import clasesConcretas.InfoPersonal;

public abstract class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7023512486231294114L;
	//TODO sobreescribir y sobrecargar setters
	//TODO para la clase Adoptante agregar boolean tieneDenuncias
	transient public static final String KEY_INFOPERSONAL = "infoPE";
	transient public static final String KEY_INFOCONTACT = "infoC";
	private InfoPersonal informacionPersonal;
	private InfoContacto informacionDeContacto;
	
	///Constructores
	public Persona() {
		this.informacionPersonal = new InfoPersonal();
		this.informacionDeContacto = new InfoContacto();
	}
	
	public Persona(InfoPersonal informacionPersonal, InfoContacto informacionDeContacto) {
		this.informacionPersonal = informacionPersonal;
		this.informacionDeContacto = informacionDeContacto;
	}

	public InfoPersonal getInformacionPersonal() {

		return informacionPersonal;
	}

	public InfoContacto getInformacionDeContacto() {
		return informacionDeContacto;
	}

	public void setInformacionPersonal(InfoPersonal informacionPersonal) {
		this.informacionPersonal = informacionPersonal;
	}

	public void setInformacionDeContacto(InfoContacto informacionDeContacto) {
		this.informacionDeContacto = informacionDeContacto;
	}

	@Override
	public String toString() {
		return "Persona [informacionPersonal=" + informacionPersonal + ", informacionDeContacto="
				+ informacionDeContacto + "]";
	}
	//TODO poner bonito Persona.toString

	@Override
	public int hashCode() {
	
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (informacionDeContacto == null) {
			if (other.informacionDeContacto != null)
				return false;
		} else if (!informacionDeContacto.equals(other.informacionDeContacto))
			return false;
		if (informacionPersonal == null) {
			if (other.informacionPersonal != null)
				return false;
		} else if (!informacionPersonal.equals(other.informacionPersonal))
			return false;
		return true;
	}
	
	
	
	public JSONObject toJson() {
		
		JSONObject json = new JSONObject();
		
		try {
			json.put(KEY_INFOCONTACT, informacionDeContacto.toJSON());
			json.put(KEY_INFOPERSONAL, informacionPersonal.toJson());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return json;
	}
	
	

}
