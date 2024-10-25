package com.example.onthigk1.enums;

import java.util.HashMap;
import java.util.Map;

public enum Roles {
    ADMINISTRATION(4), STAFF(3), MANAGER(2), EXECUTIVE(1);

    private int id;
    Roles(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Roles getRole(int id){
        for (Roles r : Roles.values()){
            if(r.id == id)
                return r;
        }
        return null;
    }
}
