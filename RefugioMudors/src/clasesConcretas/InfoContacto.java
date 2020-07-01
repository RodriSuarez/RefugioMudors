package clasesConcretas;

public class InfoContacto {
	
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
	
	

}
