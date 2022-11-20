public class User implements java.io.Serializable{

    private int id;
    private String name, address, city, email;

    public User() {
    }

    public User(int id, String name, String address, String city, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.email = email;
    }
    //Setters


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    //
}
