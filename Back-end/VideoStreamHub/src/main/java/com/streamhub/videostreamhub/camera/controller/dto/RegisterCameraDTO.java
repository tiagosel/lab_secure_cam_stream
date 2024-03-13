package com.streamhub.videostreamhub.camera.controller.dto;
import com.streamhub.videostreamhub.camera.repository.Camera;
import jakarta.validation.constraints.NotBlank;
public record RegisterCameraDTO(
        @NotBlank
        String manufacturer,
        @NotBlank
        Long customerId,
        @NotBlank
        String environment,
        @NotBlank
        String model,
        @NotBlank
        String nickName,
        @NotBlank
        String serialNumber) {



}
