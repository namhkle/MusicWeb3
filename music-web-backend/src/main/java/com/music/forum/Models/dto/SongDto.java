package com.music.forum.Models.dto;

import com.music.forum.Models.Genre;
import com.music.forum.Models.Song;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SongDto {
    private Long id;
    private String name;
    private String artist;
    private Genre genre;
    private LocalDateTime createdDate;

    public SongDto(){
    }

    public SongDto(Song song){
        this.id = song.getId();
        this.name = song.getName();
        this.artist = song.getArtist();
        this.genre = song.getGenre();
        this.createdDate = song.getCreatedDate();
    }
}
