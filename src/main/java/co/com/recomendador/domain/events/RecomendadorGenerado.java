package co.com.recomendador.domain.events;

import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.DomainEvent;

public class RecomendadorGenerado extends DomainEvent {
    private final RecomendadorId recomendadorId;

    public RecomendadorGenerado(RecomendadorId recoId) {
        super("recomendador.RecomenadorGenerado");
        this.recomendadorId = recoId;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }
}
