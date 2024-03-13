package com.streamhub.videostreamhub.camera.repository;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera, Long> {
    Page<Camera> findAllByCustomerIdEquals(Pageable page, Long id);
}
