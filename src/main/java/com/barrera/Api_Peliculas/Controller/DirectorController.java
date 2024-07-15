package com.barrera.Api_Peliculas.Controller;

import com.barrera.Api_Peliculas.Entity.Director;
import com.barrera.Api_Peliculas.Service.DirectorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/directores")
@RestController
public class DirectorController {

    private final DirectorServiceImpl directorService;

    public DirectorController(DirectorServiceImpl directorService) {
        this.directorService = directorService;
    }

    @GetMapping()
    public ResponseEntity<List<Director>> getAll() {
        try {
            List<Director> values = this.directorService.getAll();
            return ResponseEntity.ok(values);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
