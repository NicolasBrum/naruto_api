package com.naruto_api.naruto_api.model.Enum;

public enum NivelExperiencia {
    GENIN("genin"),
    CHUUNIN("chuunin"),
    JOUUNIN("jouunin"),
    KAGE("kage");

    private String nivel;

    NivelExperiencia(String nivel) {
        this.nivel = nivel;
    }
}
