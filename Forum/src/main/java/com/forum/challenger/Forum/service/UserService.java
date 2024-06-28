package com.forum.challenger.Forum.service;

import com.forum.challenger.Forum.DTOs.UserDTO;
import org.apache.catalina.User;

public interface UserService {
    User registerUser(UserDTO userDTO);
    User findByUsername(String username);
}
