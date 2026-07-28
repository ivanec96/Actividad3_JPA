package modelo.dao;

import java.util.List;

import modelo.entities.Cliente;

public class ClienteDaoImpl extends AbstractDao implements ClienteDao {

	
	
	public ClienteDaoImpl() {
		super();
	}

	@Override
	public int insertOne(Cliente entity) {
		
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
	public int updateOne(Cliente entity) {
		
		try {
			if (findById(entity.getCif()) != null) {
				
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
		
		// Para borrar se usa un Objeto. Para ello debemos guardar la informacion en un Objeto
		Cliente cliente = findById(atributoID);
		
		try {
			if (cliente != null) {
				
				tx.begin();
					em.remove(cliente);
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
	public Cliente findById(String atributoID) {
		// TODO Auto-generated method stub
		return em.find(Cliente.class, atributoID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		
		jpql = "from Cliente c";
		
		query = em.createQuery(jpql);
		
		return query.getResultList();
	}

	
	
	


}
