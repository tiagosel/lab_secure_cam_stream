package com.streamhub.videostreamhub.camera.controller.dto;
import com.streamhub.videostreamhub.camera.repository.Camera;
import jakarta.validation.constraints.NotBlank;
public record RegisterCameraDTO(
        @NotBlank
        String manufacturer,
        Long customerId,
        String environment,
        String model,
        String nickName,
        String serialNumber) {



}
