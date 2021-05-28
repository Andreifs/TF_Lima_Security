package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Plan")
public class Plan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlan;
	
	@Column(name="nombrePlan", length = 60, nullable=false)
	private String nombrePlan;
	
	@Column(name="descripcionPlan", length = 100, nullable=false)
	private String descripcionPlan;
	
	@Column(name="precioPlan", length = 4, nullable=false)
	private double precioPlan;

	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plan(int idPlan, String nombrePlan, String descripcionPlan, double precioPlan) {
		super();
		this.idPlan = idPlan;
		this.nombrePlan = nombrePlan;
		this.descripcionPlan = descripcionPlan;
		this.precioPlan = precioPlan;
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public String getNombrePlan() {
		return nombrePlan;
	}

	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}

	public String getDescripcionPlan() {
		return descripcionPlan;
	}

	public void setDescripcionPlan(String descripcionPlan) {
		this.descripcionPlan = descripcionPlan;
	}

	public double getPrecioPlan() {
		return precioPlan;
	}

	public void setPrecioPlan(double precioPlan) {
		this.precioPlan = precioPlan;
	}
	
	
}
