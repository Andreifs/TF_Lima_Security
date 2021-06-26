package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Pago")
public class Pago implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPago;
	
	@Column(name="tipoTarjeta", length = 10, nullable=false)
	private String tipoTarjeta;
	
	@Column(name="numTarjeta", length = 16, nullable=false)
	private String numTarjeta;
	
	@Column(name="cvv", length = 3, nullable=false)
	private int cvv;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaVencimiento", length = 50, nullable=false)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date dateVencimiento;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaPago", length = 50, nullable=false)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date datePago;
	 
	 @ManyToOne
	 @JoinColumn(name="idCompra")
	 private Compra compra;


	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pago(int idPago, String tipoTarjeta, String numTarjeta, int cvv, Date dateVencimiento, Date datePago,
			Compra compra) {
		super();
		this.idPago = idPago;
		this.tipoTarjeta = tipoTarjeta;
		this.numTarjeta = numTarjeta;
		this.cvv = cvv;
		this.dateVencimiento = dateVencimiento;
		this.datePago = datePago;
		this.compra = compra;
	}


	public int getIdPago() {
		return idPago;
	}


	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}


	public String getTipoTarjeta() {
		return tipoTarjeta;
	}


	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}


	public String getNumTarjeta() {
		return numTarjeta;
	}


	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}


	public int getCvv() {
		return cvv;
	}


	public void setCvv(int cvv) {
		this.cvv = cvv;
	}


	public Date getDateVencimiento() {
		return dateVencimiento;
	}


	public void setDateVencimiento(Date dateVencimiento) {
		this.dateVencimiento = dateVencimiento;
	}


	public Date getDatePago() {
		return datePago;
	}


	public void setDatePago(Date datePago) {
		this.datePago = datePago;
	}


	public Compra getCompra() {
		return compra;
	}


	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	
	
	
	
	
}
