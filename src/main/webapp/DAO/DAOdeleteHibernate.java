package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAOdeleteHibernate implements DAOdelete {



    public void deleteRecordFromDataBaseById(String tableName, String id) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
        EntityManager menager = factory.createEntityManager();
        menager.getTransaction().begin();
        Query query = menager.createQuery("DELETE FROM " + tableName +" WHERE id=" + id);
        query.executeUpdate();
        menager.getTransaction().commit();
        menager.close();
        factory.close();
    }

}
