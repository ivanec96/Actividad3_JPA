package principales;

import java.util.List;

import modelo.dao.*;
import modelo.entities.*;


public class ImprimirGastos {

	private static ProyectoEmpleadoDao pedao;
	private static ProyectoDao pdao;
	private static EmpleadoDao edao;
	private static DepartamentoDao ddao;
	private static PerfilDao pperfil;
	public static ClienteDao cdao;
	
	
	static {
		
		pedao = new ProyectoEmpleadoImpl();
		pdao = new ProyectoDaoImpl();
		edao = new EmpleadoDaoImpl();
		ddao = new DepartamentoDaoImpl();
		pperfil = new PerfilDaoImpl();
		cdao = new ClienteDaoImpl();
	}
	

	
	
	public static void main(String[] args) {
		
		
		
		List<Proyecto> terminados = pdao.proyectosByEstado("TERMINADO");
		
		if (terminados != null && !terminados.isEmpty()) {
			
			Proyecto proyecto = terminados.get(0);
			
			imprimirInforme(proyecto);
		} else {
			
			System.out.println("Informe con estado Terminado no existe");
		}
		
		
		
		
		
	}
	
	
	
	
	
	public static void imprimirInforme(Proyecto p) {
		// --- 1. DATOS DEL CLIENTE ---
        System.out.println("Datos del CLIENTE:");
        
        System.out.println("nombre: " + p.getCliente().getNombre() + " " + p.getCliente().getApellidos() + 
                           " Dirección: " + p.getCliente().getDomicilio());
        
        // --- 2. DATOS DEL PROYECTO ---
        System.out.println("\nDatos del PROYECTO:");
        System.out.println("Codigo Proyecto: " + p.getIdProyecto());
        System.out.println("Descripción Proyecto: " + p.getDescripcion());
        System.out.println("Fecha Inicio: " + p.getFechaInicio() + "   Fecha Fin real: " + p.getFechaFinReal());
        
     // --- 2. DATOS DE EMPLEADOS ---
        System.out.println("\nDETALLE DE RECURSOS EMPLEADOS:");
        System.out.println("LISTA EMPLEADOS");
        
       
        double totalHoras = 0;
        double totalPrecioEmpleados = 0;
        
        for (ProyectoConEmpleado empProy : pedao.asignarEmpleadosByProyecto(p.getIdProyecto())) {
            
            Empleado emp = empProy.getEmpleado();
            int horas = empProy.getHorasAsignadas();
          
            double tasa = emp.getPerfil().getTasaStandard(); 
            double importe = horas * tasa;
            
            System.out.println("Apellidos, nombre: " + emp.getApellidos() + ", " + emp.getNombre() + 
                               " Horas (total): " + horas + 
                               " Importe repercutido: " + importe);
            
            totalHoras += horas;
            totalPrecioEmpleados += importe;
            
        }
        
        System.out.println("Total Horas: " + totalHoras + " Total Precio: " + totalPrecioEmpleados);
	}
	

}
