package com.bomsbro.common.model.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@JsonPropertyOrder({"code", "status", "resultMessage", "data"})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper<T> {

    /**
     * http response code
     */
    private int code;

    /**
     * http status
     */
    private HttpStatus status;

    /**
     * result message
     */
    private String resultMessage;

    /**
     * real response body
     */
    private T data;


    public static <T> ResponseWrapper<T> wrap(T data, String resultMessage) {
        return new ResponseWrapper<T>(HttpStatus.OK.value(), HttpStatus.OK, resultMessage, data);
    }

    public static <T> ResponseWrapper<T> wrap(T data, String resultMessage, HttpStatus httpStatus) {
        return new ResponseWrapper<T> (httpStatus.value(), httpStatus, resultMessage, data);
    }

    public static <T> ResponseEntity<ResponseWrapper<T>> ok(T data, String resultMessage) {
        return ResponseEntity.ok(  wrap(data, resultMessage)  );
    }

    public static <T> ResponseEntity<ResponseWrapper<T>> ok(T data, String resultMessage, HttpStatus httpStatus) {
        return ResponseEntity.ok(  wrap(data, resultMessage, httpStatus)  );
    }

    public static <T> ResponseEntity<ResponseWrapper<T>> created(T data, String resultMessage) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(  wrap(data, resultMessage)  );
    }
}
