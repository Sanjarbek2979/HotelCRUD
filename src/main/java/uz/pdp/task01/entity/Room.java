package uz.pdp.task01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Sanjarbek Allayev, чт 16:56. 17.02.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Room {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false,unique = true)
private Integer number;

    @Column(nullable = false)
    private  Integer floor;

    @Column(nullable = false)
    private  Integer size;

    @ManyToOne
    private Hotel hotel;



}
