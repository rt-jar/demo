package com.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class GenericDAO< T extends Serializable> {

    private Class< T > clazz;

    @PersistenceContext
    private EntityManager entityManager;

    public final void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T findOne( long id ){
        return entityManager.find( clazz, id );
    }

    public List findAll(){
        return entityManager.createQuery( "from " + clazz.getName() )
                .getResultList();
    }

    public void create( T entity ){
        entityManager.persist( entity );
    }

    public T update( T entity ){
        return entityManager.merge( entity );
    }

    public void delete( T entity ){
        entityManager.remove( entity );
    }
    public void deleteById( long entityId ){
        T entity = findOne( entityId );
        delete( entity );
    }
}

