package com.ksoft.spring_mvc.dao;

import com.ksoft.spring_mvc.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
