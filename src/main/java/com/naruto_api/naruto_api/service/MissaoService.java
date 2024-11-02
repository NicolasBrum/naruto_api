package com.naruto_api.naruto_api.service;

import com.naruto_api.naruto_api.model.Enum.Classificao;
import com.naruto_api.naruto_api.model.Enum.TipoMissao;
import com.naruto_api.naruto_api.model.MissaoModel;
import com.naruto_api.naruto_api.model.repositories.MissaoRespository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {
    private MissaoRespository missaoRespository;

    public MissaoService(MissaoRespository missaoRespository) {
        this.missaoRespository = missaoRespository;
    }

    public List<MissaoModel> pegarTodasMissoes(){
        return missaoRespository.findAll();
    }

    public ResponseEntity<MissaoModel> pegarMissaoPorId(Integer id){
        if(!missaoRespository.findById(id).isPresent()) return null;
        return ResponseEntity.status(HttpStatus.OK).body(missaoRespository.findById(id).get());
    }

    public ResponseEntity<Void> atualizarMissao(MissaoModel missao){
        missao.setMissao_id(null);
        missaoRespository.save(missao);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<Void> deletarMissao(Integer id){
        missaoRespository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<MissaoModel> criarMissao(MissaoModel missao){
        missao.setMissao_id(null);
        missaoRespository.save(missao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public List<MissaoModel> pegarMissaoPorDificuldade(Classificao classificao){
        return missaoRespository.findAll()
                .stream()
                .filter(m -> m.getClassificao()
                        .equals(classificao))
                .toList();
    }

    public List<MissaoModel> pegarMissaoPorTipo(TipoMissao tipoMissao){
        return missaoRespository.findAll()
                .stream()
                .filter(m -> m.getTipo_missao()
                        .equals(tipoMissao))
                .toList();
    }
}
