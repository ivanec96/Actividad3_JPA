package modelo.dao;

import java.util.List;

import modelo.entities.ProyectoConProductos;

public class ProyectoConProductosImpl extends AbstractDao implements ProyectoConProductosDao{

	@Override
	public int insertOne(ProyectoConProductosDao entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(ProyectoConProductosDao entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(Integer atributoID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProyectoConProductosDao findById(Integer atributoID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProyectoConProductosDao> findAll() {

		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<ProyectoConProductos> productoByProyecto(String codigoProyecto) {
		jpql = "from ProyectoConProductos pp where pp.proyecto.idProyecto = :codigo";
		
		query =  em.createQuery(jpql);
		query.setParameter("codigo", codigoProyecto);
		
		return query.getResultList();
	}

}
