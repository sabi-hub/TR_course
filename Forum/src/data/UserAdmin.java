package data;

public class UserAdmin extends User {
    private String password;

    public UserAdmin(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserAdmin{" +
                "password='" + password + '\'' +
                '}';
    }
}
