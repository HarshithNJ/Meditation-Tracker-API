package org.meditation.meditation_tracker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.meditation.meditation_tracker.dto.session;
import org.meditation.meditation_tracker.repository.sessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class sessionService {

    @Autowired
    sessionRepository repository;

    public ResponseEntity<Object> createSession(session session) {
        if(session.getType().isBlank()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Type of session is required");

            return new ResponseEntity<Object>(map, HttpStatus.NO_CONTENT);
        }else{
            repository.save(session);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Session created successfully");
            map.put("Data", session);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> createMulSessions(List<session> sessions) {
        for(session session : sessions){
            if(session.getType().isBlank()){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("error", "Type of session is required");
    
                return new ResponseEntity<Object>(map, HttpStatus.NO_CONTENT);
            }
        }
        repository.saveAll(sessions);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Session created successfully");
            map.put("Data", sessions);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
    }
    
}
