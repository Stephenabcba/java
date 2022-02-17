package com.stephenlee.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephenlee.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    // this method retrieves all the books from the database
    List<Song> findAll();
    List<Song> findByArtistContaining(String infix);
    List<Song> findTop10ByOrderByRatingDesc();
}
