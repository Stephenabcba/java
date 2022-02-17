package com.stephenlee.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stephenlee.lookify.models.Song;
import com.stephenlee.lookify.services.SongService;

@Controller
public class SongController {
    @Autowired
    private SongService songService;
    
    @GetMapping("/")
    public String landing() {
    	return "index.jsp";
    }
    
    @GetMapping("/dashboard")
    public String songs(Model model, @ModelAttribute("song") Song song) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "songs.jsp";
    }
    
    @GetMapping("/songs/new")
    public String new_song(@ModelAttribute("song") Song song) {
        return "create.jsp";
    }
    
    @PostMapping("/songs/new")
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "create.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/dashboard";
        }
    }
    
    @GetMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "show.jsp";
    }

    @GetMapping("/search")
    public String search(@RequestParam("artist") String artist) {
    	return "redirect:/search/"+artist;
    }
    
    @GetMapping("/search/{query}")
    public String searchByArtist(Model model,@PathVariable("query") String query) {
    	if (query.equalsIgnoreCase("topTen")) {
    		List<Song> songs = songService.getTopTenSongs();
			model.addAttribute("songs", songs);
    		return "top_ten.jsp";
    	} else {
			List<Song> songs = songService.findArtistSongs(query);
			model.addAttribute("songs", songs);
			return "search.jsp";
    	}
    }
//    @GetMapping("/songs/edit/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        Song song = songService.findSong(id);
//        model.addAttribute("song", song);
//        return "edit.jsp";
//    }
//    
//    @PutMapping("/songs/edit/{id}")
//    public String update(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("song") Song song, BindingResult result) {
//        if (result.hasErrors()) {
//            return "edit.jsp";
//        } else {
//            songService.updateSong(id, song);
//            return "redirect:/songs";
//        }
//    }
//    
    @DeleteMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
}
