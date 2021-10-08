package com.carrie.lu.config.repository;

import com.carrie.lu.config.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoRepository extends JpaRepository <DemoEntity, Integer> {

    DemoEntity findById(int trafficId);

    List<DemoEntity> findAll();

    @Query("select d from DemoEntity d where d.status = ?1")
    List<DemoEntity> findByStatus(String status);
}
