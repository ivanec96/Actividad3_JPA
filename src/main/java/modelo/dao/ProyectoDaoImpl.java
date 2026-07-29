package modelo.dao;

import java.time.temporal.ChronoUnit;
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
		
		jpql = "from Proyecto p where p.jefeProyecto.idEmpl = :jefe and p.estado = :estado";
		
		query = em.createQuery(jpql);
		
		query.setParameter("jefe", jefeProyecto);
		query.setParameter("estado", estado);
		
		return query.getResultList();
	}

	@Override
	public double importesVentaProyectosTerminados() {
		jpql = "select sum(p.ventaPrevista) from Proyecto p where p.estado = 'Terminado'";
		
		query = em.createQuery(jpql);
		
		Double totalVenta = (Double) query.getSingleResult();
		
		if (totalVenta == null) {
			
			return 0.0;
		}
		
		return totalVenta;
	}

	@Override
	public double margenBrutoProyectosTerminados() {                // Diferencia suma Importes venta y gastos reales.

		jpql = "select sum(p.ventaPrevista) - sum(p.costeReal) from Proyecto p where p.estado = 'Terminado'";
		
		query = em.createQuery(jpql);
		
		/* Nos devulve un objeto de la bd pero segun los numeros con los que trabajamos
					en la bd nos puede dar otro tipo de dato diferente a double
	     	Por eso lo gurdamos en la clase padre Object
		*/
		Object resultado  =  query.getSingleResult();
		
		if (resultado == null) {        // Validamos la clase padre object si es null o no
			
			System.out.println("Margen nulo");
			return 0.0;
		}
		
		double margen = ((Number) resultado).doubleValue();    // Una vez sabemos que es un numero, lo convertimos a double de manera segura
		                                                      // Sabemos que resultado es un numero lo convertimos a double con el metodo doubleValue()
		if (margen < 0) {
			
			System.out.println("Margen negativo. Vamos a bancarrota");
			
			return margen;
		}
		
		return margen;
	}

	@Override
	public double prorcentageMargenBrutoProyectosTerminados() {     
		
		jpql = "select (((sum(p.ventaPrevista) - sum(p.costeReal)) / sum(p.costeReal)) * 100) from Proyecto p where p.estado = 'Terminado'";
		
		query = em.createQuery(jpql);
		
		Object resultado = query.getSingleResult();
		
		// Verificamos si el objeto obetenido es un numero
		
		if (resultado == null) {
			
			return 0.0;
		}
		
		
		// Si no es null. Es un numero. Lo convertimos a tipo double.
		
		double porcentage = ((Number)resultado).doubleValue();
		
		
		// Validacion para un mergen negativo
		if (porcentage < 0) {
			
			System.err.println("Cuidado porque nuestro mergen es negativo");
			
			return porcentage;
		}
		
		return porcentage;
	}

	@Override
	public int diasATerminarProyectoActivo(String codigoProyecto) {
		
		jpql = "from Proyecto p where p.estado = 'Activo' and p.idProyecto = :codigo";
		
		query = em.createQuery(jpql);
		query.setParameter("codigo", codigoProyecto);
		
		Proyecto proyecto = (Proyecto) query.getSingleResult();
		
		// El resultado de la diff de fechas suele dar un numero de tipo long
		long dias = ChronoUnit.DAYS.between(proyecto.getFechaInicio(), proyecto.getFechaFinPrevisto());
		
		return (int) dias;
	}

}
