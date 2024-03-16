package com.streamhub.videostreamhub.camera.controller;
import com.streamhub.videostreamhub.camera.controller.CameraController;
import com.streamhub.videostreamhub.camera.controller.dto.CameraDTO;
import com.streamhub.videostreamhub.camera.controller.dto.RegisterCameraDTO;
import com.streamhub.videostreamhub.camera.repository.Camera;
import com.streamhub.videostreamhub.camera.repository.CameraRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureJsonTesters
class CameraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CameraRepository repository;


    @Autowired
    private JacksonTester<RegisterCameraDTO> registerCameraDTOJSON;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JacksonTester<CameraDTO> cameraDTOJSON;
    @Test
    void testRegisterCamera() throws Exception {
        // Mocking data
        var registerCameraDTO = new RegisterCameraDTO("Test Manufacturer",123L,"Test Environment","Test Model","Test Nickname","Test Serial Number");

        when(repository.save(any())).thenReturn(modelMapper.map(registerCameraDTO,Camera.class));

        var response = mockMvc
                .perform(post("/camera")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(registerCameraDTOJSON.write(registerCameraDTO).getJson()))
                .andReturn().getResponse();

        var cameraResponse = modelMapper.map(registerCameraDTO,CameraDTO.class);
        var jsonEsperado = cameraDTOJSON.write(cameraResponse).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);


    }
}
