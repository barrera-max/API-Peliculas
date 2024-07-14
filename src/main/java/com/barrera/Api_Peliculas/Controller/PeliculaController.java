package com.barrera.Api_Peliculas.Controller;

import com.barrera.Api_Peliculas.Entity.Pelicula;
import com.barrera.Api_Peliculas.Service.PeliculaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        try {
            List<Pelicula> values = this.peliculaService.getAll();
            return ResponseEntity.ok(values);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping
    @RequestMapping("/new")
    public ResponseEntity<Pelicula> add(@RequestBody Pelicula pelicula) {
        try {
            Pelicula value = this.peliculaService.add(pelicula);
            return ResponseEntity.status(HttpStatus.CREATED).body(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Pelicula> getOne(@PathVariable Long id) {
        try {
            Pelicula value = this.peliculaService.getById(id);
            return ResponseEntity.ok().body(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Pelicula> delOne(@PathVariable Long id) {
        try {
            Pelicula value = this.peliculaService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(value);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
