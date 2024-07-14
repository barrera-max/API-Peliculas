package com.barrera.Api_Peliculas.Controller;

import com.barrera.Api_Peliculas.Entity.Pelicula;
import com.barrera.Api_Peliculas.Service.PeliculaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaServiceImpl peliculaService;

    public PeliculaController(PeliculaServiceImpl peliculaService) {
        this.peliculaService = peliculaService;
    }

    //si lo uso con un frontend deberia retornar un JSON para manejarlo
    @GetMapping
    public ResponseEntity<List<Pelicula>> getAll() {
        List<Pelicula> values = this.peliculaService.getAll();

        return ResponseEntity.ok(values);
    }

    @PostMapping
    @RequestMapping("/new")
    public ResponseEntity<Pelicula> add(@RequestBody Pelicula pelicula) {
        Pelicula value = this.peliculaService.add(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(value);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Pelicula> getOne(@PathVariable long id) {
        Pelicula value = this.peliculaService.getById(id);
        if (value != null) return ResponseEntity.status(HttpStatus.FOUND).body(value);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
