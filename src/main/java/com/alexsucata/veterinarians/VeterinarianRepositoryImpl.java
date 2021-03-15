package com.alexsucata.veterinarians;

import com.alexsucata.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class VeterinarianRepositoryImpl implements VeterinarianRepository{

    @Override
    public void create(VeterinarianEntity veterinarian) {
        Session session = null;
        try {
            session = Connection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(veterinarian);
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public VeterinarianEntity findById(Integer veterinarianId) {
        return null;
    }

    @Override
    public List<VeterinarianEntity> findAll() {
        Session session = null;
        List<VeterinarianEntity> veterinarian = new ArrayList<>();
        try {
            session = Connection.getInstance().getSession();
            veterinarian = session.createQuery("from VeterinarianEntity", VeterinarianEntity.class).list();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return veterinarian;
    }

    @Override
    public void update(VeterinarianEntity oldVeterinarian, VeterinarianEntity newVeterinarian) {

    }

    @Override
    public void delete(Integer veterinarianId) {
        Session session = null;
        try {
            session = Connection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(veterinarianId);
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
