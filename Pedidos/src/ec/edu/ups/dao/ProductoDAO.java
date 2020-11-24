package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.modelo.Producto;

public interface ProductoDAO extends GenericDAO<Producto, Integer> {
	
	public abstract void crear(Producto producto, int empresaId, int categoriaId);
	public abstract int empresaId(int id);
	public abstract int categoriaId(int id);
	public abstract List<Producto> find(int empId);
	
}
