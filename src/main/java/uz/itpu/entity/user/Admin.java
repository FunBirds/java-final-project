package uz.itpu.entity.user;

public class Admin extends User<Admin> {
    private String role;

    public String getRole() {
        return role;
    }

    public Admin setRole(String role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
