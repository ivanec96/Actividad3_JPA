package modelo.dao;

import java.util.List;

import modelo.entities.Proyecto;

public class ProyectoDaoImpl extends AbstractDao implements ProyectoDao{

	@Override
	public int insertOne(Proyecto entity) {
		
		try {
			
			tx.begin();
				em.persist(entity);
			tx.commit();
				return 1;
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
				return 0;
		}
		
	}

	@Override
	public int updateOne(Proyecto entity) {
		
		try {
			if(findById(entity.getIdProyecto()) != null ) {
				
				tx.begin();
					em.merge(entity);
				tx.commit();
					return 1;
			} else 
				return 0;
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		return -1;
		}
	}

	@Override
	public int deleteOne(String atributoID) {
		
		Proyecto proyecto = findById(atributoID);
		try {
			if(proyecto != null) {
				tx.begin();
					em.remove(proyecto);
				tx.commit();
				return 1;
			} else
				return 0;
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			return -1;
		}
		
	}

	@Override
	public Proyecto findById(String atributoID) {
		// TODO Auto-generated method stub
		return em.find(Proyecto.class, atributoID);
	}

	
	@Override
	public List<Proyecto> findAll() {
		jpql = "from Proyecto p";
		
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	
	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		
		jpql = "from Proyecto p where p.estado = :estad";
		
		query = em.createQuery(jpql);
		
		query.setParameter("estad", estado);
		return query.getResultList();
	}

	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		
		jpql = "from Proyecto p where p.cliente.cif = :cif";
		
		query = em.createQuery(jpql);
		
		query.setParameter("cif", cif);
		
		return query.getResultList();
	}

	@Override
	public List<Proyecto> proyectosByJefeProyectoAndEstado(int jefeProyecto, String estado) {
		
		jpql = "from Proyecto p where p";
		return null;
	}

	@Override
	public double importesVentaProyectosTerminados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double prorcentageMargenBrutoProyectosTerminados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
