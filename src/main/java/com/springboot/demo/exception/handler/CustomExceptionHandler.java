package com.springboot.demo.exception.handler;

import com.springboot.demo.exception.CustomException;
import com.springboot.demo.model.response.MetaData;
import com.springboot.demo.model.response.UserResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    /*@ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDetails> handleCustomException(CustomException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setCode("BAD_REQUEST");
        errorDetails.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }*/

    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handle_Exception(Exception exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setCode("INTERNAL SERVER ERROR");
        errorDetails.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<UserResponseModel> handleCustomException(CustomException exception, WebRequest webRequest) {
        MetaData metaData = MetaData.builder().code("ERROR").message(exception.getMessage()).status("BAD REQUEST").version("v1").build();
        return new ResponseEntity<>(getResponseData(metaData), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<UserResponseModel> handle_Exception(Exception exception, WebRequest webRequest) {
        MetaData metaData = MetaData.builder().code("ERROR").message(exception.getMessage()).status("INTERNAL SERVER ERROR").version("v1").build();
        return new ResponseEntity<>(getResponseData(metaData), HttpStatus.OK);
    }

    private UserResponseModel getResponseData(MetaData metaData) {
        return UserResponseModel.builder().metaData(metaData).build();
    }


}

