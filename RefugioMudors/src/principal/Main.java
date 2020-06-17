package principal;

import java.io.*;
import clasesConcretas.*;
import contenedores.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal x1 = new Animal("Simba", 1, "Ninguna", false);
		Animal x2 = new Animal("Cocoa", 2, "Perro", true);
		Animal x3 = new Animal("Puqui", 19, "Ninguna", true);
		Animal x4 = new Animal("Samira", 4, "Pitbull", true);
		Animal x5 = new Animal("Helen", 3, "Sharpey", false);
		
//		try {
//			FileInputStream bn = new FileInputStream("Animales.dat");
//			ObjectInputStream fobj = new ObjectInputStream(bn);
//		} catch (FileNotFoundException e) {
//			//e.printStackTrace();
//			System.out.println("No se encontro el archivo.");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		RegistroAnimal reg = new RegistroAnimal();
		Registro<Animal> regAnim = new Registro<Animal>();
		
		
//		reg.agregar(x1.getNombre(), x1);
//		reg.agregar(x2.getNombre(), x2);
//		reg.agregar(x3.getNombre(), x3);
//		reg.agregar(x4.getNombre(), x4);
//		reg.agregar(x5.getNombre(), x5);
//		
		
		//System.out.println(regAnim.listar());
		
	//	reg.quitar(x4.getNombre());
//		System.out.println("\n\n\n"+regAnim.listar());
//		regAnim.buscar(x1.getNombre()).guardarDatos();
		///esto funciona <3
//		System.out.println("\t\tBuscando!");
//		System.out.println(regAnim.buscar("Helen").toString());
//		x2.guardarDatos();
//		x3.guardarDatos();
//		try {
//		reg.guardarRegistro();
//		} catch (IOException e) {
//		// TODO Auto-generated catch block
//		}
		
		reg.levantarRegistro();
		//System.out.println(reg.listar());
		System.out.println("\n\nDespues de levantar el registro\n\n");
		System.out.println(reg.listar());
	}
		
		
		
}
