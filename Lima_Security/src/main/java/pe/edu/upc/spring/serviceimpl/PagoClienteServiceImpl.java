package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.PagoCliente;
import pe.edu.upc.spring.repository.IPagoClienteRepository;
import pe.edu.upc.spring.service.IPagoClienteService;

@Service
public class PagoClienteServiceImpl implements IPagoClienteService {

	@Autowired
	private IPagoClienteRepository dPagoCliente;

	@Override
	@Transactional
	public boolean insertar(PagoCliente pagocliente) {
		PagoCliente objPagoCliente= dPagoCliente.save(pagocliente);
		if	(objPagoCliente !=null)
			return true;
		else
			return false;
	
	}

	@Override
	@Transactional
	public boolean modificar(PagoCliente pagocliente) {
		boolean flag = false;
		try {
			dPagoCliente.save(pagocliente);
			flag=true;
		}
		catch(Exception ex) {
			
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPagoCliente) {
		dPagoCliente.deleteById(idPagoCliente);
	}

	@Override
		public Optional<PagoCliente> buscarId(int idPagoCliente) {
		return dPagoCliente.findById(idPagoCliente);
	}

	@Override
	public Optional<PagoCliente> listarId(int idPagoCliente) {
		return dPagoCliente.findById(idPagoCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PagoCliente> listar(){
		return dPagoCliente.findAll();
	}
	
	
	
	@Override
	@Transactional
	public List<PagoCliente> buscarPago(String namePago) {
		return dPagoCliente.buscarPago(namePago);
	}
	
	@Override
	@Transactional
	public List<PagoCliente> buscarUsuario(String nameUsuario) {
		return dPagoCliente.buscarUsuario(nameUsuario);
	}
}