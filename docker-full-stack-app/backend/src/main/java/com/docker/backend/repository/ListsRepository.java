package com.docker.backend.repository;

import com.docker.backend.entity.Lists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListsRepository extends JpaRepository<Lists, Long> {
}
