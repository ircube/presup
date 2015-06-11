package com.presup.kind;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
@Cache

public class Profile {

    @Id String userId;
    String email;
    String name;
    private List<String> projectKeys = new ArrayList<>(0);

    /**
     * Just making the default constructor private.
     */
    private Profile() {}

    /**
     * Public constructor for Profile.
     * @param userId The user id, obtained from the email
     * @param email User's main e-mail address.
     *
     */
    public Profile (String userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    /**
     * Getter for projects.
     * @return an immutable copy of projects.
     */
    public List<String> getProjectKeys() {
        return ImmutableList.copyOf(projectKeys);
    }

    /**
     * Update the Profile with the given displayName and teeShirtSize
     *
     * @param email User's main e-mail address.
     */

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectKeys(List<String> projectKeys) {
        this.projectKeys = projectKeys;
    }

    /*
    * Add a project to this profile.
    *
    * @param projectKey to add.
    * */
    public boolean addProject ( String projectKey ){
        return this.projectKeys.add(projectKey);
    }
}
