package org.meditation.meditation_tracker.controller;

import java.util.List;

import org.meditation.meditation_tracker.dto.session;
import org.meditation.meditation_tracker.service.sessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //To Fetch all records from Database by Date
    @GetMapping("/sessions/{date}")
    public ResponseEntity<Object> getSessionByDate(@PathVariable String date){
        return service.getSessionByDate(date);
    }

    //To Fetch all records from Database by Type
    @GetMapping("/sessions/type/{type}")
    public ResponseEntity<Object> getSessionByType(@PathVariable String type){
        return service.getSessionByType(type);
    }








    /* To Delete a Session Record */
    //To Delete a Session Record by ID
    @DeleteMapping("/sessions/{id}")
    public ResponseEntity<Object> deleteSession(@PathVariable int id){
        return service.deleteSession(id);
    }
}
