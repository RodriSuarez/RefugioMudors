package clasesAbstractas;

//import java.text.SimpleDateFormat;

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;

import clasesConcretas.Domicilio;

public class Denuncia {

	transient private static int contadorDenuncias = 1; /* para que no lo guarde en el archivo */
	transient public static String KEY_FECHA = "fecha";
	transient public static String KEY_NRODENUNCIA = "nroDenuncia";
	transient public static String KEY_SOLUCIONADO = "solucionado";
	transient public static String KEY_DIRECCION = "direccion";

	private Date fecha;
	private int nroDenuncia;
	private boolean solucionado;
	private Domicilio direccion;

//Constructores

	public Denuncia() {
		this.fecha = new Date(0); // recibe un long
		this.nroDenuncia = contadorDenuncias;
		aumentarContador();
		this.solucionado = false;
		this.direccion = new Domicilio();
	}

	public Denuncia(Date fecha, int nroDenuncia, boolean solucionado, Domicilio direccion) {
		this.fecha = fecha;
		this.nroDenuncia = nroDenuncia;
		corroborarContador(nroDenuncia);
		this.solucionado = solucionado;
		this.direccion = direccion;
	}
	
	public Denuncia(JSONObject JsonDenuncia) {
		try {
			
		this.fecha = Date.valueOf(JsonDenuncia.getString(KEY_FECHA));
		this.nroDenuncia = JsonDenuncia.getInt(KEY_NRODENUNCIA);
		corroborarContador(nroDenuncia);
		this.solucionado = JsonDenuncia.getBoolean(KEY_SOLUCIONADO);
		this.direccion =new Domicilio(JsonDenuncia.getJSONObject(KEY_DIRECCION));
		}
		catch (JSONException e) {
			e.getStackTrace();
		}
	}

	// Getters
	public Date getFecha() {
		return fecha;
	}

	/**
	 * getfechaString() crea variable SimpleDateFormat y transforma la fecha a
	 * String
	 * 
	 * @return la fecha como cadena de caracteres en formato calendario
	 */
	public String getfechaString() {
		// SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/aaaa");
		// String fechaString = sdf.format(this.fecha);

		return "" + fecha;
	}

	public int getNroDenuncia() {
		return nroDenuncia;
	}

	public boolean isSolucionado() {
		return solucionado;
	}

	public String isSolucionadoString() {
		String mensaje = "En proceso";

		if (isSolucionado()) {
			mensaje = "Solucionada";
		}

		return mensaje;
	}

	public Domicilio getDireccion() {
		return direccion;
	}

//Setters
	private static void aumentarContador() {
		contadorDenuncias++;
	}

	/**
	 * Dado que se desconoce el orden en el que se levantarán los registros se
	 * considera: Si el número recibido es mayor al contador, se iguala el contador
	 * al parámetro. Si son iguales, se incrementa el contador.
	 * 
	 * @param nroDenuncia
	 */
	private static void corroborarContador(int nroDenuncia) {

		if (nroDenuncia > contadorDenuncias) {
			contadorDenuncias = nroDenuncia + 1;
		} else if (nroDenuncia == contadorDenuncias) {
			contadorDenuncias++;
		}
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setNroDenuncia(int nroDenuncia) {
		this.nroDenuncia = nroDenuncia;
	}

	public void setSolucionado(boolean solucionado) {
		this.solucionado = solucionado;
	}

	public void setDireccion(Domicilio direccion) {
		this.direccion = direccion;
	}

//Sobreescritos y otros

	@Override
	public int hashCode() {
		return 9;
	}

	@Override
	public boolean equals(Object obj) {
		boolean rta = false;
		if (obj != null) {

			if (obj instanceof Denuncia) {

				Denuncia auxDenuncia = (Denuncia) obj;

				if (getNroDenuncia() == auxDenuncia.getNroDenuncia()) {

					rta = true;
				}

			}
		}
		return rta;
	}

	@Override
	public String toString() {
		return "Denuncia numero " + getNroDenuncia() + "\nRealizada el " + Date.valueOf(fecha.toString()) + "\nEstado: "
				+ isSolucionadoString();
	}

	/**
	 * Se vale de variables constantes para guardar el objeto en un json
	 * Implica guardar un objectDomicilio
	 * La fecha se guarda como String
	 * El orden: fecha, nroDenuncia, Solucionado, Dirección
	 * @return el JSONObject
	 */
	public JSONObject DenunciaTOJsonObject() {
		
		JSONObject jasonDenuncia = new JSONObject();
		
		try {
			jasonDenuncia.put(KEY_FECHA, fecha.toString());
			jasonDenuncia.put(KEY_NRODENUNCIA, nroDenuncia);
			jasonDenuncia.put(KEY_SOLUCIONADO, solucionado);
			jasonDenuncia.put(KEY_DIRECCION, direccion.DomicilioTOJsonObject());
			
		} catch (JSONException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jasonDenuncia;
	}


}
