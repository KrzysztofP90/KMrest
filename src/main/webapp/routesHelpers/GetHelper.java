package routesHelpers;

import javax.servlet.http.HttpServletRequest;

public class GetHelper {

    public String getIdFromURL(HttpServletRequest request) {
        String URL = request.getRequestURI();
        String[] arr = URL.split("/");
        if (arr.length < 3) {
            return "all";
        }
        int indexOfRecordId = 2;
        return arr[indexOfRecordId];
    }
}
