package com.dice.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private String status, description;
    private Object result;

    public Response() {
    }

    public Response(String status, String description, Object result) {
        this.status = status;
        this.description = description;
        this.result = result;
    }

}
