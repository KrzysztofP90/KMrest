package DAO;

import model.Model;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface DAOPost {

    boolean addObjectToDataBase(Model newObject, HttpServletResponse response)
            throws IOException;
}
