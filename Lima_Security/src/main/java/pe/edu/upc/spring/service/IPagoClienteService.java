package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.PagoCliente;

public interface IPagoClienteService {
	public boolean insertar(PagoCliente pagocliente);
	public boolean modificar(PagoCliente pagocliente);
	public void eliminar(int idPagoCliente);
	public Optional<PagoCliente> buscarId(int idPagoCliente);
	public Optional<PagoCliente> listarId(int idPagoCliente);
	public List<PagoCliente> listar();
	
	public List<PagoCliente> buscarUsuario(String nameRace);
	public List<PagoCliente> buscarPago(String nameDueno);
}
