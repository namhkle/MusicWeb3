package com.music.forum.Controllers;

import com.music.forum.Models.Song;
import com.music.forum.Models.dto.SongDto;
import com.music.forum.Repositories.GenreDAO;
import com.music.forum.Repositories.SongDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class SongController {
    @Autowired
    private SongDAO songDAO;

    @Autowired
    private GenreDAO genreDAO;

    @GetMapping(value = "songs")
    public ResponseEntity<List<SongDto>> getPostList(Pageable pageable) {
        Page<Song> songs = songDAO.findAllByOrderByCreatedDateDesc(pageable);
        Page<SongDto> songDto = songs.map(song -> new SongDto((song)));
        return new ResponseEntity<>(songDto.getContent(), HttpStatus.OK);
    }

    @PostMapping(value = "songs")
    public ResponseEntity<SongDto> registerPost(@RequestBody SongDto songDto) {
        Song newSong = new Song();
        newSong.setName(songDto.getName());
        newSong.setArtist(songDto.getArtist());
        newSong.setGenre(songDto.getGenre());
        newSong.setCreatedDate(LocalDateTime.now());
        SongDto returnSong =  new SongDto(songDAO.saveAndFlush(newSong));
        return new ResponseEntity<SongDto>(returnSong, HttpStatus.CREATED);
    }

    public Optional<Song> findForId(Long id) {
        return songDAO.findById(id);
    }
    @PutMapping(value = "/songs/{id}")
    public ResponseEntity<SongDto> editSong(@PathVariable Long id,
                                            @RequestBody SongDto songDto) {
        Optional<Song> song = songDAO.findById(id);
        Optional<SongDto> returnPost = this.findForId(songDto.getId())
                .map(p -> {

                    p.setName(songDto.getName());
                    p.setArtist(songDto.getArtist());
                    return p;
                })
                .map(SongDto::new);
        return returnPost.map(response -> {
            return new ResponseEntity<SongDto>(response, HttpStatus.OK);
        }).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    /*@DeleteMapping(value = "/songs/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (id == null) {
            throw new ApiException("Post id cannot null", HttpStatus.NOT_FOUND);
        } else {
            postService.deletePost(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }*/

    /*@RequestMapping(value="addsong", method = RequestMethod.GET)
    public String displaySongs(Model model){
        model.addAttribute("songs", songDAO.findAll());
        model.addAttribute("pagetitle","Add Songs");
        model.addAttribute("genres", genreDAO.findAll());
        return "addsong";
    }
    @RequestMapping(value="removesong", method = RequestMethod.GET)
    public String displaySongs2(Model model){
        model.addAttribute("songs", songDAO.findAll());
        model.addAttribute("pagetitle","Remove Songs");
        return "removesong";
    }
    @RequestMapping(value="addsong", method = RequestMethod.POST)
    public String addSong(Model model, @ModelAttribute @Valid Song newSong, @RequestParam int genreId, Errors errors){
        model.addAttribute("songs", songDAO.findAll());
        model.addAttribute("genres", genreDAO.findAll());
       if(errors.hasErrors()){
           return "addsong";
       }
        Genre gen = genreDAO.findOne(genreId);
        newSong.setGenre(gen);
        songDAO.save(newSong);
        return "addsong";
    }

    @RequestMapping(value="removesong", method = RequestMethod.POST)
    public String removeSong(@RequestParam int[] songIds){
        for(long songId : songIds){
            songDAO.deleteById(songId);
        }
        return "removesong";
    }


    @RequestMapping(value="genre", method = RequestMethod.GET)
    public String genre(Model model, @RequestParam int id){
        Genre gen = genreDAO.findOne(id);
        List<Song> songs = gen.getSongs();
        model.addAttribute("songs", songs);
        model.addAttribute("genres", genreDAO.findAll());
        return "genre";
    }*/

}
