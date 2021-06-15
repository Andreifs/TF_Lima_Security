package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.DetalleServicioXPlan;

public interface IDetalleServicioXPlanService {

	public boolean insertar(DetalleServicioXPlan detalleServicioXPlan);
	public boolean modificar (DetalleServicioXPlan detalleServicioXPlan);
	public void eliminar(int idDetalleServicioPlan);
	public List<DetalleServicioXPlan> listar();
	public List<DetalleServicioXPlan> buscarPlan(String nombrePlan);
	public List<DetalleServicioXPlan> buscarServicio(String nombreServicio);
	public Optional<DetalleServicioXPlan> listarId(int idDetalleServicioPlan);
		
}
