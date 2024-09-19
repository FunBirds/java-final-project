package uz.itpu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Cup extends Tableware<Cup> {
    @Column(nullable = false)
    private int volume;
}
