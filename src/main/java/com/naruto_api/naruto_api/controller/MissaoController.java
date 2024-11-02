package com.naruto_api.naruto_api.controller;

import com.naruto_api.naruto_api.model.Enum.Classificao;
import com.naruto_api.naruto_api.model.Enum.TipoMissao;
import com.naruto_api.naruto_api.model.MissaoModel;
import com.naruto_api.naruto_api.service.MissaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {
    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping
    public List<MissaoModel> pegarTodasMissoes(){
        return missaoService.pegarTodasMissoes();
    }

    @GetMapping("{id}")
    public ResponseEntity<MissaoModel> pegarMissaoPorId(@PathVariable Integer id){
        return missaoService.pegarMissaoPorId(id);
    }

    @GetMapping("/classificacao/{classificacao}")
    public List<MissaoModel> pegarMissaoPorDificuldade(@PathVariable Classificao classificacao){
        return missaoService.pegarMissaoPorDificuldade(classificacao);
    }

    @GetMapping("/tipo/{tipoMissao}")
    public List<MissaoModel> pegarMissaoPorTipo(@PathVariable TipoMissao tipoMissao){
        return missaoService.pegarMissaoPorTipo(tipoMissao);
    }

    @PostMapping
    public ResponseEntity<MissaoModel> criarMissao(@RequestBody MissaoModel missao){
        return missaoService.criarMissao(missao);
    }

    @PutMapping
    public ResponseEntity<Void> atualizarMissao(@RequestBody MissaoModel missao){
        return missaoService.atualizarMissao(missao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarMissao(@PathVariable Integer id){
        return missaoService.deletarMissao(id);
    }
}
