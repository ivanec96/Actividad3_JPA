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
	private static ClienteDao cdao;
	private static ProyectoConProductosDao ppdao;
	
	
	
	static {
		
		pedao = new ProyectoEmpleadoImpl();
		pdao = new ProyectoDaoImpl();
		edao = new EmpleadoDaoImpl();
		ddao = new DepartamentoDaoImpl();
		pperfil = new PerfilDaoImpl();
		cdao = new ClienteDaoImpl();
		ppdao = new ProyectoConProductosImpl();
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
                           "   Dirección: " + p.getCliente().getDomicilio());
        
        // --- 2. DATOS DEL PROYECTO ---
        System.out.println("\nDatos del PROYECTO:");
        System.out.println("Codigo Proyecto: " + p.getIdProyecto());
        System.out.println("Descripción Proyecto: " + p.getDescripcion());
        System.out.println("Fecha Inicio: " + p.getFechaInicio() + "    Fecha Fin real: " + p.getFechaFinReal());
        
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
                               "   Horas (total): " + horas + 
                               "   Importe repercutido: " + importe);
            
            totalHoras += horas;
            totalPrecioEmpleados += importe;
            
        }
        
        System.out.println("Total Horas: " + totalHoras + "   Total Precio: " + totalPrecioEmpleados);
        
        
        
        // --- 3. DATOS DE PRODUCTOS ---
        System.out.println("\nLISTA PRODUCTOS");
        
        double totalImportes = 0;
        
        for (ProyectoConProductos prodProye : ppdao.productoByProyecto(p.getIdProyecto())) {
        	
        	Producto producto = prodProye.getProducto();
        	String descripcion = producto.getDescripcion();
        	
        	int cantidad = prodProye.getCantidad();
        	double precioUnitario = producto.getPrecio();  // prodProye.getProducto().getPrecio();
        	double total = cantidad * precioUnitario;
        	
        	
        	System.out.println("Descripcion: " + descripcion + "   Cantidad: " + cantidad +
        			"   Precio Unidad: " + precioUnitario + "   Total: " + total);
        	
        	totalImportes += total;
        }
        
        System.out.println("Total Importes: " + totalImportes );
        
        
     // --- 4. DETALLE DEL IMPORTE Y ACTUALIZACIÓN ---
        System.out.println("\nDETALLE DEL IMPORTE:");
        
        double totalGastado = totalImportes + totalPrecioEmpleados;
        
        System.out.println("Total Gastado:  " + totalGastado +
        		"  Importe Venta:  " + p.getVentaPrevista());
        
        System.out.println("\n-- Actualizando el Coste Real ---");
        p.setCosteReal(totalGastado);
        pdao.updateOne(p);
        
        System.out.println("\n-- Base de datos Actualizada.");
	}
	


}
