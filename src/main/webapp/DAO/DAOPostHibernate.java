package DAO;

import com.google.gson.JsonSyntaxException;
import model.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DAOPostHibernate implements DAOPost {


    public boolean addObjectToDataBase(Model newObject, HttpServletResponse response)
            throws IOException {

        boolean added = true;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();
        try {
            menager.persist(newObject);
        }catch (PersistenceException pe) {
            pe.printStackTrace();
            added = false;
            response.getWriter().write("Check Your JSON correct! Don't pass id to JSON when use POST method!");
        }catch (JsonSyntaxException e) {
            added = false;
            response.getWriter().write("Check Your JSON correct!");
        }
        menager.getTransaction().commit();
        menager.close();
        factory.close();
        return added;
    }
}
