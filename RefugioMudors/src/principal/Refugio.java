package principal;

import java.io.IOException;

import org.json.JSONArray;

import contenedores.*;
import json.JsonUtiles;

public class Refugio {
	
	RegistroAnimal regAnimal;
	RegistroDenuncias regDenuncias;
	//RegistroAdoptantes regAdoptantes;
	
	public Refugio() {
		regAnimal = new RegistroAnimal();
		regDenuncias = new RegistroDenuncias();
	}
	
	public void guardar() {
		
		regAnimal.guardarRegistroObj();
		//regDenuncias.guardarRegistro();
		//regAdoptantes.guardarRegistro();
		
		
	}
	
	
	public void levantar() {
		regAnimal.levantarRegistroObj(); 
	}
	
	public void guardarArchivoJson() {
		JSONArray aux = new JSONArray();
		
		aux.put(regAnimal.toJsonArray());
		aux.put(regDenuncias.toJsonArray());
		//aux.put(regPersonas.toJsonArray());

		JsonUtiles.grabar(aux, "datos.json");
		
	}
}
