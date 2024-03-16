package com.streamhub.videostreamhub.camera.controller.dto;

import com.streamhub.videostreamhub.camera.repository.Camera;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CameraDTOV2 {

    private Long id;
    private String manufacturer;
    private Long customerId;
    private String environment;
    private String model;
    private String nickName;
    private String serialNumber;
}
