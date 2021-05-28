package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Dispositivo;
import pe.edu.upc.spring.repository.IDispositivoRepository;
import pe.edu.upc.spring.service.IDispositivoService;

@Service
public class DispositivoServiceImpl implements IDispositivoService {

	@Autowired
	private IDispositivoRepository dDisp;
	
	@Override
	@Transactional
	public boolean insertar(Dispositivo dispositivo) {
		Dispositivo objDisp = dDisp.save(dispositivo);
		if(objDisp == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Dispositivo dispositivo) {
		boolean flag = false;
		try {
			dDisp.save(dispositivo);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idDispositivo) {
		dDisp.deleteById(idDispositivo);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Dispositivo> listarId(int idDispositivo) {
		return dDisp.findById(idDispositivo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dispositivo> listar() {
		return dDisp.findAll();
	}

	@Override
	@Transactional
	public List<Dispositivo> buscarModelo(String modeloDisp) {
		return dDisp.buscarModelo(modeloDisp);
	}
	
}
