package uz.pdp.task01.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task01.entity.Room;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author Sanjarbek Allayev, чт 17:05. 17.02.2022
 */
public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findAllByNumber(Integer number);

    Page<Room> findAllByHotel_Id(Integer hotel_id, Pageable pageable);
}
