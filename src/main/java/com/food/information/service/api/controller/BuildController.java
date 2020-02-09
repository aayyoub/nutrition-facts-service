package com.food.information.service.api.controller;

import com.food.information.service.api.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildController {
    @GetMapping("/")
    public ResponseEntity<Response> buildInformation() {
        Response response = new Response();
        response.setHttpStatus(HttpStatus.OK);
        response.setResponseMessage("SUCCESS");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
