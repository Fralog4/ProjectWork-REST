package com.example.ProjectWorkRest.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
public class ErrorResponse {
    private LocalTime date;
    private int code;
    private String message;
    private String path;


    ErrorResponse() {
        date = LocalTime.now();
    }


}
