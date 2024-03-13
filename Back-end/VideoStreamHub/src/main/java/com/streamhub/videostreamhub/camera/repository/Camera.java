package com.streamhub.videostreamhub.camera.repository;


import com.streamhub.videostreamhub.camera.controller.dto.RegisterCameraDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "camera")
@Entity(name = "Camera")
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;

    private Long customerId;

    private String environment;
    private String model;

    private String nickName;
    private String serialNumber;

    public Camera(RegisterCameraDTO registerCameraDTO) {
        this.manufacturer = registerCameraDTO.manufacturer();
        this.customerId = registerCameraDTO.customerId();
        this.environment = registerCameraDTO.environment();
        this.model = registerCameraDTO.model();
        this.nickName = registerCameraDTO.nickName();
        this.serialNumber = registerCameraDTO.serialNumber();
    }
}
