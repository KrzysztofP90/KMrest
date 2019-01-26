package routes;

import com.google.gson.Gson;
import model.FireArms;
import routesHelpers.GetHelper;
import routesHelpers.PostAndPutHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


public class StartServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        GetHelper helper = new GetHelper();
        String id = helper.getIdFromURL(request);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
        EntityManager menager = factory.createEntityManager();
        String json;
       if (id.equals("all")) {
           json = getAllJsonArms(id, menager);
       }
       else {
           json = getArmsJsonById(id,menager);
       }
        factory.close();
        response.getWriter().write(json);
    }




    private String getArmsJsonById(String id, EntityManager menager) {
        menager.getTransaction().begin();
        List<FireArms> answer = menager.createQuery("SELECT a FROM FireArms a WHERE a.id="+id,
                FireArms.class).getResultList();

        menager.getTransaction().commit();
        menager.close();
        Gson gson = new Gson();
        return gson.toJson(answer.get(0));
    }

    private String getAllJsonArms(String id, EntityManager menager) {

        menager.getTransaction().begin();
        List<FireArms> answer = menager.createQuery("SELECT a FROM FireArms a",
                FireArms.class).getResultList();

        menager.getTransaction().commit();
        menager.close();
        Gson gson = new Gson();
        return gson.toJson(answer);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostAndPutHelper helper = new PostAndPutHelper();
        String json = helper.getJsonFromBody(request);
        Gson gson = new Gson();

        FireArms newArm = gson.fromJson(json, FireArms.class);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();
        menager.persist(newArm);
        menager.getTransaction().commit();
        menager.close();
        factory.close();
        response.getWriter().write("Object saved!");
    }


    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostAndPutHelper helper = new PostAndPutHelper();
        String json = helper.getJsonFromBody(request);

        String[] arrayOfProperties = helper.parseJsonToPropertiesArray(json);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
        EntityManager menager = factory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE FireArms a SET ");
        sb.append(helper.createCustomUpdateQuery(arrayOfProperties));

        menager.getTransaction().begin();
        Query query = menager.createQuery(sb.toString());
        query.executeUpdate();
        menager.getTransaction().commit();
        menager.close();
        factory.close();
        response.getWriter().write("Object edited!");
    }
}
