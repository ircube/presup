package com.presup.form;

import com.presup.kind.Project;

import java.util.ArrayList;

/**
 * Created by Ivo on 09/06/2015.
 */
public class ProfileForm {
    private String displayName;
    private ArrayList<Project> projects;


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
