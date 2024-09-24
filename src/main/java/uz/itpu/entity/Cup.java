package uz.itpu.entity;

import java.util.Objects;

public class Cup extends Tableware<Cup> {
    private int volume;
    private int size;

    public int getVolume() {
        return volume;
    }

    public Cup setVolume(int volume) {
        this.volume = volume;
        return this;
    }

    public int getSize() {
        return size;
    }

    public Cup setSize(int size) {
        this.size = size;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cup cup = (Cup) o;
        return volume == cup.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(volume);
    }

    @Override
    public String toString() {
        return "Cup{" + String.join(",", commonField(), "volume=" + volume) + '}';
    }

    @Override
    public String commonField() {
        return super.commonField() + ", volume=" + volume;
    }
}
