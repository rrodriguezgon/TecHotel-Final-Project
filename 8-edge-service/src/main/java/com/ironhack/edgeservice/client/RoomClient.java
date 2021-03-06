package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.entities.rooms.RegularRoom;
import com.ironhack.edgeservice.model.entities.rooms.SuiteRoom;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "room-service")
public interface RoomClient {
    // --- REGULAR ROOMS ---
    /**
     * Find All Regular Rooms
     * @return a list of RegularRoom
     */
    @GetMapping("/regular-rooms")
    @ResponseStatus(HttpStatus.OK)
    public List<RegularRoom> findAllRegularRooms();
    /**
     * Find Regular Room by Id
     * @param roomId receives an Integer with roomId
     * @return a RegularRoom
     */
    @GetMapping("/regular-rooms/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RegularRoom findRegularRoomById(@PathVariable("id") Integer roomId);
    /**
     * Update Regular Room Availability
     * @param roomId receives an Integer with roomId
     * @param availability receives a Boolean with availability
     */
    @PatchMapping("/update-regular-rooms/{id}/{availability}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRegularRoomAvailability(@PathVariable("id") Integer roomId, @PathVariable("availability") Boolean availability);
    /**
     * Create new Regular Room
     * @param regularRoom receives a RegularRoom
     * @return a RegularRoom created
     */
    @PostMapping("/regular-rooms")
    @ResponseStatus(HttpStatus.CREATED)
    public RegularRoom createRoom(@RequestBody @Valid RegularRoom regularRoom);


    // --- SUITE ROOMS ---
    /**
     * Find All Suites
     * @return a list of SuiteRoom
     */
    @GetMapping("/suites")
    @ResponseStatus(HttpStatus.OK)
    public List<SuiteRoom> findAllSuites();
    /**
     * Find Suite by id
     * @param roomId receives an Integer with roomId
     * @return a SuiteRoom
     */
    @GetMapping("/suites/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuiteRoom findSuiteById(@PathVariable("id") Integer roomId);
    /**
     * Update Suite Availability
     * @param roomId receives an Integer with roomId
     * @param availability receives a Boolean with availability
     */
    @PatchMapping("/update-suites/{id}/{availability}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSuiteAvailability(@PathVariable("id") Integer roomId, @PathVariable("availability") Boolean availability);
    /**
     * Creates a Suite
     * @param suite receives a SuiteRoom
     * @return a SuiteRoom created
     */
    @PostMapping("/suites")
    @ResponseStatus(HttpStatus.CREATED)
    public SuiteRoom createSuite(@RequestBody @Valid SuiteRoom suite);
}
