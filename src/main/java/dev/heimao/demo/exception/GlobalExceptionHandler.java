//package dev.heimao.demo.exception;
//
//import dev.heimao.demo.common.ErrorResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//
//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponse<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//
//        logger.error("Validation exception occurred", ex);
//        String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
//        return new ErrorResponse<>(400, false, "Validation Error", errorMessage);
//    }
//}