package com.jetherrodrigues.consumer.queue;

import com.jetherrodrigues.consumer.domain.User;

import java.io.Serializable;

public final class UserMessage implements Serializable {
    private String username;
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

    public final User toUser() {
        return new User(this.username, this.email);
    }
}
