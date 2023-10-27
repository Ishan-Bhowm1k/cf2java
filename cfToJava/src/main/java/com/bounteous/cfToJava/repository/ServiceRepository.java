package com.bounteous.cfToJava.repository;

import com.bounteous.cfToJava.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
    Boolean existsByServiceId(int id);
    List<String> findByTechnicianLike(String q);
}
