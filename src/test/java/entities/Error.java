package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Error implements Serializable {
   // public Object data;
    public String [] messages;
    public String resultCode;
    public String [] fieldsErrors;
}