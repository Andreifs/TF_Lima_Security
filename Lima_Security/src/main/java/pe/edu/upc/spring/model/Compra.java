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
@Table(name="Compras")
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int idCompra;

	    @ManyToOne
	    @JoinColumn(name="idPlan")
	    private Plan plan;
	    
	    

		public Compra() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Compra(int idCompra, Plan plan, Usuario usuario) {
			super();
			this.idCompra = idCompra;
			this.plan = plan;
		}
		public int getIdCompra() {
			return idCompra;
		}
		public void setIdCompra(int idCompra) {
			this.idCompra = idCompra;
		}
		public Plan getPlan() {
			return plan;
		}
		public void setPlan(Plan plan) {
			this.plan = plan;
		}
		


}

