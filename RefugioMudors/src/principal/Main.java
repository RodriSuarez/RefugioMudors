package principal;
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
		
		RegistroAnimal reg = new RegistroAnimal();
		Registro<Animal> regAnim = new Registro<Animal>();
		
		
		regAnim.agregar(x1.getNombre(), x1);
		regAnim.agregar(x2.getNombre(), x2);
		regAnim.agregar(x3.getNombre(), x3);
		regAnim.agregar(x4.getNombre(), x4);
		regAnim.agregar(x5.getNombre(), x5);
		
		System.out.println(regAnim.listar());
		
		reg.quitar(x4.getNombre());
		System.out.println("\n\n\n"+regAnim.listar());

		///esto funciona <3
		System.out.println("\t\tBuscando!");
		System.out.println(regAnim.buscar("Helen").toString());
	}

}
