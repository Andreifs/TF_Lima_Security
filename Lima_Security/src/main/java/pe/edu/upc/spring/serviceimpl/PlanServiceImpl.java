package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Plan;
import pe.edu.upc.spring.repository.IPlanRepository;
import pe.edu.upc.spring.service.IPlanService;

@Service
public class PlanServiceImpl implements IPlanService {

	@Autowired
	private IPlanRepository dPlan;
	
	@Override
	@Transactional
	public boolean insertar(Plan plan) {
		Plan objPlan = dPlan.save(plan);
		if(objPlan == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Plan plan) {
		boolean flag = false;
		try {
			dPlan.save(plan);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPlan) {
		dPlan.deleteById(idPlan);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Plan> listarId(int idPlan) {
		return dPlan.findById(idPlan);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Plan> listar() {
		return dPlan.findAll();
	}

	@Override
	@Transactional
	public List<Plan> buscarNombre(String nombrePlan) {
		return dPlan.buscarNombre(nombrePlan);
	}
	
	
	@Override
	@Transactional
	public List<Plan> buscarId(int idPlan) {
		return dPlan.buscarId(idPlan);
	}
	
	@Override
	@Transactional
	public List<Plan> buscarDescripcion(String descripcionPlan) {
		return dPlan.buscarDescripcion(descripcionPlan);
	}
	
}
