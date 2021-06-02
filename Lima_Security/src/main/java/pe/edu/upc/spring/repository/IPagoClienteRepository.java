package pe.edu.upc.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import pe.edu.upc.spring.model.PagoCliente;

@Repository
public interface IPagoClienteRepository extends JpaRepository<PagoCliente, Integer>{
	
	
	

	@Query("from PagoCliente p where p.pago.namePago like %:namePago%")
	List<PagoCliente> buscarPago(@Param("namePago") String namePago);

	@Query("from PagoCliente p where p.usuario.nameUsuario like %:nameUsuario%")
	List<PagoCliente> buscarUsuario(@Param("nameUsuario") String nameUsuario);
	
	
}
