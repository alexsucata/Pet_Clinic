package com.alexsucata.owners;

import com.alexsucata.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OwnerRepositoryImpl implements OwnerRepository {

    @Override
    public void create(OwnerEntity owner) {
        Session session = null;
        try {
            session = Connection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(owner);
            transaction.commit();

        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public OwnerEntity findById(Integer ownerId) {

        return null;
    }

    @Override
    public List<OwnerEntity> findAll() {
        List<OwnerEntity> owner = new ArrayList<>();
        Session session = null;
        try {
            session = Connection.getInstance().getSession();
            owner = session.createQuery("from OwnerEntity", OwnerEntity.class).list();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return owner;
    }

    @Override
    public void update(Integer ownerId, OwnerEntity owner) {
        Session session = null;
        owner.setOwnerId(ownerId);
        try {
            session = Connection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.update(owner);
            transaction.commit();

        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(OwnerEntity ownerId) {
        Session session = null;
        try {
            session = Connection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.delete(ownerId);
            transaction.commit();

        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            if (session != null)
                session.close();
        }
    }
}
