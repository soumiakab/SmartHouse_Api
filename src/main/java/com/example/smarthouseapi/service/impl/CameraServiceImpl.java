package com.example.smarthouseapi.service.impl;

import com.example.smarthouseapi.entity.Camera;
import com.example.smarthouseapi.repository.CameraRepository;
import com.example.smarthouseapi.service.interfaces.CameraServiceI;
import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CameraServiceImpl implements CameraServiceI {

    private final CameraRepository cameraRepository;

    @Override
    public List<Camera> getAllCameraRecords(){
        return cameraRepository.findAll();
    }


    @Override
    public Optional<Camera> getCameraById(String id){
        Optional<Camera> found = cameraRepository.findById(id);
        if (found.isEmpty()) {
            return Optional.empty();
        }
        return found;
    }



    @Override
    public Camera saveCamera(Camera camera){
        return cameraRepository.save(camera);
    }


    @Override
    public Camera updateCameraInfo(String id, Camera camera){
        if (cameraRepository.findById(id).isPresent()){
            Camera exitingCamera = cameraRepository.findById(id).get();

            exitingCamera.setFloor(camera.getFloor());

            return cameraRepository.save(exitingCamera);
        }
        else
            throw new MongoException("Record not found");
    }


    @Override
    public Camera deleteCameraRecord(String id){
        if (cameraRepository.findById(id).isPresent()){
            Camera camera = cameraRepository.findById(id).get();
            cameraRepository.delete(camera);
            return camera;
        }
        else
            throw new MongoException("Record not found");
    }
}
