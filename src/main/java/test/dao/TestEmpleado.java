package test.dao;

import java.time.LocalDate;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImpl;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImpl;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImpl;
import modelo.entities.Cliente;
import modelo.entities.Departamento;
import modelo.entities.Empleado;
import modelo.entities.Perfil;

public class TestEmpleado {
	
	private static EmpleadoDao edao;
	private static DepartamentoDao ddao;
	private static PerfilDao pperfil;
	
	static {
		
		edao = new EmpleadoDaoImpl();
		ddao = new DepartamentoDaoImpl();
		pperfil = new PerfilDaoImpl();
	}

	public static void main(String[] args) {
		
		// insertOne();
		// deleteOne();
		// findAll();
		// updateOne();
		
		// empleadoDepar();
		// porGenero();
		// porApellido();
		// salarioTotal();
		salarioPorDepartamento();
	}
	
	
	
	/*
	 * METODOS PROPIOS DE EMPLEADODAOIMPL
	 */
	public static void empleadoDepar() {
		
	
			
		for (Empleado emp : edao.empleadosByDepartamento(10)) {
			System.out.println(emp);
			}
		}
		
	
	public static void porGenero() {
		
		for (Empleado emp : edao.empleadosByGenero('M')) {
			
			System.out.println(emp);
		}
	}
	
	
	public static void porApellido() {
		
		for (Empleado emp : edao.empleadosByApellido("ia")) {
			
			System.out.println(emp);
		}
	}
	
	public static void salarioTotal() {
		
		double total = edao.salarioTotal();
		
		System.out.println("Calculo total de los empleados: " + total);
	}
	
	public static void salarioPorDepartamento() {
		
		System.out.println(edao.salarioTotal(10));
	}
	
	
	
	
	
	
	/*
	 * METODOS CRUD 
	 */
	public static void insertOne () {
		
		Empleado emp = new Empleado();
		
		emp.setNombre("Pascual");
		emp.setApellidos("Solaris");
		emp.setEmail("pascu_solaris@gmail.com");
		emp.setFechaIngreso(LocalDate.of(2026, 8, 3));
		emp.setFechaNacimiento(LocalDate.of(1996, 7, 16));
		emp.setGenero("M");
		emp.setPassword("@14927!!");
		emp.setSalario(2300);
		
		Departamento depa = ddao.findById(20);
		
		if (depa != null ) {
			
			emp.setDepartamento(depa);
		} else {
			System.out.println("-- Ese departamento no existe --");
			return;
		}
		
		Perfil perfil = pperfil.findById(1);
		
		if (perfil != null) {
			
			emp.setPerfil(perfil);
		} else {
			System.out.println("--Este perfil No existe --");
			return;
		}
		
		int resultado = edao.insertOne(emp); 
		
		if (resultado == 1) {
			System.out.println("Inserccion realizada con exito");
		}
	}
	
	public static void deleteOne() {
		
		edao.deleteOne(121);
		
	}
	
	public static void findAll() {
		
		for (Empleado emp : edao.findAll()) {
			
			System.out.println(emp);
		}
	}
	
	public static void updateOne() {

		int id = 122;
		Empleado empleadoModificar = edao.findById(id);
		
		if (empleadoModificar != null) {
			
			empleadoModificar.setSalario(245000);
		}
		
		int resultado = edao.updateOne(empleadoModificar);
		
		if (resultado == 1) {
			
			System.out.println("Modificacion con exito");
		}
	}

}
