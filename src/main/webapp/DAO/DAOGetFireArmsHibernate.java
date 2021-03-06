package DAO;

import appExceptions.IdNotExistException;
import com.google.gson.Gson;
import model.FireArms;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DAOGetFireArmsHibernate implements DAOGet {


    public String getJSOnFromDataBase(String id, HttpServletResponse response)
            throws IOException, PersistenceException {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
        EntityManager menager = factory.createEntityManager();
        String json = "";
        if (id.equals("all")) {
            json = getAllJsonArms(menager);
        }
        else {
            try {
                json = getArmsJsonById(id,menager);
            }catch (IdNotExistException e) {
                response.getWriter().write(e.getMessage());
                e.printStackTrace();
            }
        }
        factory.close();
        return json;
    }


    private String getArmsJsonById(String id, EntityManager menager) throws IdNotExistException {

        menager.getTransaction().begin();
        List<FireArms> answer = menager.createQuery("SELECT a FROM FireArms a WHERE a.id=" + id,
                FireArms.class).getResultList();

        menager.getTransaction().commit();
        menager.close();
        Gson gson = new Gson();
        if (answer.size() == 0) {
            throw new IdNotExistException();
        }
        return gson.toJson(answer.get(0));
    }


    private String getAllJsonArms(EntityManager menager) {

        menager.getTransaction().begin();
        List<FireArms> answer = menager.createQuery("SELECT a FROM FireArms a",
                FireArms.class).getResultList();

        menager.getTransaction().commit();
        menager.close();
        Gson gson = new Gson();
        return gson.toJson(answer);
    }
}
