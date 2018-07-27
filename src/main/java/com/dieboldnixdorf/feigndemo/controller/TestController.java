package com.dieboldnixdorf.feigndemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestController {


    @RequestMapping(method = RequestMethod.GET, path = "/ok")
    public ResponseEntity<String> getOK() {
            return new ResponseEntity<String>("OK!", HttpStatus.OK);
    }

}
