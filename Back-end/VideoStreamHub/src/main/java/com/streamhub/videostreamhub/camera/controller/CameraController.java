package com.streamhub.videostreamhub.camera.controller;


import com.streamhub.videostreamhub.camera.controller.dto.CameraDTO;
import com.streamhub.videostreamhub.camera.controller.dto.RegisterCameraDTO;
import com.streamhub.videostreamhub.camera.repository.Camera;
import com.streamhub.videostreamhub.camera.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/camera")
public class CameraController {

    @Autowired
    private CameraRepository repository;

    // Método PUT para registrar uma câmera
    @PostMapping()
    @Transactional
    public ResponseEntity registerCamera(@RequestBody @Validated RegisterCameraDTO registerCameraDTO, UriComponentsBuilder uriBuilder) {
        var camera = new Camera(registerCameraDTO);
        repository.save(camera);
        var uri = uriBuilder.path("/camera/{id}").buildAndExpand(camera.getId()).toUri();
        ResponseEntity teste = ResponseEntity.created(uri).body(new CameraDTO(camera));
        return teste;
    }
}