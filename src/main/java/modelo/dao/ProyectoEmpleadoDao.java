package modelo.dao;

import java.util.List;

import modelo.entities.Empleado;
import modelo.entities.ProyectoConEmpleado;

public interface ProyectoEmpleadoDao extends GenericoDao<ProyectoConEmpleado, Integer> {

	
	List<Empleado> empleadosByProyecto(String codigoProyecto);
	
	int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados);
	
	int horasAsignadasAProyecto(String codigoProyecto);   //. Suma de las horas de los empleados asignados al proyecto.
	
	double costeActualDeEmpleadosEnProyecto(String codigoProyecto);  // horas*coste-hora de cada empleado asignado al proyecto.
	
	List<ProyectoConEmpleado> asignarEmpleadosByProyecto(String codigoProyecto); 
	/*
	ESTE METODO ES CONSTRUDIDO CON EL OBJETIVO DE OBTENER LOS EMPLEADOS DE UN PROYECTO DE TIPO ENTIDAD: ProyectoConEmpleado.
	
	ASI PODREMOS OBTENER LOS DATOS NECESARIOS(horas_asignadas) DE LOS EMPLEADOS PARA PODER REALIZAR EL INFORME REQUERIDO.
	CON EL OTRO METODO, NOS DEVOLVIA UNA LISTA DE EMPLEADOS Y NO PODEMOS ACCEDER A LA VARIABLE horas_asignadas.
	
	*/
	
}
