package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Dispositivo;

public interface IDispositivoService {
	public boolean insertar(Dispositivo dispositivo);
	public boolean modificar(Dispositivo dispositivo);
	public void eliminar(int idDispositivo);
	public Optional<Dispositivo> listarId(int idDispositivo);
	List<Dispositivo> listar();
	List<Dispositivo> buscarModelo(String modeloDisp);

}
