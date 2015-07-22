package dztools.component;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent(value = "components.CustomComponent", createTag = true, tagName="yinCal", namespace="http://com.dztools.yinCal")
public class CustomComponent extends UIComponentBase {
 
    @Override
    public String getFamily() {        
        return "dztools.yinCal";
    }
 
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
 
        String value = (String) getAttributes().get("value");
 
        if (value != null) {        
            ResponseWriter writer = context.getResponseWriter();
            writer.write("<table> <tr> <td>Sun</td> <td>Mon</td> <td>Tue</td> "
            		+ "<td>Wed</td> <td>Thu</td> <td>Fri</td> <td>Sat</td> </tr> "
            		+ "<tr> <td>1</td> <td>11</td> <td>22</td> <td>13</td> <td>4</td>"
            		+ " <td>5</td> <td>12</td> </tr>");
        }
    }
}