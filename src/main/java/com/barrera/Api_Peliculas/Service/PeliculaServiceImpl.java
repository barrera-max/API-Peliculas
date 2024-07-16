package com.barrera.Api_Peliculas.Service;

import com.barrera.Api_Peliculas.DTOs.PeliculaDTO;
import com.barrera.Api_Peliculas.Entity.Pelicula;
import com.barrera.Api_Peliculas.Repositories.PeliculaRepository;
import com.barrera.Api_Peliculas.Service.Mappers.PeliculaDtoMapper;
import com.barrera.Api_Peliculas.Service.Mappers.PeliculaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    //a traves de repositorio accedo a la BD para realizar las operaciones

    private final PeliculaRepository peliculaRepository;

    private final PeliculaDtoMapper dtoMapper;

    private final PeliculaMapper entityMapper;


    public PeliculaServiceImpl(PeliculaRepository peliculaRepository, PeliculaDtoMapper peliculaDtoMapper,
                                PeliculaMapper peliculaMapper) {
        this.peliculaRepository = peliculaRepository;
        this.dtoMapper = peliculaDtoMapper;
        this.entityMapper = peliculaMapper;
    }


    @Override
    public PeliculaDTO add(PeliculaDTO entity) {
        this.peliculaRepository.save(entityMapper.apply(entity));
        return entity;
    }

    @Override
    public PeliculaDTO update(PeliculaDTO entity) {
        return null;
    }

    @Override
    public PeliculaDTO delete(Long id) {
/*
        return this.peliculaRepository.findById(id).map(pelicula -> {
            peliculaRepository.delete(pelicula);
            return pelicula;
        }).orElseThrow();
*/
        return null;
    }

    @Override
    public PeliculaDTO getById(Long id) {
        return null;
        //return this.peliculaRepository.findById(id);
    }

    @Override
    public List<PeliculaDTO> getAll() {
        return this.peliculaRepository.findAll().stream().map(dtoMapper).toList();
    }
}
