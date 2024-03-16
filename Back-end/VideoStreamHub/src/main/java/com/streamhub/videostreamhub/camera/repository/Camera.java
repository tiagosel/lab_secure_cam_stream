package com.streamhub.videostreamhub.camera.repository;


import com.streamhub.videostreamhub.camera.controller.dto.CameraDTO;
import com.streamhub.videostreamhub.camera.controller.dto.RegisterCameraDTO;
import com.streamhub.videostreamhub.camera.controller.dto.UpdateCameraDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
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


    //TO-DO remover construtor
    public Camera(RegisterCameraDTO registerCameraDTO) {
        this.manufacturer = registerCameraDTO.manufacturer();
        this.customerId = registerCameraDTO.customerId();
        this.environment = registerCameraDTO.environment();
        this.model = registerCameraDTO.model();
        this.nickName = registerCameraDTO.nickName();
        this.serialNumber = registerCameraDTO.serialNumber();
    }

    public Camera(CameraDTO cameraDTO) {
        this.manufacturer = cameraDTO.manufacturer();
        this.customerId = cameraDTO.customerId();
        this.environment = cameraDTO.environment();
        this.model = cameraDTO.model();
        this.nickName = cameraDTO.nickName();
        this.serialNumber = cameraDTO.serialNumber();
    }



}
