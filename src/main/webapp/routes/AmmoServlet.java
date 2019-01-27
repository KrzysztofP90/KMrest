package routes;

import DAO.*;
import appExceptions.BadURLforDeleteMethodException;
import com.google.gson.Gson;
import model.Ammo;
import model.Model;
import routesHelpers.DeleteHelper;
import routesHelpers.GetHelper;
import routesHelpers.PostHelper;
import routesHelpers.PutHelper;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AmmoServlet extends HttpServlet {

    private DAOput daoPut = new DAOPutHibernate();
    private DAOPost daoPost = new DAOPostHibernate();
    private DAOGet daoGetAmmo = new DAOGetAmmoHibernate();
    private DAOdelete daoDelete = new DAOdeleteHibernate();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        GetHelper helper = new GetHelper();
        String id = helper.getIdFromURL(request);
        String json = "";
        boolean urlOk = true;
        try {
            json = daoGetAmmo.getJSOnFromDataBase(id,response);
        } catch (PersistenceException e) {
            e.printStackTrace();
            urlOk = false;
            response.getWriter().write("Check Your Url!");
        }
        if (urlOk) {
            response.getWriter().write(json);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PostHelper helper = new PostHelper();
        String json = helper.getPostJsonFromBody(request);
        Gson gson = new Gson();
        Model newObject = gson.fromJson(json, Ammo.class);

        boolean added = daoPost.addObjectToDataBase(newObject,response);
        if (added) {
            response.getWriter().write("Object saved!");
        }
    }


    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PutHelper helper = new PutHelper();
        String json = helper.getJsonFromBody(request);
        String[] arrayOfProperties = helper.parseJsonToPropertiesArray(json);

        boolean editedOk = daoPut.updateObjectInDataBase("Ammo",arrayOfProperties,response);
        if (editedOk) {
            response.getWriter().write("Object edited if You enter existing id!");
        }
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DeleteHelper helper = new DeleteHelper();
        boolean deletedUrlOk = true;
        String id ="";
        try {
            id = helper.getIdFromURL(request);
        }catch (BadURLforDeleteMethodException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
            deletedUrlOk = false;
        }
        if (deletedUrlOk) {
            daoDelete.deleteRecordFromDataBaseById("Ammo",id);
            response.getWriter().write("Object removed if You enter existing id!");
        }
    }
}
