package com.music.forum.Models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max = 30)
    private String name;

    @NotNull
    @Size(min=1, max = 30)
    private String artist;

    @ManyToOne
    private Genre genre;

    public Song(){

    }

    public int getId() {
        return id;
    }

    public Song(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
