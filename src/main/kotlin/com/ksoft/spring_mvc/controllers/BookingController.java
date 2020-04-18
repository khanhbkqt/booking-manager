package com.ksoft.spring_mvc.controllers;

import com.ksoft.spring_mvc.dao.BookingRepository;
import com.ksoft.spring_mvc.dao.RoomRepository;
import com.ksoft.spring_mvc.entity.Booking;
import com.ksoft.spring_mvc.entity.Room;
import com.ksoft.spring_mvc.model.ApiResponse;
import com.ksoft.spring_mvc.model.BookingRequestData;
import com.ksoft.spring_mvc.model.CheckoutRequestData;
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

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping("/booking")
    public ApiResponse addBooking(@RequestBody BookingRequestData requestData) {

        Long roomId = requestData.getRoomId();
        Optional<Room> room = roomRepository.findById(roomId);

        // Tồn tại room với id được gửi lên
        if (room.isPresent()) {
            // Kiểm tra room có available không
            if (isRoomAvailable(room.get())) {
                Booking booking = new Booking(
                        room.get(),
                        requestData.getCustomerName(),
                        requestData.getCheckInTime(),
                        requestData.getNumOfGuesses());
                repository.save(booking);
                return ApiResponse.success("Tạo booking thành công");
            } else {
                return ApiResponse.failed("Phòng đã được sử dụng");
            }

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

    @PostMapping("/checkOut")
    public ApiResponse checkout(@RequestBody CheckoutRequestData data) {
        Optional<Booking> bookingOpt = repository.findById(data.getBookingId());
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            if (booking.getCheckOutTime() != null) {
                return ApiResponse.failed("Booking đã được checkout trước đó");
            } else if (booking.getCheckInTime().after(data.getCheckoutTime())) {
                return ApiResponse.failed("CheckoutTime phải lớn hơn CheckInTime");
            } else {
                booking.setCheckOutTime(data.getCheckoutTime());
                repository.save(booking);
                return ApiResponse.success("Checkout thành công");
            }
        } else {
            return ApiResponse.failed("Booking không tồn tại");
        }
    }

    private boolean isRoomAvailable(Room room) {
        List<Booking> bookings = repository.findByRoomIdAndCheckOutTimeIsNull(room.getId());
        return bookings.isEmpty();
    }
}
