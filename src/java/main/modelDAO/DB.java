/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modelDAO;

import main.model.Ocena;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import main.model.Izvestaj;

/**
 *
 * @author Milan Skaric
 */
public class DB {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebDnevnik02PU");

    public static List query(String jpql, Map<String, Object> params) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery(jpql);
            for (Entry<String, Object> e : params.entrySet()) {
                query.setParameter(e.getKey(), e.getValue());
            }
            List results = query.getResultList();
            return results;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public static List query(String jpql, Object... params) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery(jpql);
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
            List results = query.getResultList();
            return results;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public static void insert(Object obj) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            //em.getTransaction().begin();
            em.persist(obj);
            //em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public static void update(Object obj) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public static void delete(Object obj) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(obj));
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public Object getReference(Class cls, Integer id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            return em.getReference(cls, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static void insertNativeSQL(Object obj) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Ocena o = (Ocena) obj;
            String query = "insert into Ocena (prd_id, ucn_id, ocn_ocena, ocn_datum) VALUES(?, ?, ?, ?)";
            if (o != null && !o.equals("")) {
                em.createNativeQuery(query)
                        .setParameter(1, (o.getPrdId() != null) ? o.getPrdId().getPrdId() : null)
                        .setParameter(2, (o.getUcnId() != null) ? o.getUcnId().getUcnId() : null)
                        .setParameter(3, (o.getOcnOcena() != null) ? o.getOcnOcena() : null)
                        .setParameter(4, (o.getOcnDatum() != null) ? o.getOcnDatum() : null)
                        .executeUpdate();
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    /*public static void delete(Integer id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Osoba osoba = em.getReference(Osoba.class, id);
            em.remove(osoba);
            em.getTransaction().commit();
        } finally {
            if(em!=null)
               em.close();
        }
        
    }*/
    
    public static void insertNativeSQL1(Object obj) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Izvestaj i = (Izvestaj) obj;
            String query = "insert into Izvestaj (pro_id, ucn_id, izv_tekst, izv_datum) VALUES(?, ?, ?, ?)";
            if (i != null && !i.equals("")) {
                em.createNativeQuery(query)
                        .setParameter(1, (i.getProId() != null) ? i.getProId().getProId() : null)
                        .setParameter(2, (i.getUcnId() != null) ? i.getUcnId().getUcnId() : null)
                        .setParameter(3, (i.getIzvTekst() != null) ? i.getIzvTekst() : null)
                        .setParameter(4, (i.getIzvDatum() != null) ? i.getIzvDatum() : null)
                        .executeUpdate();
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
    
}
