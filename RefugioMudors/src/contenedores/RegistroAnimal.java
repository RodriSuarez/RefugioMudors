package contenedores;

import java.io.*;

import java.util.*;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import interfaces.IBasicas;
import json.JsonUtiles;
import clasesConcretas.*;

public class RegistroAnimal implements IBasicas<Animal>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Animal> map;
	
	public RegistroAnimal() {
		map = new HashMap<String, Animal>();
	}

	@Override
	public boolean agregar(String k, Animal e) {
		boolean rta = false;
		if(e != null && !map.containsKey(k)) {
			map.put(k,e);
			rta = true;
		}else rta = false;
		
		return rta;
	}

	@Override
	public boolean quitar(String k) {
		if(map.containsKey(k)) {
			map.remove(k);
			return true;
		}else return false;
	}

	@Override
	public String listar() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Lista: \n");
		
		Set<Entry<String, Animal>> st = map.entrySet();
		Iterator<Entry<String, Animal>> it = st.iterator();
		
		while(it.hasNext()){
			sb.append(it.next().getValue().toString()+"\n\n");
		}
		
		return sb.toString();
	}

	@Override
	public Animal buscar(String k) throws NullPointerException {
		///TODO agregar nullpointerexception o controlen los ifs
		if(map.containsKey(k))
			return map.get(k);
		else {
			throw new NullPointerException();
		}
		
	}

	// 				-- Inicio archivos --         		//

	
	public void guardarRegistro() throws IOException {
		
	//	FileOutputStream asd = new FileOutputStream("Animales.dat");
		DataOutputStream  data = new DataOutputStream(new FileOutputStream("Animales.dat"));
		
		Set<Entry<String, Animal>> st = map.entrySet();
		Iterator<Entry<String, Animal>> it = st.iterator();
		Animal aux;
		
		while(it.hasNext()){
		
			aux =  (Animal) it.next().getValue();
			data.writeInt(aux.getEdad());
			data.writeUTF(aux.getNombre());
			data.writeUTF(aux.getRaza());
			data.writeFloat(aux.getPeso());
			data.writeUTF(aux.getObservaciones());
		//	data.writeByte(fechaDeIngreso);
			data.writeInt(aux.getFechaDeIngreso().getYear());
			data.writeInt(aux.getFechaDeIngreso().getMonth());
			data.writeInt(aux.getFechaDeIngreso().getDate());
			data.writeBoolean(aux.isPerro());
			data.writeBoolean(aux.isCastrado());
			data.writeBoolean(aux.isAdoptado());
			data.writeBoolean(aux.isDisponible());
			
		}
		data.close();
		
	}
	
	public void levantarRegistro() {
		
		DataInputStream dataIngreso = null;
		FileInputStream fileIngreso;
		
		try {
			fileIngreso = new FileInputStream("Animales.dat");
			dataIngreso = new DataInputStream(fileIngreso);
//			Animal aux = new Animal();
			while(true) {
				
				
				Animal aux = new Animal();
				aux.setEdad(dataIngreso.readInt());
				aux.setNombre(dataIngreso.readUTF());				
				aux.setRaza(dataIngreso.readUTF());
				aux.setPeso(dataIngreso.readFloat());
				aux.setObservaciones(dataIngreso.readUTF());
				aux.setFechaDeIngreso(new Date(dataIngreso.readInt(), dataIngreso.readInt(), dataIngreso.readInt(), 0,0,0 ));
		//		System.out.println(aux.getFechaDeIngreso());
				aux.setPerro(dataIngreso.readBoolean());
				aux.setCastrado(dataIngreso.readBoolean());			
				aux.setAdoptado(dataIngreso.readBoolean());
				aux.setDisponible(dataIngreso.readBoolean());
			
				
			//	aux.setFechaDeIngreso(new GregorianCalendar());
				
//				System.out.println(aux.toString());
				
				agregar(aux.getNombre(), aux);
			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(EOFException e) {
			System.out.println("Termino el archivo");
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dataIngreso.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	

	
	// 				-- FIN archivos --         		//
	
	// 				-- Inicio JSON --         		//

	public void grabarJson(){
		
		Set<Entry<String, Animal>> st = map.entrySet();
		Iterator<Entry<String, Animal>> it = st.iterator();
		
		Animal aux;
		JSONArray json = new JSONArray();
		
		while(it.hasNext()){
		
			aux =  (Animal) it.next().getValue();
			json.put(aux.toJson());
			
		}
		
		JsonUtiles.grabar(json, "animales.json");
	}
	
	public void levantarJson() throws JSONException {
		
		JSONArray aux = new JSONArray(JsonUtiles.leer("animales.json"));
		
		for(int i = 0; i < aux.length(); i++) {
			JSONObject auxObj = aux.getJSONObject(i);
			JSONObject auxfecha = new JSONObject(auxObj.get(Animal.KEY_FECHA).toString());
			Date fecha = new Date(auxfecha.getInt(Animal.KEY_YEAR),auxfecha.getInt(Animal.KEY_MONTH),auxfecha.getInt(Animal.KEY_DAY),0,0,0);
	//		Date x = new Date();
	//		Animal asd = new Animal(edad, nombre, raza, peso, observaciones, fechaDeIngreso, isPerro, isCastrado, isAdoptado, isDisponible, id)
		
			Animal animAux = new Animal(auxObj.getInt(Animal.KEY_EDAD), auxObj.getString(Animal.KEY_NOMBRE), auxObj.getString(Animal.KEY_RAZA),
					auxObj.getInt(Animal.KEY_PESO), auxObj.getString(Animal.KEY_OBSERVACIONES), fecha, auxObj.getBoolean(Animal.KEY_ISPERRO),
					auxObj.getBoolean(Animal.KEY_CASTRADO),	auxObj.getBoolean(Animal.KEY_ADOPTADO), auxObj.getBoolean(Animal.KEY_DISPONIBLE), auxObj.getInt(Animal.KEY_ID));
			
			agregar(animAux.getID(), animAux);
			
	//		System.out.println(auxObj.get(Animal.KEY_NOMBRE));
		}
		
	}
	
	public JSONArray toJsonArray() {
		Set<Entry<String, Animal>> st = map.entrySet();
		Iterator<Entry<String, Animal>> it = st.iterator();
		
		Animal aux;
		JSONArray json = new JSONArray();
		
		while(it.hasNext()){
		
			aux =  (Animal) it.next().getValue();
			json.put(aux.toJson());
			
		}
		
		return json;
	}
	
	// 				-- FIN JSON --         		//

}
