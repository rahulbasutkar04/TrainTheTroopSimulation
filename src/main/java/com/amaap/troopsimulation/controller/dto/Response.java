package com.amaap.troopsimulation.controller.dto;

import java.util.Objects;

public class Response {
    public HttpStatus status;
    public Response(HttpStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Response response)) return false;
        return status == response.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                '}';
    }
}