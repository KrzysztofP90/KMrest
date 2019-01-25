package routes;

import com.google.gson.Gson;
import model.FireArms;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;


public class StartServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        String id = getMetaDateFromURL(request);
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


    private String getMetaDateFromURL(HttpServletRequest request) {
        String URL = request.getRequestURI();
        String[] arr = URL.split("/");
        if (arr.length < 3) {
            return "all";
        }
        int indexOfArmsId = 2;
        return arr[indexOfArmsId];
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

       String json = getJsonFromBody(request);
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

    private String getJsonFromBody(HttpServletRequest request) throws IOException{
        BufferedReader bf =  request.getReader();
        StringBuilder sb = new StringBuilder();
        String line = bf.readLine();
        while (line != null) {
            sb.append(line);
            line = bf.readLine();
        }
        return sb.toString();
    }
}
