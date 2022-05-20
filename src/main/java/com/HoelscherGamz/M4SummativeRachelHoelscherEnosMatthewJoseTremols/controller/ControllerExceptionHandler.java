package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.controller;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.NoTransactionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.webjars.NotFoundException;

import javax.validation.UnexpectedTypeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    //Catches IllegalArgumentException
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<CustomErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        CustomErrorResponse response = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    //Catches NoTransactionException
    @ExceptionHandler(value = {NoTransactionException.class})
    public ResponseEntity<CustomErrorResponse> handleNoTransactionException(NoTransactionException e) {
        CustomErrorResponse response = new CustomErrorResponse(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        return responseEntity;
    }


    //Catches MissingRequestValueException
    @ExceptionHandler(value = {MissingRequestValueException.class})
    public ResponseEntity<CustomErrorResponse> handleMissingRequestValueException(MissingRequestValueException e) {
        CustomErrorResponse response = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }


    //Catches an exception we haven't identified
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<CustomErrorResponse> handleAnyException(Exception e) {
        System.out.println("Caught unidentified exception");
        CustomErrorResponse response = new CustomErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<CustomErrorResponse> handleAnyNotFoundException(NotFoundException e) {
        CustomErrorResponse response = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<List<CustomErrorResponse>> newResponseErrors(MethodArgumentNotValidException e) {

        // BindingResult holds the validation errors
        BindingResult result = e.getBindingResult();

        // Validation errors are stored in FieldError objects
        List<FieldError> fieldErrors = result.getFieldErrors();

        // Translate the FieldErrors to CustomErrorResponse
        List<CustomErrorResponse> errorResponseList = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), fieldError.getDefaultMessage());
            errorResponse.setTimestamp(LocalDateTime.now());
            errorResponse.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
            errorResponseList.add(errorResponse);
        }

        // Create and return the ResponseEntity
        ResponseEntity<List<CustomErrorResponse>> responseEntity = new ResponseEntity<>(errorResponseList, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomErrorResponse> outOfRangeException(HttpMessageNotReadableException e) {
        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), "Http request not properly formatted");
        error.setStatus((HttpStatus.UNPROCESSABLE_ENTITY.value()));
        error.setTimestamp(LocalDateTime.now());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = UnexpectedTypeException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomErrorResponse> wrongTypeException(UnexpectedTypeException e) {
        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), e.getMessage());
        error.setStatus((HttpStatus.UNPROCESSABLE_ENTITY.value()));
        error.setTimestamp(LocalDateTime.now());
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }
}
