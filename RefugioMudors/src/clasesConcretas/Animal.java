package clasesConcretas;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Rodrigo Suarez	
 * @see <h1> calate esta wacho </h1>
 */
public class Animal implements Serializable {



	/**
	 * Parametros estaticos que se utilizaran para compilar el programa pero no para la ejecucion del mismo
	 */
	transient private static final long serialVersionUID = 9097910461851896056L;
	transient public static final String ARCHI_ANIMALES = "animales.dat";
	transient public static String KEY_EDAD = "edad";
	transient public static String KEY_NOMBRE = "nombre";
	transient public static String KEY_RAZA = "raza";
	transient public static String KEY_PESO = "peso";
	transient public static String KEY_OBSERVACIONES = "observaciones";
	transient public static String KEY_FECHA = "fecha";
	transient public static String KEY_YEAR = "year";
	transient public static String KEY_MONTH = "month";
	transient public static String KEY_DAY = "day";
	transient public static String KEY_ISPERRO = "isperro";
	transient public static String KEY_CASTRADO = "iscastrado";
	transient public static String KEY_ADOPTADO = "isadoptado";
	transient public static String KEY_DISPONIBLE = "isdisponible";
	transient public static String KEY_ID = "id";
	
	
	
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
	private int id;
	transient private static int proximaID = 1; //Inicializamos el primer ID en uno para que comience a contar desde dicho numero
	
	
	public Animal(int edad, String nombre, String raza, float peso, String observaciones, Date fechaDeIngreso,
			boolean isPerro, boolean isCastrado, boolean isAdoptado, boolean isDisponible, int id) {
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
		this.id = id;
		
		/**
		 * Evalua si el id que ingresa es mayor al proximo que deberia asignarse,
		 * en caso de que si, el proximo ID se vuelve el ingresado por parametro + 1.
		 */
		if(id >= proximaID)
			proximaID = id + 1;
	
			
			
	}
	
	public Animal(String nombre, int edad, String raza, boolean isPerro) {
		super();
		this.edad = edad;
		this.nombre = nombre;
		this.raza = raza;
		this.peso = 120;
		this.observaciones = "Alguna";
		this.fechaDeIngreso = new Date();
		this.isPerro = isPerro;
		this.isCastrado = false;
		this.isAdoptado = false;
		this.isDisponible = false;
		this.id = proximaID;
		proximaID++;
		
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
		this.id = proximaID;
		proximaID++;
	}
	
	
	// 				-- 		Overrides de object 		    --   ///
	@Override
	public String toString() {
		String tipo;
		String castrado;
		String adoptado;
		String disponible;
		if(isPerro) tipo = "perro"; else tipo = "gato";
		if(isCastrado) castrado = "Si"; else castrado =  "No";
		if(isAdoptado) adoptado = "Si"; else adoptado = "No";
		if(isDisponible) disponible = "Si"; else disponible = "No";
	
		
		return "ID: "+id+"\nNombre: "+ nombre +"\nEdad: "+ edad + "\nRaza: " + raza + "\nPeso: "+peso+"\nFecha de ingreso: "+ fechaDeIngreso.toString() 
		+"\nAnimal: "+ tipo + "\nCastrado: "+ castrado + "\nAdoptado: "+adoptado+"\nDisponible: "+disponible+"\n\n";
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
	
	public String getID() {
		String aux;
		aux = Integer.toString(id);
		return aux;
	}
	// 				-- 		FIN Getters y Setters		    --   ///

	
	//TODO optativo, agregar implementacion de vacunas
	
	// 				-- Inicio archivos --         		//
	
	
	public void guardarDatos() {
		

		try {
			
			DataOutputStream  data = new DataOutputStream(new FileOutputStream("Animales.dat"));
			
			data.writeInt(edad);
			data.writeChars(nombre);
			data.writeChars(raza);
			data.writeFloat(peso);
			data.writeChars(observaciones);
		//	data.writeByte(fechaDeIngreso);
			data.writeInt(fechaDeIngreso.getYear());
			data.writeInt(fechaDeIngreso.getMonth());
			data.writeInt(fechaDeIngreso.getDate());		
			data.writeBoolean(isPerro);
			data.writeBoolean(isCastrado);
			data.writeBoolean(isAdoptado);
			data.writeBoolean(isDisponible);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public JSONObject toJson() {
		
		JSONObject aux = new JSONObject();
		JSONObject fecha = new JSONObject();
		
		try {
			aux.put(KEY_ID, id);
			aux.put(KEY_EDAD,edad);
			aux.put(KEY_NOMBRE, nombre);
			aux.put(KEY_RAZA, raza);
			aux.put(KEY_PESO, peso);
			aux.put(KEY_OBSERVACIONES , observaciones);
			fecha.put(KEY_YEAR , fechaDeIngreso.getYear());
			fecha.put(KEY_MONTH , fechaDeIngreso.getMonth());
			fecha.put(KEY_DAY ,fechaDeIngreso.getDate());
			aux.put(KEY_FECHA ,fecha);
			aux.put(KEY_ISPERRO ,isPerro);
			aux.put(KEY_CASTRADO , isCastrado);
			aux.put(KEY_ADOPTADO , isAdoptado);
			aux.put(KEY_DISPONIBLE , isDisponible);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return aux;
		
	}
}
