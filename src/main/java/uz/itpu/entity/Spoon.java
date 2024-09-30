package uz.itpu.entity;


import java.util.Objects;

public class Spoon extends Tableware<Spoon> {
    private int length;
    private String type;

    public int getLength() {
        return length;
    }

    public Spoon setLength(int length) {
        this.length = length;
        return this;
    }

    public String getType() {
        return type;
    }

    public Spoon setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String commonField() {
        return super.commonField() + ", length=" + length + ", type='" + type + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spoon spoon = (Spoon) o;
        return length == spoon.length;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(length);
    }

    @Override
    public String toString() {
        return "Spoon{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", material='" + getMaterial() + '\'' +
                ", price=" + getPrice() +
                ", color='" + getColor() + '\'' +
                ", length=" + length +
                ", type='" + type + '\'' +
                '}';
    }
}
