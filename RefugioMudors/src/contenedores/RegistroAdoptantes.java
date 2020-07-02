package contenedores;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import interfaces.IBasicas;
import clasesAbstractas.Persona;
import clasesConcretas.*;

public class RegistroAdoptantes implements Serializable, IBasicas<Adoptante> {
/**
	 * 
	 */
	private static final long serialVersionUID = 7068261373093334532L;


	private ArrayList<Adoptante> lista;
	transient public static String ADOPTANTES = "adoptantes.dat";
	
		
		public RegistroAdoptantes ()
		{
			this.lista = new ArrayList<Adoptante>();
		}
		
		public boolean agregar(Adoptante e)
		{	
			boolean rta = false;
			if (e != null)
			{
			
			rta = lista.add(e);
			
			}
			
				return rta;
		}
		
		public boolean quitar(String k) {
			
				
			return false;
		}

		
		public String listar() {
		
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<lista.size(); i++)
			{
				sb.append(lista.get(i).toString()+"\n");
				System.out.println("asd");
			//	sb.append(lista.get(i).get)
			}
			return sb.toString();
		}

		
		public Adoptante buscar(String dni) { ///por dni? o deberia usar equals?
			Adoptante aux = null;
			
			for (int i=0; i< lista.size();i++)
			{
				String dniAux = lista.get(i).getInformacionPersonal().getDni();
				if (dniAux == dni)
				{
					aux = lista.get(i);
				}
				
			}
			return aux;
		}

		/// archivos: 
		public void escribirAdoptantes () throws IOException
		{
			Adoptante aux = new Adoptante();
			try {
			FileOutputStream archi = new FileOutputStream(ADOPTANTES);
			ObjectOutputStream archiObj = new ObjectOutputStream(archi);
			
			for (int i=0; i<lista.size(); i++)
			{
				archiObj.writeObject(lista.get(i));
			}
			archiObj.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			
		}
		
		public void leerAdoptantes() throws ClassNotFoundException
		{
			FileInputStream file;
			ObjectInputStream obj = null;
			try
			{
				 file = new FileInputStream(ADOPTANTES);
				 obj = new ObjectInputStream(file);
				
				while (true)
				{
			
					Adoptante aux =  (Adoptante) obj.readObject();
					System.out.println("");
					agregar(aux);
					
				}	
			}
			catch (FileNotFoundException f)
			{
				f.printStackTrace();
			}
			catch (EOFException e)
			{
				System.out.println("endoffile");
			}
			catch ( IOException e)
			{
				e.printStackTrace();
			}
		}

		@Override
		public boolean agregar(String k, Adoptante e) {
			// TODO Auto-generated method stub
			return false;
		}
	}
