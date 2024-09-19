package uz.itpu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Spoon extends Tableware<Spoon> {

    @Column(nullable = false)
    private int length;

    @Column(nullable = false)
    private String type;
}
