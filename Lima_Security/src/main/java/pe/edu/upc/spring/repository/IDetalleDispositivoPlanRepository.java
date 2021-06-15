package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.DetalleDispotisivoPlan;

@Repository
public interface IDetalleDispositivoPlanRepository extends JpaRepository<DetalleDispositivoPlan, Integer>{
	
	@Query("from DetalleDispositivoXPlan d where d.nombreDispisitvo like %:modeloDisp%")
	List<DetalleDispositivoXPlan> buscarModelo(@Param("modeloDisp") String modeloDisp);
	
	
	
}
