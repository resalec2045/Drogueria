package Models.Person;

import java.io.Serializable;

public class User implements Serializable {
    public static final long serialVersionUID = 1L;
    private String songsUserList;
    private String username;
    private String password;
    private String email;

    public User() { }

    public User(String username, String password, String email, String songsUserList) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.songsUserList = songsUserList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSongsUserList() {
        return songsUserList;
    }

}
