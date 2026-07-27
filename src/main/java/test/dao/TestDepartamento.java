package test.dao;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImpl;
import modelo.entities.Departamento;

public class TestDepartamento {

	private static DepartamentoDao dDao;
	
	static {
		
		dDao = new DepartamentoDaoImpl();
	}
	public static void main(String[] args) {
		
		// altaDepartamento();
		todos();
	}
	public static void todos() {
		
		for (Departamento depa : dDao.findAll()) {
			System.out.println(depa);
		}
	}
	
	public static void altaDepartamento () {
		
		Departamento depar = new Departamento ();
		depar.setIdDepartamento(50);
		depar.setNombre("RRHH");
		depar.setDireccion("Alicante");
		
		System.out.println(dDao.deleteOne(50));
		
	}
}
