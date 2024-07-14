package com.barrera.Api_Peliculas.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="peliculas")
@Data
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long id;

    @Column(name = "nombre_pelicula")
    private String nombre;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_director", nullable = false)
    private Director director;

}
