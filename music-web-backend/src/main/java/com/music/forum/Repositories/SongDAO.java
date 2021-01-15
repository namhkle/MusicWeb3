package com.music.forum.Repositories;

import com.music.forum.Models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SongDAO extends CrudRepository<Song, Integer> {
}
