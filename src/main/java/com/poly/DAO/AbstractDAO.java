package com.poly.DAO;

import com.poly.utils.JpaUtils;
import jakarta.persistence.*;

import java.util.*;

public class AbstractDAO<T> {
    public static final EntityManager entityManger = JpaUtils.getEntityManager();
    final Map<String, Object> queryParamValues = new HashMap<>();

    public T findById(Class<T> clazz, Integer id) {
        return entityManger.find(clazz, id);
    }

    public List<T> findAll(Class<T> clazz, boolean existIsActive) {
        String entityName = clazz.getSimpleName();
        StringBuilder jqpl = new StringBuilder();
        jqpl.append("SELECT o FROM ").append(entityName).append(" o");
        if (existIsActive == true) {
            jqpl.append(" WHERE o.isActive = 1");
        }

        TypedQuery<T> query = entityManger.createQuery(jqpl.toString(), clazz);
        return query.getResultList();
    }

    public List<T> findAll(Class<T> clazz, boolean existIsActive, boolean isNew, String column) {
        String entityName = clazz.getSimpleName();
        StringBuilder jqpl = new StringBuilder();
        jqpl.append("SELECT o FROM ").append(entityName).append(" o");
        if (existIsActive == true) {
            jqpl.append(" WHERE o.isActive = 1");
        }
        if (isNew == true) {
            jqpl.append("ORDER BY o." + column + " DESC");
        }

        TypedQuery<T> query = entityManger.createQuery(jqpl.toString(), clazz);
        return query.getResultList();
    }

    public List<T> findAll(Class<T> clazz, boolean existIsActive, boolean isNew, String column, boolean isRandom,
                           String columnRandom, int numberRandom) {
        String entityName = clazz.getSimpleName();
        StringBuilder jqpl = new StringBuilder();
        jqpl.append("SELECT o FROM ").append(entityName).append(" o");
        if (existIsActive == true) {
            jqpl.append(" WHERE o.isActive = 1");
        }
        if (isNew == true) {
            jqpl.append("ORDER BY o." + column + " DESC");
        }

        TypedQuery<T> query = entityManger.createQuery(jqpl.toString(), clazz);
        return query.getResultList();
    }
    public List<T> findAll(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize) {
        String entityName = clazz.getSimpleName();
        StringBuilder jqpl = new StringBuilder();
        jqpl.append("SELECT o FROM ").append(entityName).append(" o");
        if (existIsActive == true) {
            jqpl.append(" WHERE isActive = 1 ");
        }
        TypedQuery<T> query = entityManger.createQuery(jqpl.toString(), clazz);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public List<T> findAll(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize, boolean isNew,
                           String column) {
        String entityName = clazz.getSimpleName();
        StringBuilder jqpl = new StringBuilder();
        jqpl.append("SELECT o FROM ").append(entityName).append(" o");
        if (existIsActive == true) {
            jqpl.append(" WHERE isActive = 1 ");
        }
        if (isNew == true) {
            jqpl.append("ORDER BY o." + column + " DESC");
        }
        TypedQuery<T> query = entityManger.createQuery(jqpl.toString(), clazz);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public T findOne(String nameQuery, Class<T> clazz, final Object... params) {
        TypedQuery<T> query = entityManger.createNamedQuery(nameQuery, clazz);
            for (Object param : params) {
                query.setParameter("param", param);
                System.out.println(params.length);
            }
        List<T> result = query.getResultList();
        System.out.println(result);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> findManyByNativeQuery(String nameQuery, Object... params) {
        Query query = entityManger.createNativeQuery(nameQuery);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<T> callStore(String namedStored, Map<String, Object> params) {
        StoredProcedureQuery query = entityManger.createNamedStoredProcedureQuery(namedStored);
        params.forEach((key, value) -> query.setParameter(key, value));
        return (List<T>) query.getResultList();
    }

    public T create(T entity) {
        try {
            entityManger.getTransaction().begin();

            entityManger.persist(entity);
            entityManger.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            entityManger.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public T update(T entity) {
        try {
            entityManger.getTransaction().begin();
            entityManger.merge(entity);
            entityManger.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            entityManger.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public T delete(T entity) {
        try {
            entityManger.getTransaction().begin();
            entityManger.remove(entity);
            entityManger.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            entityManger.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

}
