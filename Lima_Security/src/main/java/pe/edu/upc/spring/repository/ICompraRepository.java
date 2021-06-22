package pe.edu.upc.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import pe.edu.upc.spring.model.Compra;

@Repository
public interface ICompraRepository extends JpaRepository<Compra, Integer>{
	

	
}
