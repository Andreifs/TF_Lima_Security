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

@Entity
@Table(name="Compra")
public class Pago implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPago;
	
	@Column(name="fechaPago", nullable = false, length= 4)
	private Date fechaPago;
	
	 @ManyToOne
	    @JoinColumn(name="idUsuario")
	    private Usuario usuario;
	 
	 @ManyToOne
	    @JoinColumn(name="idPlan")
	    private Plan plan;


	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
