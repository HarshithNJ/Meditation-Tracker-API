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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class sessionController {

    @Autowired
    sessionService service;
    
    /*To create a new session*/
    @Operation(summary = "Create a new session", description = "Creates a new session")
    @ApiResponse(responseCode = "201", description = "Session created successfully")
    @ApiResponse(responseCode = "204", description = "Bad Request")
    @PostMapping("/sessions")
    public ResponseEntity<Object> createSession(@RequestBody session session){
        return service.createSession(session);
    }

    @Operation(summary = "Create multiple sessions", description = "Creates multiple sessions")
    @ApiResponse(responseCode = "201", description = "Sessions created successfully")
    @ApiResponse(responseCode = "204", description = "Bad Request")
    @PostMapping("/sessions/multiple")
    public ResponseEntity<Object> createMulSessions(@RequestBody List<session> sessions){
        return service.createMulSessions(sessions);
    }






    /*To Fetch the Records */
    @Operation(summary = "Get all sessions", description = "Retrieves all sessions")
    @ApiResponse(responseCode = "302", description = "Sessions retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No sessions found")
    @GetMapping("/sessions")
    public ResponseEntity<Object> getAllSessions(){
        return service.getAllSessions();
    }

    @Operation(summary = "Get session list by date", description = "Retrieves sessions by date")
    @ApiResponse(responseCode = "302", description = "Sessions retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No sessions found")
    @GetMapping("/sessions/{date}")
    public ResponseEntity<Object> getSessionByDate(@PathVariable String date){
        return service.getSessionByDate(date);
    }

    @Operation(summary = "Get session list by type", description = "Retrieves sessions by type")
    @ApiResponse(responseCode = "302", description = "Sessions retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No sessions found")
    @GetMapping("/sessions/type/{type}")
    public ResponseEntity<Object> getSessionByType(@PathVariable String type){
        return service.getSessionByType(type);
    }








    /* To Delete a Session Record */
    @Operation(summary = "Delete a session", description = "Deletes a session by ID")
    @ApiResponse(responseCode = "200", description = "Session deleted successfully")
    @ApiResponse(responseCode = "404", description = "Session not found")
    @DeleteMapping("/sessions/{id}")
    public ResponseEntity<Object> deleteSession(@PathVariable int id){
        return service.deleteSession(id);
    }
}
