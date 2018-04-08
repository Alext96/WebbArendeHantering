package example;

import com.sun.enterprise.util.StringUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ResourceBundle;

public class ERRORSKIT{

    public void BAJSERROR(String msg, String clientId) {
        String codingErrorMsgKey = "coding_error_msg";
        FacesMessage fm;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (msg.isEmpty()) {
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        } else {
            ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "bundle");
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, bundle.getString(codingErrorMsgKey), bundle.getString(codingErrorMsgKey));
        }
        facesContext.addMessage(clientId, fm);
    }

}



