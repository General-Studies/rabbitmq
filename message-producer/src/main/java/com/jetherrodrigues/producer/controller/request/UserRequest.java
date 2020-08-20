package com.jetherrodrigues.producer.controller.request;

import com.jetherrodrigues.producer.domain.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public final class UserRequest implements Serializable {
    @NotNull
    @NotBlank
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public User toUser() {
        return new User(this.username, this.email);
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
