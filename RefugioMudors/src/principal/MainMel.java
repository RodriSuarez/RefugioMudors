package principal;

import java.io.EOFException;
import java.io.IOException;

import clasesAbstractas.Persona;
import clasesConcretas.Adoptante;
import clasesConcretas.Animal;
import clasesConcretas.InfoContacto;
import clasesConcretas.InfoPersonal;
import contenedores.RegAdop;
import contenedores.RegistroAdoptantes;


public class MainMel {

	public static void main(String[] args) throws IOException //throws IOException 
, ClassNotFoundException
	{
		InfoPersonal cosa = new InfoPersonal("12345", "nombre1", "apellido1", null);
		InfoPersonal cosa1 = new InfoPersonal("12335", "nombre2", "apellido2", null);
		InfoPersonal cosa2 = new InfoPersonal("12315", "nombre3", "apellido3", null);	
	//	InfoContacto 
		Adoptante pers1 = new Adoptante(cosa, new InfoContacto(), 1);
		Adoptante pers2 = new Adoptante(cosa1, new InfoContacto(), 2);
		Adoptante pers3 = new Adoptante(cosa2, new InfoContacto(), 3);
		
		/*pers1.escribirArchi();
		pers2.escribirArchi();
		pers3.escribirArchi();
		
		pers1.leer();*/

		Animal perro = new Animal("rudolf", 3, "x", true);
		Animal gato = new Animal ("feli", 1, "che", false);
		
		pers1.agregarAnimal(perro);
		pers1.agregarAnimal(gato);
		pers2.agregarAnimal(gato);
		pers2.agregarAnimal(perro);
		
/*		System.out.println("persona 1: "+pers1.toString());
		System.out.println("pers 2: "+ pers2.toString());*/
		
		pers1.eliminarAnimal("2");
	/*	System.out.println("\n borro el gato de p1: \n");
		System.out.println("\n\npers 1: "+ pers1.toString());*/
		
	//	RegistroAdoptantes reg = new RegistroAdoptantes();
		
	//	reg.agregar(pers1);
		//reg.agregar(pers2);
		RegAdop listaAdop = new RegAdop();
	//	listaAdop.agregar(pers1.getNumAfStr(),pers1);
		//listaAdop.agregar(pers2.getNumAfStr(),pers2);
	//	System.out.println(listaAdop.listar());
	//	System.out.println("\nLista completa: \n");
		//System.out.println( "\n"+reg.listar());
		
		System.out.println("\n////////////////////////////////////////////////////\n");
	//	System.out.println(listaAdop.listar());
	//		reg.escribirAdoptantes();
		//	nuevo.leerAdoptantes();
	//	listaAdop.guardarRegistroObj();
		listaAdop.levantarRegistroObj();
		
		System.out.println(listaAdop.listar());
		listaAdop.grabarJson();
//		System.out.println("\n"+ nuevo.listar());
	
	}
}
