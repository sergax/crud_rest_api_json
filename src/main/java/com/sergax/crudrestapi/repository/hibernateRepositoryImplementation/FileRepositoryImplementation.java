package com.sergax.crudrestapi.repository.hibernateRepositoryImplementation;

import com.sergax.crudrestapi.model.File;
import com.sergax.crudrestapi.model.User;
import com.sergax.crudrestapi.repository.FileRepository;
import com.sergax.crudrestapi.utils.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class FileRepositoryImplementation implements FileRepository {
    private Transaction transaction = null;
    private File file = null;

    @Override
    public List<File> getAll() {
        List<File> fileList = new ArrayList<>();

        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            fileList = session.createQuery("FROM File").getResultList();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fileList;
    }

    @Override
    public File getById(Long id) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM File WHERE id=:id");
            query.setParameter("id", id);
            List fileList = query.getResultList();
            file = (File) fileList.get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return file;
    }

    @Override
    public void create(File file) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(file);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(File file) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            File updatedFile = session.get(File.class, file.getId());
            updatedFile.setFileName(file.getFileName());
            session.update(updatedFile);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Session session = HibernateConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            File deletedFile = session.get(File.class, id);
            session.delete(deletedFile);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
