package modelo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="proyecto_con_productos")
public class ProyectoConProductos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="num_orden")
	private int numOrden;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROYECTO")
	private Proyecto proyecto;
	
	@ManyToOne
	@JoinColumn(name = "ID_PRODUCTO")
	private Producto producto;
	
	@Column (name="precio_asignado")
	private int precioAsignado;
	
	@Column (name="cantidad")
	private int cantidad;

	public ProyectoConProductos(int numOrden, Proyecto proyecto, Producto producto, int precioAsignado, int cantidad) {
		super();
		this.numOrden = numOrden;
		this.proyecto = proyecto;
		this.producto = producto;
		this.precioAsignado = precioAsignado;
		this.cantidad = cantidad;
	}

	public ProyectoConProductos() {
		super();
	}

	public int getNumOrden() {
		return numOrden;
	}

	public void setNumOrden(int numOrden) {
		this.numOrden = numOrden;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getPrecioAsignado() {
		return precioAsignado;
	}

	public void setPrecioAsignado(int precioAsignado) {
		this.precioAsignado = precioAsignado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
}
