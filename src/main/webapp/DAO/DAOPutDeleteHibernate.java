package DAO;

import com.google.gson.JsonSyntaxException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DAOammoHibernate implements DAOammo {


    public void deleteRecordFromDataBaseById(String tableName, String id) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();
        Query query = menager.createQuery("DELETE FROM " + tableName +"WHERE id=" + id);
        query.executeUpdate();
        menager.getTransaction().commit();
        menager.close();
        factory.close();
    }

    public boolean updateObjectInDataBase(String tableName, String[] arrayOfProperties, HttpServletResponse response)
            throws IOException {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
        EntityManager menager = factory.createEntityManager();
        boolean editedOk = true;
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(tableName);
        sb.append(" a SET ");
        sb.append(createCustomUpdateQuery(arrayOfProperties));
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
