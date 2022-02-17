package uz.pdp.task01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.task01.entity.Hotel;
import uz.pdp.task01.payload.ApiResponse;
import uz.pdp.task01.payload.HotelDTO;
import uz.pdp.task01.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Sanjarbek Allayev, чт 17:12. 17.02.2022
 */
@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public ApiResponse add(HotelDTO dto){
        Hotel hotel= new Hotel();

        List<Hotel> allByName = hotelRepository.findAllByName(dto.getName());
        if (!allByName.isEmpty()){
            return new ApiResponse("Bunday nomli mehmonxona avvaldan mavjud",false);
        }
        hotel.setName(dto.getName());
        hotelRepository.save(hotel);
        return  new ApiResponse("Saqlandi",true);
    }
    public ApiResponse edit(Integer id,HotelDTO dto){
        Optional<Hotel> byId = hotelRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("Bunday mehmonxona mavjud emas",false);
        }
        Hotel hotel = byId.get();
        hotel.setName(dto.getName());
        hotelRepository.save(hotel);
        return  new ApiResponse("O`zgartirildi",true);
    }

    public ApiResponse getAll(){
        List<Hotel> all = hotelRepository.findAll();
        return  new ApiResponse("Mehmonxonalar listi",true,all);
    }

    public ApiResponse delete(Integer id){
        hotelRepository.deleteById(id);
        return  new ApiResponse("O`chirildi",true);
    }
}
