package com.bounteous.cfToJava.repository;

import com.bounteous.cfToJava.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceModel,Integer> {
    Boolean existsByServiceId(int id);
    List<String> findByTechnicianLike(String q);
}
