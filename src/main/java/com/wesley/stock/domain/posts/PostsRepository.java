package com.wesley.stock.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
