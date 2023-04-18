package com.Woo.Ram.google.config.auth.dto;

import com.Woo.Ram.google.GoogleUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Getter

public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;


    public SessionUser(GoogleUser googleUser) {
        this.name = googleUser.getName();
        this.email = googleUser.getEmail();
        this.picture = googleUser.getPicture();
    }
}
