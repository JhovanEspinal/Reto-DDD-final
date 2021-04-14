package co.com.recomendador.domain.events;

import co.com.recomendador.domain.valueObjets.RecomendadorId;
import co.com.sofka.domain.generic.DomainEvent;

public class RecomendadorCreado extends DomainEvent {

    private final RecomendadorId recomendadorId;

    public RecomendadorCreado(RecomendadorId entityId) {
        super("recomendador.RecomendadorCreado");
        this.recomendadorId = entityId;
    }

    public RecomendadorId getRecomendadorId() {
        return recomendadorId;
    }
}
