package com.barrera.Api_Peliculas.Service;

import com.barrera.Api_Peliculas.Entity.Director;
import com.barrera.Api_Peliculas.Repositories.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public Director add(Director entity) {
        return this.directorRepository.save(entity);
    }

    @Override
    public Director update(Director entity) {
        return this.directorRepository.save(entity);
    }

    @Override
    public Director delete(Long id) {
        return this.directorRepository.findById(id).map(director -> {
            directorRepository.delete(director);
            return director;
        }).orElseThrow();
    }

    @Override
    public Director getById(Long id) {
        return this.directorRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Director> getAll() {
        return this.directorRepository.findAll();
    }
}
