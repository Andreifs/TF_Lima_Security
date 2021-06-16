package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="DetalleServicioXPlan")
public class DetalleServicioXPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleServicioPlan;
	


	@ManyToOne
	@JoinColumn(name="idPlan",nullable=false)
	private Plan plan;

	@ManyToOne
	@JoinColumn(name="idServicio",nullable=false)
	private Servicio servicio;


	public DetalleServicioXPlan() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DetalleServicioXPlan(int idDetalleServicioPlan, Plan plan, Servicio servicio) {
		super();
		this.idDetalleServicioPlan = idDetalleServicioPlan;
		this.plan = plan;
		this.servicio = servicio;
	}


	public int getIdDetalleServicioPlan() {
		return idDetalleServicioPlan;
	}


	public void setIdDetalleServicioPlan(int idDetalleServicioPlan) {
		this.idDetalleServicioPlan = idDetalleServicioPlan;
	}


	public Plan getPlan() {
		return plan;
	}


	public void setPlan(Plan plan) {
		this.plan = plan;
	}


	public Servicio getServicio() {
		return servicio;
	}


	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}



	
}
