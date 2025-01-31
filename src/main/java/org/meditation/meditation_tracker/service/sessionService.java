package org.meditation.meditation_tracker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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












    public ResponseEntity<Object> getAllSessions() {
        List<session> sessions = repository.findAll();

        if(sessions.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No sessions found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Sessions fetched successfully");
            map.put("Data", sessions);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getSessionByDate(String date) {
        List<session> li = repository.findByDate(date);

        if(li.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No sessions found for the given date: " + date);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Sessions fetched successfully for the given date");
            map.put("Data", li);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getSessionByType(String type) {
        List<session> li = repository.findByType(type);

        if(li.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No sessions found for the given type: " + type);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Sessions fetched successfully for the given type");
            map.put("Data", li);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }













    

    public ResponseEntity<Object> deleteSession(int id) {
        Optional<session> op = repository.findById(id);

        if (op.isPresent()){
            repository.deleteById(id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Session deleted successfully");

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Session not found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }







    public ResponseEntity<Object> updateSession(int id, session session) {
        if(repository.findById(id).isPresent()){
            session s = repository.findById(id).get();

            if(session.getDate() != null)
                s.setDate(session.getDate());

            if(session.getDuration() != null)
                s.setDuration(session.getDuration());

            if(session.getType() != null)
                s.setType(session.getType());
                
            if (session.getNotes() != null)
                s.setNotes(session.getNotes());

            repository.save(s);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Session updated successfully");
            map.put("Data", s);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Session not found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }
    
}
