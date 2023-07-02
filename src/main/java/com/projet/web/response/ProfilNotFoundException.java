package com.projet.web.response;
import java.lang.RuntimeException;
public class ProfilNotFoundException extends RuntimeException {
    
    public ProfilNotFoundException(String message) {
        super(message);
    }
    
  
}

