package com.jetherrodrigues.producer.controller.request;

import com.jetherrodrigues.producer.domain.Alert;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public final class AlertRequest implements Serializable {

    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Alert toAlert() {
        return new Alert(this.name);
    }

    @Override
    public String toString() {
        return "AlertRequest{" +
                "name='" + name + '\'' +
                '}';
    }

}
