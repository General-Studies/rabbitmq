package com.jetherrodrigues.producer.domain;

import java.io.Serializable;
import java.util.Objects;

public final class Alert implements Serializable {

    private final String name;

    public Alert(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alert alert = (Alert) o;
        return Objects.equals(name, alert.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Alert{" +
                "name='" + name + '\'' +
                '}';
    }
}
