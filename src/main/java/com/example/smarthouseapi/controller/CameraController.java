package com.example.smarthouseapi.controller;

import com.example.smarthouseapi.entity.Camera;
import com.example.smarthouseapi.entity.Floor;
import com.example.smarthouseapi.service.impl.CameraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CameraController {
    @Autowired
    private CameraServiceImpl cameraService;

    @GetMapping(value = "/camera/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Camera>> getCamera(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(cameraService.getCameraById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/cameras")
    public ResponseEntity<List<Camera>> getAllCameras(){
        List<Camera> cameras = cameraService.getAllCameraRecords();
        return ResponseEntity.ok(cameras);
    }

    @PostMapping(value = "/camera")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Camera> createCamera(@RequestBody Camera camera){
        return new ResponseEntity<>(cameraService.saveCamera(camera), HttpStatus.CREATED);
    }

    @PutMapping(value = "/camera/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Camera> updateCamera(@RequestBody Camera camera, @PathVariable(value = "id") String id){
        return new ResponseEntity<>(cameraService.updateCameraInfo(id,camera), HttpStatus.OK);
    }

    @DeleteMapping(value = "/camera/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Camera> deleteCamera(@PathVariable(value="id") String id){
        return new ResponseEntity<>(cameraService.deleteCameraRecord(id), HttpStatus.OK);
    }
}
