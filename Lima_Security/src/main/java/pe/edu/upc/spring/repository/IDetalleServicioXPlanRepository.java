package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.DetalleServicioXPlan;

@Repository
public interface IDetalleServicioXPlanRepository extends JpaRepository<DetalleServicioXPlan, Integer>{
	
	@Query("from DetalleServicioXPlan ds where ds.servicio.nombreServicio like %:nombreServicio%")
	List<DetalleServicioXPlan> buscarServicio(@Param("nombreServicio") String nombreServicio);

	@Query("from DetalleServicioXPlan ds where ds.plan.nombrePlan like %:nombrePlan%")
	List<DetalleServicioXPlan> buscaPlan(@Param("nombrePlan") String nombrePlan);
}
