package routesHelpers;

import appExceptions.IdNotExistException;
import com.google.gson.Gson;
import model.FireArms;
import sun.security.pkcs.ParsingException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetHelper {


    public String getIdFromURL(HttpServletRequest request) {
        String URL = request.getRequestURI();
        String[] arr = URL.split("/");
        if (arr.length < 3) {
            return "all";
        }
        int indexOfRecordId = 2;
        return arr[indexOfRecordId];
    }

    public String getJSONFromDataBase(String id, EntityManager menager, HttpServletResponse response) throws IOException, PersistenceException {
        String json = "";
        if (id.equals("all")) {
            json = getAllJsonArms(id, menager);
        }
        else {
            try {
                json = getArmsJsonById(id,menager);
            }catch (IdNotExistException e) {
                response.getWriter().write(e.getMessage());
                e.printStackTrace();
            }
        }
        return json;
    }

    public String getArmsJsonById(String id, EntityManager menager) throws IdNotExistException {
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


    public String getAllJsonArms(String id, EntityManager menager) {

        menager.getTransaction().begin();
        List<FireArms> answer = menager.createQuery("SELECT a FROM FireArms a",
                FireArms.class).getResultList();

        menager.getTransaction().commit();
        menager.close();
        Gson gson = new Gson();
        return gson.toJson(answer);
    }
}
