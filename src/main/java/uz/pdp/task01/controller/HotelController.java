package uz.pdp.task01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task01.payload.ApiResponse;
import uz.pdp.task01.payload.HotelDTO;
import uz.pdp.task01.service.HotelService;

/**
 * @author Sanjarbek Allayev, чт 17:16. 17.02.2022
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;


    @PostMapping("/add")
    public ApiResponse add(@RequestBody HotelDTO dto){
        return hotelService.add(dto);
    }
    @GetMapping
    public ApiResponse getAll(){
        return hotelService.getAll();
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@RequestBody HotelDTO dto,@PathVariable Integer id){
        return hotelService.edit(id,dto);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        return hotelService.delete(id);
    }
}
