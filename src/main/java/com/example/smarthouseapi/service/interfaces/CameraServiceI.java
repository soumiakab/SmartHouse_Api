package com.example.smarthouseapi.service.interfaces;

import com.example.smarthouseapi.entity.Camera;

import java.util.List;
import java.util.Optional;

public interface CameraServiceI {
    List<Camera> getAllCameraRecords();

    Optional<Camera> getCameraById(String id);

    Camera saveCamera(Camera camera);

    Camera updateCameraInfo(String id, Camera camera);

    Camera deleteCameraRecord(String id);
}
