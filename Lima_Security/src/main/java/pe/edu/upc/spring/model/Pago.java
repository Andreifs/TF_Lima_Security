package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pago")
public class Pago implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPago;
	
	@Column(name="tipoPago", nullable = false, length=20)
	private String tipoPago;
	
	@Column(name="descripcionPlan", nullable = false, length= 100)
	private String descripcionPlan;
	
	@Column(name="fechaPago", nullable = false, length= 4)
	private Date fechaPago;

	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pago(int idPago, String tipoPago, String descripcionPlan, Date fechaPago) {
		super();
		this.idPago = idPago;
		this.tipoPago = tipoPago;
		this.descripcionPlan = descripcionPlan;
		this.fechaPago = fechaPago;
	}

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getDescripcionPlan() {
		return descripcionPlan;
	}

	public void setDescripcionPlan(String descripcionPlan) {
		this.descripcionPlan = descripcionPlan;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	
	
	
}
