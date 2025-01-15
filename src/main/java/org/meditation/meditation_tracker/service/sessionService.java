package org.meditation.meditation_tracker.service;

import org.meditation.meditation_tracker.repository.sessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sessionService {

    @Autowired
    sessionRepository repository;
    
}
