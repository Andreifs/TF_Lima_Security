package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.spring.service.IDetalleDispositivoPlanService;
import pe.edu.upc.spring.model.DetalleDispositivoPlan;
import pe.edu.upc.spring.repository.IDetalleDispositivoPlanRepository;


public class DetalleDispositivoPlanServiceImpl implements IDetalleDispositivoPlanService {

	
	@Autowired
	private IDetalleDispositivoPlanRepository dDetalleDispositivoPlan;

	@Override
	@Transactional
	public boolean insertar(DetalleDispositivoPlan detalleDispositivoPlan) {
		DetalleDispositivoPlan objDetalleDispositivoPlan= dDetalleDispositivoPlan.save(detalleDispositivoPlan);
		if	(objDetalleDispositivoPlan !=null)
			return true;
		else
			return false;	
	}

	@Override
	@Transactional
	public boolean modificar(DetalleDispositivoPlan detalleDispositivoPlan) {
		boolean flag = false;
		try {
			dDetalleDispositivoPlan.save(detalleDispositivoPlan);
			flag=true;
		}
		catch(Exception ex) {
			
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idDetalleDispositivoPlan) {
		dDetalleDispositivoPlan.deleteById(idDetalleDispositivoPlan);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleDispositivoPlan> listar() {
		return dDetalleDispositivoPlan.findAll();
	}

	@Override
	@Transactional
	public List<DetalleDispositivoPlan> buscarPlan(String namePlan) {
		return dDetalleDispositivoPlan.buscaPlan(namePlan);
	}

	@Override
	@Transactional
	public List<DetalleDispositivoPlan> buscarDispositivo(String modeloDispo) {
		return dDetalleDispositivoPlan.buscarDispositivo(modeloDispo);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<DetalleDispositivoPlan> listarId(int DetalleDispositivoPlan) {
		return dDetalleDispositivoPlan.findById(DetalleDispositivoPlan);
	}
	
}
	
	
	
	
	
	