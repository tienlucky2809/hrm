package com.project.hrm.controller;

import com.project.hrm.entities.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
    /**
     * IndexOutOfBoundsException sẽ được xử lý riêng tại đây
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleExceptionIOOBE(Exception exception, WebRequest webRequest) {
        return new ErrorMessage(101, "Đối tượng không tồn tại");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleIAE(Exception exception, WebRequest webRequest){
        return new ErrorMessage(102, "Đối tượng không tồn tại");
    }

    /**
     * Tất cả các Exception không được khai báo sẽ được xử lý tại đây
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(Exception exception, WebRequest webRequest) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        return new ErrorMessage(100, exception.getLocalizedMessage());
    }
}
