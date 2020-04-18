package com.ksoft.spring_mvc.controllers;

import com.ksoft.spring_mvc.dao.RoomRepository;
import com.ksoft.spring_mvc.entity.Room;
import com.ksoft.spring_mvc.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private RoomRepository repository;

    @PostMapping("/room")
    public ApiResponse addRoom(@RequestBody Room room) {
        repository.save(room);
        return ApiResponse.success("Tạo phòng thành công");
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return repository.findAll();
    }
}
