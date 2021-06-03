package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.DetalleServicioXPlan;

public interface IDetalleServicioXPlanService {

	public boolean insertar(DetalleServicioXPlan detalleServicioXPlan);
	public boolean modificar (DetalleServicioXPlan detalleServicioXPlan);
	public void eliminar(int idDetalleServicioXPlan);
	public List<DetalleServicioXPlan> listar();
	public List<DetalleServicioXPlan> buscarPlan(String namePlan);
	public List<DetalleServicioXPlan> buscarServicio(String nameServicio);
	public Optional<DetalleServicioXPlan> listarId(int idDetalleServicioXPlan);
		
}
