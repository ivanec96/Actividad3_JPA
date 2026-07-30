package modelo.dao;

import java.util.List;

import modelo.entities.Empleado;
import modelo.entities.ProyectoConEmpleado;

public interface ProyectoEmpleadoDao extends GenericoDao<ProyectoConEmpleado, Integer> {

	
	List<Empleado> empleadosByProyecto(String codigoProyecto);
	
	int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados);
	
	int horasAsignadasAProyecto(String codigoProyecto);   //. Suma de las horas de los empleados asignados al proyecto.
	
	double costeActualDeEmpleadosEnProyecto(String codigoProyecto);  // horas*coste-hora de cada empleado asignado al proyecto.
}
