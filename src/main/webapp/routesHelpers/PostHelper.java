package routesHelpers;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class PostHelper {

    public String getPostJsonFromBody(HttpServletRequest request) throws IOException {
        BufferedReader bf =  request.getReader();
        StringBuilder sb = new StringBuilder();
        String line = bf.readLine();
        while (line != null) {
            sb.append(line);
            line = bf.readLine();
        }
        String json = sb.toString();
        return json;
    }

}
