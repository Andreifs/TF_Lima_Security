package pe.edu.upc.spring.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;






@Entity
@Table(name="PagoClieente")
public class PagoCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int idPagoCliente;

	    @Column(name="descripcionPlanC", nullable=false, length=100)
	    private String descripcionPlanC;

	    @ManyToOne
	    @JoinColumn(name="idPago")
	    private Pago pago;

	    @ManyToOne
	    @JoinColumn(name="idUsuario")
	    private Usuario usuario;
	    
	    

		public PagoCliente() {
			super();
			// TODO Auto-generated constructor stub
		}

		public PagoCliente(int idPagoCliente, String descripcionPlanC, Pago pago, Usuario usuario) {
			super();
			this.idPagoCliente = idPagoCliente;
			this.descripcionPlanC = descripcionPlanC;
			this.pago = pago;
			this.usuario = usuario;
		}

		public int getIdPagoCliente() {
			return idPagoCliente;
		}

		public void setIdPagoCliente(int idPagoCliente) {
			this.idPagoCliente = idPagoCliente;
		}

		public String getDescripcionPlanC() {
			return descripcionPlanC;
		}

		public void setDescripcionPlanC(String descripcionPlanC) {
			this.descripcionPlanC = descripcionPlanC;
		}

		public Pago getPago() {
			return pago;
		}

		public void setPago(Pago pago) {
			this.pago = pago;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}


}

