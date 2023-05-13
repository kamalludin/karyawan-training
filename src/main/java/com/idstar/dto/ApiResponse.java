package com.idstar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

    private int code;
    private String status;
    private Object data;

    public ApiResponse(int code, Object data, String status) {
        this.code = code;
        this.data = data;
        this.status = status;
    }

    public ApiResponse(int code, String status) {
        this.code = code;
        this.status = status;
    }
}
