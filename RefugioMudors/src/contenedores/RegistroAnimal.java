package contenedores;

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
		
		Set<Entry<String, Animal>> st = map.entrySet();
		Iterator<Entry<String, Animal>> it = st.iterator();
		while(it.hasNext()){
			sb.append(it.next().toString()+"\n\n");
		}
		
		return sb.toString();
	}

	@Override
	public Animal buscar(String k)  {
		///agregar nullpointerexception o controlen los ifs
		if(map.containsKey(k))
			return map.get(k);
		else return null;
		
	}

	


	
	

}
