package com.jpn2018.rapservice.repository;


import com.jpn2018.rapservice.entity.Rap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapRepository extends JpaRepository<Rap, Long> {
}
