package com.streamhub.videostreamhub.camera.controller.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCameraDTO2 {



    private String manufacturer;

    private Long id;
    private String environment;
    private String model;
    private String nickName;
    private String serialNumber;



}
