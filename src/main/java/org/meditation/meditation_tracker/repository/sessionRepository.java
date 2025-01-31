package org.meditation.meditation_tracker.repository;

import java.util.List;

import org.meditation.meditation_tracker.dto.session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface sessionRepository extends JpaRepository<session, Integer> {

    List<session> findByDate(String date);

    List<session> findByType(String type);

}
