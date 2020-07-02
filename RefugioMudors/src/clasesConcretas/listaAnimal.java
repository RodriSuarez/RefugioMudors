package clasesConcretas;

import java.util.ArrayList;

public class listaAnimal {
	private ArrayList<Animal>lista;

	
	public listaAnimal ()
	{
		this.lista = new ArrayList<Animal>();
	}
	
	public boolean agregar(Object e)
	{
		if (e != null)
		{
		if (e instanceof Animal)
		{
		lista.add((Animal) e);
		}
		return true;
		}
		else 
			return false;
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<lista.size(); i++)
		{
			sb.append( lista.get(i).toString());
		}
		return sb.toString();
	}
	
}
