package uz.pdp.task01.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sanjarbek Allayev, чт 17:07. 17.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO {
    private Integer number;
    private Integer floor;
    private Integer size;
    private Integer hotelId;
}
