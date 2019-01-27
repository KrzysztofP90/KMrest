package DAO;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface DAOGetFireArms {

    public String getJSOnFireArmFromDataBase(String id, HttpServletResponse response)
            throws IOException, PersistenceException;
}
