package com.streamhub.videostreamhub.camera.controller.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CameraDTO {

    private Long id;
    private String manufacturer;
    private Long customerId;
    private String environment;
    private String model;
    private String nickName;
    private String serialNumber;
}
