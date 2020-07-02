package contenedores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import clasesAbstractas.Denuncia;
import clasesConcretas.Animal;
import interfaces.IBasicas;
import java.io.*;
import java.nio.file.*;
import org.json.*;

public class RegistroDenuncias implements IBasicas<Denuncia> {

	private HashMap<String, Denuncia> registroDenuncias;
	//private String nombreArchivoDenuncia;

//Constructor

	public RegistroDenuncias() {
		this.registroDenuncias = new HashMap<String, Denuncia>();
	}

	/**
	 * Comprueba que el valor sea distinto de null, que el listado no esté vacío, si
	 * la clave existe, antes de agregar
	 */
	@Override
	public boolean agregar(String k, Denuncia e) {
		boolean rta = false;
		if (e != null) {
			if (!registroDenuncias.containsKey(k)) {

				registroDenuncias.put(k, e);
				rta = true;
			}
		}

	return rta;

	}

	@Override
	public boolean quitar(String k) {
		boolean rta = false;
		if (!registroDenuncias.isEmpty()) {
			if (registroDenuncias.containsKey(k)) {
				
				registroDenuncias.remove(k, registroDenuncias.get(k));
			}
		}

		return rta;
	}

	@Override
	public String listar() {
		StringBuilder texto = new StringBuilder();
		Denuncia auxDenuncia;
		
		Set<Entry<String, Denuncia>> auxSet = registroDenuncias.entrySet();
		Iterator<Entry<String, Denuncia>> auxIterator = auxSet.iterator();
		
		while (auxIterator.hasNext()) {
				auxDenuncia = (Denuncia) auxIterator.next().getValue();
			
				texto.append(auxDenuncia.toString());
		}
		
	
		return texto.toString();
	}

	@Override
	public Denuncia buscar(String k) {
		Denuncia auxDenuncia = null;
		if (registroDenuncias.containsKey(k)) {
			auxDenuncia = registroDenuncias.get(k);
		}
		return auxDenuncia;
	}
	
	
	
	public JSONArray toJsonArray() {
		Set<Entry<String, Denuncia>> st = registroDenuncias.entrySet();
		Iterator<Entry<String, Denuncia>> it = st.iterator();
		
		Denuncia aux;
		JSONArray json = new JSONArray();
		
		while(it.hasNext()){
		
			aux =  (Denuncia) it.next().getValue();
			json.put(aux.DenunciaTOJsonObject());
			
		}
		
		return json;
	}

}
