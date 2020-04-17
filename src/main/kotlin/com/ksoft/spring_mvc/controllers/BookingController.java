package com.ksoft.spring_mvc.controllers;

import com.ksoft.spring_mvc.dao.BookingRepository;
import com.ksoft.spring_mvc.dao.RoomRepository;
import com.ksoft.spring_mvc.entity.Booking;
import com.ksoft.spring_mvc.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController()
public class BookingController {
    @Autowired
    private BookingRepository repository;

    @Autowired RoomRepository roomRepository;

    @PostMapping("/booking")
    public ApiResponse addRoom(@RequestBody BookingRequestData requestData) {

        Long roomId = requestData.getRoomId();
        Optional<Room> room = roomRepository.findById(roomId);

        // Tồn tại room với id được gửi lên
        if (room.isPresent()) {
            Booking booking = new Booking(
                    room.get(),
                    requestData.getCustomerName(),
                    requestData.getCheckInTime(),
                    requestData.getNumOfGuesses());
            repository.save(booking);
            return ApiResponse.success("Tạo booking thành công");
        } else {
            return ApiResponse.failed("Tạo booking thất bại. Phòng không tồn tại");
        }
    }

    @GetMapping("/activeBookings")
    public List<Booking> getActiveBookings() {
        return repository.findByCheckOutTimeIsNull();
    }

    @GetMapping("/closedBookings")
    public List<Booking> getClosedBookings() {
        return repository.findByCheckOutTimeIsNotNull();
    }
}
