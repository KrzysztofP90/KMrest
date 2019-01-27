package DAO;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface DAOGet {

    String getJSOnFromDataBase(String id, HttpServletResponse response)
            throws IOException, PersistenceException;
}
