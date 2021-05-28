package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dispositivo")
public class Dispositivo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDispositivo;
	
	@Column(name="tipoDispositivo", length = 60, nullable=false)
	private String tipoDispositivo;
	
	@Column(name="modeloDisp", length = 20, nullable=false)
	private String modeloDisp;
	
	@Column(name="descripcionDisp", length = 100, nullable=false)
	private String descripcionDisp;
	
	@Column(name="precioDisp", length = 3, nullable=false)
	private double precioDisp;

	public Dispositivo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dispositivo(int idDispositivo, String tipoDispositivo, String modeloDisp, String descripcionDisp,
			double precioDisp) {
		super();
		this.idDispositivo = idDispositivo;
		this.tipoDispositivo = tipoDispositivo;
		this.modeloDisp = modeloDisp;
		this.descripcionDisp = descripcionDisp;
		this.precioDisp = precioDisp;
	}

	public int getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public String getModeloDisp() {
		return modeloDisp;
	}

	public void setModeloDisp(String modeloDisp) {
		this.modeloDisp = modeloDisp;
	}

	public String getDescripcionDisp() {
		return descripcionDisp;
	}

	public void setDescripcionDisp(String descripcionDisp) {
		this.descripcionDisp = descripcionDisp;
	}

	public double getPrecioDisp() {
		return precioDisp;
	}

	public void setPrecioDisp(double precioDisp) {
		this.precioDisp = precioDisp;
	}

	
}
