package com.jetherrodrigues.consumer.queue;

import com.jetherrodrigues.consumer.domain.Alert;

import java.io.Serializable;

public final class AlertMessage implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public final Alert toAlert() {
        return new Alert(this.name);
    }
}
