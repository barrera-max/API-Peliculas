package com.barrera.Api_Peliculas.Service.Mappers;

import com.barrera.Api_Peliculas.DTOs.PeliculaDTO;
import com.barrera.Api_Peliculas.Entity.Pelicula;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PeliculaDtoMapper implements Function<Pelicula, PeliculaDTO> {


    //Revisar el metodo
    @Override
    public PeliculaDTO apply(Pelicula pelicula) {
        return new PeliculaDTO(pelicula.getId(),
                pelicula.getNombre(),
                pelicula.getDescripcion(),
                pelicula.getDirector().getNombre() + ' ' +
                        pelicula.getDirector().getApellido()
        );
    }
}
