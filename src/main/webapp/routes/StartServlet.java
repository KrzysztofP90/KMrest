package routes;

import appExceptions.IdNotExistException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import model.FireArms;
import routesHelpers.GetHelper;
import routesHelpers.PutHelper;
import routesHelpers.PostHelper;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class StartServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        GetHelper helper = new GetHelper();
        String id = helper.getIdFromURL(request);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
        EntityManager menager = factory.createEntityManager();
        String json = "";
       if (id.equals("all")) {
           json = helper.getAllJsonArms(id, menager);
       }
       else {
           try {
                json = helper.getArmsJsonById(id,menager);
           }catch (IdNotExistException e) {
               response.getWriter().write(e.getMessage());
               e.printStackTrace();
           }
       }
        factory.close();
        response.getWriter().write(json);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostHelper helper = new PostHelper();

        String json = helper.getPostJsonFromBody(request);

            Gson gson = new Gson();
            FireArms newArm = gson.fromJson(json, FireArms.class);
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
            EntityManager menager = factory.createEntityManager();
            boolean added = true;
            menager.getTransaction().begin();
            try {
                menager.persist(newArm);
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
            if (added) {
                response.getWriter().write("Object saved!");
            }
    }


    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PutHelper helper = new PutHelper();
        String json = helper.getJsonFromBody(request);

        String[] arrayOfProperties = helper.parseJsonToPropertiesArray(json);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
        EntityManager menager = factory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE FireArms a SET ");
        sb.append(helper.createCustomUpdateQuery(arrayOfProperties));
        boolean editedOk = true;

        menager.getTransaction().begin();
        try {
            Query query = menager.createQuery(sb.toString());
            query.executeUpdate();
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
            editedOk = false;
            response.getWriter().write("Check Your JSON correct! Put to JSON id of object to editing!");
        }
        catch (JsonSyntaxException e) {
            e.printStackTrace();
            editedOk =false;
            response.getWriter().write("Check Your JSON correct!");
        }
        menager.getTransaction().commit();
        menager.close();
        factory.close();
        if (editedOk) {
            System.out.println(response.getStatus());
            response.getWriter().write("Object edited if You enter existing id!");
        }
    }


}
