package co.com.recomendador.domain.events;

import co.com.recomendador.domain.entities.Cliente;
import co.com.recomendador.domain.entities.Moto;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class MotosDefinidas extends DomainEvent {

    private final RecomendadorId recomendadorId;
    private final List<Moto> motosF;


    public MotosDefinidas(RecomendadorId recoId, List<Moto> motosF) {
        super("recomendador.MotoDefinida");
        this.recomendadorId = recoId;
        this.motosF = motosF;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public List<Moto> getMotosF() {
        return motosF;
    }
}
