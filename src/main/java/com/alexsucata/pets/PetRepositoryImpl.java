package com.alexsucata.pets;

import com.alexsucata.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PetRepositoryImpl implements PetRepository{

    @Override
    public void create(PetEntity pet) {
        Session session = null;
        try {
            session = Connection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(pet);
            transaction.commit();
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public PetEntity findById(Integer petId) {
        return null;
    }

    @Override
    public List<PetEntity> findAll() {
        Session session = null;
        List<PetEntity> pet = new ArrayList<>();
        try {
            session = Connection.getInstance().getSession();
            pet = session.createQuery("from PetEntity", PetEntity.class).list();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pet;
    }

    @Override
    public void update(Integer petId, PetEntity pet) {
        Session session = null;
        pet.setPetId(petId);
        try {
            session = Connection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.update(pet);
            transaction.commit();

        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(Integer petId) {
        Session session = null;
        try {
            session = Connection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.delete(petId);
            transaction.commit();

        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            if (session != null)
                session.close();
        }
    }
}
