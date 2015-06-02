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
    String displayName;
    String mainEmail;

    @Id String userId;

    /**
     * Keys of the conferences that this user registers to attend.
     */
    private List<String> conferenceKeysToAttend = new ArrayList<>(0);

    /**
     * Public constructor for Profile.
     * @param userId The user id, obtained from the email
     * @param displayName Any string user wants us to display him/her on this system.
     * @param mainEmail User's main e-mail address.
     *
     */
    public Profile (String userId, String displayName, String mainEmail) {
        this.userId = userId;
        this.displayName = displayName;
        this.mainEmail = mainEmail;

    }

    public String getDisplayName() {
        return displayName;
    }

    public String getMainEmail() {
        return mainEmail;
    }

    public String getUserId() {
        return userId;
    }

    /**
     * Getter for conferenceIdsToAttend.
     * @return an immutable copy of conferenceIdsToAttend.
     */
    public List<String> getConferenceKeysToAttend() {
        return ImmutableList.copyOf(conferenceKeysToAttend);
    }

    /**
     * Just making the default constructor private.
     */
    private Profile() {}

    /**
     * Update the Profile with the given displayName and teeShirtSize
     *
     * @param displayName
     */
    public void update(String displayName) {
        if (displayName != null) {
            this.displayName = displayName;
        }
    }

}
