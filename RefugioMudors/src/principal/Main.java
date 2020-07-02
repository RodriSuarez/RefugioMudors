package principal;

import java.io.*;
import java.util.Date;

import org.json.JSONException;

import clasesAbstractas.Denuncia;
import clasesConcretas.*;
import contenedores.*;
import vista.ListaAnimales;
import vista.VistaPrincipal;
import java.sql.Date;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub


	/*	try {
			FileInputStream bn = new FileInputStream("Animales.dat");
		//	ObjectInputStream fobj = new ObjectInputStream(bn);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("No se encontro el archivo.");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		Refugio  mudors = new Refugio();
		
	//	mudors.levantar();
		
		Denuncia x = new Denuncia((new java.sql.Date(0)), 12345, false, new Domicilio("F. Acosta", 4099, 0, 0));
		
		Denuncia x2 = new Denuncia();
		
		mudors.regDenuncias.agregar("1", x);
		mudors.regDenuncias.agregar("2", x2);
		//mudors.toJson();
		mudors.regAnimal.levantarRegistroObj();
	
		System.out.println(mudors.regAnimal.listar());
		//	mudors.regAnimal.guardarRegistroObj();
		
	
	}
		
		
		
}
