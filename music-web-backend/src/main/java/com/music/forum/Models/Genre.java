package com.music.forum.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Genre {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1, max = 25)
    private String name;

    @OneToMany
    @JoinColumn(name = "genre_id")
    private List<Song> songs = new ArrayList<>();

    public Genre(){
    }
    public Genre(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
