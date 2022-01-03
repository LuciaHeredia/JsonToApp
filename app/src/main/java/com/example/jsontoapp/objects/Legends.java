package com.example.jsontoapp.objects;

import java.util.List;

public class Legends {

    private int id;
    private List<Tags> tagsList = null;

    public Legends() {
    }

    public Legends(int id) {
        this.id = id;
    }

    public Legends(int id, List<Tags> tagsList) {
        this.id = id;
        this.tagsList = tagsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Tags> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }
}
