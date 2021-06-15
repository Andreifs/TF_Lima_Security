package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.DetalleDispositivoPlan;

<<<<<<< HEAD
public interface IPlanDispositivoPlanService {
    public boolean insertar(DetalleDispositivoPlan detalleDispositivoPlan);
=======
public interface IDetalleDispositivoPlanService {
public boolean insertar(DetalleDispositivoPlan detalleDispositivoPlan);
>>>>>>> f46e1046898ce89e162e9e316df67fe997bc3b5e
	public boolean modificar (DetalleDispositivoPlan detalleDispositivoPlan);
	public void eliminar(int idDetalleDispositivoPlan);
	public List<DetalleDispositivoPlan> listar();
	public List<DetalleDispositivoPlan> buscarPlan(String namePlan);
	public List<DetalleDispositivoPlan> buscarDispositivo(String nameDispositivo);

}
