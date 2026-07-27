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
@Table (name="empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id_empl")
	private int idEmpl;
	
	@Column (name="nombre")
	private String nombre;
	
	@Column (name="apellidos")
	private String apellidos;
	
	@Column (name="genero")
	private String genero;
	
	@Column (name="email")
	private String email;
	
	@Column (name="password")
	private String password;
	
	@Column (name="salario")
	private double salario;
	
	@Column (name="fecha_ingreso")
	private LocalDate fechaIngreso;
	
	@Column (name="fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name = "id_depar")
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;
	
	
	
	/*

		ASUMO QUE LA VALARIO SALARIO ES ANUAL.
	  
	 * */
	 
	 public double salarioMensual (int meses) {
		 
		 if (this.salario == 0) {
			 
			 System.out.println("Salario no especificado");
			 return 0;
		 }
		 
		 return (salario / 12) * meses;
		 
	 }
	 
	 
	 
	 public String nombreCompleto () {
		 
		 if (this.apellidos == null ) {
			 return this.nombre;
		 }
		 
		 return this.nombre + " " + this.apellidos;
	 }
	 
	 
	 
	 public String literalGenero () {
		
		 // Verificacion necesaria. Si el genero es null el programa se casca
		 if (getGenero() == null ) {
			 
			 return "No especificado";
		 }
		 
		 switch(getGenero().toUpperCase()) {
		 
		 case "M":
			 return "Mujer";
	
		 case "H":
			 return "Hombre";
		default:
			return "Género no especificado";
			 
		 }
		
	 }

	 
	 
	public Empleado(int idEmpl, String nombre, String apellidos, String genero, String email, String password,
			double salario, LocalDate fechaIngreso, LocalDate fechaNacimiento, Departamento departamento, Perfil perfil) {
		super();
		this.idEmpl = idEmpl;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.email = email;
		this.password = password;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.departamento = departamento;
		this.perfil = perfil;
	}

	public Empleado() {
		super();
	}

	public int getIdEmpl() {
		return idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpl=" + idEmpl + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero=" + genero
				+ ", email=" + email + ", password=" + password + ", salario=" + salario + ", fechaIngreso="
				+ fechaIngreso + ", fechaNacimiento=" + fechaNacimiento + ", departamento=" + departamento + ", perfil="
				+ perfil + "]";
	}
	 
	 
}
