package com.barrera.Api_Peliculas.Service;

import com.barrera.Api_Peliculas.Entity.Pelicula;
import com.barrera.Api_Peliculas.Repositories.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    //a traves de repositorio accedo a la BD para realizar las operaciones

    private PeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public Pelicula add(Pelicula entity) {
        return this.peliculaRepository.save(entity);
    }

    @Override
    public Pelicula update(Pelicula entity) {
        return this.peliculaRepository.save(entity);
    }

    @Override
    public Pelicula delete(Long id) {
        return this.peliculaRepository.findById(id).map(pelicula -> {
            peliculaRepository.delete(pelicula);
            return pelicula;
        }).orElseThrow();
    }

    @Override
    public Pelicula getById(Long id) {
        return this.peliculaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Pelicula> getAll() {
        return this.peliculaRepository.findAll();
    }
}
