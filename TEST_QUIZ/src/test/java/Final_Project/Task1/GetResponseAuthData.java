package Final_Project.Task1;
// --------  IMPORTS ----------------

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//declaring a public class
public class GetResponseAuthData {
    @JsonIgnoreProperties(ignoreUnknown = true)
    //defining JSON body params as variables
    public String code;
    public String message;
}

