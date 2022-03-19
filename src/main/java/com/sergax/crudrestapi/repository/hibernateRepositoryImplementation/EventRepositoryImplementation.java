package com.sergax.crudrestapi.repository.hibernateRepositoryImplementation;

import com.sergax.crudrestapi.model.Event;
import com.sergax.crudrestapi.model.File;
import com.sergax.crudrestapi.model.User;
import com.sergax.crudrestapi.repository.EventRepository;
import com.sergax.crudrestapi.utils.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImplementation implements EventRepository {
    private Transaction transaction = null;
    private Event event = null;
    private File file = null;

    @Override
    public List<Event> getAll() {
        List<Event> eventList = new ArrayList<>();

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            eventList = session.createQuery("FROM Event").getResultList();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return eventList;
    }

    @Override
    public Event getById(Long id) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Event WHERE id=:id");
            query.setParameter("id", id);
            List eventList = query.getResultList();
            event = (Event) eventList.get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return event;
    }

    @Override
    public void create(Event event) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Files WHERE id=:id");
            query.setParameter("id", event.getFile().getId());
            file = (File) query.getResultList();
            event.setFile(file);
            session.persist(event);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Event event) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Event updatedEvent = session.get(Event.class, event.getId());
            updatedEvent.setEventName(event.getEventName());
            session.update(updatedEvent);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Event deletedEvent = session.get(Event.class, id);
            session.delete(deletedEvent);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
