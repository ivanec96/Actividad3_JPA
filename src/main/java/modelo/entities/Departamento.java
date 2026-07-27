package modelo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="Departamentos")
public class Departamento {
	
	
	@Id
	@Column (name="id_depar")
	private int idDepartamento;
	
	@Column (name="nombre")
	private String nombre;
	
	@Column (name="direccion")
	private String direccion;

	public Departamento(int idDepartamento, String nombre, String direccion) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Departamento() {
		super();
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Departamento [idDepartamento=" + idDepartamento + ", nombre=" + nombre + ", direccion=" + direccion
				+ "]";
	}

	
	

}
