package clasesAbstractas;

import clasesConcretas.InfoContacto;
import clasesConcretas.InfoPersonal;

public abstract class Persona {
	//TODO sobreescribir y sobrecargar setters
	//TODO para la clase Adoptante agregar boolean tieneDenuncias
	
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((informacionDeContacto == null) ? 0 : informacionDeContacto.hashCode());
		result = prime * result + ((informacionPersonal == null) ? 0 : informacionPersonal.hashCode());
		return result;
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
	
	
	

	
	

}
