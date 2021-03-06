package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.controller.interfaces.IActivityController;
import com.ironhack.edgeservice.dto.*;
import com.ironhack.edgeservice.model.entities.activities.Massage;
import com.ironhack.edgeservice.model.entities.activities.PoolRent;
import com.ironhack.edgeservice.model.entities.activities.RoomFood;
import com.ironhack.edgeservice.model.viewModel.MassageViewModel;
import com.ironhack.edgeservice.model.viewModel.PoolRentViewModel;
import com.ironhack.edgeservice.model.viewModel.RoomFoodViewModel;
import com.ironhack.edgeservice.service.ActivityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Activity Controller")
@RestController
@RequestMapping("/")
public class ActivityController implements IActivityController {
    @Autowired
    private ActivityService activityService;

    // --- MASSAGES ---
    /**
     * Find All Massages
     * @return a list of massages
     */
    @GetMapping("/activities/massages")
    @ResponseStatus(HttpStatus.OK)
    public List<Massage> findAllMassages(@RequestHeader(value = "Authorization") String authorizationHeader){
        return activityService.findAllMassages(authorizationHeader); }

    /**
     * Find Massage by id
     * @param massageId receives a long with massageId
     * @return a Massage
     */
    @GetMapping("/activities/massages/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Massage findMassageById(@PathVariable("id") Long massageId, @RequestHeader(value = "Authorization") String authorizationHeader){
        return activityService.findMassageById(massageId, authorizationHeader); }

    /**
     * Filter Massage By User Id
     * @param userId receives an Long with userId
     * @return a list of object
     */
    @GetMapping("/activities/massages/filter/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> filterMassageByUserId(@PathVariable("userId") Long userId, @RequestHeader(value = "Authorization") String authorizationHeader){
        return activityService.filterMassageByUserId(userId, authorizationHeader); }

    /**
     * Create Massage Appointment
     * @param massageViewModel receives a Massage View Model
     * @return a Massage created
     */
    @PostMapping("/activities/massages")
    @ResponseStatus(HttpStatus.CREATED)
    public Massage createMassageAppointment(@RequestBody @Valid MassageViewModel massageViewModel, @RequestHeader(value = "Authorization") String authorizationHeader){
        return activityService.createMassageAppointment(massageViewModel, authorizationHeader);
    }
    /**
     * Change Massage Type
     * @param updateMassageTypeDto receives an UpdateMassageTypeDto
     */
    @PatchMapping("/activities/massages")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeMassageType(@RequestBody @Valid UpdateMassageTypeDto updateMassageTypeDto, @RequestHeader(value = "Authorization") String authorizationHeader){
        activityService.changeMassageType(updateMassageTypeDto, authorizationHeader); }

    /**
     * Cancel Massage Appointment
     * @param massageId receives a long with massageId
     */
    @DeleteMapping("/activities/massages/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMassageAppointment(@PathVariable("id") Long massageId, @RequestHeader(value = "Authorization") String authorizationHeader){
        activityService.deleteMassageAppointment(massageId, authorizationHeader); }


    // --- ROOM FOOD SERVICES ---
    /**
     * Find All Room Foods
     * @return a list of RoomFood
     */
    @GetMapping("/activities/room-food-services")
    @ResponseStatus(HttpStatus.OK)
    public List<RoomFood> findAllRoomFood(@RequestHeader(value = "Authorization") String authorizationHeader){
        return activityService.findAllRoomFood(authorizationHeader); }

    /**
     * Find RoomFood by id
     * @param roomFoodId receives a Long with roomFoodId
     * @return a RoomFood
     */
    @GetMapping("/activities/room-food-services/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoomFood findRoomFoodById(@PathVariable("id") Long roomFoodId, @RequestHeader(value = "Authorization") String authorizationHeader){
        return activityService.findRoomFoodById(roomFoodId, authorizationHeader); }

    /**
     * Filter Room Food By User Id
     * @param userId receives a Long with userId
     * @return a list of objects
     */
    @GetMapping("/activities/room-food-services/filter/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> filterRoomFoodByUserId(@PathVariable("userId") Long userId, @RequestHeader(value = "Authorization") String authorizationHeader){
        return activityService.filterRoomFoodByUserId(userId, authorizationHeader); }

    /**
     * Create new Room Food Request
     * @param roomFoodViewModel receives a RoomFoodViewModel
     * @return a RoomFood
     */
    @PostMapping("/activities/room-food-services")
    @ResponseStatus(HttpStatus.CREATED)
    public RoomFood createRoomFoodRequest(@RequestBody @Valid RoomFoodViewModel roomFoodViewModel, @RequestHeader(value = "Authorization") String authorizationHeader){
        return activityService.createRoomFoodRequest(roomFoodViewModel, authorizationHeader); }

    /**
     * Deliver Room Food
     * @param roomFoodId receives a Long with roomFoodId
     */
    @PatchMapping("/activities/room-food-services/deliver/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deliverRoomFood(@PathVariable("id") Long roomFoodId, @RequestHeader(value = "Authorization") String authorizationHeader){
        activityService.deliverRoomFood(roomFoodId, authorizationHeader); }

    /**
     * Update Food Menu
     * @param updateRoomFoodMenuDto receives a UpdateRoomFoodMenuDto
     */
    @PatchMapping("/activities/room-food-services/update-food")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateFoodMenu(@RequestBody @Valid UpdateRoomFoodMenuDto updateRoomFoodMenuDto, @RequestHeader(value = "Authorization") String authorizationHeader){
        activityService.updateFoodMenu(updateRoomFoodMenuDto, authorizationHeader); }

    /**
     * Update Drink Menu
     * @param updateDrinkMenuDto receives an UpdateDrinkMenuDto
     */
    @PatchMapping("/activities/room-food-services/update-drink")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDrinkMenu(@RequestBody @Valid UpdateDrinkMenuDto updateDrinkMenuDto, @RequestHeader(value = "Authorization") String authorizationHeader){
        activityService.updateDrinkMenu(updateDrinkMenuDto, authorizationHeader); }

    /**
     * Cancel Room Food Request
     * @param roomFoodId receives a Long with roomFoodId
     */
    @DeleteMapping("/activities/room-food-services/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRoomFoodRequest(@PathVariable("id") Long roomFoodId, @RequestHeader(value = "Authorization") String authorizationHeader){
        activityService.removeRoomFoodRequest(roomFoodId, authorizationHeader); }


    // --- POOL RENTS ---
    /**
     * Find All Pool Rent
     * @return a list of PoolRent
     */
    @GetMapping("/activities/pool-rents")
    @ResponseStatus(HttpStatus.OK)
    public List<PoolRent> findAllPoolRents(@RequestHeader(value = "Authorization") String authorizationHeader){
        return activityService.findAllPoolRents(authorizationHeader);
    }
    /**
     * Find PoolRent By Id
     * @param poolRentId receives a Long with poolRentId
     * @return a PoolRent
     */
    @GetMapping("/activities/pool-rents/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PoolRent findPoolRentById(@PathVariable("id") Long poolRentId, @RequestHeader(value = "Authorization") String authorizationHeader){
        return activityService.findPoolRentById(poolRentId, authorizationHeader);
    }
    /**
     * Filter Pool Rent By User Id
     * @param userId receives a Long with userId
     * @returnq list of objects
     */
    @GetMapping("/activities/pool-rents/filter/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> filterPoolRentByUserId(@PathVariable("userId") Long userId,  @RequestHeader(value = "Authorization") String authorizationHeader){
        return activityService.filterPoolRentByUserId(userId, authorizationHeader);
    }
    /**
     * Create Pool Rent
     * @param poolRentViewModel receives a PoolRentViewModel
     * @return a PoolRent
     */
    @PostMapping("/activities/pool-rents")
    @ResponseStatus(HttpStatus.CREATED)
    public PoolRent createPoolRent(@RequestBody @Valid PoolRentViewModel poolRentViewModel, @RequestHeader(value = "Authorization") String authorizationHeader){
        return activityService.createPoolRent(poolRentViewModel, authorizationHeader);
    }
    /**
     * Update Floaties Number
     * @param updateFloatiesNumDto receives a UpdateFloatiesNumDto with updateFloatiesNumDto
     */
    @PatchMapping("/activities/pool-rents/update-floaties")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateFloatiesNum(@RequestBody @Valid UpdateFloatiesNumDto updateFloatiesNumDto, @RequestHeader(value = "Authorization") String authorizationHeader){
        activityService.updateFloatiesNum(updateFloatiesNumDto, authorizationHeader); }

    /**
     * Update Towel Number
     * @param updateTowelNumDto receives a UpdateTowelNumDto
     */
    @PatchMapping("/activities/pool-rents/update-towels")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTowelNum(@RequestBody @Valid UpdateTowelNumDto updateTowelNumDto, @RequestHeader(value = "Authorization") String authorizationHeader){
        activityService.updateTowelNum(updateTowelNumDto, authorizationHeader); }

    /**
     * Cancel Pool Rent
     * @param poolRentId receives a Long with poolRentId
     */
    @DeleteMapping("/activities/pool-rents/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePoolRent(@PathVariable("id") Long poolRentId, @RequestHeader(value = "Authorization") String authorizationHeader){
        activityService.removePoolRent(poolRentId, authorizationHeader); }
}
