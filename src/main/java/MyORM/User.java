package MyORM;

import MyORM.Annotations.Column;
import MyORM.Annotations.PrimaryKey;

public class User {

    @PrimaryKey(name = "id", autoId = true)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [fullname=" + fullname + ", id=" + id + ", password=" + password + ", username=" + username + "]";
    }


    
}
