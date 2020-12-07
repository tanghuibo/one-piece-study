package io.github.tanghuibo.onepiecestudyweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanghuibo
 * @date 2020/12/8上午12:46
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> errorResult(Exception e) {
        log.error("", e);
        Map<String, Object> errorResult = new HashMap<>(1);
        errorResult.put("errorMessage", e.getMessage());
        return ResponseEntity.status(500).body(errorResult);
    }

}
