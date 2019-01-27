package routesHelpers;
import com.google.gson.JsonSyntaxException;
import model.Modelable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class PostHelper {

    public String getPostJsonFromBody(HttpServletRequest request) throws IOException {
        BufferedReader bf =  request.getReader();
        StringBuilder sb = new StringBuilder();
        String line = bf.readLine();
        while (line != null) {
            sb.append(line);
            line = bf.readLine();
        }
        String json = sb.toString();
        return json;
    }

    public boolean addObjectToDataBase(EntityManager menager, Modelable newObject, HttpServletResponse response)
    throws IOException{
        boolean added = true;
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
        return added;
    }

}
