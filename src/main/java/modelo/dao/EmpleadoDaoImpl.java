package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;
import modelo.entities.Empleado;

public class EmpleadoDaoImpl extends AbstractDao implements EmpleadoDao {
 
	
	public EmpleadoDaoImpl() {
		super();
	}

	
	
	@Override
	public int insertOne(Empleado entity) {
		
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
	public int updateOne(Empleado entity) {
		try {
			if (findById(entity.getIdEmpl()) != null) {
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

		Empleado empleado = findById(atributoID);
		
		try {
			if (empleado != null) {
				
				tx.begin();
					em.remove(empleado);
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
	public Empleado findById(Integer atributoID) {
		// TODO Auto-generated method stub
		return em.find(Empleado.class, atributoID);
	}

	@Override
	public List<Empleado> findAll() {
		jpql = "from Empleado e";
		
		query = em.createQuery(jpql);
		return query.getResultList();
	}



	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		
		jpql = "from Empleado e where e.departamento.idDepartamento = :depa";
		
		query = em.createQuery(jpql);
		
		// Inyectamos el valor del argumento 'idDepar' en el parámetro ':depa'
		query.setParameter("depa", idDepar);
		
		return query.getResultList();
	}



	@Override
	public List<Empleado> empleadosByGenero(char sexo) {
		
		jpql = "from Empleado e where e.genero = :gen";
		
		query = em.createQuery(jpql);
		
		// Hacemos de la variable sexo un cmbio de tipo. En la entidad genero es de tipo String
		query.setParameter("gen", String.valueOf(sexo));
		return query.getResultList();
	}



	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		jpql = " from Empleado e where e.apellidos like :apellido";
		
		query = em.createQuery(jpql);
		query.setParameter("apellido", "%" + subcadena + "%");
		return query.getResultList();
	}




	@Override
	public double salarioTotal() {
		
		jpql = "select sum(e.salario) from Empleado e";
		
		query = em.createQuery(jpql);
		
		Double  total =  (double) query.getSingleResult();
		
		if (total == null) {
			
			return 0.0;
		}
		
		return total;
	}




	@Override
	public double salarioTotal(int idDepar) {
		
		jpql = "select sum(e.salario) from Empleado e where e.departamento.idDepartamento = :depa";
		
		query = em.createQuery(jpql);
		
		// Inyectamos el valor del argumento 'idDepar' en el parámetro ':depa'
		query.setParameter("depa", idDepar);
		
		Double salarioTotal = (double) query.getSingleResult();
		
		if (salarioTotal == null) {
			
			return 0.0;
		}
		return salarioTotal;
	}
	


}
