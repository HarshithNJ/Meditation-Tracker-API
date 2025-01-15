package org.meditation.meditation_tracker.repository;

import org.meditation.meditation_tracker.dto.session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface sessionRepository extends JpaRepository<session, Integer> {

}
