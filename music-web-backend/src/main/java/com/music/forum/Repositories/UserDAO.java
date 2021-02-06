package com.music.forum.Repositories;

import com.music.forum.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Integer> {

}
