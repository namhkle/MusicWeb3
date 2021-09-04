package com.music.forum.Repositories;

import com.music.forum.Models.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongDAO extends JpaRepository<Song, Long> {
    //Page<Song> findByUserOrderByCreatedDateDesc(User user, Pageable pageable);

    Page<Song> findAllByOrderByCreatedDateDesc(Pageable pageable);

    Optional<Song> findById(Long id);

    void delete(Song song);
}
