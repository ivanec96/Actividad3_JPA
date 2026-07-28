package modelo.dao;

import java.util.List;

import modelo.entities.Proyecto;

public interface ProyectoDao extends GenericoDao<Proyecto, String> {

	
	List<Proyecto>	proyectosByEstado(String estado);
	
	List<Proyecto> proyectosByCliente(String cif);
	
	List<Proyecto> proyectosByJefeProyectoAndEstado(int jefeProyecto,String estado);
	
	double importesVentaProyectosTerminados();
	
	double margenBrutoProyectosTerminados();  // Diferencia suma Importes venta y gastos reales.
	
	double prorcentageMargenBrutoProyectosTerminados();
	
	int diasATerminoProyectoActivo(String codigoProyecto);   // Cuantos días quedan para terminar el proyecto (diferencia entre fecha_fin_previsto y la fecha de hoy
}
