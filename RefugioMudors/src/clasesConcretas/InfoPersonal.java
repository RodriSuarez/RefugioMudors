package clasesConcretas;

import java.util.Date;

public class InfoPersonal {

	private String dni;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	

///Constructores
	public InfoPersonal() {
		this.dni = "";
		this.nombre = "";
		this.apellido = "";
		this.fechaNacimiento = new Date();
	}
	
	public InfoPersonal(String dni, String nombre, String apellido, Date fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}
	
///Getters
	
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getNombreYApellido() {
		return nombre + " "+apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public String getFechaNacimientoString() {
		return " "+fechaNacimiento;
	}
	
///Setters
	public void setDNI(String dNI) {
		dni = dNI;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	

///Sobreescritos Object	
	@Override
	public String toString() {
		return "Información Personal \nDNI: " + getDni()+ "\nNombre: " + getNombre() + "\nApellido: " + getApellido() + "\nFecha de Nacimiento: "
				+ getFechaNacimientoString();
	}
	@Override
	public int hashCode() {
		return 3;
	}
	@Override
	public boolean equals(Object obj) {
		boolean rta = false;
		
		if (obj != null) {
			if (obj instanceof InfoPersonal) {
				
				InfoPersonal auxInfoPersonal = (InfoPersonal) obj;
				if (getDni().equals(auxInfoPersonal.getDni())){
					rta = true;
				}
			}
		}
		return rta;
	}
	
}
