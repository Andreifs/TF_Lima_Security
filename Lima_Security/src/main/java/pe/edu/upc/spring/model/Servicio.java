package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Servicio")
public class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicio;
	
	@Column(name="nombreServicio", length = 60, nullable=false)
	private String nombreServicio;
	
	@Column(name="descripcionServ", length = 100, nullable=false)
	private String descripcionServ;

	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Servicio(int idServicio, String nombreServicio, String descripcionServ) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.descripcionServ = descripcionServ;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getDescripcionServ() {
		return descripcionServ;
	}

	public void setDescripcionServ(String descripcionServ) {
		this.descripcionServ = descripcionServ;
	}
	
	
}
