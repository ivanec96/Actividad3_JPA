package modelo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="FACTURAS")
public class Factura {

	
	@Id
	@Column (name="id_factura")
	private String idFactura;
	
	@Column (name="DESCRIPCION")
	private String descripcion;
	
	@Column (name="fecha_factura")
	private LocalDate fechaFactura;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROYECTO", nullable = false)
	private Proyecto proyecto;

	 
	 
	public Factura(String idFactura, String descripcion, LocalDate fechaFactura, Proyecto proyecto) {
		super();
		this.idFactura = idFactura;
		this.descripcion = descripcion;
		this.fechaFactura = fechaFactura;
		this.proyecto = proyecto;
	}



	public Factura() {
		super();
	}



	public String getIdFactura() {
		return idFactura;
	}



	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public LocalDate getFechaFactura() {
		return fechaFactura;
	}



	public void setFechaFactura(LocalDate fechaFactura) {
		this.fechaFactura = fechaFactura;
	}



	public Proyecto getProyecto() {
		return proyecto;
	}



	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	 
	
	
	 
}
