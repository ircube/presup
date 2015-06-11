package com.presup.kind;

/**
 * Created by Ivo on 08/06/2015.
 */
public class UserPresup {

    public String name;
    public UserPresup(){
        this.name = "Default";
    }

    public UserPresup( String name ){
        this.name = "User Presup: " + name;
    }

    public String getName() {
        return name;
    }
}
