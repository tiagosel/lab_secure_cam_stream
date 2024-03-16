package com.streamhub.videostreamhub.camera.controller;


import com.streamhub.videostreamhub.camera.controller.dto.*;
import com.streamhub.videostreamhub.camera.repository.Camera;
import com.streamhub.videostreamhub.camera.repository.CameraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CameraUseCase cameraUseCase;

    // Método PUT para registrar uma câmera
    @PostMapping()
    @Transactional
    public ResponseEntity registerCamera(@RequestBody @Validated RegisterCameraDTO registerCameraDTO, UriComponentsBuilder uriBuilder) {
        var camera = new Camera(registerCameraDTO);
        repository.save(camera);
        var uri = uriBuilder.path("/camera/{id}").buildAndExpand(camera.getId()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(camera, CameraDTO.class));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity updateCamera(@RequestBody @Validated UpdateCameraDTO updateCameraDTO, UriComponentsBuilder uriBuilder, @PathVariable Long id) {
       var camera = repository.getReferenceById(id);
        modelMapper.map(updateCameraDTO,camera);
        var uri = uriBuilder.path("/camera/{id}").buildAndExpand(camera.getId()).toUri();
        var  cameraDTO = modelMapper.map(camera, CameraDTO.class);
        return ResponseEntity.created(uri).body(cameraDTO);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Page<CameraDTO>> listAll(@PageableDefault(size = 10,page = 0,sort = "customerId") Pageable page){
            var returnPage =  repository.findAll(page).map(Camera -> modelMapper.map(Camera, CameraDTO.class));

        return ResponseEntity.ok(returnPage);
    }

    @GetMapping("/customer/{id}")
    @Transactional
    public ResponseEntity<Page<CameraDTO>> listAllByCustomerId(@PageableDefault(size = 10,page = 0,sort = "customerId") Pageable page, @PathVariable Long id){
        var returnPage =  repository.findAllByCustomerIdEquals(page,id).map(Camera -> modelMapper.map(Camera, CameraDTO.class));
        //var returnPage =  repository.findAll(page).map( CameraDTO::new);
        return ResponseEntity.ok(returnPage);
    }


}