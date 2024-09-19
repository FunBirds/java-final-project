package uz.itpu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Plate extends Tableware<Plate> {

    @Column(nullable = false)
    private int diameter;
}
