package org.meditation.meditation_tracker.dto;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
    @DateTimeFormat(pattern = "mm:ss")
    private String duration;
    private String type;
    private String notes;
    
}
