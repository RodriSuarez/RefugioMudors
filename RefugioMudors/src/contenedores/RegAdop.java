package contenedores;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;

import java.util.Map.Entry;

import clasesConcretas.*;

import interfaces.IBasicas;
import json.JsonUtiles;

public class RegAdop implements IBasicas<Adoptante> {

	private HashMap<String, Adoptante>map;
	transient public static String ARCHI_ADOPTANTES = "adoptantes.dat";

	
	public RegAdop() {
		map = new HashMap<String, Adoptante>();
	}
	@Override
	public boolean agregar(String k, Adoptante e) {
		boolean rta = false;
		if(!map.containsKey(k)) {
			map.put(k, e);
			rta = true;
			System.out.println("agregado!");
		}
		return rta;
	}

	@Override
	public boolean quitar(String k) {
		boolean rta = false;
		
		if(map.containsKey(k)) {
			map.remove(k);
			rta = true;
		}
		
		return rta;
	}

	@Override
	public String listar() {
		
		StringBuilder sb = new StringBuilder();
		Set<Entry<String, Adoptante>> st = map.entrySet();
		Iterator<Entry<String, Adoptante>> it = st.iterator();
		Adoptante aux;
		
		while(it.hasNext()) {
			
			aux = it.next().getValue();
			sb.append(aux.toString());
			
		}
		
		return sb.toString();
	}
	
	
	
	/**
	 * @see <b>encerrar dentro de un if(!=null)</b> 
	 * @exception NullPointerException si la clave no existe.
	 */
	@Override
	public Adoptante buscar(String k) {
		return map.get(k);
	}
	
	
	
	public void guardarRegistroObj()  {
		FileOutputStream inData = null;
		ObjectOutputStream data = null;
		try {
			inData =  new FileOutputStream(ARCHI_ADOPTANTES);
			data = new ObjectOutputStream(inData);
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("asd");
		}
		
		Set<Entry<String, Adoptante>> st = map.entrySet();
		Iterator<Entry<String, Adoptante>> it = st.iterator();
		Adoptante aux;
		
		while(it.hasNext()) {
			aux = it.next().getValue();
			
			try {
				data.writeObject(aux);
				data.writeObject(aux.getInformacionDeContacto());
				data.writeObject(aux.getInformacionPersonal());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		try {
			data.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void levantarRegistroObj() {
		ObjectInputStream objIngreso = null;
		FileInputStream fileIngreso;
		
		
			try {
				fileIngreso = new FileInputStream(ARCHI_ADOPTANTES);
				objIngreso = new ObjectInputStream(fileIngreso);
				
				while(true) {
					Adoptante aux = (Adoptante) objIngreso.readObject();
					InfoContacto auxCont = (InfoContacto) objIngreso.readObject();
					InfoPersonal auxPer = (InfoPersonal) objIngreso.readObject();

					agregar(aux.getNumAfStr(), aux);
				}
				
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch(EOFException e) {
				System.out.println("Termino el archivo");
			} catch(IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
	
	}
	
	public void grabarJson() {
		Set<Entry<String, Adoptante>> st = map.entrySet();
		Iterator<Entry<String, Adoptante>> it = st.iterator();
		Adoptante aux;
		JSONArray json = new JSONArray();	
		while(it.hasNext()) {
		
			json.put(it.next().getValue().toJson());
		
		}
		
		JsonUtiles.grabar(json, "Adoptantes.json");
	}
	
	
	
}
