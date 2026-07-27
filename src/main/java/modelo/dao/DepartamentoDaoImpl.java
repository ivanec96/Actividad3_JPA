package modelo.dao;

import java.util.List;

import modelo.entities.Departamento;

public class DepartamentoDaoImpl extends AbstractDao implements DepartamentoDao {

	
	
	// Constructor pero no es necesario. Java nos crea uno por defecto cuando compila
	public DepartamentoDaoImpl () {
		
	}

	
	
	@Override
	public int insertOne (Departamento entity) {
		
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

	/*
	 *  Para modificar usamos merge.
	 *  
	 *  Si intentamos modificar un elemento que no existe con persist, este nos va a insertar los datos.
	 *  
	 *  usando un merge, si no existe no hace un insert
	 * 
	 * 
	 * */
	@Override
	public int updateOne (Departamento entity) {
		try {
			if (findById(entity.getIdDepartamento()) != null ) {
					tx.begin();
						em.merge(entity);
					tx.commit();	
					return 1;
			} else {
				return 0;
			}
			
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		return -1;
	}
		
	}

	@Override
	public int deleteOne (Integer atributoID) {
		
		Departamento departamento = findById (atributoID);
		try {
			if (departamento != null ) {
					tx.begin();
						em.remove(departamento);
					tx.commit();	
					return 1;
			} else {
				return 0;
			}
			
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
		return -1;
	}
		
	}

	@Override
	public Departamento findById (Integer atributoID) {
		// TODO Auto-generated method stub
		return em.find(Departamento.class, atributoID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findAll() {
		jpql = "from Departamento d";
		
		query = em.createQuery(jpql);
		
		return query.getResultList();
	}


}
