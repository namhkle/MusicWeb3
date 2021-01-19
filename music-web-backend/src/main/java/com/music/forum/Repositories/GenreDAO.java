package com.music.forum.Repositories;

import com.music.forum.Models.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GenreDAO extends CrudRepository<Genre, Integer> {
    default Genre findOne(int id) {
        return (Genre) findById(id).orElse(null);
    }
}
