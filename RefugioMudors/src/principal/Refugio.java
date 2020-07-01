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
		
		try {
			regAnimal.guardarRegistro();
			//regDenuncias.guardarRegistro();
			//regAdoptantes.guardarRegistro();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void levantar() {
		regAnimal.levantarRegistro(); 
	}
	
	public void toJson() {
		JSONArray aux = new JSONArray();
		
		aux.put(regAnimal.toJsonArray());
		aux.put(regDenuncias.toJsonArray());
		
		JsonUtiles.grabar(aux, "datos.json");
		
	}
}
