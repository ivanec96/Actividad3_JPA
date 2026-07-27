package modelo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="PRODUCTOS")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="ID_PRODUCTO")
	private int idProducto;
	
	@Column (name="DESCRIPCION")
	private String descripcion;
	
	@Column (name="PRECIO")
	private double precio;
	
	@Column (name="FECHA_CREACION")
	private LocalDate fechaCreacion;
	
	// Creacion de una union UNIDIRECCIONAL con la clase Familia
	 @ManyToOne
	 @JoinColumn(name = "ID_FAMILIA")
	private Familia familia;

	 
	 // Constructores
	public Producto(int idProducto, String descripcion, double precio, LocalDate fechaCreacion, Familia familia) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
		this.familia = familia;
	}
	
	public Producto() {
		
	}

	
	
	// Getter and Setters
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}
	 
	
	 
}
