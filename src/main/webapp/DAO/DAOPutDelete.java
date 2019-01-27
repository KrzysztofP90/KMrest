package DAO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface DAOammo {

    public void deleteRecordFromDataBaseById(String tableName, String id);

    public boolean updateObjectInDataBase(String tableName, String[] arrayOfProperties, HttpServletResponse response)
            throws IOException;
}
