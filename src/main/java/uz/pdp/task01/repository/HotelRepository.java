package uz.pdp.task01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task01.entity.Hotel;
import uz.pdp.task01.entity.Room;

import java.util.List;

/**
 * @author Sanjarbek Allayev, чт 17:05. 17.02.2022
 */
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
List<Hotel> findAllByName(String name);
}
