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






}
