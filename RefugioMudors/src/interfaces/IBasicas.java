package interfaces;

public interface IBasicas<E> {
	
	public boolean agregar(String k,E e);
	public boolean quitar(String k);
	public String listar();
	public E buscar(String k);

}
