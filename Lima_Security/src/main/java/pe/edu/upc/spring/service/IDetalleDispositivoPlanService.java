package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.DetalleDispositivoPlan;

public interface IDetalleDispositivoPlanService {
    public boolean insertar(DetalleDispositivoPlan detalleDispositivoPlan);
	public boolean modificar (DetalleDispositivoPlan detalleDispositivoPlan);
	public void eliminar(int idDetalleDispositivoPlan);
	public List<DetalleDispositivoPlan> listar();
	public List<DetalleDispositivoPlan> buscarPlan(String nombrePlan);
	public List<DetalleDispositivoPlan> buscarDispositivo(String modeloDisp);
	public Optional<DetalleDispositivoPlan> listarId(int idDetalleDispositivoPlan);


}
