package routes;

import appExceptions.BadURLforDeleteMethodException;
import appExceptions.IdNotExistException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import model.FireArms;
import routesHelpers.DeleteHelper;
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
        boolean urlOk = true;
        try {
            json = helper.getJSONFromDataBase(id, menager, response);
        } catch (PersistenceException e) {
            e.printStackTrace();
            urlOk = false;
            response.getWriter().write("Check Your Url!");
        }
        factory.close();
        if (urlOk) {
            response.getWriter().write(json);
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostHelper helper = new PostHelper();

        String json = helper.getPostJsonFromBody(request);

            Gson gson = new Gson();
            FireArms newObject = gson.fromJson(json, FireArms.class);
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
            EntityManager menager = factory.createEntityManager();

            boolean added = helper.addObjectToDataBase(menager,newObject,response);
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
        boolean editedOk = helper.updateObjectInDataBase(menager,sb,response);
        factory.close();
        if (editedOk) {
            System.out.println(response.getStatus());
            response.getWriter().write("Object edited if You enter existing id!");
        }
    }



    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DeleteHelper helper = new DeleteHelper();
        boolean deletedUrlOk = true;
        String id ="";
        try {
            id = helper.getIdFromURL(request);
        }catch (BadURLforDeleteMethodException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
            deletedUrlOk = false;
        }
        if (deletedUrlOk) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
            EntityManager menager = factory.createEntityManager();
            menager.getTransaction().begin();
            Query query = menager.createQuery("DELETE FROM FireArms WHERE id=" + id);
            query.executeUpdate();
            menager.getTransaction().commit();
            menager.close();
            factory.close();
            response.getWriter().write("Object removed if You enter existing id!");
        }
    }
}
