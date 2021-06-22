package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Compra;
import pe.edu.upc.spring.repository.ICompraRepository;
import pe.edu.upc.spring.service.ICompraService;

@Service
public class CompraServiceImpl implements ICompraService {

	@Autowired
	private ICompraRepository dCompra;

	@Override
	@Transactional
	public boolean insertar(Compra compra) {
		Compra objCompra= dCompra.save(compra);
		if	(objCompra !=null)
			return true;
		else
			return false;
	}


	@Override
	@Transactional
	public void eliminar(int idCompra) {
		dCompra.deleteById(idCompra);
	}

	@Override
	public Optional<Compra> listarId(int idCompra) {
		return dCompra.findById(idCompra);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Compra> listar(){
		return dCompra.findAll();
	}
	

}