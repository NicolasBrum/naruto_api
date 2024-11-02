package com.naruto_api.naruto_api.service;

import com.naruto_api.naruto_api.model.NinjaModel;
import com.naruto_api.naruto_api.model.repositories.NinjaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public boolean validaNinja(){
        return false;
    }

    public ResponseEntity<NinjaModel> encontrarPorId(Integer id){
        if(!ninjaRepository.findById(id).isPresent()) return null;
        return ResponseEntity.status(HttpStatus.OK).body(ninjaRepository.getReferenceById(id));
    }

    public void criarNinja(NinjaModel ninjaModel){
        ninjaModel.setNinja_id(null);
        ninjaRepository.save(ninjaModel);
    }

    public List<NinjaModel> procurarTodosNinjas(){
        return ninjaRepository.findAll();
    }

    public void atualizarNinja(NinjaModel ninjaModel){
        ninjaRepository.save(ninjaModel);
    }
}
