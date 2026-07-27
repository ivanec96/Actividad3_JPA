package modelo.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="PROYECTOS")
public class Proyecto {

	@Id
	@Column (name="ID_PROYECTO")
	private String idProyecto;
	
	@Column (name="DESCRIPCION")
	private String descripcion;
	
	@Column (name="fecha_inicio")
	private LocalDate fechaInicio;
	
	@Column (name="fecha_fin_previsto")
	private LocalDate fechaFinPrevisto;
	
	@Column (name="fecha_fin_real")
	private LocalDate fechaFinReal;
	
	@Column (name="venta_previsto")
	private double ventaPrevista;
	
	@Column (name="costes_previsto")
	private double costesPrevisto;
	
	@Column (name="coste_real")
	private double costeReal;
	
	@Column (name="estado")
	private boolean estado;
	
	private Empleado jefeProyecto;
	
	
	 @ManyToOne
	 @JoinColumn(name = "cif", nullable = false)
	private Cliente cliente;


	public Proyecto(String idProyecto, String descripcion, LocalDate fechaInicio, LocalDate fechaFinPrevisto,
			LocalDate fechaFinReal, double ventaPrevista, double costesPrevisto, double costeReal, boolean estado,
			Empleado jefeProyecto, Cliente cliente) {
		super();
		this.idProyecto = idProyecto;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.ventaPrevista = ventaPrevista;
		this.costesPrevisto = costesPrevisto;
		this.costeReal = costeReal;
		this.estado = estado;
		this.jefeProyecto = jefeProyecto;
		this.cliente = cliente;
	}

	public Proyecto () {
		
	}
	
	
	// METODOS PROPIOS DE LA CLASE PROYECTO
	
	
	public double margenPrevisto () {
		
		return ventaPrevista - costesPrevisto;
		
	
	}
	
	public double porcentajeMargenPrevisto () {
		
		if (ventaPrevista == 0) {
			return 0;
		}
		return (margenPrevisto() / ventaPrevista ) * 100;
	}
	
	
	public double margenReal() {
		
		return ventaPrevista - costeReal;
		
	}
	
	
	public double porcentajeMargenReal() {
		
		if (ventaPrevista == 0) {
			return 0;
		}
		
		return (margenReal() / ventaPrevista) * 100;

	}
	
	public double diferenciaGastos() {
		
		return costeReal - costesPrevisto;
	}
	
	public int diferenciaDiasFinPrevistoReal() {
		// Validacion
		if (fechaFinPrevisto == null || fechaFinReal == null ) {
			return 0;
		}
		
		// Casting a int para que nos de un numero
		return (int) ChronoUnit.DAYS.between(fechaFinPrevisto, fechaFinReal);
		
	}

	
	
	
	// GETTER AND SETTERS
	
	
	
	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFinPrevisto() {
		return fechaFinPrevisto;
	}

	public void setFechaFinPrevisto(LocalDate fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}

	public LocalDate getFechaFinReal() {
		return fechaFinReal;
	}

	public void setFechaFinReal(LocalDate fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public double getVentaPrevista() {
		return ventaPrevista;
	}

	public void setVentaPrevista(double ventaPrevista) {
		this.ventaPrevista = ventaPrevista;
	}

	public double getCostesPrevisto() {
		return costesPrevisto;
	}

	public void setCostesPrevisto(double costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}

	public double getCosteReal() {
		return costeReal;
	}

	public void setCosteReal(double costeReal) {
		this.costeReal = costeReal;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Empleado getJefeProyecto() {
		return jefeProyecto;
	}

	public void setJefeProyecto(Empleado jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	
	
}
