package modelo.dao;

import java.util.List;



public interface GenericoDao <E , ID> {
	
	int insertOne (E entity);  // 1 = Creado  0= No creado
	int updateOne (E entity);
	int deleteOne (ID atributoID);
	E findById (ID atributoID);
	List<E> findAll();
}


