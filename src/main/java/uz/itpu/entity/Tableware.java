package uz.itpu.entity;

import java.util.Objects;

@SuppressWarnings("unchecked")
public class Tableware<SELF extends Tableware<SELF>> {
    private Long id;
    private String name;
    private String material;
    private int price;
    private String color;

    public Long getId() {
        return id;
    }

    public SELF setId(Long id) {
        this.id = id;
            return (SELF) this;
    }

    public String getName() {
        return name;
    }

    public SELF setName(String name) {
        this.name = name;
        return (SELF) this;
    }

    public String getMaterial() {
        return material;
    }

    public SELF setMaterial(String material) {
        this.material = material;
        return (SELF) this;
    }

    public int getPrice() {
        return price;
    }

    public SELF setPrice(int price) {
        this.price = price;
        return (SELF) this;
    }

    public String getColor() {
        return color;
    }

    public SELF setColor(String color) {
        this.color = color;
        return (SELF) this;
    }

    public String commonField() {
        return "id=" + id + ", name='" + name + '\'' + ", material='" + material + '\'' + ", price=" + price + ", color='" + color + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tableware<?> tableware = (Tableware<?>) o;
        return price == tableware.price && Objects.equals(id, tableware.id) && Objects.equals(name, tableware.name) && Objects.equals(material, tableware.material) && Objects.equals(color, tableware.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, material, price, color);
    }

    @Override
    public String toString() {
        return "Tableware{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
