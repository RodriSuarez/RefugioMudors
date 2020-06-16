package contenedores;

import interfaces.IBasicas;
import java.util.*;
import java.util.Map.Entry;



public class Registro<E>  implements IBasicas<E>{

	private HashMap<String, E> map;
	
	public Registro() {
		map = new HashMap<String, E>();
	}
	@Override
	public boolean agregar(String k, E e) {
		
		if(e != null && !map.containsKey(k)) {
			map.put(k, e);
			
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
		
		Set<Entry<String, E>> st = map.entrySet();
		Iterator<Entry<String, E>> it = st.iterator();
		while(it.hasNext()){
			sb.append(it.next().toString()+"\n\n");
		}
		
		return sb.toString();
	}

	@Override
	public E buscar(String k) {
		return map.get(k);
	}
	
}
