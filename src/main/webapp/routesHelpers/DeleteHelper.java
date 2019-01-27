package routesHelpers;

import appExceptions.BadURLforDeleteMethodException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteHelper {


    public String getIdFromURL(HttpServletRequest request) throws BadURLforDeleteMethodException {
        String URL = request.getRequestURI();
        int indexOfRecordId = 2;
        String[] arr = URL.split("/");
        if (arr.length != 3 || checkIfStringIsNotIntegerFormat(arr[indexOfRecordId])) {
            throw new BadURLforDeleteMethodException();
        }else {
            return arr[indexOfRecordId];
        }
    }


    private boolean checkIfStringIsNotIntegerFormat(String toCheck) {
        try {
            Integer.parseInt(toCheck);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
 }
