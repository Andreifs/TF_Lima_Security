package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.DetalleDispositivoPlan;


@Repository
public interface IDetalleDispositivoPlanRepository extends JpaRepository<DetalleDispositivoPlan, Integer>{
	

	@Query("from DetalleDispositivoPlan dp where dp.dispositivo.idDispositivo like %:idDispositivo%")
	List<DetalleDispositivoPlan> buscarDispositivo(int idDispositivo);

	@Query("from DetalleDispositivoPlan dp where dp.plan.idPlan like %:idPlan%")
	List<DetalleDispositivoPlan> buscaPlan(int idPlan);
	

}
