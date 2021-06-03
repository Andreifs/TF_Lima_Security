package pe.edu.upc.spring.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.spring.service.IDetalleServicioXPlanService;
import pe.edu.upc.spring.model.DetalleServicioXPlan;
import pe.edu.upc.spring.repository.IDetalleServicioXPlanRepository;


public class DetalleServicioXPlanServiceImpl implements IDetalleServicioXPlanService {

	
	@Autowired
	private IDetalleServicioXPlanRepository dDetalleServicioXPlan;

	@Override
	@Transactional
	public boolean insertar(DetalleServicioXPlan detalleServicioXPlan) {
		DetalleServicioXPlan objDetalleServicioXPlan= dDetalleServicioXPlan.save(detalleServicioXPlan);
		if	(objDetalleServicioXPlan !=null)
			return true;
		else
			return false;	
	}

	@Override
	@Transactional
	public boolean modificar(DetalleServicioXPlan detalleServicioXPlan) {
		boolean flag = false;
		try {
			dDetalleServicioXPlan.save(detalleServicioXPlan);
			flag=true;
		}
		catch(Exception ex) {
			
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idDetalleServicioXPlan) {
		dDetalleServicioXPlan.deleteById(idDetalleServicioXPlan);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<DetalleServicioXPlan> listar() {
		return dDetalleServicioXPlan.findAll();
	}

	@Override
	@Transactional
	public List<DetalleServicioXPlan> buscarPlan(String namePlan) {
		return dDetalleServicioXPlan.buscaPlan(namePlan);
	}

	@Override
	@Transactional
	public List<DetalleServicioXPlan> buscarServicio(String nameServicio) {
		return dDetalleServicioXPlan.buscarServicio(nameServicio);
	}
	
		
	@Override
	@Transactional(readOnly = true)
	public Optional<DetalleServicioXPlan> listarId(int idDetalleServicioXPlan) {
		return dDetalleServicioXPlan.findById(idDetalleServicioXPlan);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
