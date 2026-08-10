package modelo.dao;

import java.util.List;

import modelo.entities.ProyectoConProductos;

public interface ProyectoConProductosDao extends GenericoDao <ProyectoConProductosDao,Integer> {

	List<ProyectoConProductos> productoByProyecto (String codigoProyecto);
}
