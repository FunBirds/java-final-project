package uz.itpu.entity;

import java.util.Objects;

public class Plate extends Tableware<Plate> {
    private int diameter;

    public int getDiameter() {
        return diameter;
    }

    public Plate setDiameter(int diameter) {
        this.diameter = diameter;
        return this;
    }

    @Override
    public String commonField() {
        return super.commonField() + ", diameter=" + diameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plate plate = (Plate) o;
        return diameter == plate.diameter;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(diameter);
    }

    @Override
    public String toString() {
        return "Plate{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", material='" + getMaterial() + '\'' +
                ", price=" + getPrice() +
                ", color='" + getColor() + '\'' +
                ", diameter=" + diameter +
                '}';
    }

}
