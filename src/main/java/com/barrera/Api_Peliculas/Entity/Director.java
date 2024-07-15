package com.barrera.Api_Peliculas.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "directores")
@Data
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_director")
    private Long idDirector;

    @Column(name = "nombre_director")
    private String nombre;

    @Column(name = "apellido_director")
    private String apellido;

    private Long licencia;

    //director es la referencia en la clase pelicula, o sea apunta al atributo de esa clase
    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore //para que no se mappee en la consulta
    private List<Pelicula> peliculas;
}
