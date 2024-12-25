package uz.itpu.entity.user;

@SuppressWarnings("unchecked")
public class User<SELF extends User<SELF>> {
    private Long id;
    private String name;
    private String email;
    private String password;

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

    public String getEmail() {
        return email;
    }

    public SELF setEmail(String email) {
        this.email = email;
        return (SELF) this;
    }

    public String getPassword() {
        return password;
    }

    public SELF setPassword(String password) {
        this.password = password;
        return (SELF) this;
    }

    public String commonField() {
        return "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'';
    }
}
