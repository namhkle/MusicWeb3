package com.music.forum.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Genre {
    @Id
    @GeneratedValue
    private int it;

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

    public int getIt() {
        return it;
    }

    public void setIt(int it) {
        this.it = it;
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
