package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.DetalleDispositivoPlan;

<<<<<<< HEAD
@Repository
public interface IDetalleDispositivoPlanRepository extends JpaRepository<DetalleDispositivoPlan, Integer>{
	
	@Query("from DetalleDispositivoPlan d where d.nombreDispisitvo like %:modeloDisp%")
	List<DetalleDispositivoPlan> buscarModelo(@Param("modeloDisp") String modeloDisp);
	
	
	
=======
public interface IDetalleDispositivoPlanRepository {
	@Query("from DetalleDispositivoPlan dp where dp.nombreDispositivo like %:nombreDispositivo%")
	List<DetalleDispositivoPlan> buscarServicio(@Param("nombreServicio") String nombreServicio);

	@Query("from DetalleDispositivoPlan dp where dp.nombrePlan like %:nombreDispositivo%")
	List<DetalleDispositivoPlan> buscaPlan(@Param("nombrePlan") String nombrePlan);

>>>>>>> f46e1046898ce89e162e9e316df67fe997bc3b5e
}
