package com.music.forum.Repositories;

import com.music.forum.Models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface SongDAO extends JpaRepository<Song, Integer> {
}
