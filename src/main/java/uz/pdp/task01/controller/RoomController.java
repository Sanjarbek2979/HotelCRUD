package uz.pdp.task01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task01.payload.ApiResponse;
import uz.pdp.task01.payload.RoomDTO;
import uz.pdp.task01.service.RoomService;


/**
 * @author Sanjarbek Allayev, чт 18:52. 17.02.2022
 */
@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomService roomService;


    @PostMapping("/add")
    public ApiResponse add(@RequestBody RoomDTO dto){
        return roomService.add(dto);
    }
    @GetMapping
    public ApiResponse getAll(){
        return roomService.getAll();
    }



    @PutMapping("/edit/{id}")
    public ApiResponse edit(@RequestBody RoomDTO dto,@PathVariable Integer id){
        return roomService.edit(id,dto);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return roomService.delete(id);
    }

    @GetMapping("/hotel/{id}")
    public Page getAll(@RequestParam("page") int page,@PathVariable Integer id){
        return roomService.getAllByHotelId(page,id);
    }
}
