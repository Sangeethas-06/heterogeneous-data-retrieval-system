package dataretrieval.project.controller;

import dataretrieval.project.model.UserTable;
import dataretrieval.project.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/devices")
@CrossOrigin("*") // to allow from all domains
    public class DeviceController {
        private final DeviceService deviceService;
        @GetMapping
        public ResponseEntity<List<UserTable>> getAllDevices() {
            List<UserTable> devices = deviceService.getAllDevices();
            return new ResponseEntity<>(devices, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<UserTable> getDeviceById(@PathVariable("id") String id) {
            UserTable device = deviceService.getDeviceById(id);
            if (device == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(device, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<UserTable> createDevice(@RequestBody UserTable device) {
            UserTable createdDevice = deviceService.createDevice(device);
            return new ResponseEntity<>(createdDevice, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<UserTable> updateDevice(@PathVariable("id") String id, @RequestBody UserTable device) {
            UserTable existingDevice = deviceService.getDeviceById(id);
            if (existingDevice == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            device.setDeviceId(id);
            UserTable updatedDevice = deviceService.updateDevice(device);
            return new ResponseEntity<>(updatedDevice, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteDevice(@PathVariable("id") String id) {
            UserTable existingDevice = deviceService.getDeviceById(id);
            if (existingDevice == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            deviceService.deleteDeviceById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
