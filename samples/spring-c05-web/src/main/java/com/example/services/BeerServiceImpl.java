package com.example.services;

import com.example.entities.Beer;
import com.example.repositories.BeerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    @Override
    public List<Beer> findAll() {
        log.info("findAll");
        return beerRepository.findAll();
    }

    @Override
    public Optional<Beer> findById(Long id) {
        log.info("findById {}", id);
        return beerRepository.findById(id);
    }
}
