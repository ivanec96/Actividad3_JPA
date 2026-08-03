package test.dao;

import java.time.LocalDate;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImpl;
import modelo.dao.DepartamentoDaoImpl;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImpl;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImpl;
import modelo.entities.Cliente;
import modelo.entities.Empleado;
import modelo.entities.Proyecto;

public class TestProyecto {
	
	private static ProyectoDao pdao;
	private static ClienteDao cdao;
	private static EmpleadoDao edao;
	
	
	static {
		
		pdao = new ProyectoDaoImpl();
		cdao = new ClienteDaoImpl();
		edao = new EmpleadoDaoImpl();

	}

	public static void main(String[] args) {
	
		// insertOne();
		// updateOne(); // MODIFICAR EL JEFE DEL PROYECTO
		// findAll();
		// deleteOne();
		//proyectoEstado();
		// proyectoCliente();
		// jefeEstadoProyecto();
		// ventasProyTerminado();
		// margenBrutoTerminado();
		// porcentajeBrutoTerminado();
		diasATerminarProyectoActivo();
		
		

	}
	
	/*
	 * METODOS PROPIOS DE PROYECTO
	 */
	

	public static void proyectoEstado() {
		
		for (Proyecto p : pdao.proyectosByEstado("Terminado")) {
			
			System.out.println(p);
		}
	}
	
	
	public static void proyectoCliente () {
		
		for (Proyecto  c : pdao.proyectosByCliente("A22222222")) {
			
			System.out.println(c);
		}
	}
	
	
	public static void jefeEstadoProyecto () {

			
		for (Proyecto p : pdao.proyectosByJefeProyectoAndEstado(114, "terminado")) {
			
		
			System.out.println(p);
		}
	
	}
	
	
	public static void ventasProyTerminado() {
		
		double total = pdao.importesVentaProyectosTerminados();
		
		System.out.println("Total ventas de proyectos terminado: " + total);
	}
	
	
	public static void margenBrutoTerminado() {
		
		double total = pdao.margenBrutoProyectosTerminados();
		
		System.out.println(total);
	}
	
	
	public static void porcentajeBrutoTerminado() {
		
		double porcentaje = pdao.prorcentageMargenBrutoProyectosTerminados();
		
		System.out.println(porcentaje);
		
	}

	
	public static void diasATerminarProyectoActivo() {
		
		int dias = pdao.diasATerminarProyectoActivo("FOR2021001");
		
		System.out.println(dias);
	}
	
	
	
	
	
	/*
	 *      METODOS CRUD DE PROYECTO
	 * */
	
	
	
	public static void insertOne() {
		
		Proyecto proyecto = new Proyecto();
		
		proyecto.setIdProyecto("FOR2021012");
		proyecto.setDescripcion("Formacion del Departamento de Software");
		proyecto.setCostesPrevisto(34000);
		proyecto.setCosteReal(32500);
		proyecto.setEstado("TERMINADO");
		proyecto.setFechaInicio(LocalDate.of(2026, 2, 12));
		proyecto.setFechaFinPrevisto(LocalDate.of(2026, 2, 27));
		proyecto.setFechaFinReal(LocalDate.of(2026, 3, 1));
		proyecto.setVentaPrevista(40000);
		
		Cliente c = cdao.findById("A22222222");
		
		if(c != null ) {
			
			proyecto.setCliente(c);
			
		} else {
			System.out.println("Cliente no existe");
				return;
		
		}
		
		Empleado  emp = edao.findById(114);
		
		if(emp != null) {
			
			proyecto.setJefeProyecto(emp);
		} else {
			System.out.println("No existe ese jefe");
			return;
		}
		
		int total = pdao.insertOne(proyecto);
		
		if (total == 1) {
			
			System.out.println("-- Proyecto insertado con exito --");
		}
				
				
	}
	
	public static void deleteOne() {
		
		System.out.println(pdao.deleteOne("FOR2021012"));
	}
	
	
	
	
	
	// MODIFICAR JEFE PROYECTO
	public static void updateOne() {

		
		Empleado jefe = edao.findById(115);
		Proyecto proyectoModificar = pdao.findById("FOR2021012");
		
		if (proyectoModificar != null && jefe != null) {
			
			proyectoModificar.setJefeProyecto(jefe);
		} else {
			System.out.println("El jefe no existe o el Proyecto no ha sido creado");
			return;
		}
		
		int resultado = pdao.updateOne(proyectoModificar);
		
		if (resultado ==  1) {
			System.out.println("-- Jefe modificado con exito --");
		} else
			System.out.println("-- Error en la modificacion --");
		return;
	}
	
	
	public static void findAll() {
		
		for (Proyecto p : pdao.findAll()) {
			System.out.println(p);
		}
	}
	
}
