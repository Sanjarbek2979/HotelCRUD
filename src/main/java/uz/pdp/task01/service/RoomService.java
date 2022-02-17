package uz.pdp.task01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.pdp.task01.entity.Hotel;
import uz.pdp.task01.entity.Room;
import uz.pdp.task01.payload.ApiResponse;
import uz.pdp.task01.payload.RoomDTO;
import uz.pdp.task01.repository.HotelRepository;
import uz.pdp.task01.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Sanjarbek Allayev, чт 17:12. 17.02.2022
 */
@Service
public class RoomService {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoomRepository roomRepository;

    public ApiResponse add(RoomDTO dto){
        Room room= new Room();

        List<Room> allByNumber = roomRepository.findAllByNumber(dto.getNumber());
        if (!allByNumber.isEmpty()){
            return new ApiResponse("Bunday raqamli xona avvaldan mavjud",false);
        }
        Optional<Hotel> byId = hotelRepository.findById(dto.getHotelId());
        if (byId.isEmpty()){
            return  new ApiResponse("Xatolik",false);
        }
        room.setNumber(dto.getNumber());
        room.setFloor(dto.getFloor());
        room.setHotel(byId.get());
        room.setSize(dto.getSize());
        roomRepository.save(room);
        return  new ApiResponse("Saqlandi",true);
    }
    public ApiResponse edit(Integer id,RoomDTO dto){

        Optional<Room> byId1 = roomRepository.findById(id);
        if (byId1.isEmpty()){
            return new ApiResponse("Xatolik",false);
        }

        Room room = byId1.get();
        List<Room> allByNumber = roomRepository.findAllByNumber(dto.getNumber());
        if (!allByNumber.isEmpty()){
            return new ApiResponse("Bunday raqamli xona avvaldan mavjud",false);
        }
        Optional<Hotel> byId = hotelRepository.findById(dto.getHotelId());
        if (byId.isEmpty()){
            return  new ApiResponse("Xatolik",false);
        }
        room.setNumber(dto.getNumber());
        room.setFloor(dto.getFloor());
        room.setHotel(byId.get());
        room.setSize(dto.getSize());
        roomRepository.save(room);
        return  new ApiResponse("O`zgartirildi",true);
    }

    public ApiResponse getAll(){
        List<Room> all = roomRepository.findAll();
        return  new ApiResponse("Xonalar listi",true,all);
    }

    public ApiResponse delete(Integer id){
        roomRepository.deleteById(id);
        return  new ApiResponse("O`chirildi",true);
    }
    public Page getAllByHotelId(Integer page, Integer hotelId){
        Pageable pageable= PageRequest.of(page,10);
        return roomRepository.findAllByHotel_Id(hotelId,pageable);
    }

}
