package DAO;

import com.google.gson.JsonSyntaxException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DAOPutHibernate implements DAOput {



    public boolean updateObjectInDataBase(String tableName, String[] arrayOfProperties, HttpServletResponse response)
            throws IOException {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
        EntityManager menager = factory.createEntityManager();
        boolean editedOk = true;
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(tableName);
        sb.append(" a SET ");
        menager.getTransaction().begin();
        try {
            sb.append(createCustomUpdateQuery(arrayOfProperties));
            Query query = menager.createQuery(sb.toString());
            query.executeUpdate();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            editedOk = false;
            response.getWriter().write("Check Your JSON correct! Put to JSON id of object to editing!");
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            editedOk = false;
            response.getWriter().write("Check Your JSON correct!");
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            editedOk = false;
            response.getWriter().write("Pass id to JSON when You edit object by put method!");
        }
        menager.getTransaction().commit();
        menager.close();
        factory.close();
        return editedOk;
    }

    private String createCustomUpdateQuery(String[] arrayOfProperties) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arrayOfProperties.length; i++) {
            sb.append("a.");
            sb.append(arrayOfProperties[i]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.toString().length()-1);
        sb.append(" WHERE a.id=");
        sb.append(arrayOfProperties[0]);
        return sb.toString();
    }
}
