package com.ksoft.spring_mvc.controllers;

import com.ksoft.spring_mvc.dao.ServiceRepository;
import com.ksoft.spring_mvc.entity.Service;
import com.ksoft.spring_mvc.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class ServiceController {
    @Autowired
    private ServiceRepository repository;

    @PostMapping("/service")
    public ApiResponse addRoom(@RequestBody Service service) {
        repository.save(service);
        return ApiResponse.success("Tạo dịch vụ thành công");
    }

    @GetMapping("/services")
    public List<Service> getAllService() {
        return repository.findAll();
    }
}
