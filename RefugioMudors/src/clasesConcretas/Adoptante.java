package clasesConcretas;

import clasesAbstractas.Persona;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Adoptante extends Persona implements Serializable {
	
	/**
	 * 
	 */
	transient public static final String KEY_NAFILIADO = "numAfiliado";
	transient public static final String KEY_ANIMALES = "listaAnimales";

	transient private static final long serialVersionUID = 5522847004172034555L;
	
	private int numeroAfiliado; /// id
	transient private int cont = 1;
	private ArrayList <Animal> animales;
	
 // TODO hacer un metodo que desde el archivo guarde el ultimo id
	
	///Constructores
	
	public Adoptante()
	{
		super();
		
		this.numeroAfiliado = cont; ///para id autoincremental. funciona pero es dudoso
		this.animales = new ArrayList<Animal>();
		cont++;
	}
	
	public Adoptante (InfoPersonal infoPersonal, InfoContacto infoContacto, int numeroAfiliado)
	{
		super(infoPersonal, infoContacto);
		this.numeroAfiliado = numeroAfiliado;
		this.animales = new ArrayList<Animal>();
		if(numeroAfiliado >= cont) {
			cont = numeroAfiliado+1;
		}
		//Adoptante.numeroAfiliado = numeroAfiliado;
	}
	
	public Adoptante(InfoPersonal infoPersonal, InfoContacto infoContacto, int numeroAfiliado, ArrayList<Animal> lista) {
		super(infoPersonal, infoContacto);
		this.numeroAfiliado = numeroAfiliado;
		this.animales = lista;
		System.out.println("KEEE");
		System.out.println(numeroAfiliado);
		if(numeroAfiliado >= cont) {
			cont = numeroAfiliado+1;
		}
	}
	
	public int getNumAfiliado()
	{
		return numeroAfiliado;
	}
	
	public String getNumAfStr() {
		return Integer.toString(numeroAfiliado);
	}

	public void setNumAfilidado (int numAfiliado) /// es necesario?
	{
		this.numeroAfiliado = numAfiliado;
	}
	
	public boolean agregarAnimal(Object e) /// método "adoptar"
	{
		if (e != null)
		{
		if (e instanceof Animal)
		{
		animales.add((Animal) e);
		}
		return true;
		}
		else 
			return false;
	}
	public boolean eliminarAnimal (String id)
	{
		int posicion = buscaPorId(id);
		//int aux = Integer.valueOf(posicion);
		if(posicion !=-1)
		{
			
		    animales.remove(posicion);
			return true;
		}
		else
		{
			return false; 
		}
		
	}
	
	public int buscaPorId(String id) ///devuelve la pos
	{
		int posicion =-1;
		
		for (int i =0; i< animales.size(); i++)
		{
//			System.out.println("coso2: "+animales.get(i).getID());
//			System.out.println("coso3: "+id);
			if (animales.get(i).getID() != id)
				//TODO cambiar eso porque dbe ser == pero no funciona
			{
		//		System.out.println("entra");
				posicion = i;
			}
			
		}
		
		return posicion;
	}
	
	@Override
	public String toString() {
	
		StringBuilder sb = new StringBuilder ();
		sb.append("\nNombre: "+getInformacionPersonal().getNombre()+" "+getInformacionPersonal().getApellido()+"\n\n");

		for (int i=0; i< animales.size();i++)
		{
			sb.append("\n"+animales.get(i).toString());
		}
		return sb.toString();
	}
	
	
	public void escribirArchi ()
	{
		DataOutputStream datoD = null;
		String dni;
		String nombre;
		String apellido;
		Date fechaNac;
		
		try
		{
			System.out.println("entry try");
			datoD = new DataOutputStream( new FileOutputStream ("Adoptantes.dat"));
			Persona aux = new Adoptante(getInformacionPersonal(), getInformacionDeContacto(), getNumAfiliado());
			dni = aux.getInformacionPersonal().getDni();
			nombre = aux.getInformacionPersonal().getNombre();
			apellido = aux.getInformacionPersonal().getApellido();
			fechaNac = aux.getInformacionPersonal().getFechaNacimiento();
			//System.out.println("casi:"+nombre+" "+apellido+" "+dni );
			datoD.writeUTF(dni);
			datoD.writeUTF(nombre);
			datoD.writeUTF(apellido);	
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("finale1");
		}
	}

	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		JSONArray anim = new JSONArray();
		
		
		try {
			json.put(KEY_NAFILIADO, numeroAfiliado);
			for(int i = 0; i < animales.size(); i++) {
				anim.put(animales.get(i).toJson());
			}
			json.put(KEY_ANIMALES, anim);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}

}
