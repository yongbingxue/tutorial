package com.yongbingxue.webmock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebMockController {

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> sendViaResponseEntity() {
        return new ResponseEntity<>("error message 403", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/200", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> send200Ok() {
        return new ResponseEntity<>("200", HttpStatus.OK);
    }

}
