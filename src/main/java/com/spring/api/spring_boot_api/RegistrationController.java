package com.spring.api.spring_boot_api;

import jdk.net.SocketFlow;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@RestController
public class RegistrationController {

    @RequestMapping(method = RequestMethod.POST,
            value = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User register(@RequestBody User user) {
        String nome = "mm";
        if(Objects.equals(user.getName(), nome)) {
            throw new IllegalArgumentException("error.username");

        }

        return user;
    }

    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException{

        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
