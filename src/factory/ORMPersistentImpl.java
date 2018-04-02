/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import entity.Book;
import entity.History;
import entity.Reader;
import interfaces.Persistent;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jvm
 */
public class ORMPersistentImpl implements Persistent{
    
    private final EntityManager em;
    private final EntityTransaction tx;
    
    public ORMPersistentImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibProPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
    @Override
    public void saveReaders(List<Reader> readers) {
        tx.begin();
        for (int i = 0; i < readers.size(); i++) {
            Reader reader = readers.get(i);
            em.persist(reader);
        }
        tx.commit();
    }

    @Override
    public void saveBooks(List<Book> books) {
        tx.begin();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            em.persist(book);
        }
        tx.commit();
    }

    @Override
    public void saveHistories(List<History> histories) {
         tx.begin();
        for (int i = 0; i < histories.size(); i++) {
            History historie = histories.get(i);
            em.persist(historie);
        }
        tx.commit();
    }

    @Override
    public List<Reader> loadReaders() {
        try {
            return em.createQuery("SELECT r FROM Reader r").getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        
    }

    @Override
    public List<Book> loadBooks() {
        try {
            return em.createQuery("SELECT b FROM Book b").getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<History> loadHistories() {
        try {
            return em.createQuery("SELECT h FROM History h").getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
}
