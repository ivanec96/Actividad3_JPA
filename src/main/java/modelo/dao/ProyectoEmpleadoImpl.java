package modelo.dao;

import java.util.List;

import jakarta.persistence.Query;
import modelo.entities.Empleado;
import modelo.entities.ProyectoConEmpleado;

public class ProyectoEmpleadoImpl extends AbstractDao implements ProyectoEmpleadoDao{

	
	
	
	
	@Override
	public int insertOne(ProyectoConEmpleado entity) {

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
	public int updateOne(ProyectoConEmpleado entity) {
		
		try {
			if (findById(entity.getNumeroOrden()) != null) {
				
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
	public int deleteOne(Integer atributoID) {
		ProyectoConEmpleado proyectoConEmpleado = findById(atributoID);
		
		try {
			if(proyectoConEmpleado != null) {
				
				tx.begin();
					em.remove(proyectoConEmpleado);
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
	public ProyectoConEmpleado findById(Integer atributoID) {
		
		return em.find(ProyectoConEmpleado.class, atributoID);
	}

	@Override
	public List<ProyectoConEmpleado> findAll() {
		
		jpql = "from ProyectoConEmpleado pe";
		
		query = em.createQuery(jpql);
		
		return query.getResultList();
	}

	
	
	
	@Override
	public List<Empleado> empleadosByProyecto(String codigoProyecto) {
		
		jpql = "from ProyectoConEmpleado pe where pe.proyecto.idProyecto = :codigo";
		
		query = em.createQuery(jpql);
		
		query.setParameter("codigo", codigoProyecto);
		
		return query.getResultList();
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados) {
		
		return 0;
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {  // SUMA DE LAS HORAS DE EMPLEADOS EN EL PROYECTO

		jpql = "select sum(pe.horasAsignadas) from ProyectoConEmpleado pe where pe.proyecto.idProyecto = :codigo";
		
		query = em.createQuery(jpql);
		
		query.setParameter("codigo", codigoProyecto);
		
		// RECOGEMOS LA SUMA EN UN OBJETO GENERICO.
		Object total = query.getSingleResult();
		
		// COMPROBAMOS QUE ESE OBJETO NO SEA NULL. ASI VERIFICAMOS QUE SI ES UN NUMERO
		
		if (total != null) {
			
			return 0;
		}
		// AHORA HACEMOS EL CAST ADECUADO
		return  ((Number)total).intValue();
	}

	@Override
	public double costeActualDeEmpleadosEnProyecto(String codigoProyecto) {
		
		jpql = "select sum(pe.horasAsignadas * pe.empleado.perfil.tasaStandard) from ProyectoConEmpleado pe "
				+ " where pe.proyecto.idProyecto = :codigo";
		
		query = em.createQuery(jpql);
		query.setParameter("codigo", codigoProyecto);
		
		Object total = query.getSingleResult();
		
		if (total != null) {
			
			return 0;
		}
		
		
		return ((Number)total).doubleValue();
	}

}
