package clasesConcretas;

import java.util.*;

public class Animal {
 /**
  * @author Rodrigo Suarez	
  */
	
	private int edad;
	private String nombre;
	private String raza;
	private float peso;
	private String observaciones;
	private Date fechaDeIngreso;
	private boolean isPerro; //Si no es perro, es gato.
	private boolean isCastrado;
	private boolean isAdoptado;
	private boolean isDisponible;
	
	public Animal(int edad, String nombre, String raza, float peso, String observaciones, Date fechaDeIngreso,
			boolean isPerro, boolean isCastrado, boolean isAdoptado, boolean isDisponible) {
		super();
		this.edad = edad;
		this.nombre = nombre;
		this.raza = raza;
		this.peso = peso;
		this.observaciones = observaciones;
		this.fechaDeIngreso = fechaDeIngreso;
		this.isPerro = isPerro;
		this.isCastrado = isCastrado;
		this.isAdoptado = isAdoptado;
		this.isDisponible = isDisponible;
	}
	
	public Animal() {
		super();
		this.edad = 0;
		this.nombre = "";
		this.raza = "";
		this.peso = 0;
		this.observaciones = "";
		this.fechaDeIngreso = new Date();
		this.isPerro = true;
		this.isCastrado = false;
		this.isAdoptado = false;
		this.isDisponible = false;
	}
	
	
	// 				-- 		Overrides de object 		    --   ///
	@Override
	public String toString() {
		return "Animal [edad=" + edad + ", nombre=" + nombre + ", raza=" + raza + ", peso=" + peso + ", observaciones="
				+ observaciones + ", fechaDeIngreso=" + fechaDeIngreso + ", isPerro=" + isPerro + ", isCastrado="
				+ isCastrado + ", isAdoptado=" + isAdoptado + ", isDisponible=" + isDisponible + "]";
	}

	@Override
	public int hashCode() {
	
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ret = false;
		
		if(obj != null) {
			Animal aux = (Animal) obj;
			if(nombre.equals(aux.getNombre()) && edad == aux.edad && fechaDeIngreso.equals(aux.fechaDeIngreso))
				ret = true;
				
		}
					
		return ret;
	}
	
	// 				-- 		FIN Overrides de object 		    --   ///

	// 				-- 		Inicio Getters y Setters		    --   ///

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(Date fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public boolean isPerro() {
		return isPerro;
	}

	public void setPerro(boolean isPerro) {
		this.isPerro = isPerro;
	}

	public boolean isCastrado() {
		return isCastrado;
	}

	public void setCastrado(boolean isCastrado) {
		this.isCastrado = isCastrado;
	}

	public boolean isAdoptado() {
		return isAdoptado;
	}

	public void setAdoptado(boolean isAdoptado) {
		this.isAdoptado = isAdoptado;
	}

	public boolean isDisponible() {
		return isDisponible;
	}

	public void setDisponible(boolean isDisponible) {
		this.isDisponible = isDisponible;
	}
	// 				-- 		FIN Getters y Setters		    --   ///

	
	//TODO agregar manejo de JSON y archivos.
	//TODO optativo, agregar implementacion de vacunas
	//TODO 
	
}
