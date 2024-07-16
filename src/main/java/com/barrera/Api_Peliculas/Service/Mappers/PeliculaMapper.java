package com.barrera.Api_Peliculas.Service.Mappers;

import com.barrera.Api_Peliculas.DTOs.PeliculaDTO;
import com.barrera.Api_Peliculas.Entity.Director;
import com.barrera.Api_Peliculas.Entity.Pelicula;
import com.barrera.Api_Peliculas.Repositories.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PeliculaMapper implements Function<PeliculaDTO, Pelicula> {

    private final PeliculaRepository peliculaRepository;

    public PeliculaMapper(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }


    @Override
    public Pelicula apply(PeliculaDTO peliculaDTO) {
        return new Pelicula(peliculaDTO.getId(),
                peliculaDTO.getNombre(),
                peliculaDTO.getDescripcion(),
                (Director) this.peliculaRepository.findById(peliculaDTO.getId())
                        .stream().map(Pelicula::getDirector)
        );
    }
}
