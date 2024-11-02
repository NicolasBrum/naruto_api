package com.naruto_api.naruto_api.controller;

import com.naruto_api.naruto_api.model.NinjaModel;
import com.naruto_api.naruto_api.service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("{id}")
    public ResponseEntity<NinjaModel> encontrarNinjaPeloId(@PathVariable Integer id) {
        return ninjaService.encontrarPorId(id);
    }

    @GetMapping
    public List<NinjaModel> listarNinjas() {
        return ninjaService.procurarTodosNinjas();
    }

    @PostMapping
    public ResponseEntity<Void> criarNinja(@RequestBody NinjaModel ninja) {
        ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarNinja(@RequestBody NinjaModel ninja) {
        ninjaService.atualizarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
