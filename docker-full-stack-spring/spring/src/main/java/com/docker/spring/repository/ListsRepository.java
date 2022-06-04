package com.docker.spring.repository;

import com.docker.spring.entity.Lists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListsRepository extends JpaRepository<Lists, Long> {
}
