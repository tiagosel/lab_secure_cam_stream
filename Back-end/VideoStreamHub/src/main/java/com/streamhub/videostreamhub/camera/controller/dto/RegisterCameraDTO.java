package com.streamhub.videostreamhub.camera.controller.dto;
import com.streamhub.videostreamhub.camera.repository.Camera;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCameraDTO
{

        @NotBlank
        private String manufacturer;

        private Long customerId;
        @NotBlank
        private String environment;
        @NotBlank
        private String model;
        @NotBlank
        private String nickName;
        @NotBlank
        private String serialNumber;

}
