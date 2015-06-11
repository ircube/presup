package com.presup.kind;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ivo on 09/06/2015.
 */
public class Project {
    private String name;
    private String description;
    private Date dateCreation;
    private Date dateModification;
    private List<String> itemKeys = new ArrayList<>(0);

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean addItem( String itemKey ){
        return this.itemKeys.add(itemKey);
    }

    public List<String> getItemKeys() {
        return itemKeys;
    }

    public void setItemKeys(List<String> itemKeys) {
        this.itemKeys = itemKeys;
    }
}
