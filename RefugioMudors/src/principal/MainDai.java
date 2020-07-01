package principal;

import java.sql.Date;

import clasesAbstractas.Denuncia;
import clasesConcretas.Domicilio;
import clasesConcretas.DenunciaMaltratoAnimal;

public class MainDai {

	public static void main(String[] args) {
		
		Date fecha = (Date) Date.valueOf("2020-06-28"); //valueOf transforma un String (o un long) en una Date. Pero si es String, tiene que tener sí o sí el formato que se detalla
		Denuncia denuncia1 = new DenunciaMaltratoAnimal(fecha, 1234567, false, new Domicilio("Ayolas", 7278, 4, 0), false);
		System.out.println(denuncia1.toString());
		System.out.println(denuncia1.DenunciaTOJsonObject().toString());
		
		Denuncia denuncia2 = new DenunciaMaltratoAnimal(denuncia1.DenunciaTOJsonObject());
		System.out.println("\n\nDenuncia2: \n\n" + denuncia2.toString());

	}

}