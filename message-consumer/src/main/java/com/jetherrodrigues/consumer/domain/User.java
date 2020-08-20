package com.jetherrodrigues.consumer.domain;

import java.io.Serializable;
import java.util.Objects;

public final class User implements Serializable {
    private final String username;
    private final String email;

    public User(final String username, final String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}