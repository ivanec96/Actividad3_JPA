package test.dao;

import java.time.LocalDate;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImpl;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImpl;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImpl;
import modelo.dao.ProyectoEmpleadoDao;
import modelo.dao.ProyectoEmpleadoImpl;
import modelo.entities.Empleado;
import modelo.entities.Proyecto;
import modelo.entities.ProyectoConEmpleado;

public class TestProyectoEmpleado {

	private static ProyectoEmpleadoDao pedao;
	private static ProyectoDao pdao;
	private static EmpleadoDao edao;
	
	static {
		
		pedao = new ProyectoEmpleadoImpl();
		pdao = new ProyectoDaoImpl();
		edao = new EmpleadoDaoImpl();
	}
	
	
	
	public static void main(String[] args) {
		
		 // findAll();
		  // insertOne();
		// deleteOne();
		// updateOne();
	//	empByProyecto ();
		// horasAsignadasProyecto ();
		costeProyecto();

	}

	/*
	 *  METODOS PROPIOS
	 * 
	 */
	
	public static void empByProyecto () {
		
		for (Empleado ele : pedao.empleadosByProyecto("FOR2021001")) {
			
			System.out.println(ele);
		}
		
	}
	
	
	public static void horasAsignadasProyecto () {
		
		 double horas = pedao.horasAsignadasAProyecto("FOR2021012");
			
			System.out.println(horas);
		
	}
	
	
	public static void costeProyecto() {
		
		double coste = pedao.costeActualDeEmpleadosEnProyecto("FOR2021012");
		
		System.out.println(coste);
	}
	
	/*
	 *    METODOS CRUD
	 * 
	 * */
	
	public static void insertOne() {
		
		ProyectoConEmpleado proEmp = new ProyectoConEmpleado();
		proEmp.setNumeroOrden(1020);
		proEmp.setFechaIncorporacion(LocalDate.of(2026, 2, 23));
		proEmp.setHorasAsignadas(40);
		
		Empleado  emp = edao.findById(114);
		
		if(emp != null) {
			
			proEmp.setEmpleado(emp);;
		} else {
			System.out.println("No existe este empleado");
			return;
		}
		
		Proyecto proyecto =  pdao.findById("FOR2021012");
		
		if (proyecto != null) {
			
		proEmp.setProyecto(proyecto);
		
		} else {
			
			System.out.println("El proyecto no existe");
			return;
		}
		
		int resultado = pedao.insertOne(proEmp);
		
		if (resultado == 1) {
			
			System.out.println("Proyecto con Empleado añadido con existo");
		} else {
			System.out.println("Error");
		}
		
	}
	
	
	public static void findAll() {
		
		for (ProyectoConEmpleado ele : pedao.findAll()) {
			System.out.println(ele);
		}
	}
	
	
	public static void deleteOne() {
		
		System.out.println(pedao.deleteOne(5));
	}
	
	
	public static void updateOne() {
		
		
		Empleado emp = edao.findById(120);
		ProyectoConEmpleado proyectoModificar = pedao.findById(6);
		
		if (proyectoModificar != null && emp != null) {
			
			proyectoModificar.setEmpleado(emp);
		} else {
			System.out.println("El Empleado no existe o el Proyecto no ha sido creado");
			return;
		}
		
		int resultado = pedao.updateOne(proyectoModificar);
		
		if (resultado ==  1) {
			System.out.println("-- Jefe modificado con exito --");
		} else
			System.out.println("-- Error en la modificacion --");
		return;
	}
}
