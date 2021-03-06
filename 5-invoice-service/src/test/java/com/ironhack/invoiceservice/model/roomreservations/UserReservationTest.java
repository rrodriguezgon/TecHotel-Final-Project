package com.ironhack.invoiceservice.model.roomreservations;

import com.ironhack.invoiceservice.enums.RoomType;
import com.ironhack.invoiceservice.enums.TypeOfUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserReservationTest {
    private UserReservation userReservation;
    private RoomReservation roomReservation;

    @BeforeEach
    void setUp() {
        roomReservation = new RoomReservation(1, RoomType.REGULAR_ROOM, 2);

        userReservation = new UserReservation();
        userReservation = new UserReservation(1L, "Ana Martins", TypeOfUser.BASIC);
    }

    @AfterEach
    void tearDown() {
        roomReservation = null;
        userReservation = null;
    }

    @Test
    void getUserId() {
        userReservation.setUserId(1L);

        assertEquals(1L, userReservation.getUserId());
    }

    @Test
    void getTypeOfUser() {
        userReservation.setTypeOfUser(TypeOfUser.BASIC);

        assertEquals(TypeOfUser.BASIC, userReservation.getTypeOfUser());
    }

    @Test
    void getRoomReservation() {
        userReservation.setRoomReservation(roomReservation);

        assertEquals(roomReservation, userReservation.getRoomReservation());
    }
}