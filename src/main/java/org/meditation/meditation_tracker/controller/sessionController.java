package org.meditation.meditation_tracker.controller;

import org.meditation.meditation_tracker.service.sessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sessionController {

    @Autowired
    sessionService service;
    
}
