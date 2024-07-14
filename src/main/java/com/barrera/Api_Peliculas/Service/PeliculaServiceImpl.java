package com.barrera.Api_Peliculas.Service;

import com.barrera.Api_Peliculas.Entity.Pelicula;
import com.barrera.Api_Peliculas.Repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    //a traves de repositorio accedo a la BD para realizar las operaciones

    private PeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepository){
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public Pelicula add(Pelicula entity) {
        Pelicula pelicula = this.peliculaRepository.save(entity);
        return pelicula;
    }

    @Override
    public Pelicula update(Pelicula entity) {
        Pelicula pelicula = this.peliculaRepository.save(entity);
        return pelicula;
    }

    @Override
    public Pelicula delete(Long id) {
        Pelicula pelicula = this.getById(id);
        if (pelicula != null) {
            this.peliculaRepository.delete(pelicula);
        }
        return pelicula;
    }

    @Override
    public Pelicula getById(Long id) {
        return this.peliculaRepository.findById(id).orElse(null);

    }

    @Override
    public List<Pelicula> getAll() {
        return this.peliculaRepository.findAll();
    }
}
