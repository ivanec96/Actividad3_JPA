package modelo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="FAMILIAS")
public class Familia {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="ID_FAMILIA")
	private int idFamilia;
	
	@Column (name="DESCRIPCION")
	private String descripcion;
	
	
	// Esto hace que la union Familia-Producto Sea BI-DIRECCIONAL
    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    
    
	public Familia(int idFamilia, String descripcion) {
		super();
		this.idFamilia = idFamilia;
		this.descripcion = descripcion;
	}
	
	// Constructor Vacio es Obligatorio 
	public Familia() {
		
	}

	public int getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
