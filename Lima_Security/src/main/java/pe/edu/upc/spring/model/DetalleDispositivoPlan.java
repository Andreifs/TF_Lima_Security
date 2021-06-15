
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
@Table(name="DetalleDipositivoPlan")
public class DetalleDispositivoPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleDispositivoPlan;
	
	@ManyToOne
	@JoinColumn(name="idPlan",nullable=false)
	private Plan plan;

	@ManyToOne
	@JoinColumn(name="idDispositivo",nullable=false)
	private Dispositivo dispositivo;


	public DetalleDispositivoPlan() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DetalleDispositivoPlan(int idDetalleDispositivoPlan, Plan plan, Dispositivo dispositivo) {
		super();
		this.idDetalleDispositivoPlan = idDetalleDispositivoPlan;
		this.plan = plan;
		this.dispositivo = dispositivo;
	}


	public int getIdDetalleDispositivoPlan() {
		return idDetalleDispositivoPlan;
	}


	public void setIdDetalleDispositivoPlan(int idDetalleDispositivoPlan) {
		this.idDetalleDispositivoPlan = idDetalleDispositivoPlan;
	}


	public Plan getPlan() {
		return plan;
	}


	public void setPlan(Plan plan) {
		this.plan = plan;
	}


	public Dispositivo getDispositivo() {
		return dispositivo;
	}


	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}


	
	
}
