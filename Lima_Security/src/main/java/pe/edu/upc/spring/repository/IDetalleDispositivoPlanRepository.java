package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.DetalleDispotisivoPlan;

public interface IPlanDispositivo {
	public boolean insertar(Plan plan);
	public boolean modificar(Plan plan);
	public void eliminar(int idPlan);
	public Optional<Plan> listarId(int idPlan);
	List<Plan> listar();
	List<Plan> buscarNombre(String nombrePlan);

}
