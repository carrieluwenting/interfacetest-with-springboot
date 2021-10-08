package com.carrie.lu.service;

import com.carrie.lu.config.entity.DemoEntity;
import com.carrie.lu.config.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class DemoJPAService {

    @Autowired
    private DemoRepository demoRepository;

    public void save(DemoEntity demo) {
        demoRepository.save(demo);
    }

    public List<DemoEntity> findAll() {
        return demoRepository.findAll();
    }

    public DemoEntity findById(int i) {
        return demoRepository.findById(i);
    }

    public List<DemoEntity> findByStatus(String s) {
        return demoRepository.findByStatus(s);
    }
}
