package com.example.services.impl;

import com.example.entities.SupermarketSection;
import com.example.repositories.SupermarketSectionRepository;
import com.example.services.SupermarketSectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SupermarketSectionServiceImpl implements SupermarketSectionService {

    private final SupermarketSectionRepository sectionRepo;

    @Override
    public List<SupermarketSection> findAll() {
        return sectionRepo.findAll();
    }

    @Override
    public Optional<SupermarketSection> findById(Long id) {
        return sectionRepo.findById(id);
    }

    @Override
    public List<SupermarketSection> findAllBySupermarketId(Long id) {
        return sectionRepo.findAllBySupermarketId(id);
    }

    @Override
    public SupermarketSection save(SupermarketSection section) {
        return sectionRepo.save(section);
    }

    @Override
    public void deleteById(Long id) {
        sectionRepo.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        sectionRepo.deleteAllById(ids);
    }

    @Override
    public void saveAll(List<SupermarketSection> sections) {
        sectionRepo.saveAll(sections);
    }
}
