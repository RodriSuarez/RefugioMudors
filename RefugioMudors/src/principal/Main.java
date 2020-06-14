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
		
		reg.agregar(x1.getNombre(), x1);
		reg.agregar(x2.getNombre(), x2);
		reg.agregar(x3.getNombre(), x3);
		reg.agregar(x4.getNombre(), x4);
		reg.agregar(x5.getNombre(), x5);
		
		System.out.println(reg.listar());
		
		reg.quitar(x4.getNombre());
		System.out.println("\n\n\n"+reg.listar());


	}

}
