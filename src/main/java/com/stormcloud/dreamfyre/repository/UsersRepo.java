package com.stormcloud.dreamfyre.repository;


import com.stormcloud.dreamfyre.entity.DreamfyreUser;
import com.stormcloud.dreamfyre.entity.DreamfyreUserPrimaryKey;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<DreamfyreUser, DreamfyreUserPrimaryKey> {

    Optional<DreamfyreUser> findByEmail(String email);
}
