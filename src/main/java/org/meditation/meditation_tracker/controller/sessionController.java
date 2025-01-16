package org.meditation.meditation_tracker.controller;

import org.meditation.meditation_tracker.dto.session;
import org.meditation.meditation_tracker.service.sessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sessionController {

    @Autowired
    sessionService service;
    
    /*To create a new session*/
    //to add one session
    @PostMapping("/session")
    public ResponseEntity<Object> createSession(@RequestBody session session){
        return service.createSession(session);
    }
}
