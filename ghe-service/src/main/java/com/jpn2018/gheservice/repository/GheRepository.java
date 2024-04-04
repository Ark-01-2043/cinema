package com.jpn2018.gheservice.repository;

import com.jpn2018.gheservice.entity.Ghe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GheRepository extends JpaRepository<Ghe, Long> {
}
