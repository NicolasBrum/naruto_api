package com.naruto_api.naruto_api.model;

import com.naruto_api.naruto_api.model.Enum.NivelExperiencia;
import com.naruto_api.naruto_api.model.Enum.StatusNinja;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ninja_id;
    private String nome;
    private String vila;
    private StatusNinja status;
    private NivelExperiencia nivel_experiencia;

}
