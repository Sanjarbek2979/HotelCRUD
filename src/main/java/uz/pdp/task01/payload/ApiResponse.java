package uz.pdp.task01.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sanjarbek Allayev, чт 17:13. 17.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
private String message;
private boolean success;
private Object object;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
