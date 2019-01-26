package routesHelpers;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class PutHelper {

    public String getJsonFromBody(HttpServletRequest request) throws IOException {
        BufferedReader bf =  request.getReader();
        StringBuilder sb = new StringBuilder();
        String line = bf.readLine();
        while (line != null) {
            sb.append(line);
            line = bf.readLine();
        }
        return sb.toString();
    }


    public String createCustomUpdateQuery(String[] arrayOfProperties) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arrayOfProperties.length; i++) {
            sb.append("a.");
            sb.append(arrayOfProperties[i]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.toString().length()-1);
        sb.append(" WHERE a.id=");
        sb.append(arrayOfProperties[0]);
        return sb.toString();
    }


    public String[] parseJsonToPropertiesArray(String json) {
        String[] propertiesArray = json.split(",");
        for (int i = 0; i < propertiesArray.length; i++ ) {
            propertiesArray[i] = propertiesArray[i].replaceAll("\\{", "");
            propertiesArray[i] =  propertiesArray[i].replaceAll("\\}", "");
            propertiesArray[i] = propertiesArray[i].replaceAll(" ","");
            propertiesArray[i] = propertiesArray[i].replaceAll("\"", "");
            propertiesArray[i] = propertiesArray[i].replaceAll(":", "=");
            if (propertiesArray[i].contains("id=")) {
                propertiesArray[i] = propertiesArray[i].replace("id=", "");
            }
        }
        return addSingleQuotesToPropertyValue(propertiesArray);
    }



    private String[] addSingleQuotesToPropertyValue(String[] arrayOfProperties) {
        for (int i= 1; i <arrayOfProperties.length; i++) {
            arrayOfProperties[i] = arrayOfProperties[i].split("=")[0] + "='" + arrayOfProperties[i].split("=")[1] + "'";
        }
        return arrayOfProperties;
    }
}
