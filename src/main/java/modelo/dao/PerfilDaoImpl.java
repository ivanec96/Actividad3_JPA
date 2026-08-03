package modelo.dao;

import java.util.List;

import modelo.entities.Empleado;
import modelo.entities.Perfil;

public class PerfilDaoImpl  extends AbstractDao implements PerfilDao{

	@Override
	public int insertOne(Perfil entity) {
		
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
	public int updateOne(Perfil entity) {
		try {
			if (findById(entity.getIdPerfil()) != null) {
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

		Perfil perfil = findById(atributoID);
		
		try {
			if (perfil != null) {
				
				tx.begin();
					em.remove(perfil);
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
	public Perfil findById(Integer atributoID) {
		// TODO Auto-generated method stub
		return em.find(Perfil.class, atributoID);
	}

	@Override
	public List<Perfil> findAll() {
		jpql = "from Perfil p";
		
		query = em.createQuery(jpql);
		return query.getResultList();
	}


}
