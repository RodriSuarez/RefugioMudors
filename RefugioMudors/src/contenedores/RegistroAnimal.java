package contenedores;

import java.io.*;

import java.util.*;
import java.util.Map.Entry;

import interfaces.IBasicas;
import clasesConcretas.*;

public class RegistroAnimal implements IBasicas<Animal> {

	private HashMap<String, Animal> map;
	
	public RegistroAnimal() {
		map = new HashMap<String, Animal>();
	}

	@Override
	public boolean agregar(String k, Animal e) {
		if(!map.containsKey(k) && e != null) {
			map.put(k,e);
			return true;
		}else return false;
		
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
	public Animal buscar(String k)  {
		///TODO agregar nullpointerexception o controlen los ifs
		if(map.containsKey(k))
			return map.get(k);
		else return null;
		
	}

	
	
	public void guardarRegistro() throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
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
			data.writeBoolean(aux.isPerro());
			data.writeBoolean(aux.isCastrado());
			data.writeBoolean(aux.isAdoptado());
			data.writeBoolean(aux.isDisponible());
			System.out.println("vuelta");
		}
		
		
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
				aux.setPerro(dataIngreso.readBoolean());
				aux.setCastrado(dataIngreso.readBoolean());			
				aux.setAdoptado(dataIngreso.readBoolean());
				aux.setDisponible(dataIngreso.readBoolean());
			

				aux.setFechaDeIngreso(new Date());
				
				System.out.println(aux.toString());
				
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

	
	

}
