package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class HbnStore implements Store, AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(HbnStore.class);
    private final StandardServiceRegistry registry;
    private final SessionFactory sf;

    public HbnStore(String path) {
        registry = new StandardServiceRegistryBuilder()
                .configure(new File(path)).build();
        sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Override
    public void init() {

    }

    @Override
    public Item add(Item item) {
        try {
            Session session = sf.openSession();
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
            session.close();
            return item;
        } catch (Exception e) {
            LOG.error("transaction exception", e);
            sf.getCurrentSession().getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public boolean replace(int id, Item item) {
        try {
            Session session = sf.openSession();
            session.beginTransaction();
            item.setId(id);
            session.update(item);
            session.getTransaction().commit();
            session.close();
            Item result = findById(id);
            return result.equals(item);
        } catch (Exception e) {
            LOG.error("transaction exception", e);
            sf.getCurrentSession().getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            Session session = sf.openSession();
            session.beginTransaction();
            Item item = new Item(null);
            item.setId(id);
            session.delete(item);
            session.getTransaction().commit();
            session.close();
            return findById(id) == null;
        } catch (Exception e) {
            LOG.error("transaction exception", e);
            sf.getCurrentSession().getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Item> findAll() {
        try {
            Session session = sf.openSession();
            session.beginTransaction();
            List result = session.createQuery("from ru.job4j.tracker.Item").list();
            session.getTransaction().commit();
            session.close();
            return result;
        } catch (Exception e) {
            LOG.error("transaction exception", e);
            sf.getCurrentSession().getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Item> findByKey(String key) {
        try {
            List<Item> items = findAll();
            return items
                    .stream()
                    .filter(item -> item.getName().equals(key))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("transaction exception", e);
            sf.getCurrentSession().getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Item findById(int id) {
        try {
            Session session = sf.openSession();
            session.beginTransaction();
            Item item = session.get(Item.class, id);
            session.getTransaction().commit();
            session.close();
            return item;
        } catch (Exception e) {
            LOG.error("transaction exception", e);
            sf.getCurrentSession().getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
