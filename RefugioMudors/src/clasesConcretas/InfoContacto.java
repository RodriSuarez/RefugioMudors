package clasesConcretas;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

public class InfoContacto implements Serializable{
	
	/**
	 * 
	 */
	transient private static final long serialVersionUID = 8730588261414613415L;
	transient public static final String KEY_NROFIJO = "nroFijo";
	transient public static final String KEY_NROCEL = "nroCel";
	transient public static final String KEY_MAIL = "mail";
	transient public static final String KEY_DOMICILIO = "domicilio";
	
	private Domicilio domicilio;
	private String nroTelFijo;
	private String nroCelular;
	private String direccionEmail;

	///Constructores
	
	public InfoContacto() {
		this.domicilio = new Domicilio();
		this.nroTelFijo = "";
		this.nroCelular = "";
		this.direccionEmail = "";
	}
	
	public InfoContacto(Domicilio domicilio, String nroTelFijo, String nroCelular, String direccionEmail) {
		this.domicilio = domicilio;
		this.nroTelFijo = nroTelFijo;
		this.nroCelular = nroCelular;
		this.direccionEmail = direccionEmail;
	}

	///Getters
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public String getDomicilioString() {
		return domicilio.toString();
	}
	public String getNroTelFijo() {
		return nroTelFijo;
	}

	public String getNroCelular() {
		return nroCelular;
	}

	public String getDireccionEmail() {
		return direccionEmail;
	}

	
	///Setters
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public void setNroTelFijo(String nroTelFijo) {
		this.nroTelFijo = nroTelFijo;
	}

	public void setNroCelular(String nroCelular) {
		this.nroCelular = nroCelular;
	}

	public void setDireccionEmail(String direccionEmail) {
		this.direccionEmail = direccionEmail;
	}

	///Sobreescritos Object
	@Override
	public String toString() {
		return "InfoContacto [domicilio=" + domicilio + ", nroTelFijo=" + nroTelFijo + ", nroCelular=" + nroCelular
				+ ", direccionEmail=" + direccionEmail + "]";
	}
	//TODO poner bonito infoContacto.toString

	@Override
	public int hashCode() {
		return 2;
	}

	/**
	 * Equals en  clase InfoContacto compara por nro de celular
	 */
	@Override
	public boolean equals(Object obj) {
	boolean rta = false;
		
		if (obj != null) {
			if (obj instanceof InfoContacto) {
				
				InfoContacto auxInfoContacto = (InfoContacto) obj;
				if (getNroCelular().equals(auxInfoContacto.getNroCelular())){
					rta = true;
				}
			}
		}
		return rta;
	}
	
	public JSONObject toJSON() {
		
		JSONObject json = new JSONObject();
		
		try {
			json.put(KEY_NROCEL, nroCelular);
			json.put(KEY_NROFIJO, nroTelFijo);
			json.put(KEY_MAIL, direccionEmail);
			json.put(KEY_DOMICILIO, domicilio.DomicilioTOJsonObject());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return json;
	}
	

}
