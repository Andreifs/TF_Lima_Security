package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.DetalleDispositivoPlan;

public interface IPlanDispositivoPlanService {
public boolean insertar(DetalleDispositivoPlan detalleDispositivoPlan);
	public boolean modificar (DetalleDispositivoPlan detalleDispositivoPlan);
	public void eliminar(int idDetalleDispositivoPlan);
	public List<DetalleDispositivoPlan> listar();
	public List<DetalleDispositivoPlan> buscarPlan(String namePlan);
	public List<DetalleDispositivoPlan> buscarServicio(String nameServicio);

}
