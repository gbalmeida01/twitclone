package com.twitclone.twitclone.repository;

import com.twitclone.twitclone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
