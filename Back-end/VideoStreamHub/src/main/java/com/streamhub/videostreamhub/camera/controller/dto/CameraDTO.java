package com.streamhub.videostreamhub.camera.controller.dto;

import com.streamhub.videostreamhub.camera.repository.Camera;
import jakarta.validation.constraints.NotBlank;

public record CameraDTO(Long id,
                        String manufacturer,
                        Long customerId,
                        String environment,
                        String model,
                        String nickName,
                        String serialNumber) {

    public CameraDTO(Camera camera) {
        this(camera.getId(),camera.getManufacturer(),camera.getCustomerId(),camera.getEnvironment(),camera.getModel(),camera.getNickName(),camera.getSerialNumber());
    }
}
