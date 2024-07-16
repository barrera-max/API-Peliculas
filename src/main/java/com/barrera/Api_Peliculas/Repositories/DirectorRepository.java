package com.barrera.Api_Peliculas.Repositories;

import com.barrera.Api_Peliculas.Entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

}
