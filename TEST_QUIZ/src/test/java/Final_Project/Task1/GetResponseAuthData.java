package Final_Project.Task1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class GetResponseAuthData {
    @JsonIgnoreProperties(ignoreUnknown = true)
        public String code;
        public String message;
    }

