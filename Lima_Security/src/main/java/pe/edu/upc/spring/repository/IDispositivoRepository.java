package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Dispositivo;

@Repository
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Integer>{
	@Query("from Dispositivo d where d.modeloDisp like %:modeloDisp%")
	List<Dispositivo> buscarModelo(@Param("modeloDisp") String modeloDisp);

}
