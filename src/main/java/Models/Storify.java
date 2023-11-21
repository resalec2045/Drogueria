package Models;
import Models.Person.Persona;

import java.io.Serializable;
import java.util.ArrayList;

public class Storify implements Serializable {
    public static final long serialVersionUID = 1L;

    private boolean isUser;
    private Persona user;
    public Storify() { }

    public boolean isUser() {
        return isUser;
    }
    public void setUser(boolean user) {
        isUser = user;
    }

    public void setUser(Persona user) {
        this.user = user;
    }

    public Persona getUser() {
        return user;
    }

}
