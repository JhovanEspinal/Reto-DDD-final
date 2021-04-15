package co.com.recomendador.domain;

import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.recomendador.domain.valueObjets.Sede;
import co.com.sofka.domain.generic.DomainEvent;

public class SedeAgregada extends DomainEvent {
    private final RecomendadorId recoId;
    private final Sede sede;

    public SedeAgregada(RecomendadorId recoId,Sede sede) {
        super("recomendador.SedeAgregada");
        this.recoId = recoId;
        this.sede = sede;

    }

    public Sede getSede() {
        return sede;
    }
}
