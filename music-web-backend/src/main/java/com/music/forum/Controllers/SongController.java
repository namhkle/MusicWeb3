package com.music.forum.Controllers;

import com.music.forum.Models.Genre;
import com.music.forum.Models.Song;
import com.music.forum.Repositories.GenreDAO;
import com.music.forum.Repositories.SongDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class SongController {
    @Autowired
    private SongDAO songDAO;

    @Autowired
    private GenreDAO genreDAO;

    @RequestMapping(value="")
    public String home(Model model){
        model.addAttribute("songs", songDAO.findAll());
        model.addAttribute("pagetitle","Home");
        return "home";
    }
    @RequestMapping(value="addsong", method = RequestMethod.GET)
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
        for(int songId : songIds){
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
    }

}
