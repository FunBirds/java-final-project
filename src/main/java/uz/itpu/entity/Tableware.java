package uz.itpu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Tableware<SELF extends Tableware<SELF>> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String material;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String color;
}
