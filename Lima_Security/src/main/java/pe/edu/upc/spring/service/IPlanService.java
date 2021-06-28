package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Plan;

public interface IPlanService {
	public boolean insertar(Plan plan);
	public boolean modificar(Plan plan);
	public void eliminar(int idPlan);
	public Optional<Plan> listarId(int idPlan);
	List<Plan> listar();
	List<Plan> buscarNombre(String nombrePlan);
	List<Plan> buscarDescripcion(String descripcionPlan);
	List<Plan> buscarId(int idPlan);
}
