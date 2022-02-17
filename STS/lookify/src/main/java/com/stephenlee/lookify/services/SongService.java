package com.stephenlee.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephenlee.lookify.models.Song;
import com.stephenlee.lookify.repositories.SongRepository;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepo;

    // returns all the songs
    public List<Song> allSongs() {
        return songRepo.findAll();
    }
    // creates a song
    public Song createSong(Song e) {
        return songRepo.save(e);
    }
    // retrieves a song
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepo.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    
    public Song updateSong(Long id, Song newSong) {
        Optional<Song> optionalSong = songRepo.findById(id);
        if(optionalSong.isPresent()) {
            Song song = optionalSong.get();
            song.setTitle(newSong.getTitle());
            song.setArtist(newSong.getArtist());
            song.setRating(newSong.getRating());
            return songRepo.save(song);
        } else {
            return null;
        }
    }
    
    public void deleteSong(Long id) {
        songRepo.deleteById(id);
    }
    
    public List<Song> getTopTenSongs() {
    	return songRepo.findTop10ByOrderByRatingDesc();
    }
    
    public List<Song> findArtistSongs(String query) {
    	return songRepo.findByArtistContaining(query);
    }
}

