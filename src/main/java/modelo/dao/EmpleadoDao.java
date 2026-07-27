package modelo.dao;

import java.util.List;

import modelo.entities.Empleado;

public interface EmpleadoDao extends GenericoDao<Empleado, Integer> {
	
	
	List<Empleado> empleadosByDepartamento(int idDepar);
	
	List<Empleado> empleadosByGenero(char sexo);
	
	List<Empleado> empleadosByApellido(String subcadena);
	
	double salarioTotal();
	
	double salarioTotal(int idDepar);
}
