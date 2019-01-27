package DAO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface DAOput {


    boolean updateObjectInDataBase(String tableName, String[] arrayOfProperties, HttpServletResponse response)
            throws IOException;
}
