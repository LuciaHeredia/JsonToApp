package com.example.jsontoapp.objects;

import java.util.List;

public class Legends {

    private int id;
    private List<Tags> tags = null;

    public Legends() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }
}
