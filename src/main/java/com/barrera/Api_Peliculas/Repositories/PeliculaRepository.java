package com.barrera.Api_Peliculas.Repositories;

import com.barrera.Api_Peliculas.Entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

}
