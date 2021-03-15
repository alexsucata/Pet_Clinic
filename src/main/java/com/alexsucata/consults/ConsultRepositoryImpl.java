package com.alexsucata.consults;


import com.alexsucata.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ConsultRepositoryImpl implements ConsultRepository {

    @Override
    public void create(ConsultEntity consult) {
        Session session = null;
        try {
            session = Connection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(consult);
            transaction.commit();
        } catch (Exception exception) {
            System.out.println(exception);
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public ConsultEntity findById(Integer consultId) {
        return null;
    }

    @Override
    public List<ConsultEntity> findAll() {
        Session session = null;
        List<ConsultEntity> consult = new ArrayList<>();
        try {
            session = Connection.getInstance().getSession();
            consult = session.createQuery("from ConsultEntity", ConsultEntity.class).list();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return consult;
    }

    @Override
    public void update(Integer consultId, ConsultEntity consult) {
        Session session = null;
        consult.setConsultId(consultId);
        try {
            session = Connection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.update(consult);
            transaction.commit();

        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            if (session != null)
                session.close();
        }

    }

    @Override
    public void delete(ConsultEntity consultId) {
        Session session = null;
        try {
            session = Connection.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.delete(consultId);
            transaction.commit();

        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            if (session != null)
                session.close();
        }

    }
}
