package com.naruto_api.naruto_api.model;

import com.naruto_api.naruto_api.model.Enum.Classificao;
import com.naruto_api.naruto_api.model.Enum.StatusMissao;
import com.naruto_api.naruto_api.model.Enum.TipoMissao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer missao_id;
    private Classificao classificao;
    private TipoMissao tipo_missao;
    private StatusMissao status;

    @OneToOne
    @JoinColumn(name = "ninja_id", referencedColumnName = "ninja_id")
    private NinjaModel ninja;

}
