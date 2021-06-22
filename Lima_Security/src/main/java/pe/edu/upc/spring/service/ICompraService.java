package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Compra;

public interface ICompraService {
	public boolean insertar(Compra compra);
	public void eliminar(int idCompra);
	public Optional<Compra> listarId(int idCompra);
	public List<Compra> listar();
	
}
