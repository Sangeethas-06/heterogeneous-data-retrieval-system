package dataretrieval.project.service;

import dataretrieval.project.model.UserTable;
import dataretrieval.project.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final RestTemplate restTemplate;
    public UserTable createDevice(UserTable device) {
        return deviceRepository.save(device);
    }

    public List<UserTable> getAllDevices() {
        return deviceRepository.findAll();
    }
    public UserTable getDeviceById(String deviceId) {
        return deviceRepository.findById(deviceId).orElse(null);
    }
    public UserTable updateDevice(UserTable device) {
        return deviceRepository.save(device);
    }
    public void deleteDeviceById(String deviceId) {
        deviceRepository.deleteById(deviceId);
    }


}
