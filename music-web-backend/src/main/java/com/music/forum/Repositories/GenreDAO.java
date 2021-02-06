package com.music.forum.Repositories;

import com.music.forum.Models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface GenreDAO extends JpaRepository<Genre, Integer> {
    default Genre findOne(int id) {
        return (Genre) findById(id).orElse(null);
    }
}
