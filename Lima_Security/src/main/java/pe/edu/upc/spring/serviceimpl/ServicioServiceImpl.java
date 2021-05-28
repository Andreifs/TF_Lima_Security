package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Servicio;
import pe.edu.upc.spring.repository.IServicioRepository;
import pe.edu.upc.spring.service.IServicioService;

@Service
public class ServicioServiceImpl implements IServicioService {

	@Autowired
	private IServicioRepository dServ;
	
	@Override
	@Transactional
	public boolean insertar(Servicio servicio) {
		Servicio objServ = dServ.save(servicio);
		if(objServ == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Servicio servicio) {
		boolean flag = false;
		try {
			dServ.save(servicio);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idServicio) {
		dServ.deleteById(idServicio);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Servicio> listarId(int idServicio) {
		return dServ.findById(idServicio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Servicio> listar() {
		return dServ.findAll();
	}

	@Override
	@Transactional
	public List<Servicio> buscarNombre(String nombreServicio) {
		return dServ.buscarNombre(nombreServicio);
	}
	
}
