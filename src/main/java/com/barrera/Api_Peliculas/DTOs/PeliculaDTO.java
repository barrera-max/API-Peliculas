package com.barrera.Api_Peliculas.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PeliculaDTO {

    private Long id;

    private String nombre;

    private String descripcion;

    private String nombreDirector;

}
