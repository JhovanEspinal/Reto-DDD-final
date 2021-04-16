package co.com.recomendador.domain.events;

import co.com.recomendador.domain.entities.Cliente;
import co.com.recomendador.domain.entities.Moto;
import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.DomainEvent;

public class MotoDefinida extends DomainEvent {

    private final RecomendadorId recomendadorId;
    private final Moto moto;


    public MotoDefinida(RecomendadorId recoId, Moto moto) {
        super("recomendador.MotoDefinida");
        this.recomendadorId = recoId;
        this.moto = moto;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }

    public Moto getMoto() {
        return moto;
    }
}
