package routesHelpers;

import appExceptions.IdNotExistException;
import com.google.gson.Gson;
import model.FireArms;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
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
