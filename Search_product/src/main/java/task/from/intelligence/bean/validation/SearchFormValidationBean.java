package task.from.intelligence.bean.validation;

import java.io.Serializable;
 
/**
 * This is a JavaBean containing 3 properties coming from an HTML form.
 *
 * @author sergey.pilypiv
 * @version 1.0, 14/05/17
 */
public class SearchFormValidationBean implements Serializable {

    private String mandatoryTextField;

    public SearchFormValidationBean() {
    }
    
    public void setMandatoryTextField(String mandatoryTextField) {
        this.mandatoryTextField = mandatoryTextField;
    }
    public String getMandatoryTextField() {
        return mandatoryTextField;
    }
    
    /* makes the bean persistent. */
    public void store() {
        // to be implemented.
    }
}