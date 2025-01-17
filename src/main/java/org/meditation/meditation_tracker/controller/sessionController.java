package org.meditation.meditation_tracker.controller;

import java.util.List;

import org.meditation.meditation_tracker.dto.session;
import org.meditation.meditation_tracker.service.sessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sessionController {

    @Autowired
    sessionService service;
    
    /*To create a new session*/
    //to add one session
    @PostMapping("/sessions")
    public ResponseEntity<Object> createSession(@RequestBody session session){
        return service.createSession(session);
    }

    //To add multiple sessions
    @PostMapping("/sessions/multiple")
    public ResponseEntity<Object> createMulSessions(@RequestBody List<session> sessions){
        return service.createMulSessions(sessions);
    }






    /*To Fetch the Records */
    //To Fetch all records from Database
    @GetMapping("/sessions")
    public ResponseEntity<Object> getAllSessions(){
        return service.getAllSessions();
    }
}
